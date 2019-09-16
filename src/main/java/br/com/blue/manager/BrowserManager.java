package br.com.blue.manager;

import br.com.blue.browser.Browser;
import br.com.blue.report.ReportManager;

import br.com.blue.util.Globals;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class BrowserManager {

    private Browser browser;

    private SeleniumManager selenium = SeleniumManager.getInstance();

    public BrowserManager(Browser browser){
        this.browser = browser;
    }

    public FluentWait fluentWait(int timeout, int polling) {

        FluentWait<WebDriver> fluentWait = new FluentWait<>(this.browser.getWebDriver())
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(polling))
                .ignoring(NoSuchElementException.class);

        return fluentWait;
    }

    // ### Waits ###

    public void waitElementPresent(String by, String element) {
        FluentWait ClickableWait = fluentWait(10, 2);
        ClickableWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selenium.By(by,element)));
    }

    public void waitElementDone(String by, String element) {
        FluentWait ClickableWait = fluentWait(10, 2);
        ClickableWait.until(ExpectedConditions.presenceOfElementLocated(selenium.By(by, element)));
        ClickableWait.until(ExpectedConditions.visibilityOfElementLocated(selenium.By(by, element)));

    }

    public void compareElementInListIsEqual(String typeBy, String element, String messageSucess, String messageError, String valueCompare)throws  Exception{

        try{

            waitElementPresent(typeBy,element);
            List<WebElement> elementFind =  SeleniumManager.getInstance().findList(typeBy,element);
            int size =  SeleniumManager.getInstance().findList(typeBy,element).size();

            for (int i = 0; i < size ; i++){

                String nome = elementFind.get(i).getText();

                if(nome.contains(valueCompare.replace(".",","))){
                    System.out.println(messageSucess);
                    ReportManager.getInstance().evidenceTestSucess(messageSucess);
                    break;
                }
            }

        }
        catch(Exception e){
            System.out.println(messageError);
            ReportManager.getInstance().evidenceTestFail(messageError);
            throw  e;
        }
    }

    public void compareElementIsEqual(String typeBy, String element, String valueCompare, String messageSucess, String messageError)throws  Exception{

        try{
                String nome = SeleniumManager.getInstance().getTextElement(typeBy,element);

                if(nome.contains(valueCompare.replace(".",","))){
                    System.out.println(messageSucess);
                    ReportManager.getInstance().evidenceTestSucess(messageSucess +" - "+valueCompare);
                }
                else{
                    throw new Exception(messageError);
                }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            ReportManager.getInstance().evidenceTestFail(messageError);
            throw  e;

        }
    }

}
