package br.com.projetoticeub.agendadeconsultas.dtos.pacientedto;

import br.com.projetoticeub.agendadeconsultas.dtos.enderecodto.DadosEndereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DadosSalvarPaciente(@NotBlank String nomeCompleto,
                                  @NotNull @Pattern(regexp = ("\\d{11}")) String cpf,
                                  @NotNull LocalDate dataNascimento,
                                  @NotBlank String telefone,
                                  @NotNull @Email String email,
                                  String genero,
                                  @NotNull DadosEndereco endereco) {
}
