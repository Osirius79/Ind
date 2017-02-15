package Resume;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ResumeRefreshTest {
	
	WebDriver driver; 
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user1\\workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	@Test
	public void DoRefresh() throws InterruptedException{
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		driver.navigate().to("https://www.indeed.ca/");
		//Finding and clicking sign in link
		driver.findElement(By.xpath("//a[@id='userOptionsLabel']")).click();
		//EmailAdress input
		driver.findElement(By.id("signin_email")).sendKeys("pvorontsovp@gmail.com");
		//Password input
		driver.findElement(By.id("signin_password")).sendKeys("indeed022");
		//Click signIn button
		
		WebElement signInButton = driver.findElement(By.xpath("//button[@class='sg-btn sg-btn-primary btn-signin']"));

		Actions actions = new Actions(driver);

		actions.moveToElement(signInButton).click().perform();
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement signInButton = wait.until(ExpectedConditions.elementToBe(By.xpath("//button[@class='sg-btn sg-btn-primary btn-signin']")));
		signInButton.click();
		
		//Clicking on MyProfile
		driver.findElement(By.xpath("//span[@id='userOptionsLabel']/b[text()='pvorontsovp@gmail.com']")).click();
		//Clicking ResumeLink
		driver.findElement(By.xpath("//div[@id='userOptions']//a[text()='Resume']")).click();
		
		//Clicking IMG of Additional information
		driver.findElement(By.xpath("//div[@id='container']/div/div[2]/div/div[2]/div[1]/div[13]/div[2]/div/div/div/div[1]/a/img")).click();
		
		//Clicking SaveButton to save and refresh my resume
		driver.findElement(By.xpath("//div[@id='container']//button[text()='Save']")).click();

		

		

		
		
	}

}
