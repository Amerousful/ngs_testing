import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action {

        private static final Logger log = Logger.getLogger(Action.class);

        static public void startDriver() {
            System.setProperty("webdriver.chrome.driver", "/home/pavel/.nvm/versions/node/v6.9.1/lib/node_modules/chromedriver/lib/chromedriver/chromedriver");
        }

        static WebDriver driver = new ChromeDriver();
        static WebDriverWait wait = new WebDriverWait(driver, 10);


        static public void goToPage(String url) {
            driver.get(url);
        }

        static public void clickTheButton(By fieldlocator) {
            elementWait(fieldlocator);
            WebElement element = driver.findElement(fieldlocator);
            element.click();
        }

    static public void clickTheNotClikableButton(By fieldlocator) {
            elementToBeClikable(fieldlocator);
            WebElement element = driver.findElement(fieldlocator);
            element.click();
    }

        static protected boolean elementWait(By locator) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                return true;
            } catch (TimeoutException e) {
                log.error("Time of occurrence of the element: " + locator + " is over");
                return false;
            }
        }

    static protected boolean elementToBeClikable(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        }catch (TimeoutException ex){
            log.error("element: " + locator + " not clikable");
            return false;
        }

    }

        static public void fillField(By fieldlocator, String fielddata) {
            elementWait(fieldlocator);
            WebElement element = driver.findElement(fieldlocator);
            element.sendKeys(fielddata);
        }

        static public void exitDriver() {
            driver.quit();
        }

        static public boolean confirmCreationProject() {
            return elementWait(Locators.getNewprojectname());
        }
        static public boolean confirmCreateWorkFlows() {
            return elementWait(Locators.getConfirmcreateworkwflows());
    }
        static public boolean confirmCreateSample() {
            return elementWait(Locators.getNewsamplename());
    }


    static public void killProject() {
            clickTheButton(Locators.getCheckboxpath());
            clickTheButton(Locators.getDeletebutton());
            clickTheButton(Locators.getYesbutton());
        }

    static public void killWorkFlows() {
            clickTheButton(Locators.getDeletebutton());
    }

    static public void uploadFile(By fieldlocator, String filelocation) {
            elementWait(fieldlocator);
            WebElement element = driver.findElement(fieldlocator);
            element.sendKeys(filelocation);
    }




}
