package pl.antygravity.spring5webappvol2.bootstrap;

import pl.antygravity.spring5webappvol2.model.Author;
import pl.antygravity.spring5webappvol2.model.Book;

public class DevBootstrap {

    private void initData (){

        //Anita
        Author anita = new Author("Anita", "Bean");
        Book zws = new Book("Żywienie w sporcie", "978-83-7785-331-5", "Zysk i s-ka");
        anita.getBooks().add(zws);
        zws.getAuthors().add(anita);

        //Jeff
        Author jeff = new Author("Jeff", "Galloway");
        Book tmb = new Book("Trening mentalny biegacza", "978-83-246-4873-3", "Helion");
        jeff.getBooks().add(tmb);
        tmb.getAuthors().add(jeff);
    }
}
