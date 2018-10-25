package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

	public static WebDriver driver;
	public Properties properties;
	public String data_properties_path = "/Users/tellsworth16/Documents/Career/Selenium/";
	
	
   /**
	* Initializes the WebDriver
 	* @return WebDriver
 	* @throws IOException
 	*/
	public WebDriver initializeDriver() throws IOException {
		
		//Sets property file
		properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(data_properties_path + "/DraftKingsSeleniumAutomationTesting/src/main/java/resources/data.properties");
		properties.load(fileInputStream);
		
		//Creates WebDriver object based on type of browser
		String browserName = properties.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", properties.getProperty("driver.path"));
			driver = new ChromeDriver();	
		}
		else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();	
		}
		else {
			driver = new InternetExplorerDriver();	
		}
		
		//Maximize Browser
		driver.manage().window().maximize();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Launch DraftKings.com
		driver.get(properties.getProperty("url"));
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlContains(properties.getProperty("url")));
		
		return driver;
	}
	

	/**
	 * Takes screenshot of current screen.  Used in Listeners.java when test fails
	 * @param testName
	 * @throws IOException
	 */
	public void getScreenshot(String testName) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File(properties.getProperty("screenshotsPath") + testName + "_screenshot.png"));
	}	
	
	
	/**
	 * Takes downloaded file from DraftKings website and returns all players based on desired position
	 * @param position
	 * @return
	 * @throws IOException
	 */
	public ArrayList<String> getAllAvailablePlayersByPostition(String position) throws IOException {

		ArrayList<String> listOfPlayers = new ArrayList<String>();
		
		//Read in list of available players from XSLX file
		FileInputStream file = new FileInputStream(properties.getProperty("DraftKingsPlayersXLSX") + "DKSalaries.xlsx"); 
		XSSFWorkbook workBook = new XSSFWorkbook(file);	
		XSSFSheet sheet = workBook.getSheetAt(0);

		Iterator<Row> rows = sheet.rowIterator();
		Row firstRow = (Row) rows.next();


		//Get index of position and name column
		int positionColumn = 0;
		int nameColumn = 0;
		for(Cell categories : firstRow) {
			if(categories.getStringCellValue().equals("Position")){
				positionColumn = categories.getColumnIndex();
			}
			
			if(categories.getStringCellValue().equals("Name")){
				nameColumn = categories.getColumnIndex();
			}
		}
		
		//Returns all players from position stated in parameter
		for(Row allRows : sheet) {
			if(allRows.getCell(positionColumn).getStringCellValue().equals(position)) {
				listOfPlayers.add(allRows.getCell(nameColumn).getStringCellValue());
			}
		}
		
		return listOfPlayers;
	}	

}
	

