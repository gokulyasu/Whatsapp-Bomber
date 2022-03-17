package WhatsappDrivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Steps {
	WebDriver driver;
	ReusableMethods rm;
	Steps(WebDriver driver){
		this.driver=driver;
		 rm=new ReusableMethods(driver);
	}
	
	public void login() {
		driver.findElement(By.xpath("//li[contains(text(),'Open WhatsApp on your phone')]"));
		
		if(rm.waitForElement("//div[@id='side']")) {
		System.out.println("login successfully");
		}
	}
	public void searchContact(String number) {
		//driver.findElement(By.xpath("//li[contains(text(),'Open WhatsApp on your phone')]"));
		
	WebElement searchBar=	driver.findElement(By.xpath("//div[contains(@title,'Search input textbox')]"));
	searchBar.click();
	searchBar.sendKeys(number);
	rm.waitForElement("//button//span[@data-testid='x-alt']");
	driver.findElement(By.xpath("//div[@data-testid='cell-frame-container']//img")).click();
	if(rm.waitForElement("//div[contains(text(),'Type a message')]")) {
		System.out.println("Type a message visibled");
	}
		//System.out.println("final ========= "+rm.waitForElement(null));
		
	}
	public void sentMessage(String message) {
		WebElement textBar=driver.findElement(By.xpath("//div[contains(text(),'Type a message')]"));
		Actions action= new Actions(driver);
		action.click(textBar).sendKeys(message).build().perform();
		//textBar.click();
		//action.sendKeys("Hello").click(textBar).build().perform();
		//textBar.sendKeys("Hello");
		driver.findElement(By.xpath("//button/span[contains(@data-testid,'send')]")).click();
	
	}
	public void logout() {
		driver.findElement(By.xpath("//span[@data-testid='menu']")).click();
		try {
		Thread.sleep(1000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[@aria-label='Log out']")).click();
		
	}
}
