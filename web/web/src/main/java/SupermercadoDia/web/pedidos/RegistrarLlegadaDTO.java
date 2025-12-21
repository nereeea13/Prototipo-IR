package SupermercadoDia.web.pedidos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrarLlegadaDTO {
    private List<RegistrarLlegadaLineaDTO> lineas;
}
