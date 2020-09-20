var productActions = {
    addToCart: function () {
        return this
            .moveToElement('@addToCartButton', 10, 10)
            .click('@addToCartButton')
     }
}

module.exports = {
    url: '/',
    commands: [productActions],
    elements: {
        addToCartButton: '#add_to_cart',
    }
}
