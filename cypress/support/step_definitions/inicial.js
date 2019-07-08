import { Given, Then } from "cypress-cucumber-preprocessor/steps";

beforeEach(() => {
    Given(`que o usuário visualiza a Lista de Importações`, () => {
      cy.visit('/')
    })
}) 

Then(`verifica se o usuário visualiza a pagina da lista de Importações`, () => {
    cy.contains('Lista de importações da sua loja').should('be.visible')
})

Then(`verifica se o usuário {string} se encontra no primeiro da lista de importação`, (string) => {
    cy.get('td').eq(0).should('contain', string)
})

Then(`Verifica se o titulo da página é igual a Teste realizado por Saulo Santigo via requisição`, () => {
    cy.server().should((server) => {
    cy.request('/').its('body').should('include', '<title>Teste realizado por Saulo Santiago</title>')
    expect(server.status).to.eq(200)
  })
})