package guru.springframework.msscbeerservice.services.brewing;

import guru.springframework.msscbeerservice.config.JmsConfig;
import guru.springframework.msscbeerservice.domen.Beer;
import guru.springframework.msscbeerservice.events.BrewBeerEvent;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import guru.springframework.msscbeerservice.services.invetory.BeerInventoryService;
import guru.springframework.msscbeerservice.web.mapper.BeerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BrewingService {
    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    public BrewingService(BeerRepository beerRepository, BeerInventoryService beerInventoryService,
                          JmsTemplate jmsTemplate, BeerMapper beerMapper) {

        this.beerRepository = beerRepository;
        this.beerInventoryService = beerInventoryService;
        this.jmsTemplate = jmsTemplate;
        this.beerMapper = beerMapper;
    }

    @Scheduled(fixedRate = 5000) //every 5 seconds
    public void checkForLowInventory() {
        List<Beer> beers = beerRepository.findAll();

        beers.forEach(beer -> {
            Integer invQuantityOnHands = beerInventoryService.getOnhandInventory(beer.getId());

            log.debug("Min on hand is: " + beer.getMinOnHand());
            log.debug("Inventory is: " + invQuantityOnHands);

            if (beer.getMinOnHand() >= invQuantityOnHands) {
                jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE, new BrewBeerEvent(beerMapper.beerToBeerDto(beer)));
            }
        });
    }
}
