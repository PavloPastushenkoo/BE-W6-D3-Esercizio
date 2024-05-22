package it.nextdevs.u5s2g2es.service;

import it.nextdevs.u5s2g2es.model.BlogAuthor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BlogAuthorService {
    private List<BlogAuthor> authors = new ArrayList<>();

    public List<BlogAuthor> getAllAuthors() {
        return authors;
    }

    public Optional<BlogAuthor> getAuthorById(Integer id) {
        return authors.stream().filter(blogAuthor -> Objects.equals(blogAuthor.getId(), id)).findFirst();
    }

    public String saveAuthor(BlogAuthor blogAuthor) {
        authors.add(blogAuthor);
        return "Autore creato con questo id: "+ blogAuthor.getId();
    }

    public BlogAuthor updateAuthor(Integer id, BlogAuthor blogAuthor) {
        Optional<BlogAuthor> authorOpt = getAuthorById(id);

        if (authorOpt.isPresent()) {
            BlogAuthor author = authorOpt.get();
            author.setNome(blogAuthor.getNome());
            author.setCognome(blogAuthor.getCognome());
            author.setEmail(blogAuthor.getEmail());
            author.setAvatar("https://ui-avatars.com/api/?name="+blogAuthor.getNome()+"+"+blogAuthor.getCognome());
            author.setDataDiNascita(blogAuthor.getDataDiNascita());
            authors.set(id, author);
            return author;
        } else {
            throw new RuntimeException("Autore non trovato");
        }
    }

    public String deleteAuthor(Integer id) {
        Optional<BlogAuthor> authorOpt = getAuthorById(id);

        if (authorOpt.isPresent()) {
            authors.remove(authorOpt.get());
            return "Autore cancellato";
        } else {
            throw new RuntimeException("Autore non trovato");
        }
    }
}
