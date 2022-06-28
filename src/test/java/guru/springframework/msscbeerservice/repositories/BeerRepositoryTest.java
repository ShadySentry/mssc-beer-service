package guru.springframework.msscbeerservice.repositories;

import guru.springframework.msscbeerservice.domen.Beer;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void dbInitializedTest() {
        List<Beer> allBeers=beerRepository.findAll();

        log.debug("total beers loaded "+allBeers.size());

        assertTrue(allBeers.size()>0);
    }
}