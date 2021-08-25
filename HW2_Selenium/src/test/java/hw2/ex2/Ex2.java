package hw2.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Ex2 {
    private WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        webDriver.manage().window().maximize();
    }

    @AfterClass
    public void quit() {

        /* 10. Close Browser */

        webDriver.quit();
    }

    @Test
    public void siteURLTest() {

        /* 1) Open test site by URL */

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://jdi-testing.github.io/jdi-light/index.html");
    }

    @Test
    public void browserTitleTest() {

        /* 2) Assert Browser title */

        Assert.assertEquals(webDriver.getTitle(), "Home Page");
    }

    @Test
    public void userLoginTest() {

        /* 3) Perform login */

        webDriver.findElement(By.xpath("//*[@id='user-icon']")).click();
        webDriver.findElement(By.xpath("//*[@id='name']")).sendKeys("Roman");
        webDriver.findElement(By.xpath("//*[@id='password']")).sendKeys("Jdi1234");
        webDriver.findElement(By.xpath("//*[@id='login-button']")).click();


        /* 4) Assert User name in the left-top side of screen that user is loggined */

        String currentUsername = webDriver.findElement(By.xpath("//*[@id='user-name']")).getAttribute("innerHTML");
        Assert.assertEquals(currentUsername, "Roman Iovlev");
    }


    @Test(dependsOnMethods = {"userLoginTest"})
    public void openDifferentElementsPageTest() {

        /* 5) Open through the header menu Service -> Different Elements Page */

        WebElement dropdown = webDriver.findElement(By.xpath("//div[starts-with(@class, uui-header)]//li[@class='dropdown']"));
        dropdown.click();
        dropdown.findElement(By.xpath("//a[text()='Different elements']")).click();

    }

    @Test(dependsOnMethods = {"openDifferentElementsPageTest"})
    public void checkboxesTest() {
        webDriver.navigate().refresh();

        /* 6) Select checkboxes */

        WebElement waterCheckbox = webDriver.findElement(By.xpath("//*[@class='checkbox-row'][1]/label[1]/input"));
        waterCheckbox.click();

        WebElement windCheckbox = webDriver.findElement(By.xpath("//*[@class='checkbox-row'][1]/label[3]/input"));
        windCheckbox.click();

        /* 9.1) Assert that for each checkbox there is an individual log row
                 and value is corresponded to the status of checkbox.            */

        WebElement waterCheckboxLog = webDriver.findElement(By.xpath("//*[starts-with(@class, 'panel-body-list')]/li[2]"));
        String waterCheckboxLogStatus = waterCheckboxLog.getText();

        WebElement windCheckboxLog = webDriver.findElement(By.xpath("//*[starts-with(@class, 'panel-body-list')]/li[1]"));
        String windCheckboxLogStatus = windCheckboxLog.getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(waterCheckbox.isSelected());
        softAssert.assertTrue(waterCheckboxLog.isDisplayed());
        softAssert.assertTrue(waterCheckboxLogStatus.contains("Water"));
        softAssert.assertTrue(waterCheckboxLogStatus.contains("true"));

        softAssert.assertTrue(windCheckbox.isSelected());
        softAssert.assertTrue(windCheckboxLog.isDisplayed());
        softAssert.assertTrue(windCheckboxLogStatus.contains("Wind"));
        softAssert.assertTrue(windCheckboxLogStatus.contains("true"));

    }

    @Test(dependsOnMethods = {"openDifferentElementsPageTest"})
    public void radioTest() {
        webDriver.navigate().refresh();

        /* 7) Select radio */

        WebElement selenRadiobutton = webDriver.findElement(By.xpath("//*[@class='checkbox-row'][2]/label[4]/input"));
        selenRadiobutton.click();

        /* 9.2) Assert that for radiobutton there is a log row
                and value is corresponded to the status of radiobutton. */

        WebElement selenRadiobuttonLog = webDriver.findElement(By.xpath("//*[starts-with(@class, 'panel-body-list')]/li[1]"));
        String selenRadiobuttonLogStatus = selenRadiobuttonLog.getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(selenRadiobutton.isSelected());
        softAssert.assertTrue(selenRadiobuttonLog.isDisplayed());
        softAssert.assertTrue(selenRadiobuttonLogStatus.contains("metal"));
        softAssert.assertTrue(selenRadiobuttonLogStatus.contains("Selen"));
    }

    @Test(dependsOnMethods = {"openDifferentElementsPageTest"})
    public void dropdownTest() {
        webDriver.navigate().refresh();

        /* 8) Select in dropdown */

        WebElement dropdown = webDriver.findElement(By.xpath("//*[@class='colors']"));
        dropdown.click();

        WebElement yellowOption = dropdown.findElement(By.xpath(".//*[text()='Yellow']"));
        yellowOption.click();

        /* 9.3) Assert that for dropdown there is a log row
                and value is corresponded to the selected value.  */

        WebElement rowLog = webDriver.findElement(By.xpath("//*[starts-with(@class, 'panel-body-list')]/li[1]"));
        String logStatus = rowLog.getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(yellowOption.isSelected());
        softAssert.assertTrue(rowLog.isDisplayed());
        softAssert.assertTrue(logStatus.contains("Colors"));
        softAssert.assertTrue(logStatus.contains("Yellow"));

        softAssert.assertAll();
    }
}




