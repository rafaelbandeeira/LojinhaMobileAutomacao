package modulos.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ItemCreateScreen extends BaseScreen {

    @FindBys({
            @FindBy(id = "com.lojinha:id/productName"),
            @FindBy(id = "com.lojinha:id/editText")
    })
    private WebElement productName;

    @FindBys({
            @FindBy(id = "com.lojinha:id/productValue"),
            @FindBy(id = "com.lojinha:id/editText")
    })
    private WebElement productValue;

    @FindBys({
            @FindBy(id = "com.lojinha:id/productColors"),
            @FindBy(id = "com.lojinha:id/editText")
    })
    private WebElement productColor;

    @FindBy(id = "com.lojinha:id/saveButton")
    private WebElement saveButton;

    public ItemCreateScreen(WebDriver app) {
        super(app);
    }

    public ItemCreateScreen inserirProdutoNome(String nome) {
        productName.click();
        productName.sendKeys(nome);

        return this;
    }

    public ItemCreateScreen inserirProdutoValor(String valor) {
        productValue.click();
        productValue.sendKeys(valor);

        return this;
    }

    public ItemCreateScreen inserirProdutoCores(String cores) {
        productColor.click();
        productColor.sendKeys(cores);

        return this;
    }

    private void submeterProduto() {
        saveButton.click();
    }

    public ItemCreateScreen submeterProdutoComErro() {
        submeterProduto();

        return this;
    }

    public ItemEditScreen submeterProdutoComSucesso() {
        submeterProduto();

        return new ItemEditScreen(app);
    }

    public String lerMensagem() {
        return capturarMensagemToast();
    }
}
