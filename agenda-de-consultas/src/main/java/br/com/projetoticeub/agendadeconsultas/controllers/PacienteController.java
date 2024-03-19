package br.com.projetoticeub.agendadeconsultas.controllers;

import br.com.projetoticeub.agendadeconsultas.dtos.pacientedto.DadosAtualizacaoPaciente;
import br.com.projetoticeub.agendadeconsultas.dtos.pacientedto.DadosDetalhesPaciente;
import br.com.projetoticeub.agendadeconsultas.dtos.pacientedto.DadosListagemPacientes;
import br.com.projetoticeub.agendadeconsultas.dtos.pacientedto.DadosSalvarPaciente;
import br.com.projetoticeub.agendadeconsultas.models.Paciente;
import br.com.projetoticeub.agendadeconsultas.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity salvar(@RequestBody @Valid DadosSalvarPaciente dados, UriComponentsBuilder uriBuilder) {
        if(service.cpfJaCadastrado(dados.cpf())) {
           return ResponseEntity.badRequest().body("CPF já cadastrado! ");
        }
        var paciente = new Paciente(dados);
        service.salvar(paciente);
        var uri = uriBuilder.path("/paciente/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhesPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemPacientes>> listar(@PageableDefault(size = 10, sort = {"nomeCompleto"}) Pageable paginacao) {
       var pacientes = service.listarTodos(paginacao).stream()
               .map(DadosListagemPacientes::new).toList();
       return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity listarPorCpf(@PathVariable String cpf){
        var paciente = service.listarPeloCpf(cpf);
        return ResponseEntity.ok(paciente);
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = service.buscarPorId(dados.id());
        paciente.atualizarInformacoes(dados);
        paciente = service.atualizar(paciente);
        return ResponseEntity.ok().body(new DadosDetalhesPaciente(paciente));
    }

}
