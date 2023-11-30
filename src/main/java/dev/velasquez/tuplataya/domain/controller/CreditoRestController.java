package dev.velasquez.tuplataya.domain.controller;

import dev.velasquez.tuplataya.domain.controller.dto.CreditoDTO;
import dev.velasquez.tuplataya.domain.entities.Credito;
import dev.velasquez.tuplataya.service.ICreditoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/creditos")
public class CreditoRestController {
    private ICreditoService creditoService;

    public CreditoRestController(ICreditoService creditoService) {
        this.creditoService = creditoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditoDTO> findById(@PathVariable Long id) {
        Optional<Credito> creditoOptional = creditoService.findById(id);
        if (creditoOptional.isPresent()) {
            Credito credito = creditoOptional.get();
            CreditoDTO creditoDTO = CreditoDTO.builder()
                    .id(credito.getId())
                    .montoSolicitado(credito.getMontoSolicitado())
                    .plazoDias(credito.getPlazoDias())
                    .totalPagar(credito.getTotalPagar())
                    .tasaInteres(credito.getTasaInteres())
                    .comision(credito.getComision())
                    .descuento(credito.getDescuento())
                    .cliente(credito.getCliente()).build();
            return ResponseEntity.ok(creditoDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("")
    public ResponseEntity<List<CreditoDTO>> findAll() {
        List<CreditoDTO> creditoDTOList = creditoService.findAll()
                .stream()
                .map(c -> CreditoDTO.builder()
                        .id(c.getId())
                        .montoSolicitado(c.getMontoSolicitado())
                        .plazoDias(c.getPlazoDias())
                        .totalPagar(c.getTotalPagar())
                        .tasaInteres(c.getTasaInteres())
                        .comision(c.getComision())
                        .descuento(c.getDescuento())
                        .build()).toList();
        return ResponseEntity.ok(creditoDTOList);
    }
}
