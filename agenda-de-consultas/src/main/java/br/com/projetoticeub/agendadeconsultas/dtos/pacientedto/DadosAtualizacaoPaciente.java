package br.com.projetoticeub.agendadeconsultas.dtos.pacientedto;

import br.com.projetoticeub.agendadeconsultas.dtos.enderecodto.DadosEndereco;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizacaoPaciente(@NotNull
                                       Long id,
                                       String nomeCompleto,
                                       LocalDate dataNascimento,
                                       String telefone,
                                       String email,
                                       String genero,
                                       DadosEndereco endereco) {
}