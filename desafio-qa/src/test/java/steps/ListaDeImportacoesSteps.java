package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.ListaDeImportacoesPage;

public class ListaDeImportacoesSteps extends ListaDeImportacoesPage {

	@Dado("^que tenha acessado a url \"([^\"]*)\"$")
	public void que_tenha_acessado_a_url(String url) throws Throwable {
		acessarPage(url);
	}

	@Quando("^a tela for carregada totalmente$")
	public void a_tela_for_carregada_totalmente() throws Throwable {
		verificarPage();
	}
	
	@Entao("^deve ser exibido o titulo \"([^\"]*)\"$")
	public void deve_ser_exibido_o_titulo(String titulo_esperado) throws Throwable {
		validarTitulo(titulo_esperado);
	}

	@Entao("^deve ser exibido o valor total abaixo do titulo igual a \"([^\"]*)\"$")
	public void deve_ser_exibido_o_valor_total_abaixo_do_titulo_igual_a(String valor_total_abaixo_esperado) throws Throwable {
		validarValorTotalAbaixoTitulo(valor_total_abaixo_esperado);
	}

	@Entao("^deve ser exibido o valor total acima da tabela igual a \"([^\"]*)\"$")
	public void deve_ser_exibido_o_valor_total_acima_da_tabela_igual_a(String valor_total_acima_esperado) throws Throwable {
		validarValorTotalAcimaTabela(valor_total_acima_esperado);
	}

	@Entao("^deve ser exibido o nome do comprador igual a \"([^\"]*)\"$")
	public void deve_ser_exibido_o_nome_do_comprador_igual_a(String comprador_esperado) throws Throwable {
		validarNomeComprador(comprador_esperado);
	}

	@Entao("^deve ser exibido a descricao do item igual a \"([^\"]*)\"$")
	public void deve_ser_exibido_a_descricao_do_item_igual_a(String descricao_esperada) throws Throwable {
		validarDescricao(descricao_esperada);
	}

	@Entao("^deve ser exibido o preco do item igual a \"([^\"]*)\"$")
	public void deve_ser_exibido_o_preco_do_item_igual_a(String preco_esperado) throws Throwable {
		validarPreco(preco_esperado);
	}

	@Entao("^deve ser exibido a quantidade de itens vendidos igual a '(\\d+)'$")
	public void deve_ser_exibido_a_quantidade_de_itens_vendidos_igual_a(int qtd_esperada) throws Throwable {
		validarQtd(qtd_esperada);
	}

	@Entao("^deve ser exibido o valor total de itens vendidos do vendedor igual a \"([^\"]*)\"$")
	public void deve_ser_exibido_o_valor_total_de_itens_vendidos_do_vendedor_igual_a(String total_esperado) throws Throwable {
		validarTotal(total_esperado);
	}

	@Entao("^deve ser exibido o nome do vendedor igual a \"([^\"]*)\"$")
	public void deve_ser_exibido_o_nome_do_vendedor_igual_a(String vendedor_esperado) throws Throwable {
		validarNomeVendedor(vendedor_esperado);
	}

	@Entao("^deve ser exibido o endereco do vendedor igual a \"([^\"]*)\"$")
	public void deve_ser_exibido_o_endereco_do_vendedor_igual_a(String endereco_esperado) throws Throwable {
		validarEnderecoVendedor(endereco_esperado);
		fecharNavegador();
	}
}
