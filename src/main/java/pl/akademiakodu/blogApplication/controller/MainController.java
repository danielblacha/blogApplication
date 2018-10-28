package pl.akademiakodu.blogApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.akademiakodu.blogApplication.model.Post;
import pl.akademiakodu.blogApplication.repository.PostRepository;

@Controller
public class MainController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/")
    public String getIndexPage(Model model) {
        model.addAttribute("name", "Daniel");
        return "index";
    }

    @GetMapping("/addPost")
    public String addPostPage() {
        return "addPost";
    }

    @PostMapping("/addPost")
    public String addPost(@RequestParam(value = "title") String title,
                          @RequestParam(value = "content") String content) {
        Post post = new Post(title, content);
        postRepository.save(post);
        System.out.println("Params: " + title + ", " + content);
        return "index";
    }

    @GetMapping("/posts")
    public String postsPage(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "posts";
    }

    @GetMapping("/posts/{title}")
    public String postsByTitle(@PathVariable String title, Model model) {
        model.addAttribute("posts", postRepository.findAllByTitleContains(title));
        return "posts";
    }
}
