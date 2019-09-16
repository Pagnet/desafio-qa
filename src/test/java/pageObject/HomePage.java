package pageObject;

import br.com.blue.data.ManagerData;
import br.com.blue.enums.TypeSelector;
import br.com.blue.report.ReportManager;
import br.com.blue.util.Globals;

public class HomePage {

    public ManagerData managerData = new ManagerData();
    public static HomePage homePage = new HomePage();

    public void validaNomeComprador(String nome) throws Exception {


        Globals.browserManager.compareElementInListIsEqual(TypeSelector.XPATH.getTypeSelector(),
                "//*[@class='importer-purchases-table']//tr/td[1]",
                "Nome do Comprador  "+nome+" encontrado e validado no sistema",
                "Nome Não Encontrado em Tela",
                nome
        );
        ReportManager.getInstance().endTestReport();
    }

    public void validaPreco(String nome) throws Exception {

        int i =  managerData.getID(nome)[0]+1;

        Globals.browserManager.compareElementIsEqual(
                TypeSelector.XPATH.getTypeSelector(),
                "//*[@class='importer-purchases-table']//tr["+(i)+"]/td[3]",
                String.valueOf(managerData.getPreco(nome)[0]),
                "Preco Correto",
                "Preco encontra-se diferente do portfolio de venda"
        );
        ReportManager.getInstance().endTestReport();
    }

    public void validaValorTotal(String nome) throws Exception {

        double valorTotal = managerData.getPreco(nome)[0] * managerData.getQuantia(nome)[0];
        int i =  managerData.getID(nome)[0]+1;

        Globals.browserManager.compareElementIsEqual(
                TypeSelector.XPATH.getTypeSelector(),
                "//*[@class='importer-purchases-table']//tr["+(i)+"]/td[5]",
                String.valueOf(valorTotal),
                "Valor Total de Compra do Comprador " + nome + " Correto",
                "Valor Total de Compra do Comprador " + nome + " Incorreto, Valor correto: " + valorTotal
        );

        ReportManager.getInstance().endTestReport();

    }
}
