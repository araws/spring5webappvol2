package pl.antygravity.spring5webappvol2.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.antygravity.spring5webappvol2.model.Author;
import pl.antygravity.spring5webappvol2.model.Book;
import pl.antygravity.spring5webappvol2.repository.AuthorRepository;
import pl.antygravity.spring5webappvol2.repository.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    AuthorRepository authorRepository;
    BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //Anita
        Author anita = new Author("Anita", "Bean");
        Book zws = new Book("Żywienie w sporcie", "978-83-7785-331-5", "Zysk i s-ka");
        anita.getBooks().add(zws);
        zws.getAuthors().add(anita);

        authorRepository.save(anita);
        bookRepository.save(zws);

        //Jeff
        Author jeff = new Author("Jeff", "Galloway");
        Book tmb = new Book("Trening mentalny biegacza", "978-83-246-4873-3", "Helion");
        jeff.getBooks().add(tmb);
        tmb.getAuthors().add(jeff);

        authorRepository.save(jeff);
        bookRepository.save(tmb);
    }
}
