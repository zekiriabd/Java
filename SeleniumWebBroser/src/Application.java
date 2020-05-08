public class Application {
    public static void main(String[] args){
        final String chromedriver = "D:\\Program Files\\chromedriver\\chromedriver.exe";
        final String url ="https://www.google.fr/";
        System.setProperty("webdriver.chrome.driver", chromedriver);
        WebDriver driver = new ChromeDriver();

        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver -->
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-chrome-driver</artifactId>
    <version>4.0.0-alpha-5</version>
</dependency>

    }
}
