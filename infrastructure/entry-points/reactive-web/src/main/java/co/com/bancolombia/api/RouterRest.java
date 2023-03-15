package co.com.bancolombia.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterRest {
//    @Bean
//    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
//        return RouterFunctions.route(GET("/api/usecase/{id}"), handler::getPersona)
//                .andRoute(GET("/api/usecase"), handler::getPersonas)
//                .andRoute(POST("/api/usecase/create"), handler::savePersona)
//                .andRoute(DELETE("/api/usecase/{id}"), handler::deletePersona)
//              //  .andRoute(GET("/api/usecase/{name}"), handler::getPersonaByName)
//        ;
//    }

    @Bean
    public RouterFunction<ServerResponse> personaRouterFunc(Handler handler) {
        return RouterFunctions.route(GET("/api/usecase/personas").and(accept(MediaType.APPLICATION_JSON))
                        ,handler::getPersonas)
                .andRoute(GET("/api/usecase/persona/"+"{id}").and(accept(MediaType.APPLICATION_JSON))
                        ,handler::getPersona)
                .andRoute(POST("/api/usecase/persona").and(accept(MediaType.APPLICATION_JSON))
                        ,handler::savePersona)
                .andRoute(DELETE("/api/usecase/persona/"+"{id}").and(accept(MediaType.APPLICATION_JSON))
                        ,handler::deletePersona);
    }
}
