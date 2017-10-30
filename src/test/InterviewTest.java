package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;


/**
 * Created by Smit on 28.10.2017.
 *
 * I know. All actions must be hide in classes, but it's my first develop tests.
 * And I wrote this tests for a weekend
 * I thought to use Selenide, but I'm having a problem with import and create architecture.
 * 3 tests on the End is a very bad support code and I think need rewriting them.
 */
public class InterviewTest {
    WebDriver webDriver;


    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "D:\\Coding\\InterviewTask\\driver\\geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(webDriver, 30, 500);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://www.wiley.com/WileyCDA/");
    }


    /* ##Test 1
    Check the following links displayed in top navigation menu:
        Home
        Subjects
        About Wiley
        Contact Us
        Help
    */
    @Test
    public void CheckFollowingLinks(){
        MainPage mainPage = new MainPage(webDriver);
        Assert.assertTrue(mainPage.linkHome.isDisplayed());
        Assert.assertTrue(mainPage.linkSubjects.isDisplayed());
        Assert.assertTrue(mainPage.linkAboutWiley.isDisplayed());
        Assert.assertTrue(mainPage.linkContactUs.isDisplayed());
        Assert.assertTrue(mainPage.linkHelp.isDisplayed());


    }
//      ##Test 2
//      There are 9 items under resources sub-header


    @Test
    public void CheckItemsUnderResources(){
        Assert.assertTrue(webDriver.findElements(By.cssSelector("#homepage-links > ul > li")).size() == 9);

    }
//      ##Test 3
//         Check Titles are “Students”, “Authors”, “Instructors”,“Librarians”,
//          “Societies”, “Conferences”, “Booksellers”, “Corporations”,“Institutions”

    @Test
    public void CheckTitlesResources(){
        MainPage mainPage = new MainPage(webDriver);
        Assert.assertTrue(mainPage.linkStudents.isDisplayed());
        Assert.assertTrue(mainPage.linkAuthors.isDisplayed());
        Assert.assertTrue(mainPage.linkInstructors.isDisplayed());
        Assert.assertTrue(mainPage.linkLibrarians.isDisplayed());
        Assert.assertTrue(mainPage.linkSocieties.isDisplayed());
        Assert.assertTrue(mainPage.linkConferences.isDisplayed());
        Assert.assertTrue(mainPage.linkBooksellers.isDisplayed());
        Assert.assertTrue(mainPage.linkCorporations.isDisplayed());
        Assert.assertTrue(mainPage.linkInstitutions.isDisplayed());

    }

    //      ##Test 4
    // Check that http://www.wiley.com/WileyCDA/Section/id-404702.html url is opened
    @Test
    public void CheckLinkIsOpened(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickStudentsMainPage();
        String URL = webDriver.getCurrentUrl();
        Assert.assertEquals(URL, "http://eu.wiley.com/WileyCDA/Section/id-404702.html" );

    }

    //      ##Test 5
    // Check that “Students” header is displayed
    @Test
    public void CheckHeaderStudentsDisplayed(){
        MainPage mainPage = new MainPage(webDriver);
        StudentPage studentPage = new StudentPage(webDriver);
        mainPage.clickStudentsMainPage();
        Assert.assertEquals(true, studentPage.headerStudents.isDisplayed());


    }

