
const vendasComandos = {
    validarTitulo(titulo) {
      return this
        .waitForElementVisible('@titulo', 1000)
        .assert.containsText('@titulo', titulo)
    },
    validarTotalVendas() {
      return this
        .waitForElementVisible('@total', 1000)
        .assert.containsText('@total', 'R$190,00')
    }
};

module.exports = {
    url: 'https://desafio-qa.herokuapp.com/',
    commands: [vendasComandos],
    elements: {
        titulo: 'h1',
        total: 'h2',
        preco: 'price',
        importacao: '#importer-status-imported h2',
        total: '#importer-status-imported h3'
      }
};