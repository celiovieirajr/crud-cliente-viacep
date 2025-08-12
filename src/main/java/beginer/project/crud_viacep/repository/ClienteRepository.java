package beginer.project.crud_viacep.repository;

import beginer.project.crud_viacep.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
