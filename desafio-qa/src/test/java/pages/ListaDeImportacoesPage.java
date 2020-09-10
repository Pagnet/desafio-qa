package pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.TestRunner;

public class ListaDeImportacoesPage extends TestRunner{
	
	public void acessarPage(String url) throws InterruptedException {
		driver.get(url);
	}
	
	public void verificarPage() throws InterruptedException {
		WebElement page = driver.findElement(By.className("container"));
		assertTrue(page.isDisplayed());
	}
	
	public void verificarTabelaImportacoes() throws InterruptedException {
		WebElement tabela = driver.findElement(By.className("importer-purchases-table"));
		assertTrue(tabela.isDisplayed());
	}
	
	public void validarTitulo(String titulo_esperado) throws InterruptedException {
		String titulo_exibido = driver.findElement(By.tagName("h1")).getText();
		assertEquals(titulo_esperado, titulo_exibido);
	}
	
	public void validarValorTotalAbaixoTitulo(String valor_total_abaixo_esperado) throws InterruptedException {
		String valor_total_abaixo_exibido = driver.findElement(By.tagName("price")).getText();
		assertEquals(valor_total_abaixo_esperado, valor_total_abaixo_exibido);
	}
	
	public void validarValorTotalAcimaTabela(String valor_total_acima_esperado) throws InterruptedException {
		String valor_total_acima_exibido = driver.findElement(By.tagName("price")).getText();
		assertEquals(valor_total_acima_esperado, valor_total_acima_exibido);
	}
	
	public void validarNomeComprador(String comprador_esperado) throws InterruptedException {
		String comprador_exibido = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[1]")).getText();
		assertEquals(comprador_esperado, comprador_exibido);
	}
	
	public void validarDescricao(String descricao_esperada) throws InterruptedException {
		String descricao_exibida = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]")).getText();
		assertEquals(descricao_esperada, descricao_exibida);
	}
	
	public void validarPreco(String preco_esperado) throws InterruptedException {
		String preco_exibido = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]")).getText();
		assertEquals(preco_esperado, preco_exibido);
	}
	
	public void validarQtd(int qtd_esperada) throws InterruptedException {
		String qtd_exibida = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[4]")).getText();
		assertEquals(qtd_esperada, qtd_exibida);
	}
	
	public void validarTotal(String total_esperado) throws InterruptedException {
		String total_exibido = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[5]")).getText();
		assertEquals(total_esperado, total_exibido);
	}
	
	public void validarNomeVendedor(String vendedor_esperado) throws InterruptedException {
		String vendedor_exibido = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[6]")).getText();
		assertEquals(vendedor_esperado, vendedor_exibido);
	}
	
	public void validarEnderecoVendedor(String endereco_esperado) throws InterruptedException {
		String vendedor_exibido = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[7]")).getText();
		assertEquals(endereco_esperado, vendedor_exibido);
	}
	
	public void fecharNavegador() {
		driver.close();
	}

}
