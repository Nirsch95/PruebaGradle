package co.com.bancolombia.api;

import co.com.bancolombia.model.persona.Persona;
import co.com.bancolombia.usecase.prueba.PruebaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
@RequiredArgsConstructor
public class Handler {
    private final PruebaUseCase useCase;

    static Mono<ServerResponse> notFound = ServerResponse.notFound().build();

    public Mono<ServerResponse> savePersona(ServerRequest serverRequest) {
        var newPerson = serverRequest.bodyToMono(Persona.class);

        return newPerson.flatMap(persona ->
                ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(useCase.save(persona), Persona.class));
    }

    public Mono<ServerResponse> getPersonas(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(useCase.getPersonas(), Persona.class).log();
    }
    public Mono<ServerResponse> getPersona(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        Mono<Persona> personaMono = useCase.findById(id);

        return personaMono.flatMap(persona ->
                ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromValue(persona)))
                .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> deletePersona(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        Mono<Void> deleteMono = useCase.delete(id);

        return deleteMono.flatMap(item ->
                ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(deleteMono, Void.class));
    }


}
