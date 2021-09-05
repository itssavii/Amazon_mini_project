package mini_project_amazon;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.time.LocalDateTime;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class amazon_project 
{
	private static String Module_name = null;
	private static String Test_result = null;
	private static String Comment = null;
	static WebDriver driver;
	public static void main(String args[]) throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver","E:\\thinkQ\\chrome_driver\\chromedriver.exe");	
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		login();
		readExcel();///for text file
		System.out.println("******************************************");
		System.out.println("End of Code");
		endCode();
		getOutput();
		
	}

	public static void login() throws IOException
	{
		Module_name="Login";
		///get user name and password from text file 
		File file = new File("E:\\software\\think\\Data.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		Properties prop = new Properties();
		prop.load(new FileInputStream(file));
		String user = prop.getProperty("username");
		String pass = prop.getProperty("password");
		while ((st = br.readLine()) != null)
			System.out.println(st);
		WebElement signin = driver.findElement(By.xpath("//div[@class='nav-line-1-container']"));
		signin.click();
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(user);
		WebElement next = driver.findElement(By.xpath("//input[@id='continue']"));
		next.click();
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(pass);
		WebElement login = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		login.click();
		System.out.println("Welcome - USER:::");
		System.out.println("Loggin Succesfully:::");
		System.out.println("......................");
		System.out.println("......................");
		String firstUrl= "https://www.amazon.in/";
		String secondUrl ="https://www.amazon.in/?ref_=nav_ya_signin&";
		if(firstUrl!=secondUrl)
		{
			Test_result ="Pass";
			Comment = "Loggin Succesfully";
			
		}
		else
		{
			Test_result ="Fail";
			Comment = "Loggin Not Succesfully";	
		}
		WriteTest_toTxt("TestData.txt",Module_name,Test_result,Comment);
	}
	
	

	public static void readExcel() throws IOException
	{
		Module_name = "Read Excel Data";
		try 
		{
		
			File file = new File("E:\\software\\think\\src\\Excel\\productData.xlsx"); //create file object and give the path to file	   
			FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file
			//creating Workbook instance that refers to .xlsx file
			XSSFWorkbook wb= new XSSFWorkbook(fis); //create a workbook instance
			XSSFSheet Sheet1= wb.getSheetAt(0); //create sheet object 
			
			String product0= Sheet1.getRow(1).getCell(0).getStringCellValue();
			String product1= Sheet1.getRow(2).getCell(0).getStringCellValue();
			String product2= Sheet1.getRow(3).getCell(0).getStringCellValue();
			String product3= Sheet1.getRow(4).getCell(0).getStringCellValue();
		
			System.out.println("***************************************");
			System.out.println(product0);
			System.out.println(product1);
			System.out.println(product2);
			System.out.println(product3);
			System.out.println("***************************************");
		
			Search(product0,product1,product2);
			wb.close();
			Test_result="Pass";
			Comment = "Read Succesfully";
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		WriteTest_toTxt("TestData.txt",Module_name,Test_result,Comment);
		
	}

	private static void Search(String product0, String product1, String product2) throws IOException 
	{
		
		// TODO Auto-generated method stub
		//product1 search and print to 5 result
		 WebElement txtbox1 = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		 txtbox1.sendKeys(product0);
		 WebElement check1 = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		 check1.click();
		 System.out.println("List of top 5 result of product 3");
		 System.out.println(product0);
		 printTopItemList();
		
		 System.out.println("******************************************");
		 //product 2 search and print to 5 result
		 driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();//clear previous search result
		 WebElement txtbox2 = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		 txtbox2.sendKeys(product1);
		 WebElement check2 = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		 check2.click();
		 System.out.println("List of top 5 result of product 2 ");
		 System.out.println(product1);
		 printTopItemList();
		
		 System.out.println("******************************************");
		 //product 3 search and print to 5 result
		 driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		 WebElement txtbox3 = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		 txtbox3.sendKeys(product2);
		 WebElement check3 = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		 check3.click();
		 System.out.println("List of top 5 result of product 3 ");
		 System.out.println(product2);
		 printTopItemList();
		 System.out.println("done");
	}
	
	public static void printTopItemList() 
	{
		//print top 5 result as per search product
		WebElement topResult = driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']"));
		List<WebElement> links = topResult.findElements(By.tagName("h2"));
		for (int i = 1; i <= 5; i++)
		{
			    System.out.println("Result"+(i)+"->" +links.get(i).getText());
		}

	}
		
	public static void endCode()
	{	
		driver.close();
	}
	
	private static void WriteTest_toTxt(String string, String Module_name, String Test_result, String Comment) throws IOException 
	{
		File txtfile = new File("TestData.txt");
		try
		{
			FileWriter fw = new FileWriter(txtfile,true);
		// TODO Auto-generated method stub
			fw.write("\r\n");
			fw.write("Module name::"+Module_name);
			fw.write("\r\n");
			fw.write("ModuleName ::");
			fw.write("TestResult ::");
			fw.write("Comment");
			fw.write("\r\n");
			fw.append(Module_name +"::");
			fw.append(Test_result+"::");
			fw.append(Comment);
			fw.write("\r\n");
			fw.flush();
			fw.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println(e);
		} 
		
		
	}
	
	public static void getOutput()
	{
		try 
		{
	          // Save original out stream.
	           PrintStream originalOut = System.out;
	           // Save original err stream.
	           PrintStream originalErr = System.err;
              // Create a new file output stream.
	           PrintStream fileOut = new PrintStream("./out.txt");
	            // Create a new file error stream. 
	            PrintStream fileErr = new PrintStream("./err.txt");
	            // Redirect standard out to file.
	            System.setOut(fileOut);
	            // Redirect standard err to file.
	            System.setErr(fileErr);
	            // Wrapped Scanner to get user input.
	            Scanner scanner = new Scanner(System.in);

		 }
		 catch(IOException e1) 
		 {
		       System.out.println("Error during reading/writing");
		 }
		
	}

}


