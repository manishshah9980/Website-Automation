

package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationOfAutomation {
    static protected WebDriver driver;
    // METHOD 1 WAIT FOR CLICKABLE
    public void waitUntilClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //METHOD 2 WAIT UNTIL VISIBLE
    public void waituntilvisible(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    // METHOD 3 WAIT UNTIL ELEMENT PRESENT
    public void waituntilElementPresent(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
    // METHOD FOR DROP DOWN BY INDEX CREATED
    public void selectFromDropDownByIndex(By by, int index) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }
    // METHOD FOR DROP DOWN BY VALUE CREATED
    public void selectFromDropdownByvalue(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }
    // METHOD FOR DROPDOWN FOR VISIBLE CREATED
    public void selectFromDropDownByVisible(By by, String visibleText) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(visibleText);
    }
    // METHOD FOR TIMESTAMP CREATED
    public String timestamp() {
        DateFormat dateFormat = new SimpleDateFormat("ddmmyyHHmmss");
        Date date = new Date();
        return (dateFormat.format(date));
    }


    // METHOD 4 GET TEXT FROM ELEMENT
    public String getTextfromElement(By by)
    {
        return driver.findElement(by).getText();
    }

    // METHOD 5 CLICK ON ELEMENT
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    // METHOD 6 ENTER THE TEXT(SEND KEY)
    public void enterText(By by,String text) {
        driver.findElement(by).sendKeys(text);
    }

    // METHOD 11 FOR @ BEFORE
    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/BrowserDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 50);
    }
    //METHOD FOR AFTER TEST
    @AfterTest
    public void aftertest(){
        driver.close();
    }


    @Test

    public void userShouldAbleToRegisterSuccessFully_Asda() {
     // BEFORE TEST METHOD CREATED
        beforeTest();

      //OPEN URL
        driver.get(" https://www.asda.com/");

     // FIND ELEMENT AND CLICK ON GROCERIES
        clickOnElement(By.linkText("Groceries"));


     // FIND THE ELEMENT AND CLICK ON REGISTER
        clickOnElement(By.linkText("Register"));

     // FIND THE ELEMENT AND ENTER EMAIL ADDRESS (BY USING TIMESTAMP )
        enterText(By.xpath("//input[@type='email']"),"manish"+timestamp()+"@yahoo.com");

     // FIND THE ELEMENT AND TYPE THE PASSWORD
        enterText(By.xpath(" //input[@type='password']"),"Abcd@1234");

     // FIND THE ELEMENT AND ENTER THE POSTCODE
        enterText(By.xpath("//input[@type='text']"),"Al108pj");

     // FIND THE ELEMENT AND CLICK ON TERMS AND CONDITIONS
        clickOnElement(By.className("checkmark"));

     // FIND THE ELEMENT AND CLICK ON REGISTER TO COMPLETE REGISTRATION
        clickOnElement(By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/button"));

     // ASSERT STATEMENT CREATED
        String expected = "welcome to asda";
        String actual = String.valueOf(By.xpath("//*[@id=\"root\"]/main/section/main/div[2]/div[1]/div/div[1]"));
        Assert.assertEquals("failed",expected,actual);



    }

    @Test

    public void UserShouldRegisterSuccessfullyMockplus() {
      // BEFORE TEST CREATED
        beforeTest();

     // OPEN URL:
        driver.get("https://www.mockplus.com/");

     //FIND ELEMENT AND CLICK ON REGISTER
        clickOnElement(By.linkText("Register"));

     //FIND THE ELEMENT AND ENTER EMAIL ID USING TIMESTAMP
        enterText(By.id("email"),"manish"+timestamp()+"@yahoo.com");

     // ENTER THE PASSWORD
        enterText(By.id("password"),"Abcd@1234");

     // CONFIRM PASSWORD
        enterText(By.id("cofPassword"),"Abcd@1234");

     // CLICK ON TERMS AND CONDITIONS
        clickOnElement(By.xpath("//*[@id=\"agree\"]/span[1]"));

     // CLICK ON RESTER TO FINISH REGISTERATION
        clickOnElement(By.xpath("//*[@id=\"register\"]"));

        // USING ASSERT STATEMENT FOR WELCOME MESSAGE
        String expected = "thanks for registering mockplus";
        String actual = String.valueOf(driver.findElement(By.xpath("//*[@id=\"chooseProduct\"]/div[1]/h1")));
        Assert.assertEquals("failed",expected,actual);

    }

    @Test

    public void UserShouldRegisterSucessfullyAmazon() {
      // BEFORE TEST CREATED
        beforeTest();

      // OPENING URL:
        driver.get("https://www.amazon.co.uk/");

      // FIND ELEMENT AND CLICK ON MY ACCOUNT
        clickOnElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));

     //   FIND ELEMENT AND CLICK ON REGISTER
        clickOnElement(By.xpath("//*[@id=\"auth-create-account-link\"]"));

      // FIND ELEMENT AND ENTER THE NAME
        enterText(By.xpath("//*[@id=\"ap_customer_name\"]"),"manish");

     // FIND ELEMENT AND ENTER THE EMAIL
        enterText(By.xpath("//*[@id=\"ap_email\"]"),"manish"+timestamp()+"@gmail.com");

      // FIND THE ELEMENT AND ENTER THE PASSWORD
        enterText(By.name("password"),"Manish@9999");

      // FIND THE ELEMENT AND RE-ENTER THE PASSWORD
        enterText(By.name("passwordCheck"),"Manish@9999");

     // CLICK ON CONTINUE TO GET THE WELCOME MESSAGE
        clickOnElement(By.id("continue"));

      // ASSERT STATEMENT CREATED FOR VERIFY YOUR EMAIL DISPLAYED IN THE END MESSAGE
        String expected = "Verify your email";
        String actual = String.valueOf(By.xpath("//*[@id=\"cvf-page-content\"]/div/div/div[1]/form/div[1]/div[1]/h1"));
        Assert.assertEquals("failed",expected,actual);
    }

    @Test

    public void UserShouldRegisterSuccessfullyDominos() {

      // @BEFORE METHOD USED
        beforeTest();

      // OPEN URL
        driver.get("https://www.dominos.co.uk/");

      // FIND ELEMENT AND CLICK ON REGISTER
        clickOnElement(By.xpath("//*[@id=\"account-overlay\"]/ul/li[2]/a"));

     // FIND ELEMENT AND ENTER THE NAME
        enterText(By.xpath("//*[@id=\"registerPanel\"]/div/form/div[1]/div[1]/input"),"manish");

     // FIND ELEMENT AND ENTER THE PASSWORD
        enterText(By.name("Password"),"Manish@1234");

     //FIND ELEMENT AND ENTER MOBILE NUMBER
        enterText(By.xpath("//*[@id=\"registerPanel\"]/div/form/div[1]/div[2]/input"),"07533360517");

     //FIND ELEMENT AND ENTER EMAIL ADDRESS(BY USING TIMESTAMP
       enterText(By.xpath("//*[@id=\"registerPanel\"]/div/form/div[1]/div[3]/input"),"manish"+timestamp()+"@gmail.com");

     //FIND ELEMENT AND ENTER POSTCODE
       enterText(By.xpath("//*[@id=\"register_postcodeLookup\"]"),"al109dw");

     //FIND ELEMENT AND CLICK ON REGISTER TO COMPLETE REGISTRATION
        clickOnElement(By.xpath("//*[@id=\"registerPanel\"]/div/form/div[3]/button"));
    }

    @Test
    // DUE TO LACK OF TIME I HAVE NOT USED REUSABLE METHOD IN THE LAST PROGRAM

    public void UserShouldRegisterSuccessfullyOcado()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/java/BrowserDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ocado.com/");
        WebDriverWait wait = new WebDriverWait(driver, 50);
        driver.findElement(By.linkText("Register")).click();
        selectFromDropdownByvalue(By.xpath("//select[@id=\"title\"]"),"Mrs");
        driver.findElement(By.id("firstName")).sendKeys("manisha");
        driver.findElement(By.id("lastName")).sendKeys("shah");
        driver.findElement(By.xpath("//*[@id=\"login\"]")).sendKeys("mamnish"+timestamp()+"@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("Manish@9988");
        driver.findElement(By.id("postcode")).sendKeys("Al109dw");
        driver.findElement(By.xpath("//*[@id=\"registration-submit-button\"]")).click();
        String expected = "welcome to ocado";
        String actual = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/h3")).getText();
        Assert.assertEquals("failed",expected,actual);


    }


}





