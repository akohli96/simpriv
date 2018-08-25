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
		String snippet = "CREATE TABLE SNIPPET(\n" +
				"  MESSAGE varchar(255),\n" +
				"  UUID varchar(255) primary key,\n" +
				"  USER_FROM varchar (255),\n" +
				"  USER_TO varchar (255)\n" +
				")";
		log.info("Creating tables");
		jdbcTemplate.execute("CREATE TABLE USERS(\n" +
				"  USERNAME varchar(255) primary key,\n" +
				"  PASSWORD varchar(255) unique\n" +
				")");
		jdbcTemplate.execute(snippet);
		log.info("Tables created");
	}

}
