package guru.springframework.msscbeerservice.events;


import guru.springframework.msscbeerservice.web.model.BeerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class BeerEvent {

    static final long serialVersionUID= 3058362749392791545L;

    private final BeerDto beerDto;
}
