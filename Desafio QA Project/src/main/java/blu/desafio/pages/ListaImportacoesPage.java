package blu.desafio.pages;

import static blu.desafio.core.DriverFactory.getDriver;

import java.math.BigDecimal;

import org.openqa.selenium.By;

import blu.desafio.core.Utils;

public class ListaImportacoesPage {

	public void acessarTela() {
		getDriver().get("https://desafio-qa.herokuapp.com/");
	}

	public String retornaTotalTitulo() {
		return getDriver().findElement(By.xpath("//h2//price")).getText();
	}

	public String retornaTotalImportacao() {
		return getDriver().findElement(By.xpath("//h3//price")).getText();
	}

	public String retornaTextoColunaComprador() {
		return getDriver().findElement(By.xpath("//table[@class='importer-purchases-table']/tbody[1]/tr[1]/th[1]"))
				.getText();
	}
	
	public Object retornaTextoColunaDescricao() {
		return getDriver().findElement(By.xpath("//table[@class='importer-purchases-table']/tbody[1]/tr[1]/th[2]"))
				.getText();
	}

	public String retornaTextoColunaPreco() {
		return getDriver().findElement(By.xpath("//table[@class='importer-purchases-table']/tbody[1]/tr[1]/th[3]"))
				.getText();
	}

	public String retornaTextoColunaEndereco() {
		return getDriver().findElement(By.xpath("//table[@class='importer-purchases-table']/tbody[1]/tr[1]/th[7]"))
				.getText();
	}

	public String retornaTextoColunaQtd() {
		return getDriver().findElement(By.xpath("//table[@class='importer-purchases-table']/tbody[1]/tr[1]/th[5]"))
				.getText();
	}

	public String retornaTextoColunaTotal() {
		return getDriver().findElement(By.xpath("//table[@class='importer-purchases-table']/tbody[1]/tr[1]/th[4]"))
			.getText();
	}
	
	public Object retornaTextoColunaNomeVendedor() {
		return getDriver().findElement(By.xpath("//table[@class='importer-purchases-table']/tbody[1]/tr[1]/th[6]"))
				.getText();
	}
	
	public String retornaValorColunaPreco(String nome) {
		return getDriver().findElement(By.xpath("//tr/td[normalize-space(text())='"+ nome + "']/../td[3]"))
				.getText();
	}
	
	public String retonaValorTotal(String nome) {
		String preco = Utils.removerFormatacao(retornaValorColunaPreco(nome));
		String qtd = retornaValorColunaQtd(nome);
		BigDecimal total = new BigDecimal(preco).multiply(new BigDecimal(qtd));
		return total.toString();
	}
	
	public String retornaValorColunaQtd(String nome) {
		return getDriver().findElement(By.xpath("//tr/td[normalize-space(text())='"+ nome + "']/../td[5]"))
				.getText();
	}

	public String retonaValorColunaTotal(String nome) {
			return getDriver().findElement(By.xpath("//tr/td[normalize-space(text())='"+ nome + "']/../td[4]"))
				.getText();
	}
	
	

}
