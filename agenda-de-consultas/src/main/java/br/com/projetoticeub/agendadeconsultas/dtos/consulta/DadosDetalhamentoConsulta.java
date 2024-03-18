package br.com.projetoticeub.agendadeconsultas.dtos.consulta;

import br.com.projetoticeub.agendadeconsultas.models.Consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(Long id, Long idPaciente, LocalDateTime data) {

    public DadosDetalhamentoConsulta(Consulta consulta){
       this(consulta.getId(), consulta.getPaciente().getId(), consulta.getData());
    }

}
