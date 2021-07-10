package modulos.setup;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Configuration {
    DesiredCapabilities capabilities = new DesiredCapabilities();


    public Configuration() {
        setEmulator();
    }

    public DesiredCapabilities setEmulator() {
        capabilities.setCapability("deviceName", "Pixel_2_API_29");
        capabilities.setCapability("platform", "Android");
        capabilities.setCapability("udid", "emulator-5554");

        return setLojinhaApp();
    }

    public DesiredCapabilities setLojinhaApp() {
        capabilities.setCapability("appPackage", "com.lojinha");
        capabilities.setCapability("appActivity", "com.lojinha.ui.MainActivity");
        capabilities.setCapability(
                "app",
                "/Users/rafaelds/Downloads/Lojinha+Android+Nativa/lojinha-nativa.apk"
        );

        return capabilities;
    }
}
