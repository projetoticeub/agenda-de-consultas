package br.com.projetoticeub.agendadeconsultas.models;

import br.com.projetoticeub.agendadeconsultas.dtos.enderecodto.DadosEndereco;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private String cep;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;
    private String uf;

    public Endereco(DadosEndereco dados) {
        this.cep = dados.cep();
        this.bairro = dados.bairro();
        this.rua = dados.rua();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.uf = dados.uf();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if (dados.rua() != null) {
            this.rua = dados.rua();
        }
        if (dados.numero() != null) {
            this.numero = dados.numero();
        }
        if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
        if (dados.uf() != null) {
            this.uf = dados.uf();
        }
    }
}
