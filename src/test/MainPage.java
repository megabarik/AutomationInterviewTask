package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Smit on 28.10.2017.
 */
public class MainPage {
    private WebDriver webDriver;
    private WebDriverWait wait;


    public MainPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(linkText = "Home")
    WebElement linkHome;

    @FindBy(linkText = "Subjects")
    WebElement linkSubjects;

    @FindBy(linkText = "About Wiley")
    WebElement linkAboutWiley;

    @FindBy(linkText = "Contact Us")
    WebElement linkContactUs;

    @FindBy(linkText = "Help")
    WebElement linkHelp;



    @FindBy(linkText = "Students")
    WebElement linkStudents;

    @FindBy(linkText = "Authors")
    WebElement linkAuthors;

    @FindBy(linkText = "Instructors")
    WebElement linkInstructors;

    @FindBy(linkText = "Librarians")
    WebElement linkLibrarians;

    @FindBy(linkText = "Societies")
    WebElement linkSocieties;

    @FindBy(linkText = "Conferences")
    WebElement linkConferences;

    @FindBy(linkText = "Booksellers")
    WebElement linkBooksellers;

    @FindBy(linkText = "Corporations")
    WebElement linkCorporations;

    @FindBy(linkText = "Institutions")
    WebElement linkInstitutions;

    @FindBy(css = "#id31")
    WebElement buttonSubmitSignUp;

    @FindBy(css = "#EmailAddress")
    WebElement textEmail;

    @FindBy(css = "#links-site > form > fieldset > input.icon.icon__search.search-form-submit")
    WebElement pageSearchList;

    @FindBy(css = "#query")
    WebElement textSearch;


    public  void clickStudentsMainPage(){
        linkStudents.click();
    }

    public  void setTextEmail(String text){
        textEmail.clear();
        textEmail.sendKeys(text);
    }

    public void clickHome() {
        linkHome.click();
    }

    public void clickButtonSubmitSignUp() {
        buttonSubmitSignUp.click();
    }

    public void checkAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = webDriver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            //exception handling
        }
    }

    public String checkAlertText() {
        String text = "";
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = webDriver.switchTo().alert();
            text = alert.getText();

        } catch (Exception e) {

            //exception handling
        }
        return text;
    }


    public  void setTextSearch(String text){
        textSearch.clear();
        textSearch.sendKeys(text);
    }

    public void clickSearch(){
        pageSearchList.click();
    }

    public void clickInstitutions() {
        linkInstitutions.click();
    }
}
