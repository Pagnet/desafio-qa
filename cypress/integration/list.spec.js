describe('Validação dos dados da página', () => {
  it('Título e subtítulo da página', () => {
    cy.get('h1').should('have.text', '\n  \n  Lista de importações da sua loja\n');
    cy.get('body > h2').should('have.text', '\n  Total Bruto das importações\n  0,00\n');
    cy.get('body > h2 > price').should('have.text', '0,00');
  });

  it('Título da tabela de importação', () => {
    cy.get('h2 > b').should('have.text', '\n      \n      Importação Nº 5\n    ');
    cy.get('h3').should('have.text', '\n    Total bruto da importação\n    R$ 96,00\n    \n    \n  ');
    cy.get('h3 > price').should('have.text', 'R$ 96,00');
  })

  it('Título das colunas', () => {
    cy.get('table > tbody > tr > th:nth-child(1)').should('have.text', 'Comprado');
    cy.get('table > tbody > tr > th:nth-child(2)').should('have.text', 'Descrição');
    cy.get('table > tbody > tr > th:nth-child(3)').should('have.text', 'Preco');
    cy.get('table > tbody > tr > th:nth-child(4)').should('have.text', 'Qtde.');
    cy.get('table > tbody > tr > th:nth-child(5)').should('have.text', 'Total');
    cy.get('table > tbody > tr > th:nth-child(6)').should('have.text', 'Nome vendendor');
    cy.get('table > tbody > tr > th:nth-child(7)').should('have.text', 'Endereços vendedor');
  });

  it('Dados fixos das colunas', () => {
    cy.get('table > tbody > tr:nth-child(2)').parent('').within(() => {
      cy.get('td').eq(0).contains('João Silva');
      cy.get('td').eq(1).contains('R$10 off R$20 of food');
      cy.get('td').eq(2).contains('R$ 10,00');
      cy.get('td').eq(3).contains('R$ 20,00');
      cy.get('td').eq(4).contains('4');
      cy.get('td').eq(5).contains('987 Fake St');
      cy.get('td').eq(6).contains("Bob's Pizza");
    });
    cy.get('table > tbody > tr:nth-child(3)').parent('').within(() => {
      cy.get('tr:nth-child(3) > td').eq(0).contains('Amy Pond');
      cy.get('tr:nth-child(3) > td').eq(1).contains('R$30 of awesome for R$10');
      cy.get('tr:nth-child(3) > td').eq(2).contains('R$ 10,00');
      cy.get('tr:nth-child(3) > td').eq(3).contains('R$ 50,00');
      cy.get('tr:nth-child(3) > td').eq(4).contains('10');
      cy.get('tr:nth-child(3) > td').eq(5).contains('456 Unreal Rd');
      cy.get('tr:nth-child(3) > td').eq(6).contains("Tom's Awesome Shop");
    });
    cy.get('table > tbody > tr:nth-child(4)').parent('').within(() => {
      cy.get('tr:nth-child(4) > td').eq(0).contains('Marty McFly');
      cy.get('tr:nth-child(4) > td').eq(1).contains('R$20 Sneakers for R$5');
      cy.get('tr:nth-child(4) > td').eq(2).contains('R$ 5,00');
      cy.get('tr:nth-child(4) > td').eq(3).contains('R$ 5,00');
      cy.get('tr:nth-child(4) > td').eq(4).contains('2');
      cy.get('tr:nth-child(4) > td').eq(5).contains('123 Fake St');
      cy.get('tr:nth-child(4) > td').eq(6).contains('Sneaker Store Emporium');
    });
    cy.get('table > tbody > tr:nth-child(5)').parent('').within(() => {
      cy.get('tr:nth-child(5) > td').eq(0).contains('Snake Plissken');
      cy.get('tr:nth-child(5) > td').eq(1).contains('R$20 Sneakers for R$5');
      cy.get('tr:nth-child(5) > td').eq(2).contains('R$ 5,00');
      cy.get('tr:nth-child(5) > td').eq(3).contains('R$ 20,00');
      cy.get('tr:nth-child(5) > td').eq(4).contains('8');
      cy.get('tr:nth-child(5) > td').eq(5).contains('123 Fake St');
      cy.get('tr:nth-child(5) > td').eq(6).contains('Sneaker Store Emporium');
    });
  });
});
