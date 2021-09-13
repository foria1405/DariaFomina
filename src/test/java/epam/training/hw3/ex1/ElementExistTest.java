package epam.training.hw3.ex1;


import static epam.training.hw3.DataClass.BENEFIT_INDEX_PAGE_TEXT;
import static org.assertj.core.api.Assertions.assertThat;

import epam.training.hw3.BaseTestClass;
import epam.training.hw3.components.Frame;
import epam.training.hw3.pages.HomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class ElementExistTest extends BaseTestClass {

    @AfterTest
    void tearDown() {
        softAssertions.assertAll();
    }

    @Test
    public void checkElementsTest() {
        //1. Open test site by URL
        HomePage homePage = new HomePage(webDriver, properties.getString("baseURL"));

        //2. Assert Browser title
        assertThat(homePage.getTitle())
                .isEqualTo(properties.getString("title"));

        //3. Perform login
        homePage.getHeader().signIn(
                properties.getString("login"),
                properties.getString("password"));

        //4. Assert Username is loggined
        assertThat(homePage.getHeader().isNameDisplayed());

        assertThat(homePage.getHeader().getName())
                .isEqualTo(properties.getString("name"));

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertThat(homePage.getHeader().getHeaderElementsText())
                .hasSize(properties.getInt("toolbar.size"))
                .isEqualTo(properties.getList("toolbar"));


        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertThat(homePage.getBenefit().getBenefitIconsNumber())
                .isEqualTo(properties.getInt("images.size"));

        homePage.getBenefit().getBenefitIcons()
                .forEach(element ->
                        softAssertions
                                .assertThat(element.isDisplayed())
                                .isTrue());

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertThat(homePage.getBenefit().getBenefitTextsNumber())
                .isEqualTo(properties.getInt("text.size"));

        softAssertions
                .assertThat(homePage.getBenefit().getBenefitTextsExtracted())
                .isEqualTo(BENEFIT_INDEX_PAGE_TEXT);


        //8. Assert that there is the iframe with “Frame Button” exist
        assertThat(homePage.getFrame().getFrame())
                .isNotNull();

        assertThat(homePage.getFrame().isFrameDisplayed())
                .isTrue();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        Frame frame = homePage.switchToFrame();

        assertThat(frame.getFrameButton())
                .isNotNull();

        assertThat(frame.isFrameButtonDisplayed())
                .isTrue();

        //10. Switch to original window back
        homePage = (HomePage) frame.switchToDefault();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertThat(homePage.getNavigationBar().getNavigationBarNumber())
                .isEqualTo(properties.getInt("text.left.size"));

        homePage.getNavigationBar().getNavigationBar()
                .forEach(element ->
                        softAssertions
                                .assertThat(element.isDisplayed())
                                .isTrue());
        softAssertions
                .assertThat(homePage.getNavigationBar().getNavigationBarExtracted())
                .isEqualTo(properties.getList("text.left"));

    }
}
