package guru.springframework.msscbeerservice.events;


import guru.springframework.msscbeerservice.web.model.BeerDto;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    static final long serialVersionUID= 3058362749392791545L;

    private BeerDto beerDto;
}
