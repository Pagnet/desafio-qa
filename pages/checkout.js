var checkoutActions = {
    proceedToCheckoutOnCartModal: function (){
        return this
            .waitForElementVisible('@checkoutButtonCart',5000)
            .click('@checkoutButtonCart')
    },

    proceedToCheckoutOnSummary: function (){
        return this
            .moveToElement('@checkoutButtonSummary',10,10)
            .waitForElementVisible('@checkoutButtonSummary',5000)
            .click('@checkoutButtonSummary')
    },

    proceedtoCheckoutOnAddress: function(){
        return this
            .waitForElementVisible('@checkoutButtonAddress',10000)
            .click('@checkoutButtonAddress')
    },

    proceedtoCheckoutOnShipping: function(){
        return this
            .waitForElementVisible('@checkerBox')
            .click('@checkerBox')
            .waitForElementVisible('@checkoutButtonShipping',5000)
            .click('@checkoutButtonShipping')
    },

    selectBankWirePayment: function(){
        return this
            .moveToElement('@bankWireOption', 10, 10)
            .waitForElementVisible('@bankWireOption',5000)
            .click('@bankWireOption')
    },

    confirmOrderOnPayment: function (){
        return this
            .waitForElementVisible('@confirmButtonPayment',5000)
            .click('@confirmButtonPayment')
    },

    orderCompletedWithSuccess: function (message){
        return this
            .moveToElement('@boxPaymentResult',10,10)
            .waitForElementPresent('@boxPaymentResult',5000)
            .assert.containsText('@boxPaymentResult', message)
    },

    setProductOrder: async function(){
        const browser = this
        const jsonResult =  await browser.getText('@boxPaymentResult');
        return JSON.stringify(jsonResult).substr(290,9)

    },
}

module.exports = {
   url: '/',
   commands: [checkoutActions],
   elements: {
        checkoutButtonCart: '.button-medium',
        checkoutButtonSummary: '.standard-checkout',
        checkoutButtonAddress: 'button[name=processAddress]',
        checkoutButtonShipping: 'button[name=processCarrier]',
        checkerBox: '.checker',
        bankWireOption: '.bankwire',
        confirmButtonPayment: '#cart_navigation span',
        boxPaymentResult: '.box'
   }
}
