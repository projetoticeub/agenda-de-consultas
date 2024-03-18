package br.com.projetoticeub.agendadeconsultas.repositories;

import br.com.projetoticeub.agendadeconsultas.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
