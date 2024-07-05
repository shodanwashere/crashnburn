package com.shodan.crashandburn.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "author_user_id", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime timestamp;

    @ManyToMany
    private List<User> likedBy;

    private String content;

    public Comment(){};

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<User> getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(List<User> likedBy) {
        this.likedBy = likedBy;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Comment by ");
        sb.append(this.author.getUsername());
        sb.append(" @ ");
        sb.append(timestamp.toString());
        sb.append(":\n\t'");
        sb.append(this.content);
        sb.append("'");
        return sb.toString();
    }
}
