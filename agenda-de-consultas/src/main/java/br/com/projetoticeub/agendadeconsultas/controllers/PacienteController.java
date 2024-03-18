package br.com.projetoticeub.agendadeconsultas.controllers;

import br.com.projetoticeub.agendadeconsultas.dtos.pacientedto.DadosListagemPacientes;
import br.com.projetoticeub.agendadeconsultas.dtos.pacientedto.DadosSalvarPacienteDto;
import br.com.projetoticeub.agendadeconsultas.models.Paciente;
import br.com.projetoticeub.agendadeconsultas.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<DadosListagemPacientes>> listar() {
       var pacientes = service.listarTodos().stream()
               .map(DadosListagemPacientes::new)
               .toList();
       return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Paciente> listarPorCpf(@PathVariable String cpf){
        var paciente = service.listarPeloCpf(cpf);
        return ResponseEntity.ok(paciente);
    }



}
