

package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationOfAutomation {
    static protected WebDriver driver;

    @Test

    public void userShouldAbleToRegisterSuccessFully_Asda() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/BrowserDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://www.asda.com/");
        WebDriverWait wait = new WebDriverWait(driver, 50);
        driver.findElement(By.linkText("Groceries")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("manish_shah9999@yahoo.com");
        driver.findElement(By.xpath(" //input[@type='password']")).sendKeys("Abcd@1234");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Al108pj");
        driver.findElement(By.className("checkmark")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/button")).click();


    }

    @Test

    public void UserShouldRegisterSuccessfullyMockplus() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/BrowserDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mockplus.com/");
        WebDriverWait wait = new WebDriverWait(driver, 50);
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("email")).sendKeys("manish_shah9999@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("Abcd@1234");
        driver.findElement(By.id("cofPassword")).sendKeys("Abcd@1234");
        driver.findElement(By.xpath("//*[@id=\"agree\"]/span[1]")).click();
    }

    @Test

    public void UserShouldRegisterSucessfullyAmazon() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/BrowserDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.co.uk/");
        WebDriverWait wait = new WebDriverWait(driver, 50);
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"auth-create-account-link\"] ")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_customer_name\"]")).sendKeys("manish");
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("manish9999shah@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Manish@9999");
        driver.findElement(By.name("passwordCheck")).sendKeys("Manish@9999");
        driver.findElement(By.id("continue")).click();
    }

    @Test

    public void UserShouldRegisterSuccessfullyDominos() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/BrowserDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.dominos.co.uk/");
        WebDriverWait wait = new WebDriverWait(driver, 50);
        driver.findElement(By.xpath("//*[@id=\"account-overlay\"]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"registerPanel\"]/div/form/div[1]/div[1]/input")).sendKeys("manish");
        driver.findElement(By.name("Password")).sendKeys("Manish@1234");
        driver.findElement(By.xpath("//*[@id=\"registerPanel\"]/div/form/div[1]/div[2]/input")).sendKeys("07533360517");
        driver.findElement(By.xpath("//*[@id=\"registerPanel\"]/div/form/div[1]/div[3]/input")).sendKeys("manish9999shah@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"register_postcodeLookup\"]")).sendKeys("al109dw");
        driver.findElement(By.xpath("//*[@id=\"registerPanel\"]/div/form/div[3]/button")).click();
    }

    @Test

    public void UserShouldRegisterSuccessfullyOcado()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/java/BrowserDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ocado.com/");
        WebDriverWait wait = new WebDriverWait(driver, 50);
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("title")).click();
        driver.findElement(By.name("title")).sendKeys("mrs");
        driver.findElement(By.id("firstName")).sendKeys("manisha");
        driver.findElement(By.id("lastName")).sendKeys("shah");
        driver.findElement(By.xpath("//*[@id=\"login\"]")).sendKeys("mamnish_shah9999@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("Manish@9988");
        driver.findElement(By.id("postcode")).sendKeys("Al109dw");
        driver.findElement(By.xpath("//*[@id=\"registration-submit-button\"]")).click();


    }


}





