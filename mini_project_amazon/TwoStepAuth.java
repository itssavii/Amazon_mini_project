package mini_project_amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.jboss.aerogear.security.otp.Totp;

// https://jar-download.com/artifacts/org.jboss.aerogear/aerogear-otp-java/1.0.0/source-code

public class TwoStepAuth {

	public static void main(String[] args) {
		
		//Add your key below, which you copied earlier and used in Google Authenticator
        Totp totp = new Totp("jmtq kipu xwdn 2pup slxm zvon 3wep odyk"); // 2FA secret key
        String twoFactorCode = totp.now(); //Generated 2FA code here
        System.out.println("Two factor code is:"+twoFactorCode);
        

	 //driver.findElement(By.id("totpPin")).sendKeys(twoFactorCode);

		
		// TODO Auto-generated method stub

/*		 System.setProperty("webdriver.chrome.driver", "c://worksoft//chromedriver//chromedriver.exe");
		        
		 WebDriver driver = new ChromeDriver();
		        
		 driver.manage().window().maximize();
		 
		 driver.get("https://accounts.google.com/");
		 
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("kamath.test@gmail.com");
		 
		 driver.findElement(By.xpath("//span[text()='Next']")).click();
		      
		 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("");
		      
		 driver.findElement(By.xpath("//span[text()='Next']")).click();
		  
		// OTP value is returned from getTwoFactor method
		 /*
	        Totp totp = new Totp("emz7 exr3 javs dguw 4nhe cm2z kcny zgel"); // 2FA secret key
	        String twoFactorCode = totp.now(); //Generated 2FA code here
	        System.out.println("Two factor code is:"+twoFactorCode);
		 driver.findElement(By.id("totpPin")).sendKeys(twoFactorCode);
		        
		 driver.findElement(By.id("totpNext")).click();
		 
        */
	}

	//public class TOTPGenerator {
	    /*
	     * Method is used to get the TOTP based on the security token
	     * @return
	     */
	    //public String getTwoFactorCode(){
	//Replace with your security key copied from step 12
	   //   	Totp totp = new Totp("jmtq kipu xwdn 2pup slxm zvon 3wep odyk"); // 2FA secret key
	     //   String twoFactorCode = totp.now(); //Generated 2FA code here
	    //    return twoFactorCode;
	 //   }
	//}
	
}
