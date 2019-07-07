
# language: pt

Funcionalidade: Visualização plataforma de Lista de Importações

        Eu como usuário, gostaria de visualizar a tela da aplicação Lista de Importações.

    Contexto: 
    Dado que o usuário visualiza a Lista de Importações
    
    @integracao
    Cenário: Acessar aplicação Lista de Importações com sucesso
        Então verifica se o usuário visualiza a pagina da lista de Importações

    @integracao
    Cenário: Verifica ordem do usuário João Silva, na lista de Importações
        Então verifica se o usuário "João Silva" se encontra no primeiro da lista de importação 
