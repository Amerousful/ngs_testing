import org.openqa.selenium.By;

public class Locators {

    private static String url = "http://localhost:8080/projects";
    private static By newprojectbutton = By.cssSelector("#app > div > div > div > div > div.col-sm-12 > div.controlButtons.btn-toolbar > button");
    private static By createbutton = By.xpath("//*[@class='btn btn-primary']");
    private static By projectnamefiled = By.xpath("//*[@class='form-control']");
    private static By newprojectname = By.xpath("//*[contains(text(), 'project_name')]");
    private static By checkboxpath = By.xpath("//*[@class='checkbox']");
    private static By deletebutton = By.xpath("//*[@class='btn btn-link']");
    private static By yesbutton = By.xpath("//*[@class='btn btn-primary']");


    static public String getUrl() {
        return url;
    }

    static public By getNewprojectbutton() {
        return newprojectbutton;
    }

    static public By getCreateButton() {
        return createbutton;
    }
    static public By getProjectnamefiled() {
        return projectnamefiled;
    }

    static public By getNewprojectname() {
        return newprojectname;
    }

    static public By getCheckboxpath() {
        return checkboxpath;
    }

    static public By getDeletebutton() {
        return deletebutton;
    }

    static public By getYesbutton() {
        return yesbutton;
    }


}




