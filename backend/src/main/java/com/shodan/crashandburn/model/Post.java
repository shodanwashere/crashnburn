package com.shodan.crashandburn.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "post")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "post_type",
discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("1")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_user_id", nullable = false)
    private User author;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime timestamp;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "originalPost")
    private List<ReplyPost> replies;

    @ManyToMany
    @JoinTable(
            name = "post_likes",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<User> likedBy;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    public Post(){};

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<ReplyPost> getReplies() {
        return replies;
    }

    public void setReplies(List<ReplyPost> replies) {
        this.replies = replies;
    }

    public List<User> getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(List<User> likedBy) {
        this.likedBy = likedBy;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.author.getUsername());
        sb.append(" @ "); sb.append(this.timestamp.toString());
        sb.append(": '"); sb.append(this.content); sb.append("'");
        return sb.toString();
    }
}
