export class ImportListPO {

  constructor() {
    this.text_page_title = ('h1')
  }

  validateTitlePage() {
    cy.contains(this.text_page_title, 'Lista de importações da sua loja')
  }

}
 export const importPage = new ImportListPO();
