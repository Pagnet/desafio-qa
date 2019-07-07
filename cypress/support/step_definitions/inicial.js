import { Given, Then } from "cypress-cucumber-preprocessor/steps";

beforeEach(() => {
    Given(`que o usuário visualiza a Lista de Importações`, () => {
      cy.visit('/')
    })
}) 

Then(`verifica se o usuário visualiza a pagina da lista de Importações`, () => {
    cy.contains('Lista de importações da sua loja').should('be.visible')
})
