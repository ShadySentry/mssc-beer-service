package guru.springframework.msscbeerservice.web.mapper;

import guru.springframework.msscbeerservice.domen.Beer;
import guru.springframework.msscbeerservice.web.model.BeerDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {
    Beer beerDtoToBeer(BeerDto dto);

    BeerDto beerToBeerDto(Beer beer);
}
