package pl.antygravity.spring5webappvol2.repository;

import org.springframework.data.repository.CrudRepository;
import pl.antygravity.spring5webappvol2.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
