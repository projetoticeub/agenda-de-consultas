package br.com.projetoticeub.agendadeconsultas.dtos.enderecodto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(@NotBlank
                            @Pattern(regexp = "\\d{8}")
                            String cep,

                            @NotBlank
                            String bairro,

                            @NotBlank
                            String rua,

                            String complemento,

                            String numero,

                            @NotBlank
                            String uf) {
}
