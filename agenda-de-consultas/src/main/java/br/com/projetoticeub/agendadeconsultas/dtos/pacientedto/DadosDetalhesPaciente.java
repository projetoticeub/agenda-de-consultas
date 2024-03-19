package br.com.projetoticeub.agendadeconsultas.dtos.pacientedto;

import br.com.projetoticeub.agendadeconsultas.models.Endereco;
import br.com.projetoticeub.agendadeconsultas.models.Paciente;

import java.time.LocalDate;

public record DadosDetalhesPaciente(Long id,
                                    String nomeCompleto,
                                    String cpf,
                                    LocalDate dataNascimento,
                                    String telefone,
                                    String email,
                                    String genero,
                                    Endereco endereco) {

    public DadosDetalhesPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNomeCompleto(), paciente.getCpf(), paciente.getDataNascimento(),
        paciente.getTelefone(), paciente.getEmail(), paciente.getGenero(), paciente.getEndereco());
    }

}
