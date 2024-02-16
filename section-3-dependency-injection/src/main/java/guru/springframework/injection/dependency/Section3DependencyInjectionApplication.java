package guru.springframework.injection.dependency;

import guru.springframework.injection.dependency.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Section3DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Section3DependencyInjectionApplication.class, args);
		MyController myController = (MyController) ctx.getBean("myController");

		String greetings = myController.sayHello();

		System.out.println(greetings);
	}

}
