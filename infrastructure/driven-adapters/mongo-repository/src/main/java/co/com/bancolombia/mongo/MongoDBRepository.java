package co.com.bancolombia.mongo;

import co.com.bancolombia.model.persona.Persona;
import co.com.bancolombia.mongo.document.PersonaDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MongoDBRepository extends ReactiveMongoRepository<PersonaDocument, String>, ReactiveQueryByExampleExecutor<PersonaDocument> {

}
