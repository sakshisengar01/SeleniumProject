package day4;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Getdata {		
		@DataProvider
		@Test
	   public String[][] SendData()throws BiffException, IOException {	
		String data[][];
		String  path = "C:\\Users\\chak\\OneDrive\\Desktop\\Login.xls";		
		FileInputStream f  = new FileInputStream(path);		
		Workbook workbook = Workbook.getWorkbook(f);		
		Sheet sheet = workbook.getSheet("One");
		int row = sheet.getRows();
		int col = sheet.getColumns();
		System.out.println(row);
		System.out.println(col);
		data = new String[row][col];
		//Cell cell =  sheet.getCell(1,1);		
		//String value = cell.getContents();		
		//System.out.println(value);		
		for(int i=0;i<row;i++)			
		{
			for(int j=0;j<col;j++)
			{
				Cell cell =  sheet.getCell(j,i);
				String value = cell.getContents();
				//System.out.println(value);
				data[i][j] = value;	
				//System.out.println(data[i][j]);
			}
		}
		return data;		
	}
	@Test(dataProvider = "SendData")
	void GetDatafromexcel(String username , String pass , String Language) throws InterruptedException
	{
		System.out.println(username);
		System.out.println(pass);
		System.out.println(Language);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.openemr.io/openemr/interface/login/login.php?site=default");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='authUser']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='clearPass']")).sendKeys(pass);
		
		Select sel = new Select(driver.findElement(By.xpath("//*[@id='login_form']/div[3]/div/select")));
		sel.selectByVisibleText(Language);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='login-button']"));
		Thread.sleep(2000);
	}

}
