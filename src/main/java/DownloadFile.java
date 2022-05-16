import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DownloadFile {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;

        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "C:/Utility/Downloads/");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("start-maximized");
        driver =  new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.vkd.nl/download/file.cfg");
        Thread.sleep(5000);

        driver.quit();
    }
}
