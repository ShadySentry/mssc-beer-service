package guru.springframework.msscbeerservice.web.mapper;


import guru.springframework.msscbeerservice.domen.Beer;
import guru.springframework.msscbeerservice.services.invetory.BeerInventoryService;
import guru.sfg.brewery.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;

public class BeerMapperDecorator implements BeerMapper {

    private BeerInventoryService beerInventoryService;
    private BeerMapper mapper;

    @Autowired
    public void setBeerInventoryService(BeerInventoryService beerInventoryService) {
        this.beerInventoryService = beerInventoryService;
    }

    @Autowired
    public void setMapper(BeerMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        BeerDto dto = mapper.beerToBeerDto(beer);

        return dto;
    }

    @Override
    public BeerDto beerToBeerDtoWithInventory(Beer beer) {
        BeerDto dto = mapper.beerToBeerDto(beer);
        dto.setQuantityOnHand(beerInventoryService.getOnhandInventory(beer.getId()));

        return dto;
    }

    @Override
    public Beer beerDtoToBeer(BeerDto dto) {
        return mapper.beerDtoToBeer(dto);
    }
}
