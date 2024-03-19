package br.com.projetoticeub.agendadeconsultas.services;

import br.com.projetoticeub.agendadeconsultas.models.Paciente;
import br.com.projetoticeub.agendadeconsultas.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    @Transactional
    public Paciente salvar(Paciente paciente) {
        return repository.save(paciente);
    }

    public Page<Paciente> listarTodos(Pageable paginacao) {
        return repository.findAll(paginacao);
    }

    public Paciente listarPeloCpf(String cpf){
        return repository.findForCpf(cpf);
    }

    public Paciente buscarPorId(Long id) {
        return repository.getReferenceById(id);
    }

    @Transactional
    public Paciente atualizar(Paciente paciente) {
        return repository.save(paciente);
    }

    public boolean cpfJaCadastrado(String cpf){
        var paciente =  repository.findForCpf(cpf);
        return paciente != null;
    }

}
