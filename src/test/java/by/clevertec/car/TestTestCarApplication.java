package by.clevertec.car;

import org.springframework.boot.SpringApplication;

public class TestTestCarApplication {

	public static void main(String[] args) {
		SpringApplication.from(TestCarApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
