package br.com.projetoticeub.agendadeconsultas.models;

import br.com.projetoticeub.agendadeconsultas.dtos.pacientedto.DadosAtualizacaoPaciente;
import br.com.projetoticeub.agendadeconsultas.dtos.pacientedto.DadosSalvarPaciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private String genero;
    @Embedded
    private Endereco endereco;

    public Paciente(DadosSalvarPaciente dados) {
        this.nomeCompleto = dados.nomeCompleto();
        this.cpf = dados.cpf();
        this.dataNascimento = dados.dataNascimento();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.genero = dados.genero();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.nomeCompleto() != null) {
            this.nomeCompleto = dados.nomeCompleto();
        }
        if (dados.dataNascimento() != null) {
            this.dataNascimento = dados.dataNascimento();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.genero() != null) {
            this.genero = dados.genero();
        }
        if (dados.endereco() != null) {
            this.endereco = this.endereco != null ? this.endereco : new Endereco();
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }
}
