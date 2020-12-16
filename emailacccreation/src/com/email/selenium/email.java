/* code  written by YISTECH purely in java 
*if you want to use this code elsewhere, make sure 
*to credit me!
*feel to free to make changes to this code yourself locally
*if you are not experienced with java, I have written some comments in the slashes helping
*you identify what line of code does what exactly.
*/
package com.email.selenium;


import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class email{
public static void main(String[] args) throws InterruptedException {
	int leftLimit = 48; // numeral '0'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 10;
System.setProperty("webdriver.gecko.driver","/home/yistech/Selenium_Setup/geckodriver"); // Setting system properties of FirefoxDriver
WebDriver driver = new FirefoxDriver();//Creating an object of FirefoxDriver
Random random = new Random(); //creation new Random object
String generatedString = random.ints(leftLimit, rightLimit + 1)
.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
.limit(targetStringLength)
.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
.toString();
String url = "https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&dsh=S637702215%3A1607537520274806&gmb=exp&biz=false&flowName=GlifWebSignIn&flowEntry=SignUp";
System.out.println(generatedString);
driver.get(url); //loads the url , account creation
//the lines below are used if we set normal gmail page
//driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/ul[1]/li[2]/a")).click();
//driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div/div/span/span")).click();
String usr = "emailacc".concat(generatedString); 
//join strings , generated and tunnel
String psswd = generatedString;
WebElement firstname = driver.findElement(By.name("firstName"));
String frst = "Tunnel";
firstname.sendKeys(frst);

Thread.sleep(1000);
WebElement lastname = driver.findElement(By.name("lastName"));
lastname.sendKeys("BEAR");

Thread.sleep(1000);
WebElement Username = driver.findElement(By.name("Username"));
Username.sendKeys(usr); 
Thread.sleep(1000);
WebElement password = driver.findElement(By.name("Passwd"));
password.sendKeys(psswd);
Thread.sleep(1000);
driver.findElement(By.name("ConfirmPasswd")).sendKeys(psswd);

System.out.println("email acc: "+ usr);
System.out.println("password: " + psswd);


//Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/div[2]")).click();

}
}