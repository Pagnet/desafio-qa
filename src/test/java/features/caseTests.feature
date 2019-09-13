# language: pt
@test
  Funcionalidade: Estes casos de testes descrevem as validações realizadas  no sistema Lista de Importações.

  Contexto:
  Dado usuário acessar o sistema Lista de Importações

  Cenário: Validar Lista de Compradores
    Então será feita a validação de todos os compradores do sistema

  Cenário: Validar Preco do Produto
    Então será feita a validação de todos os precos dos produtos do sistema

  Cenário : Validar acesso ao sistema via API
    Então será realizado a requisicao no sistema e validado se o mesmo foi realizado com sucesso

    Cenário : Validar Texto de Titulo Via API
      Então será realizado a requisicao no sistema e validado se o texto do titulo foi encontrado com sucesso
