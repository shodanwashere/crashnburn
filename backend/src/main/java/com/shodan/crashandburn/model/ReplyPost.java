package com.shodan.crashandburn.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("2")
public class ReplyPost extends Post{

    @ManyToOne
    @JoinColumn(name = "original_post_id")
    private Post originalPost; // nullable = true will propagate to superclass. logic must be implemented in service to check originalPost is always fed through REST API

    public ReplyPost(){ super(); }

    public void setOriginalPost(Post originalPost) {
        this.originalPost = originalPost;
    }

    public Post getOriginalPost(){
        return this.originalPost;
    }
}
