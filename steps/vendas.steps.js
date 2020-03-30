const {client} = require('nightwatch-api')
const {Given, When, Then} = require('cucumber')

When('Eu acesso a página de vendas', function () {
    let vendas = client.page.vendas()
    return vendas.navigate()
});

Then('devo visualizar o titulo {string}', function (titulo) {
    let vendas = client.page.vendas()
    return vendas.validarTitulo(titulo)
});

Then('devo visualizar o valor total de {string}', function (total) {
    let vendas = client.page.vendas()
    return vendas.validarTotalVendas(total)
});

Then('devo visualizar os valores {string} {string} {string} {string} {string} {string} {string} {string}', function (vendedor, descricao, quantidade, preco, total, comprador, endereco, linha) {
    return new Promise((resolve, reject) => {
         client.getText(`table tbody tr:nth-child(${linha}) td:nth-child(1)`, function(result){
            if (result.value !== vendedor){
                reject(new Error(`${vendedor} não é igual a ${result.value}`))
            }
         })
         client.getText(`table tbody tr:nth-child(${linha}) td:nth-child(2)`, function(result){
            if (result.value !== descricao){
                reject(new Error(`${descricao} não é igual a ${result.value}`))
            }
         })
         client.getText(`table tbody tr:nth-child(${linha}) td:nth-child(3)`, function(result){
            if (result.value !== preco){
                reject(new Error(`${preco} não é igual a ${result.value}`))
            }
         })
         client.getText(`table tbody tr:nth-child(${linha}) td:nth-child(4)`, function(result){
            if (result.value !== quantidade){
                reject(new Error(`${quantidade} não é igual a ${result.value}`))
            }
         })
         client.getText(`table tbody tr:nth-child(${linha}) td:nth-child(5)`, function(result){
            if (result.value !== total){
                reject(new Error(`${total} não é igual a ${result.value}`))
            }
         })
         client.getText(`table tbody tr:nth-child(${linha}) td:nth-child(6)`, function(result){
            if (result.value !== comprador){
                reject(new Error(`${comprador} não é igual a ${result.value}`))
            }
         })
         client.getText(`table tbody tr:nth-child(${linha}) td:nth-child(7)`, function(result){
            if (result.value !== endereco){
                reject(new Error(`${endereco} não é igual a ${result.value}`))
            }
            resolve(true)
         })
     })
});