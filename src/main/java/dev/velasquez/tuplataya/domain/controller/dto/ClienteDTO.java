package dev.velasquez.tuplataya.domain.controller.dto;

import dev.velasquez.tuplataya.domain.entities.Credito;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {

    private Long id;
    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private String identificacion;
    private String telefonoFijo;
    private String telefonoCelular;
    private String direccion;
    private String correoElectronico;
    private String contrasena;
    private String nombreUsuario;
    private List<Credito> creditList = new ArrayList<>();

}
