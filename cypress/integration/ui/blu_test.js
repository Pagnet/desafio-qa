/// <reference types="Cypress"/>
describe("conduct research and shopping", () => {

    beforeEach(() => {
        cy.visit(Cypress.env('baseUrl'));
    });

    it("purchase with existing user", () => {
        const product = "Blouse"
        const userAccount = {
            email: 'Jands@gmail.com',
            password: 'Palestra100'
        }

        cy.searchProduct(product)
        cy.addToCard()
        cy.proceedToCard()
        cy.proceedToCheckout()
        cy.loginAccount(userAccount)
        cy.proceedToCheckout()
        cy.termsOfService()
        cy.proceedToCheckout()
        cy.payByCheck()
        cy.confirmOrder()
        cy.screenshot()
        cy.get('.alert').should('contain', 'Your order on My Store is complete.')
    });

    it("conduct research with nonexistent product", () => {
        const product = "Test"

        cy.searchProduct(product)
        cy.screenshot()
        cy.get('.alert').should('contain', 'No results were found for your search')
    });
});