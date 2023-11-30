package dev.velasquez.tuplataya.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.MERGE, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Credito> creditList = new ArrayList<>();

}
