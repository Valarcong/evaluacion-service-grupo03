package pe.edu.cibertec.evaluacionservicegrupo03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.evaluacionservicegrupo03.dto.ResumenCrediticioClienteDTO;
import pe.edu.cibertec.evaluacionservicegrupo03.dto.ScoringRiesgoDTO;
import pe.edu.cibertec.evaluacionservicegrupo03.service.EvaluacionService;

@RestController
@RequestMapping("/api/v1/evaluaciones")
public class EvaluacionController {

    private final EvaluacionService evaluacionService;
    public EvaluacionController(EvaluacionService evaluacionService) {
        this.evaluacionService = evaluacionService;
    }

    @GetMapping("/scoring/{clienteId}")
    public ScoringRiesgoDTO obtenerScoring(@PathVariable("clienteId") Long clienteId) {
        return evaluacionService.obtenerScoring(clienteId);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResumenCrediticioClienteDTO obtenerInformacionConsolidada(@PathVariable("clienteId") Long clienteId) {
        return evaluacionService.obtenerInformacionConsolidada(clienteId);
    }
}
