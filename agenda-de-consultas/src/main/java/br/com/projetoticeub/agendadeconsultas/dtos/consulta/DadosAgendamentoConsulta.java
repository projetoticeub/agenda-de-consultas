package br.com.projetoticeub.agendadeconsultas.dtos.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(@NotNull
                                       Long idPaciente,

                                       @NotNull
                                       @Future
                                       LocalDateTime data) {
}
