package modulos.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemListScreen extends BaseScreen {
    @FindBy(id = "com.lojinha:id/floatingActionButton")
    private WebElement floatingButton;

    public ItemListScreen(WebDriver app) {
        super(app);
    }

    public ItemCreateScreen abrirNovoProduto() {
        floatingButton.click();

        return new ItemCreateScreen(app);
    }
}
