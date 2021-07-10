package modulos.screens;

import org.openqa.selenium.WebDriver;

public class ItemEditScreen extends BaseScreen {


    public ItemEditScreen(WebDriver app) {
        super(app);
    }

    public String lerMensagem() {
        return capturarMensagemToast();
    }
}
