package br.com.blue.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface Browser {

    void startWithGui();

    WebDriver getWebDriver();

    WebDriverWait getWebDriverWait(Integer timeToWait);

    void setURL(String url);

    void closeTab();

    void close();

    void refresh();

    void back();

}
