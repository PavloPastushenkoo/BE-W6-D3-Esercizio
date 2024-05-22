package it.nextdevs.u5s2g2es.controller;

import it.nextdevs.u5s2g2es.model.BlogAuthor;
import it.nextdevs.u5s2g2es.service.BlogAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogAuthorController {
    @Autowired
    private BlogAuthorService blogAuthorService;

    @GetMapping("/authors")
    public List<BlogAuthor> getAllAuthors() {
        return blogAuthorService.getAllAuthors();
    }

    @GetMapping("/authors/{id}")
    public BlogAuthor getAuthorById(@PathVariable Integer id) {
        Optional<BlogAuthor> authorOpt = blogAuthorService.getAuthorById(id);

        if (authorOpt.isPresent()) {
            return authorOpt.get();
        } else {
            throw new RuntimeException("Post con id "+id+" non trovato");
        }
    }

    @PostMapping("/authors")
    public String saveAuthor(@RequestBody BlogAuthor blogAuthor) {
        return blogAuthorService.saveAuthor(blogAuthor);
    }

    @PutMapping("/authors/{id}")
    public BlogAuthor updateAuthor(@PathVariable Integer id, @RequestBody BlogAuthor blogAuthor) {
        return blogAuthorService.updateAuthor(id, blogAuthor);
    }

    @DeleteMapping("/authors/{id}")
    public String deleteAuthor(@PathVariable Integer id) {
        return blogAuthorService.deleteAuthor(id);
    }
}
