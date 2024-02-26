package guru.springframework.di;

import guru.springframework.di.config.SfgConfiguration;
import guru.springframework.di.controllers.*;
import guru.springframework.di.datasource.FakeDataSource;
import guru.springframework.di.services.PrototypeBean;
import guru.springframework.di.services.SingletonBean;
import guru.springframework.pets.controllers.PetController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages =
		{"guru.springframework.di",
		"guru.springframework.pets"})
@SpringBootApplication
public class Section3DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Section3DependencyInjectionApplication.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

		System.out.println("---------Profile");
		I18nController i18nController = (I18nController)ctx.getBean("i18nController");
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

		System.out.println("---------Singleton");
		SingletonBean singletonBean = (SingletonBean)ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean.getMyScope());
		SingletonBean singletonBean2 = (SingletonBean)ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		System.out.println("---------Prototype");
		PrototypeBean prototypeBean = (PrototypeBean) ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean.getMyScope());
		PrototypeBean prototypeBean2 = (PrototypeBean) ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());

		System.out.println("---------FakeDataSource");
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcUrl());

		System.out.println("---------Properties Binding");
		SfgConfiguration sfgConfiguration = ctx.getBean(SfgConfiguration.class);
		System.out.println(sfgConfiguration.getUsername());
		System.out.println(sfgConfiguration.getPassword());
		System.out.println(sfgConfiguration.getJdbcUrl());
	}

}
