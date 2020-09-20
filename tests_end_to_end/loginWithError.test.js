var axios = require('axios');
let userData = {}

module.exports = {
    before: async function (browser){

        userData = {
            name: 'Manuel Neto',
            email: 'mbn.man@gmail.com',
            pass: '12345678'            
        }

    },
    
    'dado que eu estou na tela de login': function (browser){        
        let login = browser.page.login();
        
        login.openScreen()
    },

    'quando eu faço login na aplicação': function (browser){
        let login = browser.page.login();
        
        login.with(userData.email,userData.pass)   
    },

    'então a mensagem de erro deve ser exibida': function (browser){
        let login = browser.page.login();

        login.failedMessageDisplayed()
    },
}