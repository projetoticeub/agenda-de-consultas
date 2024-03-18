package br.com.projetoticeub.agendadeconsultas.services;

import br.com.projetoticeub.agendadeconsultas.models.Paciente;
import br.com.projetoticeub.agendadeconsultas.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    @Transactional
    public Paciente salvar(Paciente paciente) {
        return repository.save(paciente);
    }

    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    public Paciente listarPeloCpf(String cpf){
        return repository.findForCpf(cpf);
    }

    @Transactional
    public Paciente buscarPorId(Long id) {
        return repository.getReferenceById(id);
    }

    @Transactional
    public Paciente atualizar(Paciente paciente) {
        return repository.save(paciente);
    }

}
