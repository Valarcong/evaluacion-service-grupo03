package pe.edu.cibertec.evaluacionservicegrupo03.service;

import pe.edu.cibertec.evaluacionservicegrupo03.dto.ResumenCrediticioClienteDTO;
import pe.edu.cibertec.evaluacionservicegrupo03.dto.ScoringRiesgoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Service
public class EvaluacionService {

    private final Map<Long, ScoringRiesgoDTO> scoringPorCliente = new HashMap<>();

    public EvaluacionService() {
        scoringPorCliente.put(1L, new ScoringRiesgoDTO(1L, 780, "BAJO", 45000.00,
                "Cliente con excelente historial crediticio. Riesgo bajo."));
        scoringPorCliente.put(2L, new ScoringRiesgoDTO(2L, 690, "MEDIO", 18000.00,
                "Cliente con historial aceptable. Requiere seguimiento."));
        scoringPorCliente.put(3L, new ScoringRiesgoDTO(3L, 540, "ALTO", 6000.00,
                "Cliente con historial irregular de pagos. Riesgo alto."));
        scoringPorCliente.put(4L, new ScoringRiesgoDTO(4L, 410, "CRITICO", 1500.00,
                "Cliente con reportes negativos vigentes. Riesgo critico."));
    }

    public ScoringRiesgoDTO obtenerScoring(Long clienteId) {
        if (scoringPorCliente.containsKey(clienteId)) {
            return scoringPorCliente.get(clienteId);
        }
        return new ScoringRiesgoDTO(clienteId, 600, "MEDIO", 10000.00,
                "Cliente nuevo sin historial previo. Evaluacion preliminar.");
    }

    public ResumenCrediticioClienteDTO obtenerInformacionConsolidada(Long clienteId) {
        ScoringRiesgoDTO scoring = obtenerScoring(clienteId);

        String estado = "NO_APTO";
        if (scoring.getNivelRiesgo().equals("BAJO") || scoring.getNivelRiesgo().equals("MEDIO")) {
            estado = "APTO";
        }

        return new ResumenCrediticioClienteDTO(clienteId, "Cliente " + clienteId,
                "7000000" + clienteId, scoring, new ArrayList<>(), estado);
    }
}
