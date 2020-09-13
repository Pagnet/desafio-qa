Cypress.Commands.add("searchProduct",(product) =>  {
    cy
    .get('#search_query_top').type(product)
    .get('#searchbox > .btn').click()
})

Cypress.Commands.add("addToCard",() =>  {
    cy.get('.ajax_add_to_cart_button > span').click()
})

Cypress.Commands.add("proceedToCard",() =>  {
    cy.get('.button-container > .button-medium > span').click()
})

Cypress.Commands.add("proceedToCheckout",() =>  {
    cy.get('.cart_navigation > .button > span').click()
})

Cypress.Commands.add("loginAccount", (userAccount) => {
    cy
    .get('#email').type(userAccount.email)
    .get('#passwd').type(userAccount.password)
    .get('#SubmitLogin > span').click()
})

Cypress.Commands.add("termsOfService", () => {
    cy.get('#cgv').click()
})

Cypress.Commands.add("payByCheck", () => {
    cy.get('.cheque').click()
})

Cypress.Commands.add("confirmOrder", () => {
    cy.get('#cart_navigation > .button > span').click()
})









