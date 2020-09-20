var accountActions = {
     accountIsDiplayed: function (accountName){
        return this
            .waitForElementVisible('@userInfo',5000)
            .assert.containsText('@userInfo',accountName)
     },

     openAccountScreen: function (){
         return this
            .click('@userInfo')
     },

     openOrderHistoryScreen: function(){
        return this
            .click('@userOrderHistory')
     },

     orderStatusIsCorrect: function(order,status){
         return this
            .useXpath() 
            .assert.containsText('//tr[1]//td[1]//a',order)
            .assert.containsText('//tr[1]//td[5]//span',status)   
     }
}

module.exports = {
    url: '/',
    commands: [accountActions],
    elements: {
        userInfo: '.header_user_info',
        userOrderHistory: '.icon-list-ol',
    }
}
