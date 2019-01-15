package soapuipoject;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.Sheet;
import jxl.Workbook;

public class Testsoap {

	public static void main(String[] args) throws Exception {
		 try {
		       
		        FileInputStream fis = new FileInputStream("Z:\\Documents\\Bas\\blog\\datasources\\testdata.xls");
		        // Access the required test data sheet
		        
		        Workbook wb =Workbook.getWorkbook(fis);
		        Sheet s=wb.getSheet("testdata");
		        int rowCount = s.getRows();
		        int colcount =s.getColumns();
		        Thread.sleep(4000);
		       		      
		      
		        // Loop through all rows in the sheet
		        // Start at row 1 as row 0 is our header row
		        for(int i = 1;i<=10;i++){
		          
		            // Run the test for the current test data row
		            runTest(s.getCell(0,1).toString(),s.getCell(0,2).toString());
		        }
		        fis.close(); 
		    } catch (IOException e) {
		        System.out.println("Test data file not found");
		    }   

	}

	
	public static void runTest(String strSearchString, String strPageTitle) throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sparkelon\\Desktop\\Alekhya\\SeleniumNew\\drivers\\geckodriver.exe");
		
	   
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
	    driver.manage().window().maximize();
	    Thread.sleep(7000);	

	    // Enter the search string and send it
	    WebElement element = driver.findElement(By.name("q"));
	    element.sendKeys(strSearchString);
	    element.submit();
	     
	    // Check the title of the page
	    if (driver.getTitle().equals(strPageTitle)) {
	        System.out.println("Page title is " + strPageTitle + ", as expected");
	    } else {
	        System.out.println("Expected page title was " + strPageTitle + ", but was " + driver.getTitle() + " instead");
	    }
	     
	    //Close the browser
	    driver.quit();
	}

}
