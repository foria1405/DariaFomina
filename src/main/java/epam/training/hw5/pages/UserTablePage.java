package epam.training.hw5.pages;

import epam.training.hw5.pageComponents.LogPanel;
import epam.training.hw5.pageComponents.UserTable;
import org.openqa.selenium.WebDriver;

public class UserTablePage extends AbstractPage {

    public UserTablePage(WebDriver webDriver) {
        super(webDriver);
    }

    private final LogPanel logPanel = new LogPanel(webDriver);
    private final UserTable userTable = new UserTable(webDriver);

    public LogPanel getLogPanel() {
        return logPanel;
    }

    public UserTable getUserTable() {
        return userTable;
    }
}
