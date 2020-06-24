Este é um projeto vinculado ao projeto prático de conclusão do curso de AceleraDev - Codenation.
Proposta: implementar uma API REST de log de eventos gerados por microsserviços. 
Abaixo estão os requisitos considerados:

**Premissas:**

A API deve ser pensada para atender diretamente um front-end
Deve ser capaz de gravar os logs de erro em um banco de dados relacional
O acesso a ela deve ser permitido apenas por requisições que utilizem um token de acesso válido

**Funcionalidades**

Deve permitir a autenticação do sistema que deseja utilizar a API gerando o Token de Acesso
Pode ser acessado por multiplos sistemas
Deve permitir gravar registros de eventos de log salvando informações de Level(error, warning, info), Descrição do Evento, LOG do Evento, ORIGEM(Sistema ou Serviço que originou o evento), DATA(Data do evento), QUANTIDADE(Quantidade de Eventos de mesmo tipo)
Deve permitir a listagem dos eventos juntamente com a filtragem de eventos por qualquer parâmetro especificado acima
Deve suportar Paginação
Deve suportar Ordenação por diferentes tipos de atributos
A consulta de listagem não deve retornar os LOGs dos Eventos
Deve permitir a busca de um evento por um ID, dessa maneira exibindo o LOG desse evento em específico