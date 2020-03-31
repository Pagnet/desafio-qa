package base.testbase;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestBase {
	private static RemoteWebDriver driver;
	private static int secondsToWait = 20;

	protected static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	protected static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	protected static ThreadLocal<ExtentTest> node = new ThreadLocal<ExtentTest>();

	public static boolean printAllSteps = false;

	public static String reportPath;
	public static String screenshotAbsolutePath;
	public static String screenshotPathLocal;
	public static String screenshotPathKlov;
	public static String screenshotPath;

	public static SoftAssert softAssert;

	public final static String FS = File.separator;
	public final static String PROJECT_PATH = Paths.get("").toAbsolutePath().toString();
	public final static String TEST_OUTPUT_PATH = Paths.get("").toAbsolutePath().toString() + FS + "test-output";

	/**
	 * Método para retorno do WebDriver default
	 * 
	 * @return RemoteWebDriver - WebDriver default para execução
	 */
	public static RemoteWebDriver getDriver() {
		return driver;
	}

	/**
	 * Método para definição do WebDriver default
	 * 
	 * @param RemoteWebDriver - WebDriver default para execução
	 */
	public static void setDriver(RemoteWebDriver driver) {
		TestBase.driver = driver;
		setSecondsToWait(20);
	}

	public static int getSecondsToWait() {
		return secondsToWait;
	}

	public static void setSecondsToWait(int secondsToWait) {
		TestBase.secondsToWait = secondsToWait;
	}

	/**
	 * Método que aguarda o elemento ficar visível e disponível para interação
	 * 
	 * @param By - Forma de pesquisa (by) que o Selenium irá utilizar para encontrar
	 *           o componente na tela
	 * @return WebElement - Após o Selenium aguardar o componente ficar disponível,
	 *         o método retorna o elemento para execução do evento
	 */
	private WebElement waitElementToBeClickable(By by) {
		new WebDriverWait(getDriver(), secondsToWait).until(ExpectedConditions.presenceOfElementLocated(by));
		return new WebDriverWait(getDriver(), secondsToWait).until(ExpectedConditions.elementToBeClickable(by));
	}

	/**
	 * Método que recebe um WebElement e retorna o texto contido nele
	 * 
	 * @param WebElement - Elemento para extração do texto
	 * @return String - Texto extraido do Elemento
	 */

	public String getText(By by) {
		return waitElementToBeClickable(by).getText();
	}

	/* Execuções */

	/**
	 * Método que executa o "WebDriver.switchTo().defaultContent();"
	 */
	public void switchToDefaultFrame() {
		driver.switchTo().defaultContent();
	}

	/**
	 * Método que executa o "WebDriver.switchTo().frame(<WebElement>);"
	 *
	 * @param WebElement - Frame para mudança de contexto
	 */
	public void switchFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * Método que executa o "WebDriver.switchTo().frame(<frameName>);"
	 *
	 * @param String - Nome do Frame para mudança de contexto
	 */
	public void switchFrame(String name) {
		driver.switchTo().frame(name);
	}

	/**
	 * Método que executa o "WebElement.sendKeys("<texto>");" para o componente
	 * "textbox". Essa execução ocorrerá após o Selenium validar se o texto é
	 * diferente de <vazio> e validar se o componente já está disponível para
	 * interação. Ao final é executado o método de criação do passo-a-passo do
	 * relatório.
	 * 
	 * @param By     - Forma de pesquisa (by) que o Selenium irá utilizar para
	 *               encontrar o componente na tela
	 * @param String - Nome do componente (exatamente como está visível em tela -
	 *               sem "/" ou "\" caso exista). Essa informação será utilizada
	 *               para informar para o relatório, qual componente o Selenium está
	 *               interagindo
	 * @param String - Texto que será inserido no textbox
	 */
	public void setText(By by, String name, String text) {
		if (text != null && !text.isEmpty()) {
			waitElementToBeClickable(by).sendKeys(text);
			setStep("Preencher o campo '" + name + "' = " + text);
		}
	}

	/**
	 * Método que executa o "WebElement.click();" para o componente "checkbox". Essa
	 * execução ocorrerá após o Selenium validar se o componente já está disponível
	 * para interação, verificar se o checkbox está desmarcado e, caso esteja,
	 * realizar o ".click()" para marcar o checkbox. Caso o checkbox já esteja
	 * marcado, não será realizada qualquer interação com o checkbox. Ao final é
	 * executado o método de criação do passo-a-passo do relatório.
	 * 
	 * @param By     - Forma de pesquisa (by) que o Selenium irá utilizar para
	 *               encontrar o componente na tela
	 * @param String - Nome do componente (exatamente como está visível em tela -
	 *               sem "/" ou "\" caso exista). Essa informação será utilizada
	 *               para informar para o relatório, qual componente o Selenium está
	 *               interagindo
	 */
	public void selectCheckBox(By by, String name) {
		WebElement el = waitElementToBeClickable(by);
		if (!el.isSelected())
			el.click();

		setStep("Marcar o campo '" + name + "'");
	}

	/**
	 * Método que executa o "WebElement.click();" para o componente "checkbox". Essa
	 * execução ocorrerá após o Selenium validar se o componente já está disponível
	 * para interação, verificar se o checkbox está marcado e, caso esteja, realizar
	 * o ".click()" para desmarcar o checkbox. Caso o checkbox já esteja desmarcado,
	 * não será realizada qualquer interação com o checkbox. Ao final é executado o
	 * método de criação do passo-a-passo do relatório.
	 * 
	 * @param By     - Forma de pesquisa (by) que o Selenium irá utilizar para
	 *               encontrar o componente na tela
	 * @param String - Nome do componente (exatamente como está visível em tela -
	 *               sem "/" ou "\" caso exista). Essa informação será utilizada
	 *               para informar para o relatório, qual componente o Selenium está
	 *               interagindo
	 */
	public void deselectCheckBox(By by, String name) {
		WebElement el = waitElementToBeClickable(by);
		if (el.isSelected())
			el.click();

		setStep("Desmarcar o campo '" + name + "'");
	}

	/**
	 * Método que executa o "Select.selectByIndex(<index>);" para o componente
	 * dropdown/combobox. Essa execução ocorrerá após o Selenium validar se o
	 * componente já está disponível para interação. Ao final é executado o método
	 * de criação do passo-a-passo do relatório.
	 * 
	 * @param By     - Forma de pesquisa (by) que o Selenium irá utilizar para
	 *               encontrar o componente na tela
	 * @param String - Nome do componente (exatamente como está visível em tela -
	 *               sem "/" ou "\" caso exista). Essa informação será utilizada
	 *               para informar para o relatório, qual componente o selenium está
	 *               interagindo
	 * @param Int    - Index do combobox. O index em resumo, é o número do item
	 *               dentro da listagem do componente, começando com "0" (zero)
	 */
	public void selectByIndex(By by, String name, int index) {
		Select select = new Select(waitElementToBeClickable(by));
		select.selectByIndex(index);

		setStep("Selecionar o campo '" + name + "', posição = " + index);
	}

	/**
	 * Método que executa o "Select.selectByVisibleText(<String>);" para o
	 * componente dropdown/combobox. Essa execução ocorrerá após o Selenium validar
	 * se o componente já está disponível para interação. Ao final é executado o
	 * método de criação do passo-a-passo do relatório. IMPORTANTE! - Esse método
	 * deverá ser utilizado como default para a seleção para o componente
	 * dropdown/combobox.
	 * 
	 * @param By     - Forma de pesquisa (by) que o Selenium irá utilizar para
	 *               encontrar o componente na tela
	 * @param String - Nome do componente (exatamente como está visível em tela -
	 *               sem "/" ou "\" caso exista). Essa informação será utilizada
	 *               para informar para o relatório, qual componente o selenium está
	 *               interagindo
	 * @param String - Texto do item do combobox que deverá ser selecionado
	 */
	public void selectByText(By by, String name, String text) {
		if (text != null && !text.isEmpty()) {
			Select select = new Select(waitElementToBeClickable(by));
			select.selectByVisibleText(text);

			setStep("Selecionar o campo '" + name + "' = " + text);
		}
	}

	/**
	 * Método que executa o "Select.selectByValue(<String>);" para o componente
	 * dropdown/combobox. Essa execução ocorrerá após o Selenium validar se o
	 * componente já está disponível para interação. Ao final é executado o método
	 * de criação do passo-a-passo do relatório.
	 * 
	 * @param By     - Forma de pesquisa (by) que o Selenium irá utilizar para
	 *               encontrar o componente na tela
	 * @param String - Nome do componente (exatamente como está visível em tela -
	 *               sem "/" ou "\" caso exista). Essa informação será utilizada
	 *               para informar para o relatório, qual componente o selenium está
	 *               interagindo
	 * @param String - Parâmetro "value" contido na tag do item combox/dropdown que
	 *               será selecionado
	 */
	public void selectByValue(By by, String name, String value) {
		if (value != null && !value.isEmpty()) {
			Select select = new Select(waitElementToBeClickable(by));
			select.selectByValue(value);

			setStep("Selecionar o campo '" + name + "', valor = " + value);
		}
	}

	/**
	 * Método que executa o "WebElement.click();" para o componente "button". Essa
	 * execução ocorrerá após o Selenium validar se o componente já está disponível
	 * para interação. Ao final é executado o método de criação do passo-a-passo do
	 * relatório.
	 * 
	 * @param By     - Forma de pesquisa (by) que o Selenium irá utilizar para
	 *               encontrar o componente na tela
	 * @param String - Nome do componente (exatamente como está visível em tela -
	 *               sem "/" ou "\" caso exista). Essa informação será utilizada
	 *               para informar para o relatório, qual componente o Selenium está
	 *               interagindo
	 */
	public void clickButton(By by, String name) {
		waitElementToBeClickable(by).click();
		setStep("Clicar no botão '" + name + "'");
	}

	public void overElement(By by) {
		overElement(by, null);
	}

	/**
	 * Método que executa o "Actions.moveToElement(WebElement).perform();" para o
	 * componente "menu". Essa execução ocorrerá após o Selenium validar se o
	 * componente já está disponível para interação. Ao final é executado o método
	 * de criação do passo-a-passo do relatório.
	 * 
	 * @param By     - Forma de pesquisa (by) que o Selenium irá utilizar para
	 *               encontrar o componente na tela
	 * @param String - Nome do componente (exatamente como está visível em tela -
	 *               sem "/" ou "\" caso exista). Essa informação será utilizada
	 *               para informar para o relatório, qual componente o Selenium está
	 *               interagindo
	 */
	public void overElement(By by, String name) {
		Actions action = new Actions(getDriver());
		action.moveToElement(waitElementToBeClickable(by)).perform();

		if (name != null)
			setStep("Mover para o menu '" + name + "'");
	}

	/**
	 * Método que executa o "Assert.assertEquals(<resultadoAtual>,
	 * <resultadoEsperado>);" para o texto de um WebElement, após formatá-los. A
	 * formatação do <resultadoAtual> e <resultadoEsperado> é executada convertendo
	 * todas as letras para maiúsculas e removendo os espaços de antes e depois das
	 * Strings. Essa execução ocorrerá após o Selenium validar se o componente já
	 * está disponível para interação. Ao final é executado o método de criação do
	 * passo-a-passo do relatório.
	 * 
	 * @param By     - Forma de pesquisa (by) que o Selenium irá utilizar para
	 *               encontrar o componente na tela
	 * @param String - Nome do componente (exatamente como está visível em tela -
	 *               sem "/" ou "\" caso exista). Essa informação será utilizada
	 *               para informar para o relatório, qual componente o Selenium está
	 *               interagindo
	 * @param String - Resultado esperado
	 */
	public void verifyByElementText(By by, String name, String expected) {
		String expectedFormated = expected.toUpperCase().trim();
		String atualFormated = getText(by).toUpperCase().trim();

		overElement(by);

		softAssert.assertEquals(atualFormated, expectedFormated);
		setStep("Verificando se o texto de '" + name + "' é = " + expectedFormated, Status.INFO);

	}

	public static void createDir(String directory) {
		File file = new File(directory);
		if (!file.exists()) {
			try {
				file.mkdir();
			} catch (SecurityException se) {
				System.out.println("An exception occured while creating file '" + file + "': " + se);
			}
		}
	}

	private static void takeScreenShot(String screenShotName) {
		try {
			createDir(screenshotPathLocal);

			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File targetFile = new File(screenshotPathLocal, screenShotName);
			FileUtils.copyFile(screenshotFile, targetFile);

			BufferedImage image = ImageIO.read(screenshotFile);
			int scaledWidth = (int) (image.getWidth() * 0.25);
			int scaledHeight = (int) (image.getHeight() * 0.25);
			BufferedImage resized = resizeImage(image, scaledHeight, scaledWidth);

			File output = new File(screenshotPathLocal, "small_" + screenShotName);
			ImageIO.write(resized, "png", output);

		} catch (Exception e) {
			System.out.println("An exception occured while taking screenshot: " + e.getCause());
		}
	}

	private static BufferedImage resizeImage(BufferedImage img, int height, int width) {
		Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = resized.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		return resized;
	}

	private static String generateHtmlOfScreenshot(String img, String smallImg) {
		return "</br><a href= '" + img + "' target=\"_blank\"><img src='" + smallImg
				+ "' style='height: 250px;' alt='Forest'></a>";
	}

	public static void setStep(String step) {
		setStep(step, null, Status.PASS);
	}

	public static void setStep(String step, Status statusVerify) {
		setStep(step, null, statusVerify);
	}

	public static void setStep(String step, Throwable error, Status statusVerify) {
		String src = "";
		String srcSmall = "";

		String screenShotName = Util.getCurrentTimeStamp("dd-MM-yyyy_HH-mm-ss-SSS") + ".png";
		takeScreenShot(screenShotName);

		src = screenshotPath + FS + screenShotName;
		srcSmall = screenshotPath + FS + "small_" + screenShotName;

		if (statusVerify == Status.FAIL) {
			System.out.println("[FAILED] " + step + "\n");

			if (error != null)
				System.out.println(error + "\n");
			test.get().log(statusVerify, step + "<br/>Result:" + generateHtmlOfScreenshot(src, srcSmall));
		} else {
			System.out.println("[EXECUTED] " + step);
			if (printAllSteps) {
				test.get().log(statusVerify, step + "<br/>Result:" + generateHtmlOfScreenshot(src, srcSmall));
			} else {
				test.get().log(statusVerify, step);
			}
		}
	}
}
