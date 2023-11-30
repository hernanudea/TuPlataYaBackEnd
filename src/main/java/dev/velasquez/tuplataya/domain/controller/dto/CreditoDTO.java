package dev.velasquez.tuplataya.domain.controller.dto;

import dev.velasquez.tuplataya.domain.entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditoDTO {

    private Long id;
    private BigDecimal montoSolicitado;
    private int plazoDias;
    private BigDecimal totalPagar;
    private Float tasaInteres;
    private BigDecimal comision;
    private BigDecimal descuento;
    private Cliente cliente;
}
