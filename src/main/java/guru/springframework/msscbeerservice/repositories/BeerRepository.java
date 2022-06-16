package guru.springframework.msscbeerservice.repositories;

import guru.springframework.msscbeerservice.domen.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

}
