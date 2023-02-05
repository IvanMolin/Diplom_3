package ru.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void startUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // для того, чтобы запустить тест в яндекс браузере, необходимо закомменитровать строки выше
        // и раскомментировать строки ниже
        /*System.setProperty("webdriver.chrome.driver", "/Users/macbook/Desktop/WebDriver/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        driver = new ChromeDriver(options);*/
        driver.get("https://stellarburgers.nomoreparties.site");
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    @After
    public void cleanUp(){
        driver.quit();
    }
}
