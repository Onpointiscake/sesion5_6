

package com.example.sesion5_6;

import com.example.sesion5_6.entities.Laptop;
import com.example.sesion5_6.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Sesion56Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Sesion56Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null, "Lenovo", "X1", 2099);
		Laptop laptop2 = new Laptop(null, "Apple", "MacBook Air", 1129);
		Laptop laptop3 = new Laptop(null, "Acer", "A515", 575);

		repository.save(laptop1);
		repository.save(laptop2);
		repository.save(laptop3);


	}

}
