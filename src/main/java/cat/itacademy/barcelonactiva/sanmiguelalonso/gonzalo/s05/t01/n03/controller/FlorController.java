package cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n03.controller;

import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n03.model.FlorDTO;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n03.service.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 
@RestController
@RequestMapping("/flor")
public class FlorController
{
    @Autowired
    private FlorService florService;

    //using Flux for collection of flowers
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/clientFlorsAll")
    public Flux<?> findAllFlor() {
        return florService.findAllFlors();
    }


    @GetMapping(value = "/clientFlorsGetOne/{id}")
    //using Mono for single FLor
    public Mono<?> findById(@PathVariable("id") Integer id) {
        return florService.findById(id);
    }
 
    @PostMapping(value = "/clientFlorsAdd")
    @ResponseStatus(HttpStatus.CREATED)
    //using Mono for single Flor
    public Mono<?> create(@RequestBody FlorDTO e) {
    	return florService.create(e);
    }
 
    @PutMapping(value = "/clientFlorsUpdate")
    @ResponseStatus(HttpStatus.OK)
    //using Mono for single employee
    public Mono<Object> update(@RequestBody FlorDTO e) {
        return florService.update(e);
    }
 
    @DeleteMapping(value = "/clientFlorsDelete/{id}")
    @ResponseStatus(HttpStatus.OK)
    // using Mono<Void> when no response content is expected
    public Mono<Object> delete(@PathVariable("id") Integer id) {
    	return florService.delete(id);
    }
}
