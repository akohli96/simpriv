package com.simpriv.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SimprivApplication implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(SimprivApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SimprivApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		log.info("Creating tables");
		jdbcTemplate.execute("CREATE TABLE users(username varchar(255) primary key, password_hash varchar(255) unique)");
		jdbcTemplate.execute("CREATE TABLE snippet(message_text varchar(255), password_hash varchar(255) unique, url_link varchar(255) unique, user_from varchar (255), user_to varchar (255)");
		log.info("Tables created");
	}

}
