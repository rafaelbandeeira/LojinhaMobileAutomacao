package modulos.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseScreen {
    protected WebDriver app;

    @FindBy(xpath = "//android.widget.Toast")
    private WebElement toastMessage;

    public BaseScreen(WebDriver app) {
        this.app = app;
        PageFactory.initElements(app, this);
    }

    public String capturarMensagemToast() {
        return toastMessage.getText();
    }
}
