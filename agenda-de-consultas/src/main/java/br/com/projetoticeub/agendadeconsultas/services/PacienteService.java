package br.com.projetoticeub.agendadeconsultas.services;

import br.com.projetoticeub.agendadeconsultas.models.Paciente;
import br.com.projetoticeub.agendadeconsultas.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public Paciente salvar(Paciente paciente) {
        return repository.save(paciente);
    }

}
