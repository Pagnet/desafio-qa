var loginActions = {
    with: function (email,pass) {
        return this
            .setValue('@emailField',email)
            .setValue('@passField',pass)
            .click('@loginButton')
     },

     openScreen: function (){
         return this   
            .navigate()
            .waitForElementVisible('@signInLink',5000)
            .click('@signInLink')
     },

     failedMessageDisplayed: function (){
         return this
            .waitForElementVisible('@failedMessage',5000)
            .assert.containsText('@failedMessage','Authentication failed.')
     }
}

module.exports = {
    url: '/',
    commands: [loginActions],
    elements: {
        signInLink: '.login',
        emailField: 'input[name=email]',
        passField: 'input[name=passwd]',
        loginButton: 'button[name=SubmitLogin]',
        failedMessage: 'ol > li',
    }
}
