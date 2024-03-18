package br.com.projetoticeub.agendadeconsultas.services;

import br.com.projetoticeub.agendadeconsultas.dtos.consulta.DadosAgendamentoConsulta;
import br.com.projetoticeub.agendadeconsultas.dtos.consulta.DadosDetalhamentoConsulta;
import br.com.projetoticeub.agendadeconsultas.models.Consulta;
import br.com.projetoticeub.agendadeconsultas.repositories.ConsultaRepository;
import br.com.projetoticeub.agendadeconsultas.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados) {
        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var consulta = new Consulta();
        consulta.setPaciente(paciente);
        consulta.setData(dados.data());
        consultaRepository.save(consulta);
        return new DadosDetalhamentoConsulta(consulta);
    }

}
