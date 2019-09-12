package br.com.blue.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ChromeBrowser implements Browser {

    private WebDriver webDriver;

    public ChromeBrowser() {

    }

    @Override
    public void startWithGui() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        this.webDriver = new ChromeDriver(options);
        this.webDriver.manage().deleteAllCookies();
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Override
    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    @Override
    public WebDriverWait getWebDriverWait(Integer timeToWait) {
        return new WebDriverWait(this.webDriver, timeToWait);
    }

    @Override
    public void setURL(String url) {
        this.webDriver.get(url);
    }

    @Override
    public void closeTab() {
        ArrayList<String> janelas = new ArrayList<String>(this.webDriver.getWindowHandles());
        String janelaAtual = this.webDriver.getWindowHandle();
        int contador = janelas.size();

        for (int i = 1; i < contador; i++) {

            String nomeDasJanelas = janelas.get(i);

            if ((nomeDasJanelas != janelaAtual) && (janelas.size() > 1)) {
                this.webDriver.switchTo().window(janelas.get(i));
                this.webDriver.close();

            }
        }

        this.webDriver.switchTo().window(janelaAtual);
    }

    @Override
    public void close() {
        this.getWebDriver().close();
    }

    @Override
    public void back() {
        this.getWebDriver().navigate().back();
    }

    @Override
    public void refresh() {
        this.getWebDriver().navigate().refresh();
    }


}
