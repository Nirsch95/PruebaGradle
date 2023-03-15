package co.com.bancolombia.mongo;

import co.com.bancolombia.model.persona.Persona;
import co.com.bancolombia.model.persona.gateways.PersonaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class PersonaRepositoryImpl implements PersonaRepository {

    private MongoRepositoryAdapter dao;

    private MongoDBRepository repository;


    @Override
    public Mono<Persona> findById(String id) {
        return dao.findById(id);
    }

    @Override
    public Mono<Void> delete(String id) {
        return dao.deleteById(id);
    }

    @Override
    public Mono<Persona> save(Persona persona) {
        return dao.save(persona);
    }

    @Override
    public Flux<Persona> getAll() {
        return dao.findAll();
    }
}

