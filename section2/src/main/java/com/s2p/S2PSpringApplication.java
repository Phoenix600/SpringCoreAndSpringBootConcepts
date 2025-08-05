package com.s2p;

import com.s2p.beans.Vehicle;
import com.s2p.config.ProjectConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class S2PSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(S2PSpringApplication.class, args);

		Vehicle veh = new Vehicle();
		veh.setName("Honda City");
		System.out.println("Vehicle name from non-spring context is: " + veh.getName());

        /*
        The var keyword was introduced in Java 10. Type inference is used in
        var keyword in which it detects automatically the datatype of a variable
        based on the surrounding context.
        * */
		var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

		Vehicle vehicle = context.getBean(Vehicle.class);
		System.out.println("Vehicle name from Spring Context is: " + vehicle.getName());

        /*
        We don’t need to do any explicit casting while fetching a bean from context.
        Spring is smart enough to look for a bean of the type you requested in its context.
        If such a bean doesn’t exist,Spring will throw an exception.
        * */
		String hello = context.getBean(String.class);
		System.out.println("String value  from Spring Context is: " + hello);

		Integer num = context.getBean(Integer.class);
		System.out.println("Integer value  from Spring Context is: " + num);

	}

}
