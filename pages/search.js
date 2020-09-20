var searchActions = {
    byProduct: function (product) {
        return this
            .waitForElementVisible('@searchField',5000)
            .setValue('@searchField', product)
     },

     selectResult: function(product){
        return this
            .useXpath()
            .waitForElementVisible(`//li[contains(text(),"${product}")]`, 5000)
            .click(`//li[contains(text(),"${product}")]`)
            .useCss()
     },

     go: function(){
        return this
            .waitForElementVisible('@glassIcon',5000)
            .click('@glassIcon')
     }
}

module.exports = {
    url: '/',
    commands: [searchActions],
    elements: {
        searchField: '#search_query_top',
        glassIcon: 'button[name=submit_search]'
    }
}
