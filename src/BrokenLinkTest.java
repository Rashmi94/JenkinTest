import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenLinkTest {

    private static WebDriver driver;

    @BeforeTest
    public void launchBrowser()
    {
        this.driver = new ChromeDriver();
    }

    @Test
    public void linkTest()
    {
        this.driver.get("https://the-internet.herokuapp.com/broken_images");
        this.driver.findElements(By.xpath("//*[@src]")).stream()
                .map(y -> y.getAttribute("src"))
                .forEach(y -> System.out.println(y));
    }

    @AfterTest
    public void quitDriver()
    {
        this.driver.quit();
    }
}
