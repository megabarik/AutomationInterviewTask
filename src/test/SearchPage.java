/*
package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

*/
/**
 * Created by Smit on 28.10.2017.
 *//*

public class SearchPage {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private String stringCssSelector;

    public SearchPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
        PageFactory.initElements(webDriver, this);
    }


    public void setStringCssSelector(String stringCssSelector) {
        this.stringCssSelector = stringCssSelector;
    }

//    private String cssLocatorForRandom = "#search-results > div:nth-child("+ numberRow+ ")";

    @FindBy(xpath = "/*/
/*[@id=\"search-results\"]")
    WebElement headerStudents;

    WebElement clickRandomItem = randomItem(headerStudents,stringCssSelector);

    private WebElement randomItem(WebElement headerStudents, String stringCssSelector) {
        String css = "#search-results > div";
        return headerStudents.findElement(By.cssSelector(String.format(css,stringCssSelector)));
    }

    public void clickRandomItem() {
        clickRandomItem.click();
    }
}
*/
