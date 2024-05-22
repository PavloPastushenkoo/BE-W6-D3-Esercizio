package it.nextdevs.u5s2g2es.service;

import it.nextdevs.u5s2g2es.model.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BlogPostService {
    private List<BlogPost> posts = new ArrayList<>();

    public List<BlogPost> getAllPosts() {
        return posts;
    }

    public Optional<BlogPost> getPostById(Integer id) {
        return posts.stream().filter(blogPost -> Objects.equals(blogPost.getId(), id)).findFirst();
    }

    public String savePost(BlogPost blogPost) {
        posts.add(blogPost);
        return "Post creato con questo id: "+blogPost.getId();
    }

    public BlogPost updatePost(Integer id, BlogPost blogPost) {
        Optional<BlogPost> postOpt = getPostById(id);

        if (postOpt.isPresent()) {
            BlogPost post = postOpt.get();
            post.setCategoria(blogPost.getCategoria());
            post.setContenuto(blogPost.getContenuto());
            post.setTempoDiLettura(blogPost.getTempoDiLettura());
            return post;
        } else {
            throw new RuntimeException("Post non trovato");
        }
    }

    public String deletePost(Integer id) {
        Optional<BlogPost> postOpt = getPostById(id);

        if (postOpt.isPresent()) {
            posts.remove(postOpt.get());
            return "Post cancellato";
        } else {
            throw new RuntimeException("Post non trovato");
        }
    }
}
