package epam.training.jdihomework.site.elements;

import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import epam.training.jdihomework.entities.UserEntity;
import lombok.Getter;

@Getter
public class Header {
    @FindBy(id = "login-form")
    private LoginForm loginForm;

    @FindBy(id = "user-icon")
    private Icon userIcon;

    @FindBy(id = "user-name")
    private Button userName;

    @FindBy(css = "ul[class='uui-navigation nav navbar-nav m-l8']>li>a[href='metals-colors.html']")
    private Button metalColors;

    public void loginAs(UserEntity userEntity) {
        userIcon.click();
        loginForm.loginAs(userEntity);
    }
}

