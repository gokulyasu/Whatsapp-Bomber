package WhatsappDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.demo.Model;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	public static WebDriver driver;

	public  void driver(Model model) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Scanner sc= new Scanner(System.in);
		//System.out.println("Enter the mobile number :");
		String number= model.getNumber()+"";
		//System.out.println("Enter the message");
		String message=model.getMessage();
		//System.out.println("Enter the Counts"); 
		int count=model.getCount();
		System.out.println( number+"\n"+message+"\n"+count);
		
		driver.get("https://web.whatsapp.com/");
		
		
		Steps st = new Steps(driver);
		st.login();
		st.searchContact(number);
		for (int i = 0; i < count; i++) {
			System.out.println("Sending " + (i + 1) + " th message");
			st.sentMessage(message);
		}
		st.logout();
		driver.close();
		driver.quit();
		
	}

}
