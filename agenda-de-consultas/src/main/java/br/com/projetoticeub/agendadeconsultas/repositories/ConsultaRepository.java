package br.com.projetoticeub.agendadeconsultas.repositories;

import br.com.projetoticeub.agendadeconsultas.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
