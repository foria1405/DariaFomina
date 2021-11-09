package epam.training.jdihomework.tests;

import static epam.training.jdihomework.site.JdiLightSite.homePage;
import static epam.training.jdihomework.site.JdiLightSite.metalsColorsPage;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import epam.training.jdihomework.entities.MetalColorsEntity;
import epam.training.jdihomework.utils.JsonDataProvider;
import org.testng.annotations.Test;


public class MetalColorsTest extends BaseTest {
    @Test(dataProvider = "metalColorsEntities", dataProviderClass = JsonDataProvider.class)
    public void metalColorsFormTest(MetalColorsEntity metalColorsEntity) {
        assertThat(metalsColorsPage.isOpened()).isTrue();
        metalsColorsPage.getMetalsColorsForm().submit(metalColorsEntity);
        assertThat(metalsColorsPage.getResultAsListString())
                .isEqualTo(metalColorsEntity.getEntitytAsListString());
    }
}
