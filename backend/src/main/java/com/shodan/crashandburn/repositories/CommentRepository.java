package com.shodan.crashandburn.repositories;

import com.shodan.crashandburn.model.Comment;
import com.shodan.crashandburn.model.Post;
import com.shodan.crashandburn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    public List<Comment> findByAuthor(User author);

    public List<Comment> findByPost(Post post);
}
