import {importPage} from '../pages/lista_importacao'

beforeEach(() => {
  cy.homePage(Cypress.env('URL_QA'))
})

describe('List of imports from your store', () => {
  it('should check the title of the homepage', () => {
       importPage.validateTitlePage()
  })
})
