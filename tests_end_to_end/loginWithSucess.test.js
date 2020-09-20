let userData = {}

module.exports = {
    before: function (browser){

        userData = {
            name: 'Manuel Neto',
            email: 'mbn.man@gmail.com',
            pass: '12345',
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

    'então a conta do usuário deve ser exibida': function (browser){
        let account = browser.page.account();

        account.accountIsDiplayed(userData.name)
    },
}