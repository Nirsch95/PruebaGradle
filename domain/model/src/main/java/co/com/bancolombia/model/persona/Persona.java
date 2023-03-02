package co.com.bancolombia.model.persona;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Persona {

    private String id;
    private Date createAt;
    private String name;
}
