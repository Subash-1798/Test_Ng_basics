package test_class;

import java.util.NoSuchElementException;

import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class Learningattributes {
	
	

	@Test(priority = 1 ,enabled = true)
	public void Email() {
		
		System.out.println("Email");
//		throw new NoSuchElementException();
		
	}
	
	@Test(dependsOnMethods = "Email" , alwaysRun = true)
   public void password() {
		
	   System.out.println("password");
//	   throw new RuntimeException();
		
	}
	
	
	@Test(dependsOnMethods = "password")
	   public void Login() {
			
		   System.out.println("Login");
			
		}
	@Test(description = "This is Digiclass")
	public void Digiclass() {
		
		System.out.println("Digiclass");
	}

}
