package it.nextdevs.u5s2g2es.controller;

import it.nextdevs.u5s2g2es.model.BlogPost;
import it.nextdevs.u5s2g2es.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/blogPosts")
    public List<BlogPost> getAllPosts() {
        return blogPostService.getAllPosts();
    }

    @GetMapping("/blogPosts/{id}")
    public BlogPost getPostById(@PathVariable Integer id) {
        Optional<BlogPost> postOpt = blogPostService.getPostById(id);

        if (postOpt.isPresent()) {
            return postOpt.get();
        } else {
            throw new RuntimeException("Post con id "+id+" non trovato");
        }
    }

    @PostMapping("/blogPosts")
    public String savePost(@RequestBody BlogPost blogPost) {
        return blogPostService.savePost(blogPost);
    }

    @PutMapping("/blogPosts/{id}")
    public BlogPost updatePost(@PathVariable Integer id, @RequestBody BlogPost blogPost) {
        return blogPostService.updatePost(id, blogPost);
    }

    @DeleteMapping("/blogPosts/{id}")
    public String deletePost(@PathVariable Integer id) {
        return blogPostService.deletePost(id);
    }
}
