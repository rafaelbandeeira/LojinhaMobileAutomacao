package modulos.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LoginScreen extends BaseScreen {
    @FindBys({
            @FindBy(id = "com.lojinha:id/user"),
            @FindBy(id = "com.lojinha:id/editText")
    })
    private WebElement usernameField;

    @FindBys({
            @FindBy(id = "com.lojinha:id/password"),
            @FindBy(id = "com.lojinha:id/editText")
    })
    private WebElement passwordField;

    @FindBy(id = "com.lojinha:id/loginButton")
    private WebElement loginButton;

    public LoginScreen(WebDriver app) {
        super(app);
    }

    public LoginScreen inserirUsuario(String username) {
        usernameField.click();
        usernameField.sendKeys(username);

        return this;
    }

    public LoginScreen inserirSenha(String password) {
        passwordField.click();
        passwordField.sendKeys(password);

        return this;
    }

    public ItemListScreen fazerLogin() {
        loginButton.click();

        return new ItemListScreen(app);
    }
}
