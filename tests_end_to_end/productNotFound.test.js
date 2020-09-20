let userData = {}

module.exports = {
    before: function (browser){

        userData = {
            name: 'Manuel Neto',
            email: 'mbn.man@gmail.com',
            pass: '12345',
            product: 'bbb'
        }

        let login = browser.page.login();
        let account = browser.page.account();

        login
            .openScreen()
            .with(userData.email,userData.pass)

        account.accountIsDiplayed(userData.name)
    },
    
    'dado que eu procuro por produto': function (browser){
        let search = browser.page.search();

        search
            .byProduct(userData.product)
            .go()
    },

    'quando o produto não for encontrado': function (browser){
        browser
            .waitForElementVisible('.heading-counter',5000)
    },

    'então será exibida mensagem de nenhum resultado encontrado': function (browser){
        browser
            .assert.containsText('.alert-warning','No results were found for your search')
    }
}