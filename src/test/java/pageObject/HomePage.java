package pageObject;

import br.com.blue.data.ManagerData;
import br.com.blue.enums.TypeSelector;
import br.com.blue.util.Globals;

public class HomePage {

    ManagerData managerData = new ManagerData();

    public void homePage() throws Exception {

        Globals.browserManager.waitElementDone(TypeSelector.CLASSNAME.getTypeSelector(), "container");
    }

    public void validaNomeComprador() throws Exception {

        Globals.browserManager.compareElementInListIsEqual(TypeSelector.XPATH.getTypeSelector(),
                "//*[@class='importer-purchases-table']//tr/td[1]",
                "Nome Encontrado",
                "Nome Não Encontrado em Tela",
                managerData.getNomeComprador()[0]
        );

    }

    public void validaPreco(String nome) throws Exception {

        Globals.browserManager.compareElementInListIsEqual(TypeSelector.XPATH.getTypeSelector(),
                "//*[@class='importer-purchases-table']//tr/td[1]",
                "Nome Encontrado",
                "Nome Não Encontrado em Tela",
                String.valueOf(managerData.getPreco(nome)[0])
        );

    }

    public void validaValorTotal(String nome) throws Exception {

        double valorTotal = managerData.getPreco(nome)[0] * managerData.getQuantia(nome)[0];

        Globals.browserManager.compareElementInListIsEqual(TypeSelector.XPATH.getTypeSelector(),
                "//*[@class='importer-purchases-table']//tr/td[5]",
                "Valor Total da Compra do Comprador " + nome + " Correto",
                "Valor Total da Compra do Comprador " + nome + " Incorreto, Valor correto: " + valorTotal,
                String.valueOf(valorTotal)
        );

    }
}
