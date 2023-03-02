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

@Component
@RequiredArgsConstructor
public class Handler {
    private final PruebaUseCase useCase;

    public Mono<ServerResponse> savePersona(ServerRequest serverRequest) {
        var newPerson = serverRequest.bodyToMono(Persona.class);

        return newPerson.flatMap(persona ->
                ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(useCase.save(persona), Persona.class));
    }
}
