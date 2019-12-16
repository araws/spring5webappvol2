package pl.antygravity.spring5webappvol2.repository;

import org.springframework.data.repository.CrudRepository;
import pl.antygravity.spring5webappvol2.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
