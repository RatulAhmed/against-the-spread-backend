package com.atspickem.backend;

import com.atspickem.backend.dao.NflScheduleDAO;
import com.atspickem.backend.dao.NflSpreadDAO;
import com.atspickem.backend.dao.UserChoiceDAO;
import com.atspickem.backend.dao.UserDAO;
import com.atspickem.backend.util.OddsScraper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {UserDAO.class,
											NflScheduleDAO.class,
											NflSpreadDAO.class,
											UserChoiceDAO.class})
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
}
