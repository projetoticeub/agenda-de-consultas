package br.com.projetoticeub.agendadeconsultas.dtos.pacientedto;

import br.com.projetoticeub.agendadeconsultas.models.Paciente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosListagemPacientes(@NotBlank String nome,
                                     @NotBlank String telefone,
                                     @NotNull @Email String email,
                                     String genero) {

    public DadosListagemPacientes(Paciente paciente){
        this(paciente.getNomeCompleto(), paciente.getTelefone(), paciente.getEmail(), paciente.getGenero());
    }

}

