package pl.akademiakodu.blogApplication.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date added = new Date();

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Post() {

    }

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "postId")
    List<PostComment> comments = new ArrayList<>();

    public void addComment(PostComment postComment) {
        comments.add(postComment);
        postComment.setPost(this);
    }

    public void removeComment(PostComment postComment) {
        comments.remove(postComment);
        postComment.setPost(null);
    }

    public List<PostComment> getComments() {
        return comments;
    }

    public void setComments(List<PostComment> comments) {
        this.comments = comments;
    }
}
