package AmazonBDD.pages;//Author: Mihai Moraru

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

public class AmazonSearch {

    public WebDriver driver;

    //open specified browser
    public void chooseBrowser(Browsers browser) throws Exception {
        //instantiate a new browser based on the choice of browsers
        switch (browser) {
            case Firefox: {
                driver = new FirefoxDriver();
                break;
            }
            case Chrome: {
                driver = new ChromeDriver();
                break;
            }
            case InternetExplorer: {
                driver = new InternetExplorerDriver();
                break;
            }
            case Safari: {
                driver = new SafariDriver();
                break;
            }
            //case Android:				{ driver = new AndroidDriver();			break; }
            //case Iphone:				{ driver = new IPhoneDriver();			break; }
            default: {
                throw new Exception();
            }
        }
        driver.navigate().to("http://amazon.co.uk");
    }

    ;//Android, Ipad, Iphone,

    // enter searched product
    public void searchProduct(String product)
    {
        By byElement = By.id("twotabsearchtextbox");
        WebElement webElement = driver.findElement(byElement);
        Actions selAction = new Actions(driver);
        selAction.sendKeys(webElement, product).perform();
    }

    // click GO button to search in Amazon
    public void clickGoButton()
    {
        By byElement = By.className("nav-submit-input");//id("login");
        WebElement webElement = driver.findElement(byElement);
        Actions selAction = new Actions(driver);
        selAction.click(webElement).perform();
    }

    public void checkPageDisplayed(String page) {
        String title = null;    //the page title
        String url = null;        //the page url
        if (page.equalsIgnoreCase("search results")) {    //settings for the login page
            url = "=search-alias";
        }
        assertTrue(driver.getCurrentUrl().contains(url));
    }

    public enum Browsers {Firefox, Chrome, InternetExplorer, Opera, Safari}


}
