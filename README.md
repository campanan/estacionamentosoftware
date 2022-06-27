# estacionamentosoftware
Software de gestão de estacionamento, utilizando Java, SpringBoot, MySql e Thymeleaf.

# Notas sobre o desenvolvimento:

Inicialmente seria realizado o desenvolvimento utilizando dois projetos, uma API backend e um frontend iria consumir essa API.
Ao fim optei por utilizar o Thymeleaf, onde o front é realizado server-side, para aprender e utilizar uma ferramenta nova.
Também utilizei o Docker para apenas o banco de dados, mesmo não sendo uma prática comum, para praticar e verificar conhecimentos com conteineirização.
O design utilizado para o estacionamento foi o padrão Rest, devido a inicialmente buscar a realização de uma API Restful. Após algumas mudanças e endpoints adcionados com a finalidade de acessar as ciews que o thymeleaf iria gerenciar, utilizamos o padrão MVC.

### Utilização
Primeiramente para utilização se deve fazer o clone do repositório.
Devemos ter instalado o docker e o maven nesse projeto. Os comandos abaixos devem ser digitados na sua IDE de desenvolvimento.
Posteriormente também sera conteinerizado a aplicação, de forma a simplificar a execução.
```javascript
cd "diretorio de sua preferencia"

git clone https://github.com/campanan/estacionamentosoftware

docker-compose up
```
### Configuração

Como pedido nas especificações, será adcionado diretamente no mysql os dados nas tabelas valor e usuario.

Utilizando o workbench ou outro terminal para o mysql inserir os 2 comandos:
```javascript

INSERT INTO `movimento`.`usuario`
(`id`,`nome`,`senha`,`usuario`)
VALUES
(1,admin,123456,admin);

##########################################

INSERT INTO `movimento`.`valor`
(`id`,`data_fim`,`valor_demais_horas`,`valor_primeira_hora`)
VALUES
(1,null,4,6);


```
Após isso inicializar a aplicação via IDE. Posteriormente iremos conteinerizar toda a aplicação, de forma a podeser ser utilizada apenas com comandos de run do docker.



###Futuras Implementações

Inicialmente não foi implementado testes unitários, e tratamento para excecções como tentar inserir valores em branco para o sistema, devido a utilização do Thymeleaf, os primeiros tratamentos que foram realizados para a API não cumprem o papel de impedir a requisição do cliente. 
