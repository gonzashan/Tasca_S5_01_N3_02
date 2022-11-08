package cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n03.service;

import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n03.exception.ErrorDetails;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n03.exception.RequestOk;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n03.model.FlorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class FlorService implements IFlorService
{
	@Autowired
	WebClient webClient;


	public Flux<?> findAllFlors()
	{
		return webClient.get()
				.uri("/getAll")
				.retrieve()
				.bodyToFlux(Object.class)
				.timeout(Duration.ofMillis(10_000));
	}


	public Mono<?> findById(Integer id)
	{
		return webClient.get()
				.uri("/getOne/" + id)
				.retrieve()
				.bodyToMono(Object.class)
				.onErrorReturn(new ErrorDetails(HttpStatus.NOT_FOUND.value(),
						"No se ha trobat flor amb id:"
						+ id));
	}


	public Mono<?> create(FlorDTO flor)
	{
		return webClient.post()
				.uri("/add")
				.body(Mono.just(flor), FlorDTO.class)
				.retrieve()
				.bodyToMono(Object.class)
				.timeout(Duration.ofMillis(30_000))
				.onErrorReturn(new ErrorDetails(500,"Internal Error"));
	}


	public Mono<Object> update(FlorDTO e)
	{
		return webClient.put()
				.uri("/update")
				.body(Mono.just(e), FlorDTO.class)
				.retrieve()
				.bodyToMono(Object.class)
				.onErrorReturn(new HttpServerErrorException(HttpStatus.NOT_FOUND,
						":ERROR  El id: " +  e.getPk_FlorID() + " no existeix").getLocalizedMessage());
	}


	public Mono<Object> delete(Integer id)
	{
		return webClient.delete()
				.uri("/delete/" + id)
				.retrieve()
				.bodyToMono(Object.class)
				.onErrorReturn(new ErrorDetails(HttpStatus.NOT_FOUND.value(),
						"No se ha trobat flor amb id:" + id));
	}

}