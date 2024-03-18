package br.com.projetoticeub.agendadeconsultas.controllers;

import br.com.projetoticeub.agendadeconsultas.dtos.pacientedto.DadosSalvarPacienteDto;
import br.com.projetoticeub.agendadeconsultas.models.Paciente;
import br.com.projetoticeub.agendadeconsultas.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    public ResponseEntity<Paciente> save(@RequestBody @Valid DadosSalvarPacienteDto dados, UriComponentsBuilder uriBuilder) {
        var paciente = new Paciente(dados);
        service.salvar(paciente);
        var uri = uriBuilder.path("/paciente/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(paciente);
    }

}
