package br.com.projetoticeub.agendadeconsultas.controllers;

import br.com.projetoticeub.agendadeconsultas.dtos.consulta.DadosAgendamentoConsulta;
import br.com.projetoticeub.agendadeconsultas.services.ConsultaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @PostMapping
    @Transactional
    public ResponseEntity Salvar(@RequestBody @Valid DadosAgendamentoConsulta dados) {
        var consulta = service.agendar(dados);
        return ResponseEntity.ok(consulta);
    }

}
