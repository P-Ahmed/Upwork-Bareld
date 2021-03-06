import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DownloadFile {
    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "C:/Utility/Downloads/");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("start-maximized");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        driver =  new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        driver.get("https://94.214.202.174:8443/");
        Thread.sleep(2000);

        driver.findElement(By.name("sUserName")).sendKeys("admin");
        driver.findElement(By.name("sSysPass")).sendKeys("Draytek");
        driver.findElement(By.name("btnOk")).click();

        Thread.sleep(3000);
        driver.switchTo().frame("menu");
        driver.findElement(By.xpath("//font[contains(text(),'System Maintenance')]")).click();
        driver.findElement(By.xpath("//font[contains(text(),'Configuration Backup')]")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("main");
        driver.switchTo().frame("cfgMain");
        //Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/form/table[2]/tbody/tr/td/form[1]/table/tbody/tr[5]/td/input")).click();
        Thread.sleep(2000);

        //Press the keyboard key "Enter"
        Robot keyPress = new Robot();
        keyPress.keyPress(KeyEvent.VK_ENTER);

        Thread.sleep(5000);

        driver.quit();
    }
}
