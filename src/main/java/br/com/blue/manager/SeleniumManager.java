package br.com.blue.manager;

import br.com.blue.util.Globals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SeleniumManager {


    private final static SeleniumManager seleniumManager = new SeleniumManager();

    private SeleniumManager(){
    }

    public static SeleniumManager getInstance(){

        return SeleniumManager.seleniumManager;
    }

    public By By(String by , String elementString){

        By element = null;

        switch (by){

            case "cssSelector" : element = By.cssSelector(elementString);break;
            case "id" : element = By.id(elementString); break;
            case "name" : element = By.name(elementString);break;
            case "className" : element = By.className(elementString);break;
            case "xpath" : element = By.xpath(elementString);break;
            case "linkText" : element = By.linkText(elementString);break;
            case "partialLinkText" : element = By.partialLinkText(elementString);break;

        }

        return element;
    }

    public WebElement findElement(String by, String element){
        return Globals.browser.getWebDriver().findElement(By(by,element));
    }

    public List<WebElement> findList(String by,String element){

        List<WebElement> elementList = Globals.browser.getWebDriver().findElements(By(by,element));
        return elementList;
    }

    public void clickElement(String by,String element){
        Globals.browser.getWebDriver().findElement(By(by, element)).click();

    }

    public void inputText (String by,String element, String text){
        Globals.browser.getWebDriver().findElement(By(by,element)).sendKeys(text);
    }

    public void sendKeysTAB (String by,String element){
        Globals.browser.getWebDriver().findElement(By(by,element)).sendKeys(Keys.TAB);
    }

    public void selectOptions(String by,String element,String typeOptionSelect, String paramSelect){

        Select selectElement = new Select(Globals.browser.getWebDriver().findElement(By(by,element)));

        switch(typeOptionSelect){
            case "selectByVisibleText" : selectElement.selectByVisibleText(paramSelect); //Select the option that displays the text matching the parameter.
            case "selectByIndex" : selectElement.selectByIndex(Integer.parseInt(paramSelect)); // Selects the option at the given index.
            case "selectByvalue" : selectElement.selectByValue(paramSelect); // Select Atribute "value"
            case "getFirstSelectedOptions" : selectElement.getFirstSelectedOption();
            case "getAllSelectedOptions": selectElement.getAllSelectedOptions();
        }
    }

    public void deselectOptions(String by,String element,String typeOptionSelect, String paramSelect){

        Select selectElement = new Select(Globals.browser.getWebDriver().findElement(By(by,element)));

        switch(typeOptionSelect){
            case "deselectByVisibleText" : selectElement.deselectByVisibleText(paramSelect); //Deselect the option that displays the text matching the parameter.
            case "deselectByIndex" : selectElement.deselectByIndex(Integer.parseInt(paramSelect)); // Deselects the option at the given index.
            case "deselectByvalue" : selectElement.deselectByValue(paramSelect); // Deselect Atribute "value"
            case "deselectAll" : selectElement.deselectAll();

        }

    }

    public String getTextElement(String by, String element){

        return Globals.browser.getWebDriver().findElement(By(by,element)).getText();
    }

    public String getAttribute(String by, String element, String nameAttribute){

        return Globals.browser.getWebDriver().findElement(By(by,element)).getAttribute(nameAttribute);
    }

    public void scrollElementJavaScriptExecutor(String by, String element){

        ((JavascriptExecutor) Globals.browser.getWebDriver()).executeScript("arguments[0].scrollIntoView();", Globals.browser.getWebDriver().findElement(By(by,element)));

    }

    public void clickElementJavaScriptExecutor(String by, String element){

        ((JavascriptExecutor) Globals.browser.getWebDriver()).executeScript("arguments[0].click();", Globals.browser.getWebDriver().findElement(By(by,element)));

    }


}
