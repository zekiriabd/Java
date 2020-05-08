import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Application {
    public static void main(String[] args){

        final String url ="https://translate.google.fr/?hl=fr";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);


        WebElement source = driver.findElement(By.id("source"));
        source.sendKeys("السلام عليكم");
        WebElement result = driver.findElement(By.className("tlid-translation"));
        String htmlresult = result.getAttribute("innerHTML");
        System.out.println(htmlresult);


        /*String webAddressTitel = driver.getTitle();
        String webPageUrl = driver.getCurrentUrl();
        String webSource = driver.getPageSource();*/

        //driver.close();
        //driver.quit();


       /* System.out.println("===============================================");
        System.out.println(webAddressTitel);
        System.out.println("===============================================");
        System.out.println(webPageUrl);
        System.out.println("===============================================");
        System.out.println(webSource);
        System.out.println("===============================================");*/



    }
}