//      ##Test 6
    //Check “Resources For” menu on the left

    @Test
    public void CheckResourcesMenuLeft(){

        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickStudentsMainPage();//#sidebar


        int X = webDriver.findElement(By.id("sidebar")).getLocation().getX(); // Get location container
        String floatPosition = webDriver.findElement(By.id("sidebar")).getCssValue("float"); // Get css property for container
        int Y = webDriver.findElement(By.id("sidebar")).getLocation().getY(); // Get location container
        if(X != 466 & Y != 206 & floatPosition != "left"){
            System.out.println("Test Failed");
            System.out.println("Position X: " + X);
            System.out.println("Position Y: " + Y);
            System.out.println("Position Float: " + floatPosition);

        }

        Assert.assertEquals(X, 466);
        Assert.assertEquals(Y, 206);
        Assert.assertEquals(floatPosition, "left");

        //TO-DO Think about another check

    }

    //      ##Test 7
    //8 items are displayed in the menu
    @Test
    public void CheckResourcesDisplayed(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickStudentsMainPage();
        int num = webDriver.findElements(By.cssSelector("#sidebar > div > ul > li > ul > li")).size();
        if(num != 8){ //Check count elements
            System.out.println("Count elements:" + num);
        }
        Assert.assertTrue(webDriver.findElements(By.cssSelector("#sidebar > div > ul > li > ul > li")).size() == 8);

    }
    //      ##Test 8
    //Check Items are “Authors”, “Librarians”, “Booksellers”,
    // “Instructors”, “Students” ,”Government Employees”, “Societies”, “Corporate Partners”
    @Test
    public void CheckResourcesItems(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickStudentsMainPage();
        StudentPage studentPage = new StudentPage(webDriver);
        Assert.assertTrue(studentPage.linkAuthors.isDisplayed());
        Assert.assertTrue(studentPage.linkLibrarians.isDisplayed());
        Assert.assertTrue(studentPage.linkBooksellers.isDisplayed());
        Assert.assertTrue(studentPage.linkInstructors.isDisplayed());
        Assert.assertTrue(studentPage.linkStudents.isDisplayed());
        Assert.assertTrue(studentPage.linkGovernmentEmployees.isDisplayed());
        Assert.assertTrue(studentPage.linkSocieties.isDisplayed());
        Assert.assertTrue(studentPage.linkCorporatePartners.isDisplayed());
    }



    //      ##Test 9
//        not clickable element students
    @Test
    public void CheckStudentsNotClick(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickStudentsMainPage();
        StudentPage studentPage = new StudentPage(webDriver);
        Assert.assertTrue(studentPage.clickStudentStudentsPage());// check click

    }
    //      ##Test 10
    //        different style students
    @Test
    public void CheckStudentsStyle(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickStudentsMainPage();
        StudentPage studentPage = new StudentPage(webDriver);
        studentPage.clickStudentStudentsPage(); //click students page

        String colorSelect = webDriver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/ul/li/ul/li[5]/span")).getCssValue("color");
        String backgroundColorSelect = webDriver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/ul/li/ul/li[5]/span")).getCssValue("background-color");
//        System.out.println(colorSelect);
//        System.out.println(backgroundColorSelect);
//        System.out.println(studentPage.checkNotSelectColor());
//        System.out.println(studentPage.checkNotBackgroundSelectColor());


        //TO-DO Add another styles and think about another realization
        Assert.assertFalse(colorSelect.equals(studentPage.checkNotSelectColor()));
        Assert.assertFalse(backgroundColorSelect.equals(studentPage.checkNotBackgroundSelectColor()));



    }



    //      ##Test 11
    //        check alert signup
    @Test
    public void CheckAlertAppearedFieldSignUp(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickHome();
        mainPage.clickButtonSubmitSignUp();
        mainPage.checkAlert(); //Check Alert window

    }
    //      ##Test 12
    //        check textAlert
    @Test
    public void CheckTextAlertAppearedFieldSignUp(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickHome();
        mainPage.clickButtonSubmitSignUp();
        Assert.assertEquals(mainPage.checkAlertText(), "Please enter email address"); //Check Alert text
    }

    //      ##Test 13
    //        Check that alert appeared with invalid email
    @Test
    public void CheckAlertAppearedInvalidEmail(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickHome();
        mainPage.setTextEmail("blablabla.ru");
        mainPage.clickButtonSubmitSignUp();
        mainPage.checkAlert(); //Check Alert window

    }
    //      ##Test 14
