let userData = {}

module.exports = {
    before: function (browser){

        userData = {
            name: 'Manuel Neto',
            email: 'mbn.man@gmail.com',
            pass: '12345',
            product: 'Blouses',
        }

        let login = browser.page.login();
        let account = browser.page.account();

        login
            .openScreen()
            .with(userData.email,userData.pass)

        account.accountIsDiplayed(userData.name)
    },
    
    'dado que eu procuro pelo produto': function (browser){
        let search = browser.page.search();

        search
            .byProduct(userData.product)
            .selectResult(userData.product)
    },

    'quando coloco o produto no carrinho': function (browser){
        let product = browser.page.product();
        let checkout = browser.page.checkout();

        product.addToCart()
        checkout.proceedToCheckoutOnCartModal()
        
    },

    'e deleto o produto do carrinho': function(browser){
        browser
            .waitForElementVisible('.icon-trash',5000)
            .click('.icon-trash')
    },

    'então a mensagem para carrinho vazio é exibida': function (browser){
        browser
            .assert.containsText('.alert-warning','Your shopping cart is empty.')
    }
}