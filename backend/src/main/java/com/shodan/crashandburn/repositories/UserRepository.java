package com.shodan.crashandburn.repositories;

import com.shodan.crashandburn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);

    public User findByEmail(String email);
}
