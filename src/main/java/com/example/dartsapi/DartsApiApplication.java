package com.example.dartsapi;

import com.example.dartsapi.database.MongoConnection;
import com.example.dartsapi.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import java.util.List;

@SpringBootApplication()
public class DartsApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(DartsApiApplication.class, args);
		MongoConnection connection = MongoConnection.getInstance();
		System.out.println(connection.database.getCollection("user").find());
	}

}
