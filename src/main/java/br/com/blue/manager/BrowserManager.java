package br.com.blue.manager;

import br.com.blue.browser.Browser;
import br.com.blue.report.ReportManager;
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

                if(elementFind.equals(valueCompare)){
                    System.out.println(messageSucess);
                    ReportManager.getInstance().evidenceTestSucess(messageSucess +" - "+valueCompare);

                }
                else{
                    System.out.println(messageSucess);
                    ReportManager.getInstance().evidenceTestFail(messageError + " - " + valueCompare);
                }
            }

        }
        catch(TimeoutException | NoSuchElementException e){
            ReportManager.getInstance().evidenceTestFail(messageError);
            System.out.println(messageError);
        }
    }

    public boolean isElementDisplayed(String typeBy, String element)throws  Exception{

        By elementBy = SeleniumManager.getInstance().By(typeBy,element);

        fluentWait(10,2).until(ExpectedConditions.visibilityOfElementLocated(elementBy));

        if(SeleniumManager.getInstance().findElement(typeBy, element).isDisplayed()) {

            return true;
        }
        else{
            return false;
        }

    }





}
