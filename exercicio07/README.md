# Como executar a aplicação

Dentro da pasta do projeto, execute o comando `mvn spring-boot:run`

## Procedure mysql
DELIMITER $$
CREATE PROCEDURE proc_endereco(IN in_id BIGINT, OUT endereco VARCHAR(254))
READS SQL DATA
BEGIN 
   SELECT CONCAT(logradouro, ', ', cidade, ', ', estado, '.')
   INTO endereco
   FROM ENDERECOS WHERE id = in_id;
END $$
