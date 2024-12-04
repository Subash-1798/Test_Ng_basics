package test_class;

import org.testng.annotations.Test;

public class Groups {
	
	
	
	@Test(groups = {"Reg"})
   public void password() {
		
	   System.out.println("password");
//	   throw new RuntimeException();
		
	}
	
	
	@Test(groups = {"sanity"})
	   public void Login() {
			
		   System.out.println("Login");
			
		}
	@Test()
	public void Digiclass() {
		
		System.out.println("Digiclass");
	}

	
	

}
