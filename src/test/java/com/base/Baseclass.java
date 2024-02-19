package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public static WebDriver driver;

	public void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public void maximizewindows() {
		driver.manage().window().maximize();
	}

	public void enterurl(String url) {
		driver.get(url);
	}

	public void elementsendkeysjs(WebElement element, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}

	public void elementclick(WebElement element) {
		element.click();
	}

	public void clearText(WebElement element) {
		element.clear();
	}

	public WebElement findlocatorById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}

	public WebElement findlocatorByName(String attributevalue) {
		WebElement element = driver.findElement(By.name(attributevalue));
		return element;
	}

	public WebElement findlocatorByclassName(String attributevalue) {
		WebElement element = driver.findElement(By.className(attributevalue));
		return element;
	}

	public WebElement findlocatorByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	public String getappTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String getappurl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public void closeWindow() {
		driver.close();
	}

	public void quitwkndows() {
		driver.quit();
	}

	// get text
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public static String getProjectLoc() {
		String path = System.getProperty("user.dir");
		return path;
	}

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectLoc() + "\\Config\\config.propertities"));
		return (String) properties.get(key);
	}

	public static void getBrowser(String browserType) {

//		switch (browserType) {
//		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
//			break;
//		case "firefox":
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//			break;
//		case "ie":
//			WebDriverManager.iedriver().setup();
//			driver = new InternetExplorerDriver();
//			break;
//		case "edge":
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//			break;
//		default:
//			break;
//		}
	}

	public void enterkey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public Actions moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		return action;
	}

	public void DoubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick().perform();
	}

	public void contectclick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void referesh() {
		driver.navigate().refresh();
	}

	public void forward() {
		driver.navigate().forward();
	}

	public void backward() {
		driver.navigate().back();
	}

	public void launchUrl(String value) {
		driver.navigate().to(value);
	}

	public void sleep(int num) throws InterruptedException {
		Thread.sleep(num);
	}

	public WebElement getFirstSelectedOptions(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		return firstSelectedOption;
	}

	public static void selectOptionByText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public void selectOptionByAttribute(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public void selectOptionByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public void deselectByText(WebElement element, String text) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);
	}

	public void deselectByAttribute(WebElement element, String value) {
		Select s = new Select(element);
		s.deselectByValue(value);
	}

	public void implicitwait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	
	/*
	 * public void explicitwait( WebDriverWait wait, WebElement element, String
	 * input) { wait = new WebDriverWait(driver, Duration.ofSeconds(30)); element =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(input))); }
	 */
	 

	public void insertvaluetextbox(WebElement element, String input) {

		element.sendKeys(input);

	}

	public void OkInAlert() {
		driver.switchTo().alert().accept();
	}

	public void cancelInAlert(Alert alert) {
		alert.dismiss();
	}

	public String getTextFromWebPage(WebElement element) {
		String text = element.getText();
		return text;
	}

	
	  public String getattribute(WebElement element, String value) { String
	  attribute = element.getAttribute(value); return attribute; }
	 
	
	public String getattribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	public void closeallWindows() {
		driver.quit();
	}

	public void closecurrentwindows() {
		driver.close();
	}

	public void insertvalueTextBoxusingjs(WebElement element, String input) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + input + "')", element);
	}

	public void clickButtonByjs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public void scrollDownusingjs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public void scrollupusingjs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	public void takescreenshot(String path) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileUtils.copyFile(source, destination);
	}

	public File file(String value) {
		File file = new File(value);
		return file;
	}

	public void Sysoutput(String name) {
		System.out.println(name);
	}

	public void Sysout(WebElement element) {
		System.out.println(element);
	}

	public String getDatafromcell(String sheet1, int rownum, int column) throws IOException {
		String res = " ";
		File f = new File("C:\\Users\\ADMIN\\eclipse-workspace\\SessionDay2\\Excel\\execl.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet(sheet1);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(column);
		// String stringCellValue = cell.getStringCellValue();
		// System.out.println(stringCellValue);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
				res = dateformat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long round = Math.round(numericCellValue);

				if (numericCellValue == round) {
					res = String.valueOf(round);

				} else {
					res = String.valueOf(numericCellValue);

				}
			}
		default:
			break;
		}
		return res;

	}

	public void writeincell(String sheet1, int rownum, int cellnum, String name) throws IOException {
		File f = new File("C:\\Users\\ADMIN\\eclipse-workspace\\SessionDay2\\Excel\\execl.xlsx");
		// to get the location
		Workbook book = new XSSFWorkbook();
		// to get the sheet
		Sheet sheet = book.createSheet(sheet1);
		// to create a row
		Row createRow = sheet.createRow(rownum);
		// to create a cloumn
		Cell createCell = createRow.createCell(cellnum);
		createCell.setCellValue(name);
		FileOutputStream out = new FileOutputStream(f);
		book.write(out);
	}
	/*
	 * public List getAllSelectedOptions(WebElement element) { Select s=new
	 * Select(element); List<WebElement> allSelectedOptions =
	 * s.getAllSelectedOptions(); return allSelectedOptions; } /*public List
	 * getSelectedOptions(WebElement element) { Select s=new Select(element);
	 * List<WebElement> SelectedOptions = s.getASelectedOptions(); return
	 * SelectedOptions; } public List getOptions(WebElement element) { Select s=new
	 * Select(element); List<WebElement> options = s.getOptions(); return options; }
	 */

}
