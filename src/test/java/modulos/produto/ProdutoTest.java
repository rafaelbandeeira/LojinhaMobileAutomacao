package modulos.produto;

import modulos.screens.LoginScreen;
import modulos.setup.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@DisplayName("testes mobile do módulo de produto")
public class ProdutoTest {
    WebDriver app;

    @BeforeEach
    public void setup() throws MalformedURLException {
        app = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), new Configuration().setLojinhaApp());
        app.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        app.quit();
    }

    @DisplayName("validação do valor de produto não permitido")
    @Test
    public void testValidacaoValorProdutoNaoPermitido() {
        String mensagemApresentada = new LoginScreen(app)
                .inserirUsuario("admin")
                .inserirSenha("admin")
                .fazerLogin()
                .abrirNovoProduto()
                .inserirProdutoNome("Samsung S10")
                .inserirProdutoValor("700001")
                .inserirProdutoCores("preto, azul")
                .submeterProdutoComErro()
                .lerMensagem();

        Assertions.assertEquals(
                "O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",
                mensagemApresentada
        );
    }
}
