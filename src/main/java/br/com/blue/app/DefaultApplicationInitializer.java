package br.com.blue.app;

import br.com.blue.browser.Browser;
import br.com.blue.browser.ChromeBrowser;
import br.com.blue.enums.BrowserEnum;
import br.com.blue.enums.EnvironmentEnum;
import br.com.blue.manager.BrowserManager;
import br.com.blue.util.Globals;
import org.apache.commons.lang3.EnumUtils;

public class DefaultApplicationInitializer implements ApplicationInitializer {

    public DefaultApplicationInitializer() {

        if(System.getProperty("pathDriver") == null){
            throw new RuntimeException("pathDriver deve ser informado");
        }

        if(System.getProperty("browser") == null){
            throw new RuntimeException("browser deve ser informado");
        }

        if(!EnumUtils.isValidEnum(BrowserEnum.class, System.getProperty("browser"))){
            throw new RuntimeException("Browser: " + System.getProperty("browser") + " invalido");
        }

        if(System.getProperty("environment") == null){
            throw new RuntimeException("environment deve ser informado");
        }

        if(!EnumUtils.isValidEnum(EnvironmentEnum.class, System.getProperty("environment"))){
            throw new RuntimeException("Environment: " + System.getProperty("environment") + " invalido");
        }

        System.setProperty("webdriver.chrome.driver", System.getProperty("pathDriver"));

        BrowserEnum browserEnum = BrowserEnum.valueOf(System.getProperty("browser"));

        Browser browser = null;

        if (BrowserEnum.CHROME.equals(browserEnum)) {
            browser = new ChromeBrowser();
        }

        BrowserManager browserManager = new BrowserManager(browser);

        EnvironmentEnum environment = EnvironmentEnum.valueOf(System.getProperty("environment"));

        System.out.println("Teste Realizado em ambiente de " +environment);

        Globals.browser = browser;
        Globals.enviroument = environment;
        Globals.browserManager = browserManager;
    }

}