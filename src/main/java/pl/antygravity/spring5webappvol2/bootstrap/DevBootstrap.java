package pl.antygravity.spring5webappvol2.bootstrap;

import io.micrometer.core.instrument.binder.hystrix.MicrometerMetricsPublisherThreadPool;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.antygravity.spring5webappvol2.model.Author;
import pl.antygravity.spring5webappvol2.model.Book;
import pl.antygravity.spring5webappvol2.model.Publisher;
import pl.antygravity.spring5webappvol2.repository.AuthorRepository;
import pl.antygravity.spring5webappvol2.repository.BookRepository;
import pl.antygravity.spring5webappvol2.repository.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher zysk = new Publisher();
        zysk.setName("Zysk i s-ka");
        Publisher helion = new Publisher();
        helion.setName("Helion");

        publisherRepository.save(zysk);
        publisherRepository.save(helion);

        //Anita
        Author anita = new Author("Anita", "Bean");
        Book zws = new Book("Żywienie w sporcie", "978-83-7785-331-5", zysk);
        anita.getBooks().add(zws);
        zws.getAuthors().add(anita);

        authorRepository.save(anita);
        bookRepository.save(zws);

        //Jeff
        Author jeff = new Author("Jeff", "Galloway");
        Book tmb = new Book("Trening mentalny biegacza", "978-83-246-4873-3", helion);
        jeff.getBooks().add(tmb);
        tmb.getAuthors().add(jeff);

        authorRepository.save(jeff);
        bookRepository.save(tmb);
    }
}
