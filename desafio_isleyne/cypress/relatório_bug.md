# Relatório de bugs
> Escrita em BDD.

1.

Resultado esperado:

Dado que o “Gerente” deseja visualizar o valor total das importações da lista de importações da sua loja
Então deve ser apresentado a somatoria de todos os valores vendidos


Resultado encontrado:

 Ao verificar o valor do campo “ Total  bruto das importações” o valor total se encontra zerado (0) .


2.

Resultado esperado:
Dado que o “Gerente” deseja visualizar o valor total bruto da importação  Nº 5
Quando somar todos os valores total das compras dos  (4) compradores
Então deve ser apresentado a somatória total de todos os valores vendidos


Resultado encontrado:
 Ao verificar o campo “ Total  bruto das importações  Nº 5”  o valor total não bate com a somatória de todos o valor total das compras dos (4) compradores .

3.

Resultado esperado
Dado que o Gerente deseja visualizar a quantidade de compra de cada comprador
Então deve apresentar a quantidade de itens comprados no campo “Qtde”


Resultado encontrado:
Ao verificar o campo “Qtde” de todos os compradores, o valor não está conforme o esperado, pois exibe o valor do preço “total” ao invés da quantidade.




4.
Resultado esperado
Dado que o Gerente deseja visualizar o valor “total” de cada comprador
Então deve apresentar o valor total da compra no campo “Total”

Resultado encontrado:
Ao verificar o campo “Total” , pois exibe a quantidade ao invés do valor da compra



5.

Resultado esperado
Dado que o Gerente deseja visualizar o valor “total” do comprador “Marty McFly”
Quando o item comprado estiver em promoção
E a quantidade de itens comprados
Então deve apresentar o valor total da compra no campo “Total”


Resultado encontrado:
Ao verificar a descrição e a quantidade de item de  compra do comprado “Marty McFly” , o valor total não bate com a quantidade comprada,  sendo que, cada item tem o valor de 5 reais conforme a promoção descrita no campo Descrição.

O comprador MartyMcfly comprou 2 itens na promoção, somando no valor total de R$ 10 reias


6.

Resultado esperado:

Dado que o Gerente deseja visualizar o valor “total” do comprador “Snake Plissken”
Quando o item comprado estiver em promoção
E a quantidade de itens comprados
Então deve apresentar o valor total da compra no campo “Total”



Resultado encontrado:
Ao verificar a descrição e a quantidade de item de  compra do comprado “Snake Plissken” , o valor total não bate com a quantidade comprada,  sendo que, cada item tem o valor de 5 reais conforme a promoção descrita no campo Descrição.

O comprador Snake Plissken comprou 8 itens na promoção, somando no valor total de R$ 40 reais
