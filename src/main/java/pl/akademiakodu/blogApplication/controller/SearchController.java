package pl.akademiakodu.blogApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.akademiakodu.blogApplication.model.Post;
import pl.akademiakodu.blogApplication.repository.PostRepository;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/search")
    public String search(@RequestParam String searchPhrase, Model model) {
        List<Post> postList = postRepository.findAllByTitleContainsOrContentContains(searchPhrase, searchPhrase);
        model.addAttribute("posts", postList);
        model.addAttribute("searchPhrase", searchPhrase);
        return "posts";
    }
}