////        Check that alert text is “Invalid email address.”
@Test
public void CheckAlertTextInvalidEmail(){
    MainPage mainPage = new MainPage(webDriver);
    mainPage.clickHome();
    mainPage.setTextEmail("blablabla.ru");
    mainPage.clickButtonSubmitSignUp();
    Assert.assertEquals(mainPage.checkAlertText(), "Invalid email address."); //Check Alert text

}
    //      ##Test 15
//        Check that search list of items appeared
    @Test
    public void CheckAppeardSearchList() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.setTextSearch("for dummies");
        mainPage.clickSearch();
        WebElement element = webDriver.findElement(By.cssSelector("#page-title > h1"));
        String text = element.getText();
        Assert.assertEquals(text, "Search Results");//#search-results
        ArrayList<WebElement> list = new ArrayList(webDriver.findElements(By.cssSelector("#search-results > div"))); //Get elements on collections
        System.out.println(list.size());
        int rows = list.size();
        if (list.size() == 0){
            System.out.println("Nothing elements find");
            Assert.assertTrue(false);

        } else {
            Assert.assertTrue(true);
        }
        Random random = new Random();
        System.out.println(random.nextInt(rows));

    }

//      ##Test 16
    //        Click random item link (link with book title)
//        Check that page with header equal to the title you clicked is displayed


    @Test
    public void CheckRandomPageTitle() {

        MainPage mainPage = new MainPage(webDriver);
        mainPage.setTextSearch("for dummies");
        mainPage.clickSearch();
        ArrayList<WebElement> list = new ArrayList(webDriver.findElements(By.cssSelector("#search-results > div"))); //Get elements on collections
        int rows = list.size();
        Random random = new Random();
        int randomNumber = random.nextInt(rows);

        //MegaSpike-nail :-)
        if (randomNumber == 0) {
            randomNumber++;
        }

        System.out.println(randomNumber);
        String randomCssSelectorEnd = ":nth-child(" + randomNumber + ")"; //save random child
        String name = webDriver.findElement(By.cssSelector("#search-results > div" + randomCssSelectorEnd + " > div.product-title")).getText(); //Get text on list
        webDriver.findElement(By.cssSelector("#search-results > div" + randomCssSelectorEnd + " > div.product-title > a")).click();
        Assert.assertEquals(name, webDriver.findElement(By.className("productDetail-title")).getText());





}

/*
           ###### TO-DO Think
           ###### How to use PageObject pattern for this test
           ###### Maybe use Selenide for dynamic parameters

//        webDriver.findElement(By.cssSelector("#search-results > div" + randomCssSelectorEnd)).click();
//        Assert.assertTrue();
//        SearchPage searchPage = new SearchPage(webDriver);
//        searchPage.setStringCssSelector(randomCssSelectorEnd);
//        searchPage.clickRandomItem();

*/



    //      ##Test 17
    //        Click “Home” link at the top navigation menu
//        Click “Institutions” icon under Resources sub-header
//        Check http://wileyedsolutions.com/ is opened in new window (or tab)
    @Test
    public void CheckOpenNewWindow(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickHome();
        String oldWindowHandle = webDriver.getWindowHandle(); //Get Handle Tab
        System.out.println(oldWindowHandle);
        mainPage.clickInstitutions();
        String newWindowHandle = webDriver.getWindowHandle(); //Get Handle Tab

        //MegaSpike-nail :-)
        if (oldWindowHandle == newWindowHandle){
            Assert.assertTrue(false);
        } else {
            Assert.assertTrue(true);
        }

        String URL = webDriver.getCurrentUrl();
        /*

         Specification is URL - http://wileyedsolutions.com/
         Actual Result RediRectUrl ia - https://edservices.wiley.com/
         !!!!SO ITS FAIL!!!!

         */

         Assert.assertEquals(URL, "http://wileyedsolutions.com/");






    }
    @After
    public void tearDown(){
        if (webDriver != null)
            webDriver.quit();
    }
}
