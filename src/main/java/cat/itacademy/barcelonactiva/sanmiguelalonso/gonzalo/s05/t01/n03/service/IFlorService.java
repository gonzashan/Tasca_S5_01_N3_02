package cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n03.service;

import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n03.model.FlorDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 
public interface IFlorService
{

    Flux<?> findAllFlors();
	
	Mono<?> findById(Integer id);
 
    Mono<?> create(FlorDTO e);
 
    Mono<Object> update(FlorDTO e);
 
    Mono<Object> delete(Integer id);
}