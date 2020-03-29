import {loginPage} from "../pages/lista_importacao"

Cypress.Commands.add('homePage', (url) => {
  cy.visit(url)
})
