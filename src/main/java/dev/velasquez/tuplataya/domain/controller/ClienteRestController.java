package dev.velasquez.tuplataya.domain.controller;

import dev.velasquez.tuplataya.domain.controller.dto.ClienteDTO;
import dev.velasquez.tuplataya.domain.entities.Cliente;
import dev.velasquez.tuplataya.service.IClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteRestController {
    private final IClienteService clienteService;
    URI uri = URI.create("/clientes");

    public ClienteRestController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            ClienteDTO clienteDTO = ClienteDTO.builder()
                    .id(cliente.getId())
                    .nombres(cliente.getNombres())
                    .primerApellido(cliente.getPrimerApellido())
                    .segundoApellido(cliente.getSegundoApellido())
                    .identificacion(cliente.getIdentificacion())
                    .telefonoFijo(cliente.getTelefonoFijo())
                    .telefonoCelular(cliente.getTelefonoCelular())
                    .direccion(cliente.getDireccion())
                    .correoElectronico(cliente.getCorreoElectronico())
                    .contrasena(cliente.getContrasena())
                    .nombreUsuario(cliente.getNombreUsuario())
                    .build();

            return ResponseEntity.ok(clienteDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("")
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<ClienteDTO> creditoDTOList = clienteService.findAll()
                .stream()
                .map(c -> ClienteDTO.builder()
                        .id(c.getId())
                        .nombres(c.getNombres())
                        .primerApellido(c.getPrimerApellido())
                        .segundoApellido(c.getSegundoApellido())
                        .identificacion(c.getIdentificacion())
                        .telefonoFijo(c.getTelefonoFijo())
                        .telefonoCelular(c.getTelefonoCelular())
                        .direccion(c.getDireccion())
                        .correoElectronico(c.getCorreoElectronico())
                        .contrasena(c.getContrasena())
                        .nombreUsuario(c.getNombreUsuario())
                        .build()).toList();
        return ResponseEntity.ok(creditoDTOList);
    }

    @PostMapping("")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody ClienteDTO dto) {
        Optional<Cliente> clienteOptional = clienteService.findById(id);

        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            cliente.setId(dto.getId());
            cliente.setNombres(dto.getNombres());
            cliente.setPrimerApellido(dto.getPrimerApellido());
            cliente.setSegundoApellido(dto.getSegundoApellido());
            cliente.setIdentificacion(dto.getIdentificacion());
            cliente.setTelefonoFijo(dto.getTelefonoFijo());
            cliente.setTelefonoCelular(dto.getTelefonoCelular());
            cliente.setDireccion(dto.getDireccion());
            cliente.setCorreoElectronico(dto.getCorreoElectronico());
            cliente.setContrasena(dto.getContrasena());
            cliente.setNombreUsuario(dto.getNombreUsuario());
            clienteService.save(cliente);
            return ResponseEntity.ok("Registro Actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("")
    public ResponseEntity<ClienteDTO> save(@RequestBody ClienteDTO dto) {
        if (dto.getIdentificacion().isBlank() || dto.getNombres().isBlank() || dto.getNombreUsuario().isBlank() || dto.getPrimerApellido().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        clienteService.save(Cliente.builder()
                .id(dto.getId())
                .nombres(dto.getNombres())
                .primerApellido(dto.getPrimerApellido())
                .segundoApellido(dto.getSegundoApellido())
                .identificacion(dto.getIdentificacion())
                .telefonoFijo(dto.getTelefonoFijo())
                .telefonoCelular(dto.getTelefonoCelular())
                .direccion(dto.getDireccion())
                .correoElectronico(dto.getCorreoElectronico())
                .contrasena(dto.getContrasena())
                .nombreUsuario(dto.getNombreUsuario())
                .build());

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (id != null) {
            clienteService.deleteById(id);
            return ResponseEntity.ok("Registro Eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}
