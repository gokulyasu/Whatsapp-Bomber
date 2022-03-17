package WhatsappDrivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReusableMethods {
	WebDriver driver;
	ReusableMethods(WebDriver driver){
		this.driver=driver;
	}
	public boolean waitForElement(String xpath) {
		
		boolean res=false;
		while(!res) {
			try {
				driver.findElement(By.xpath(xpath)).isEnabled();
				res=true;
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Waiting for element ...!!!");
			}
			
			//System.out.println(res);
		}
		return true;
	}
}
