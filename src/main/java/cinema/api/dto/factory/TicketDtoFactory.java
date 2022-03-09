package cinema.api.dto.factory;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import cinema.api.dto.TicketDto;
import cinema.store.entity.SeancePlace;

@Component
public class TicketDtoFactory {

	
	
	public TicketDto createTicketDto(SeancePlace entity) {
		return new TicketDto(
				entity.getId(),
				entity.getClient().getNumClient(),
				entity.getPlace().getNumber(),
				entity.getSeance().getFilm().getTitle(),
				entity.getPlace().getHall().getName(),
				entity.getSeance().getStartedAt(),
				entity.getSeance().getPrice());
	}
	
	public List<TicketDto> createListTicketDto(List<SeancePlace> entities){
		return entities
				.stream()
				.map(this::createTicketDto)
				.collect(Collectors.toList());
	}
}
