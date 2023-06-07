package com.example.dartsapi;

import com.example.dartsapi.entities.UserEntity;
import com.example.dartsapi.model.User;
import com.example.dartsapi.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class DartsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DartsApiApplication.class, args);
	}

}
