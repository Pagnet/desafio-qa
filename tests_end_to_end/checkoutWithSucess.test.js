let userData = {}

module.exports = {
    before: function (browser){

        userData = {
            name: 'Manuel Neto',
            email: 'mbn.man@gmail.com',
            pass: '12345',
            product: 'Blouses',
            order: '',
            orderStatus:'On backorder'
        }

        let login = browser.page.login();
        let account = browser.page.account();
        
        login
            .openScreen()
            .with(userData.email,userData.pass)

        account.accountIsDiplayed(userData.name)
    },
    
    'quando eu procuro pelo produto': function (browser){
        let search = browser.page.search();

        search
            .byProduct(userData.product)
            .selectResult(userData.product)
    },

    'e coloco o produto no carrinho': function (browser){
        let product = browser.page.product();
        
        product.addToCart()
    },

    'e faço checkout': function (browser) {
        let checkout = browser.page.checkout();

        checkout
            .proceedToCheckoutOnCartModal()
            .proceedToCheckoutOnSummary()
            .proceedtoCheckoutOnAddress()
            .proceedtoCheckoutOnShipping()
            .selectBankWirePayment()
            .confirmOrderOnPayment()    

    },
    'então a ordem deve ser completada com sucesso': function (browser) {       
        let checkout = browser.page.checkout();

        checkout.orderCompletedWithSuccess('Your order on My Store is complete.')
            
    },

    'e o número da ordem deve ser armazenado': async function (browser){
        let checkout = browser.page.checkout()

        userData.order = await checkout.setProductOrder()

    },

    'e o número e status da ordem devem ser exibidos corretamente no histórico': function (browser) {
        let account = browser.page.account()
            
        account
            .openAccountScreen()
            .openOrderHistoryScreen()  
            .orderStatusIsCorrect(userData.order,userData.orderStatus)  
            
    }
}