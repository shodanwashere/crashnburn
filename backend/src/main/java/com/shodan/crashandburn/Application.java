package com.shodan.crashandburn;

import com.shodan.crashandburn.model.Post;
import com.shodan.crashandburn.model.User;
import com.shodan.crashandburn.model.UserCredentials;
import com.shodan.crashandburn.repositories.PostRepository;
import com.shodan.crashandburn.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(UserRepository userRepository, PostRepository postRepository){
		return (args -> {
			UserCredentials uc = new UserCredentials();
			uc.setPasswordHash("4b92c3e0c44b65a118e82643bf2732bdde45ffa084be53123bb7c84aca5e68ab");
			uc.setSalt("thwAudb9TGsG98TyADkbsyFYk");

			User u = new User();
			u.setUsername("shodanwashere");
			u.setEmail("shodantltwb@proton.me");
			u.setPronouns("he/him");
			u.setCredentials(uc);

			User su = userRepository.save(u);

			log.info("Users found with findAll():");
			log.info("===========================");
			userRepository.findAll().forEach(user -> {
				log.info(user.toString());
			});

			Post p = new Post();
			p.setAuthor(su);
			p.setContent("this is my post! hiii :)");

			Post sp = postRepository.save(p);

			log.info("Posts found with findAll():");
			log.info("===========================");
			postRepository.findAll().forEach(post -> {
				log.info(post.toString());
			});
		});
	}

}
