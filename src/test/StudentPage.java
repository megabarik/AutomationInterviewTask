package test;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Smit on 28.10.2017.
 */
public class StudentPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    public StudentPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(css = "#page-title > h1")
    WebElement headerStudents;

    @FindBy(linkText = "Authors")
    WebElement linkAuthors;

    @FindBy(linkText = "Librarians")
    WebElement linkLibrarians;

    @FindBy(linkText = "Booksellers")
    WebElement linkBooksellers;

    @FindBy(linkText = "Instructors")
    WebElement linkInstructors;


    @FindBy(linkText = "Students")
    WebElement linkStudents;


    @FindBy(linkText = "Societies")
    WebElement linkSocieties;


    @FindBy(linkText = "Corporate Partners")
    WebElement linkCorporatePartners;

    @FindBy(linkText = "Government Employees")
    WebElement linkGovernmentEmployees;

    public boolean clickStudentStudentsPage(){ // Check changes URL after click
        linkStudents.click();
        String URL = webDriver.getCurrentUrl();
        if(webDriver.getCurrentUrl().equals("http://eu.wiley.com/WileyCDA/Section/id-404702.html")){
            return true;
        } else {
            return false;

        }
    }

    public String checkNotSelectColor(){ // Check color font
        linkStudents.click();

        String colorNotSelect = webDriver.findElement(By.className("autonavItem")).getCssValue("color");
return colorNotSelect;
    }

    public String checkNotBackgroundSelectColor(){ // Check backgroundcolor
        linkStudents.click();
        String colorNotSelect = webDriver.findElement(By.className("autonavItem")).getCssValue("background-color");
        return colorNotSelect;
    }

}
