package br.com.projetoticeub.agendadeconsultas.repositories;

import br.com.projetoticeub.agendadeconsultas.models.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query("SELECT p FROM Paciente p WHERE p.cpf = :cpf")
    Paciente findForCpf(@Param("cpf") String cpf);

    @Query("SELECT p FROM Paciente p")
    Page<Paciente> findAll(Pageable pageable);

}
