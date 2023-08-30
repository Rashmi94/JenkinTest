import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.function.Predicate;

public class test {
    static Predicate<List<WebElement>> male = y -> y.get(1).getText().equalsIgnoreCase("MALE");
    static Predicate<List<WebElement>> country = y -> y.get(2).getText().equalsIgnoreCase("AU");
    static Predicate<List<WebElement>> female = y -> y.get(1).getText().equalsIgnoreCase("FEMALE");

    static WebDriver driver = new ChromeDriver();
    public test(WebDriver driver)
    {
        this.driver = driver;
    }

    public static void main(String[] args)
    {
/*        ChromeOptions co = new ChromeOptions();
        co.setBrowserVersion("115");*/

        driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
        new test(driver).selectFunction(male.and(country));
      //  new test(driver).selectFunction(female);
    }

    public void selectFunction(Predicate<List<WebElement>> p)
    {
        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        rows.stream()
                .skip(1)
                .map(y -> y.findElements(By.tagName("td")))
                .filter(p)
                .map(y -> y.get(3))
                .map(y ->y.findElement(By.tagName("input")))
                .forEach(y -> y.click());

    }

}
