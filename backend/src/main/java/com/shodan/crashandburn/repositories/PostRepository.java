package com.shodan.crashandburn.repositories;

import com.shodan.crashandburn.model.Post;
import com.shodan.crashandburn.model.ReplyPost;
import com.shodan.crashandburn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAuthor(User author);

    List<ReplyPost> findByOriginalPost(Post originalPost);
}
