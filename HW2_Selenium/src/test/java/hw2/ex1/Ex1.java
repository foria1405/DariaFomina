package hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

import java.util.List;

public class Ex1 {
    private WebDriver webDriver;

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        webDriver.manage().window().maximize();

    }

    @AfterClass
    public void closeBrowser() {

        /* 12. Close Browser */

        webDriver.quit();
    }

    @Test
    public void siteURLTest() {

        /* 1. Open test site by URL */

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://jdi-testing.github.io/jdi-light/index.html");
    }

    @Test
    public void browserTitleTest() {

        /* 2. Assert Browser title  */

        Assert.assertEquals(webDriver.getTitle(), "Home Page");
    }

    @Test
    public void loginTest() {

        /* 3. Perform login */

        webDriver.findElement(By.xpath("//*[@id='user-icon']")).click();
        webDriver.findElement(By.xpath("//*[@id='name']")).sendKeys("Roman");
        webDriver.findElement(By.xpath("//*[@id='password']")).sendKeys("Jdi1234");
        webDriver.findElement(By.xpath("//*[@id='login-button']")).click();

        /* 4) Assert User name is loggined */

        String currentUsername = webDriver.findElement(By.xpath("//*[@id='user-name']")).getAttribute("innerHTML");
        Assert.assertEquals(currentUsername, "Roman Iovlev");

    }

    @Test
    public void headerSectionTest() {

        /* 5) Assert that there are 4 items on the header section are displayed
         and they have proper texts*/

        List<WebElement> headerObject = webDriver.findElements(By.xpath("//*[starts-with(@class,'uui-header')]/nav/ul[1]/li/a"));

        Assert.assertEquals(headerObject.size(), 4);

        for(WebElement we : headerObject) {
            Assert.assertTrue(we.isDisplayed());
        }

        String[] expectedTestHeaderObject = {"HOME","CONTACT FORM","SERVICE","METALS & COLORS"};

        for(int i = 0; i < headerObject.size(); i++) {
            String actualText = headerObject.get(i).getText();
            Assert.assertEquals(actualText, expectedTestHeaderObject[i]);
        }
    }

    @Test
    public void indexPageDisplayedTest() {

        /* 6) Assert that there are 4 images on the Index Page and they are displayed */

        List<WebElement> indexPageImages = webDriver.findElements(By.xpath("//*[@class='benefit-icon']"));

        Assert.assertEquals(indexPageImages.size(), 4);

        for(WebElement we : indexPageImages) {
            Assert.assertTrue(we.isDisplayed());
        }

        /* 7) Assert that there are 4 texts on the Index Page under icons and they have proper text */

        List<WebElement> textUnderIcons = webDriver.findElements(By.xpath("//*[@class='benefit-txt']"));

        Assert.assertEquals(textUnderIcons.size(), 4);

        String[] indexPageCaptionsExpectedTexts = {
                "To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};

        for(int i = 0; i < textUnderIcons.size(); i++) {

            Assert.assertTrue(textUnderIcons.get(i).isDisplayed());
            Assert.assertEquals(textUnderIcons.get(i).getText(), indexPageCaptionsExpectedTexts[i]);

        }
    }

    @Test
    public void frameButtonTest() {

        /* 8) Assert that there is the iframe with “Frame Button” exist */

        WebElement buttonIFrame = webDriver.findElement(By.xpath("//*[@id=\"frame\"]"));
        Assert.assertTrue(buttonIFrame.isDisplayed());

        /* 9) Switch to the iframe and check that there is “Frame Button” in the iframe*/

        webDriver.switchTo().frame(buttonIFrame);
        WebElement frameButton = webDriver.findElement(By.xpath("//*[@id=\"frame-button\"]"));
        Assert.assertTrue(frameButton.isDisplayed());

        /* 10) Switch to original window back*/

        webDriver.switchTo().parentFrame();
    }

    @Test
    public void leftSectionTest() {

        /* 11) Assert that there are 5 items in the Left Section are displayed and they have proper text*/

        List<WebElement> leftSectionObject = webDriver.findElements(By.xpath("//*[@id='mCSB_1_container']/ul[1]/li/a"));

        Assert.assertEquals(leftSectionObject.size(), 5);

        for (WebElement lso : leftSectionObject) {
            Assert.assertTrue(lso.isDisplayed());
        }

        String[] expectedTestLeftSectionObject = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};

        for (int i = 0; i < leftSectionObject.size(); i++) {
            String actualText = leftSectionObject.get(i).getText();
            Assert.assertEquals(actualText, expectedTestLeftSectionObject[i]);
        }

    }

}