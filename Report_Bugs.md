# Lista de Bugs identificados na página

Agrupei os bugs encontrados em três taks.

----

## Título: [Front][Importação] Listagem de Importação - Erros ortograficos nos textos

**Problema**

Identificado que: Na página de listagem de vendas de importação alguns textos estão com erro ortograficos.

1. Texto do título da primeira coluna "Comprado" com escrita errada.
2. Texto do título da terceira coluna "Preco" com escrita errada.
3. Texto do título da sexta coluna "Nome vendendor" com escrita errada".
4. Texto do título da setima coluna "Endereços vendedor" com escrita errada.
5. Textos da coluna "Descrição" foram de padrão.
	
**Processo**

Passo a Passo: Acessar https://desafio-qa.herokuapp.com/ > Verificar textos conforme informado acima.

Ambiente: QA

Navegador: Google Chrome

Plataforma: Windows

**Solução**

Deve funcionar da seguinte forma: 

1. Texto correto "Comprador".
2. Texto correto "Preço".
3. Texto correto "Nome vendedor".
4. Texto correto "Endereço vendedor".
5. Pradão para valor "R$ 00,00".

----

## Título: [Front][Importação] Listagem de Importação - Ajuste de Layout

**Problema**

Identificado que:

1. Tabela não é responsiva.
2. Células da coluna não tem margem da direito, quando o texto é grande fica quase encontando na linha. No responsivo o texto vaza a célula.
3. Largura da coluna "Total" está despropocional ao dado interior dela.
4. Dados das colunas trocados:
	a. "Qtde" com "Total".
	b. "Nome vendendor" com "Endereços vendedor".
	
**Processo**

Passo a Passo: 

1. Acessar https://desafio-qa.herokuapp.com/ > Executar comando F12 > Executar comando CTRL+SHIT+M > Escolher brackpoint.

Demais: Acessar https://desafio-qa.herokuapp.com/ > Verificar conforme informado acima.

Ambiente: QA

Navegador: Google Chrome

Plataforma: Windows

**Solução**

Deve funcionar da seguinte forma: 

1. Aplicar responsividade para os brackpoint 1366px, 1024px, 768px, 320px.
2. Aplicar margem igual para todos os lados dentro da célula.
3. Ajustar largura de acordo com o dado.
4. Atualizar referencia das informações da tabela.

----

## Título: [Front][Importação] Listagem de Importação - Calculos da página errados

**Problema**

Identificado que:

1. Calculo da coluna "Total" está errado.
2. Calculo total da importação está errado.
3. Calculo total de todas as importações está errado.
	
**Processo**

Passo a Passo: Acessar https://desafio-qa.herokuapp.com/ > Executar calculo nos valores conform informado.

Ambiente: QA

Navegador: Google Chrome

Plataforma: Windows

**Solução**

Deve funcionar da seguinte forma: 

1. O valor da coluna "Total" deve ser o valor da coluna "Preço" x o valor da coluna "Qtde".
2. O valor total bruto da importação deve ser a soma de todos os valores da coluna "Total".
3. O valor total bruto de todas as importações deve ser a soma do valor bruto de todas as importações.
