package pl.akademiakodu.blogApplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.blogApplication.model.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}
