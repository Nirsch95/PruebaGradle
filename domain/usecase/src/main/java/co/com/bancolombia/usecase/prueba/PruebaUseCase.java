package co.com.bancolombia.usecase.prueba;

import co.com.bancolombia.model.persona.Persona;
import co.com.bancolombia.model.persona.gateways.PersonaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class PruebaUseCase {

    private final PersonaRepository repository;

    public Flux<Persona> getPersonas(){
        return repository.getAll();
    }

    public Mono<Persona> save(Persona persona){
        return repository.save(persona);
    }

    public Mono<Persona> findById(String id){
        return repository.findById(id);
    }

    public Mono<Void> delete(String id){
        return repository.delete(id);
    }
}
