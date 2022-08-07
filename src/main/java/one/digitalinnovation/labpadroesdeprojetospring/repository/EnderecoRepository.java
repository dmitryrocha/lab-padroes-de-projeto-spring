package one.digitalinnovation.labpadroesdeprojetospring.repository;

import one.digitalinnovation.labpadroesdeprojetospring.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
