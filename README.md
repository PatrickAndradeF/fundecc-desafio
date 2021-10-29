# fundecc-desafio
Repositório para desafio da Fundecc

Explicando a execução da aplicação:

No diretório "frontend", encontra-se a parte do front-end relacionada ao desafio. Nesta pasta possui um arquivo "readme", que detalha como executar a aplicação via linha de comando.
No meu caso específico, tive que baixar o node.js, que possui os pacotes npm necessários para a execução da aplicação(Sistemas Windows).

No diretório fundecc-desafio/fundecc atualizado/fundecc/, encontra-se o back-end que foi desenvolvido em java-spring boot e pode ser executado via linha de comando através do 
comando mvn spring-boot:run. Esse comando deve ser executado no caminho que possui o arquivo "pom.xml".

NOTA: o back-end deve ser executado primeiro, visto que o o front-end possui um arquivo chamado "vue.config.js", que poussi uma proxy para mapear as requisições que são enviadas 
fora do seu path para: http://localhost:8080/, sendo assim, para correta execução do front e back, será necessário executar primeiro o back-end.
