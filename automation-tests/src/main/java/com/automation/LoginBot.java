package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginBot{
    public static void main(String[] args) throws InterruptedException{ // allows us to use Thread.sleep to pause and watch

        // Set up the driver
        WebDriverManager.chromedriver().setup();

        //Open browser
        WebDriver driver = new ChromeDriver();

        try {
            // Go to the website
            Thread.sleep(3000);
            driver.get("http://localhost:3000");
            driver.manage().window().maximize(); // makes the window full screen

            WebElement userBox =  driver.findElement(By.id("username"));
            userBox.sendKeys("Holly");

            WebElement passBox = driver.findElement(By.id("password"));
            passBox.sendKeys("pass123");

            WebElement registerBtn = driver.findElement(By.id("register-btn"));
            registerBtn.click();

            Thread.sleep(2000);

            WebElement displayTxt = driver.findElement(By.id("message-display"));
            String expectedText = displayTxt.getText();
            if (expectedText.equals(expectedText)){
                System.out.println("PASSED");
            }else{
                System.out.println("FAILED");
            }
            userBox = driver.findElement(By.id("username"));
            userBox.clear();
            userBox.sendKeys("Holly");

            passBox = driver.findElement(By.id("password"));
            passBox.clear();
            passBox.sendKeys("pass123");

            WebElement loginBtn = driver.findElement(By.id("login-btn"));
            loginBtn.click();

            Thread.sleep(3000);

            WebElement finalMessage = driver.findElement(By.id("message-display"));
            String loginText = finalMessage.getText();

            if (loginText.equals("Login Successful")){
                System.out.println("PASSED");
            }else{
                System.out.println("LOGIN TEST FAILED: Got: " + loginText);
            }
        }


        finally {
            driver.quit();
        }

/*  Finding Elements (WebElement) - driver.findElement(By.id("...")), this returns a WebElement object
    the following can be done with WebElement:
        element.sendKeys("text") - Types into a input text box
        elemnet.click() - Clicks a button
        element.clear(): This wipes the text box clean
 */



    }
}