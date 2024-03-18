package br.com.projetoticeub.agendadeconsultas.models;

import br.com.projetoticeub.agendadeconsultas.dtos.pacientedto.DadosSalvarPacienteDto;
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

    public Paciente(DadosSalvarPacienteDto dados) {
        this.nomeCompleto = dados.nomeCompleto();
        this.cpf = dados.cpf();
        this.dataNascimento = dados.dataNascimento();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.genero = dados.genero();
        this.endereco = new Endereco(dados.endereco());
    }
}
