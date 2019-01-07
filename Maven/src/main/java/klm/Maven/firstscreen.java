package klm.Maven;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Sheet;
import jxl.Workbook;
public class firstscreen {
	
	public static void main(String[] args) throws Exception{
		int i;
		 //String driverPath = "C:\\Users\\Sparkelon\\Desktop\\Alekhya\\SeleniumNew\\drivers\\geckodriver.exe";
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sparkelon\\Desktop\\Alekhya\\SeleniumNew\\drivers\\geckodriver.exe");
		
	   	/*FirefoxOptions options = new FirefoxOptions();
		options.setLogLevel(FirefoxDriverLogLevel.DEBUG);
		WebDriver driver = new FirefoxDriver(options);*/
		WebDriver driver = new FirefoxDriver();
		/*FirefoxOptions firefox_options  = new FirefoxOptions();
		firefox_options.setCapability("marionette", true);*/
        driver.get("https://www.klm.com/home/nl/en");
        driver.manage().window().maximize();
        Thread.sleep(7000);	
        
        //WebDriverWait wait=new WebDriverWait(driver, 20);
        
	     //  WebElement agreepop= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[text()=' Agree ']")));
	    
        WebElement agreepop= driver.findElement(By.xpath( "//*[text()=' Agree ']"));
	      if(agreepop.isDisplayed() && agreepop.isEnabled()){
	    	  agreepop.click();
	      }
	     Thread.sleep(3000);
    /* driver.findElement(By.xpath("//*[text()=' Agree ']")).click();
      Thread.sleep(3000);*/
	    for( i=1;i<3;i++){
	     String klmfile ="C:\\Users\\Sparkelon\\Desktop\\Alekhya\\Klmm.xls";
				FileInputStream fis = new FileInputStream(klmfile );
		        Workbook wb =Workbook.getWorkbook(fis);
		        Sheet s=wb.getSheet("FromList");
		        int rowCount = s.getRows();
		        int colcount =s.getColumns();
		        Thread.sleep(4000);
		       		      
		      //from text box
		        		WebElement fromtext = driver.findElement(By.xpath("//div[@class='g-search-form--connections']//div[1]//label[1]//input[1]"));
		        		 fromtext.sendKeys(s.getCell(0,i).getContents());
		                Actions action = new Actions(driver);
		         
		                action.moveToElement(fromtext).build().perform();
		                fromtext.sendKeys(Keys.DOWN);
		                fromtext.sendKeys(Keys.RETURN);
		                Thread.sleep(3000);
		       //to text box
		                WebElement totext = driver.findElement(By.xpath("//div[@class='g-search-form--connections']//div[1]//label[2]//input[1]"));
		                totext.sendKeys(s.getCell(1,i).getContents());
		               // Actions action1 = new Actions(driver);
		                action.moveToElement(totext).build().perform();
		                totext.sendKeys(Keys.DOWN);
		                totext.sendKeys(Keys.RETURN);
		              
		               // driver.findElement(By.linkText("Eindhoven - Eindhoven Airport (EIN), Netherlands")).click();
		        		//"//div[@class='g-search-form--connections']//div[1]//label[2]/input"));
		   
		        Thread.sleep(3000);
		        //departure date
			       driver.findElement(By.xpath("//*[@id='est-search-homepage']/div[2]/div[2]/form/div/div[1]/label[3]/input")).click();
			       Thread.sleep(2000);
			       driver.findElement(By.xpath(s.getCell(2,i).getContents())).click();
			      // System.out.println(s.getCell(2,i).getContents());
			 			       
			       Thread.sleep(3000);
			       
			       //passengers
			        driver.findElement(By.xpath("//span[contains(text(),'Passengers')]")).click();
			        
			        driver.findElement(By.xpath("//div[@class='selectorView']//div[3]//div[1]//button[2]")).click();
			        		driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
			       Thread.sleep(3000);
			       //travel class dropdown
			       driver.findElement(By.xpath("//select[@class='g-search-form--input g-forms-selectbox']")).click();
			        Thread.sleep(2000);
			       // driver.findElement(By.xpath("//option[@value='ECONOMY']")).click();
			        driver.findElement(By.xpath(s.getCell(3,i).getContents())).click();
			        Thread.sleep(2000);
			       //view offers
	    	        driver.findElement(By.xpath("//div[@class='g-search-form--footer g-clear']//span")).click();
	    	        Thread.sleep(5000);
	    	        //next page
	    	       // WebDriverWait wait=new WebDriverWait(driver, 20);
    	        	//code for  choose a depaure filght link -- EUR...
		    	      // WebElement deptflightlink= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//span[@class='bf-flight-overview__price-button__amount g-hc-ignore']")));
	    	        WebElement deptflightlink=driver.findElement( By.xpath( "//span[@class='bf-flight-overview__price-button__amount g-hc-ignore']"));
		    	       
		    	       deptflightlink.click();
		    	        Thread.sleep(5000);
		    	       // WebElement availflightdate= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "/html/body/div[5]/div/div[2]/div/div/div/div[3]/div[1]/div[2]/div[2]/div/div[12]")));
		    	       // WebElement availflightdate= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "/html/body/div[5]/div/div[2]/div/div/div/div[3]/div/div[2]/div[3]/div/div[12]")));
		    	       /* Friday, November 30, 2018
		    	        WebElement img= driver.findElement(By.xpath("//*[@aria-label = 'Continue']"));
		    	        img.click();
		    	        Thread.sleep(3000);*/
		    	        WebElement availflightdate= driver.findElement(By.xpath("//*[@data-a11ydate = 'Saturday, May 11, 2019']"));
		    	       // WebElement availflightdate= driver.findElement(By.xpath(s.getCell(12,i).getContents()));
		    	        Thread.sleep(5000);


		    	        
		    	        /* WebElement availflightdate= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "/html/body/div[5]/div/div[2]/div/div/div/div[3]/div[1]/div[2]/div[2]/div/div[12]")));
		    	       availflightdate.click(); 
		    	        Thread.sleep(3000);*/
		    	       // WebElement availflightdate= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bf-fares__fare g-hc-ignore bf-fares__fare--more-day-bars bf-fares__fare--selected bf-fares__fare--bar bf-fares__fare--bar--lowest']")));
		    	        
		    	       /* driver.findElement((By.xpath( "//div[@class='bf-flight-overview__flex__price g-hc-ignore bf-flight-overview__flex__price--button']//button[@type='button'])"))).click();
		    	        Thread.sleep(3000);*/
		    	        
		    	        //code for  choose a return flight date --EUR....
		    	        Thread.sleep(7000);
		    	        
		    	      //*[@id="brandedFaresWidgetContainer"]/div/div/div[3]/div[2]/div/ul/li[2]/div[1]/div/div
		    	        
		    	        driver.findElement((By.xpath("//li[@class='bf-flight-list__item g-hc-ignore']"))).click();
		    	        
		    	        //driver.findElement((By.xpath( "/html/body/div[5]/div/div[2]/div/div/div/div[3]/div[2]/div/ul/li/div[1]/div/div/div[5]/button"))).click();
		    	        Thread.sleep(6000);
		    	        
		    	        //first page continue --we can see here continue,mail my search details
		    	        WebElement Continue =driver.findElement((By.xpath( "//*[@id='bf-continue-button']")));
		    	        
		    	        Continue.sendKeys(Keys.DOWN);
		    	        Thread.sleep(3000);
		    	        Continue.click();
		    	        Thread.sleep(9000);
		    	        JavascriptExecutor jse = (JavascriptExecutor)driver;
		    	        jse.executeScript("window.scrollBy(0,250)", ""); 
		    	        Thread.sleep(5000);
		    	        // 2nd page continue --we can see here back and continue buttons /html/body/div[6]/div/div/div/div[1]/div/div[1]/ul/li[5]/button[1]  /html/body/div[6]/div/div/div/div[1]/div/div[1]/ul/li[5]/button[1]
		    	       // WebElement Continue1= driver.findElement(By.xpath( "//*[@id=\"uniqueProductShopAppContainer\"]/div/div/div/div[1]/div/div[1]/ul/li[3]/button[1]/span"));
		    	       // WebElement Continue1 =driver.findElement((By.xpath("//*[@id=\"uniqueProductShopAppContainer\"]/div/div/div/div[1]/div/div[1]/ul/li[3]/button[1]/span")));
		    	        //	"//*[@id=\"uniqueProductShopAppContainer\"]/div/div/div/div[1]/div/div[1]/ul/li[3]/button[1]")));
		    	        		
		    	      //*[@id="uniqueProductShopAppContainer"]/div/div/div/div[1]/div/div[1]/ul/li[3]/button[1]
		    	        
		    	        
		    	        WebElement Continue1 =driver.findElement((By.xpath("//li[@class='ps-page-product-list-booking__product-list__navigation g-forms-button-group g-clear']//button[1]")));
		    		       
		    	        Continue1.sendKeys(Keys.DOWN);
		    	       
		    	      //li[@class='ps-page-product-list-booking__product-list__navigation g-forms-button-group g-clear']//button[1]
		    	        Thread.sleep(9000);
		    	        Continue1.click();
		    	        
		    	       //details submission
		    	        Thread.sleep(5000);
		    	        
		    	        jse.executeScript("window.scrollBy(0,250)", "");
		    	        WebElement Title = driver.findElement(By.xpath("//select[@id='passengerField_1000_title']"));
		    	        /*JavascriptExecutor js = (JavascriptExecutor) driver;
		    	        
		    	   	  js.executeScript("arguments[0].scrollIntoView();", Title);*/
		    	   	 // Title.sendKeys(Keys.DOWN); 
		    	   	  Select dropdown= new Select(Title);    
		    	   	  dropdown.selectByVisibleText("Mrs") ; 
		    	   	  
		    	   	  jse.executeScript("window.scrollBy(0,250)", "");
		    	   	  
		    	   	 /* String klmfile ="C:\\Users\\admin\\Desktop\\KLM\\Klmm.xls";
		    	   		FileInputStream fis = new FileInputStream(klmfile );
		    	         Workbook wb =Workbook.getWorkbook(fis);
		    	         Sheet s=wb.getSheet("ToList");
		    	         int rowCount = s.getRows();
		    	         int colcount =s.getColumns();*/
		    	         Thread.sleep(2000);
		    	         WebElement firstname = driver.findElement(By.id("passengerField_1000_firstName"));
		    	             //input[@id='passengerField_1001_firstName']
		    	   	  firstname.sendKeys(s.getCell(4,i).getContents());
		    	   	 //firstname.sendKeys("alekkk");
		    	   	Thread.sleep(2000);
		    	   	   WebElement lastname = driver.findElement(By.id("passengerField_1000_lastName"));
		    	   		//input[@id='passengerField_1001_lastName']
		    	   	   lastname.sendKeys(s.getCell(5,i).getContents());
		    	   	  // lastname.sendKeys("tttt");
		    	   	 //checkout-form-validation-group[@form-name='passengerField_1001_dateOfBirth']//select[@name='year']
		    	   	Thread.sleep(4000);
		    	   	  /*WebElement dayvisible=driver.findElement(By.xpath("//select[@name='day']"));
		    	   	  if(dayvisible.isDisplayed()) {
		    		Select day = new Select(driver.findElement(By.xpath("//select[@name='day']")));
		    		day.selectByIndex(6); 
		    	   	  }
		    		   Thread.sleep(1000);
		    		   WebElement monthvisible=driver.findElement(By.xpath("//select[@name='month']"));
			    	   	  if(dayvisible.isDisplayed()) {
		    	   	Select month = new Select(driver.findElement(By.xpath("//select[@name='month']")));
		    	   	   month.selectByIndex(6);
		    	    	Thread.sleep(1000);
			    	   	  }
			    	   	  Thread.sleep(1000);
		    	   	
		    	   	WebElement yearvisible=driver.findElement(By.xpath("//select[@name='year']"));
		    	   	  if(yearvisible.isDisplayed()) {
		    	   	Select year = new Select(driver.findElement(By.xpath("//select[@name='year']")));
			    	   	   year.selectByIndex(10);
			    	   	   Thread.sleep(4000);
		    	   	  }
			    */
		    	   	  Thread.sleep(4000);  
			    	   	     
		    	   	     driver.findElement(By.id("passengerField_1000_emailAddress")).sendKeys(s.getCell(8,1).getContents());
		    	   	     //sendKeys("thumatialekhya@gmail.com");
		    	   	     //sendKeys(s.getCell(1,10).getContents());
		    	   	     Thread.sleep(3000);
		    	   	    driver.findElement(By.id("passengerField_1000_phoneNumberFirst")).sendKeys(s.getCell(9,1).getContents());
		    	   	  //  sendKeys("657764287");
		    	   	    //sendKeys(s.getCell(1,11).getContents());
		    	   	   //adult title
		    	   	   
		    	   	  Thread.sleep(7000);
		    	   	  
		    	   	   WebElement Title1 = driver.findElement(By.id("passengerField_1001_title"));
		    	   	    
		    	   	  // Title1.sendKeys(Keys.DOWN);
		    	   		//  js.executeScript("arguments[0].scrollIntoView();", Title1);
		    	   		   Thread.sleep(2000);
		    	   		  Select dropdown1= new Select(Title1);    
		    	   		  dropdown1.selectByVisibleText("Mr") ; 
		    	   		
		    	   		  Thread.sleep(2000);
		    	   		
		    	   		  WebElement firstname1 = driver.findElement(By.id("passengerField_1001_firstName"));
		    	             //input[@id='passengerField_1001_firstName']
		    	   	 // firstname1.sendKeys(s.getCell(1,10).getContents());
		    	   	  firstname1.sendKeys("manuu");
		    	   	   WebElement lastname1 = driver.findElement(By.id("passengerField_1001_lastName"));
		    	   		//input[@id='passengerField_1001_lastName']
		    	   	   Thread.sleep(2000);
		    	   	   lastname1.sendKeys("madhineni");
		    	   	  // lastname1.sendKeys(s.getCell(1,11).getContents());
		    	   	 //checkout-form-validation-group[@form-name='passengerField_1001_dateOfBirth']//select[@name='day']
		    	   	 //checkout-form-validation-group[@form-name='passengerField_1000_dateOfBirth']//select[@name='day']
		    	   	  /* WebElement day1 =  driver.findElement(By.xpath("//checkout-form-validation-group[@form-name='passengerField_1001_dateOfBirth']//select[@name='day']"));
		    	   	  // day1.sendKeys(s.getCell(1,12).getContents());
		    	   	   day1.sendKeys("11");
		    	   	   Thread.sleep(2000);
		    	   	   WebElement month1=  driver.findElement(By.xpath("//checkout-form-validation-group[@form-name='passengerField_1001_dateOfBirth']//select[@name='month']"));
		    	   	 //  month1.sendKeys(s.getCell(2,12).getContents());
		    	   	   month1.sendKeys("January");
		    	   	   Thread.sleep(2000);
		    	   	   WebElement year1=  driver.findElement(By.xpath("//checkout-form-validation-group[@form-name='passengerField_1001_dateOfBirth']//select[@name='year']"));
		    	   	   //year1.sendKeys(s.getCell(3,12).getContents());
		    	   	   year1.sendKeys("1988");
		    	   	   Thread.sleep(2000);   */
		    	   	   jse.executeScript("window.scrollBy(0,700)", "");
		    	   	 driver.findElement(By.xpath("//h3[contains(text(),'No insurance')]")).click();
		    	   	   Thread.sleep(2000);   
		    	   	   
		    	   	   WebElement submit =driver.findElement(By.xpath("//*[@id='checkout-step-submit']"));
		    	   	   
		    	   	   Thread.sleep(10000); 
		    	   	 submit.click();
		    	     Thread.sleep(7000);   
		    	     driver.get("https://www.klm.com/home/nl/en");
		    	     Thread.sleep(5000); 
		    	 /*	driver.findElement(By.xpath("   //a[contains(text(),'KLM for business')]")).click();
		    	    Thread.sleep(7000);*/ 
	    	     		}
	}

}
