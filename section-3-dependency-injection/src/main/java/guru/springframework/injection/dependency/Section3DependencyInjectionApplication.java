package guru.springframework.injection.dependency;

import guru.springframework.injection.dependency.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Section3DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Section3DependencyInjectionApplication.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

		System.out.println("---------Profile");
		I18nController i18nController =
				(I18nController)ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		System.out.println("---------Primary Bean");
		MyController myController = (MyController) ctx.getBean("myController");
		String greetings = myController.sayHello();
		System.out.println(greetings);

		System.out.println("---------Property");
		PropertyInjectorController propertyInjectorController =
				(PropertyInjectorController)ctx.getBean("propertyInjectorController");
		System.out.println(propertyInjectorController.getGreeting());

		System.out.println("---------Setter");
		SetterInjectorController setterInjectorController =
				(SetterInjectorController)ctx.getBean("setterInjectorController");
		System.out.println(setterInjectorController.getGreeting());

		System.out.println("---------Constructor");
		ConstructorInjectorController constructorInjectorController =
				(ConstructorInjectorController)ctx.getBean("constructorInjectorController");
		System.out.println(constructorInjectorController.getGreeting());
	}

}
