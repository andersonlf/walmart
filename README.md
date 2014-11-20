walmart
=======

[![Build Status](https://travis-ci.org/andersonlf/walmart.svg?branch=master)](https://travis-ci.org/andersonlf/walmart)


Problema
--------

**Entregando Mercadorias**

O Walmart esta desenvolvendo um novo sistema de logistica e sua ajuda é muito importante neste momento. Sua tarefa será desenvolver o novo sistema de entregas visando sempre o menor custo. Para popular sua base de dados o sistema precisa expor um Webservices que aceite o formato de malha logística (exemplo abaixo), nesta mesma requisição o requisitante deverá informar um nome para este mapa. É importante que os mapas sejam persistidos para evitar que a cada novo deploy todas as informações desapareçam. O formato de malha logística é bastante simples, cada linha mostra uma rota: ponto de origem, ponto de destino e distância entre os pontos em quilômetros.

<pre>
A B 10
B D 15
A C 20
C D 30
B E 50
D E 30
</pre>

Com os mapas carregados o requisitante irá procurar o menor valor de entrega e seu caminho, para isso ele passará o nome do ponto de origem, nome do ponto de destino, autonomia do caminhão (km/l) e o valor do litro do combustivel, agora sua tarefa é criar este Webservices. Um exemplo de entrada seria, origem A, destino D, autonomia 10, valor do litro 2,50; a resposta seria a rota A B D com custo de 6,25.

Voce está livre para definir a melhor arquitetura e tecnologias para solucionar este desafio, mas não se esqueça de contar sua motivação no arquivo README que deve acompanhar sua solução, junto com os detalhes de como executar seu programa. Documentação e testes serão avaliados também =) Lembre-se de que iremos executar seu código com malhas beeemm mais complexas, por isso é importante pensar em requisitos não funcionais também!!

Também gostariamos de acompanhar o desenvolvimento da sua aplicação através do código fonte. Por isso, solicitamos a criação de um repositório que seja compartilhado com a gente. Para o desenvolvimento desse sistema, nós solicitamos que você utilize a sua (ou as suas) linguagem de programação principal. Pode ser Java, JavaScript ou Ruby.


Solução
-------

**Arquitetura**

O aplicativo foi desenvolvido usando a Plataforma JEE 7 - Java Enterprise Edition, empregando APIs robustas para persitência, como a Java Persistence API (JPA), e a recente Java API for RESTful Web Services (JAX-RS) para construção de Web Services. Além dessas APIs, também foi utilizada o Simple Logging Facade for Java (SL4J), como facade para o Log4j, renomado framework para logging de aplicações. Para criação de testes unitários foi utilizado o JUnit, na versão 4.11.

Os componentes da solução são: um módulo EJB (JAR) e um módulo WAR empacotados como um EAR. O módulo WAR publica os RESTFul Web Services enquanto o módulo EJB possui a unidade de persistência, entidades, serviços EJB, classes utilitárias, singletons, DTOs e DAOs.

A arquitetura provê ainda um conjunto de super classes que fornece infraestrutura mínima para o desenvolvimento de novas funcionalidades com rapidez e segurança tendo apoio na parametrização de objetos com mesmo comportamento.

Dessa forma, uma requisição típica atendida pelo sistema tem o seguinte ciclo de vida:
  
  1. Recepção no RESTFul Web Services, hospedado no contexto web da aplicação.
  1. No momento de implantação a Dependency Injection (DI) disponibiliza o serviço EJB para chamada a partir do resource.
  1. O serviço EJB é invocado e uma transação é aberta.
  1. No serviço EJB, no momento da implantação, a Dependency Injection (DI) disponibiliza outros recursos necessários para construção do EJB, por exemplo o Entity Manager associado a unidade de persistência do módulo. Outros recursos são criados, como o DAO.
  1. Uma chamada ao método de persistência é realizada.
  1. O DAO executa a operação e retorna para o serviço EJB.
  1. O EJB retorna para o Web Service que retorna para o cliente. 


**Softwares necessários**

  * Oracle JDK 8u25
  * Wildfly 8.1.0.Final
  * Apache Maven 3.2.3
  * H2 Database 1.3.176


**Instalação**

  * Oracle JDK 8u25
    1. Acesse http://www.oracle.com/technetwork/java/javase/downloads/index.html e faça o download do Oracle JDK 8u25.
    1. Realize a instalação e crie a variável de ambiente JAVA_HOME apontando para a raiz do diretório onde o Oracle JDK 8u25 foi instalado.
  
  * H2 Database 1.3.176
    1. Acesse http://www.h2database.com/h2-2014-04-05.zip e realize o download da H2 Database 1.3.176.
    1. Descompacte o arquivo no diretório home do usuário. A partir de agora esse diretório será chamado H2_HOME.
    1. Acesse o diretório H2_HOME/bin e edite o arquivo h2.sh ou h2.bat.
    1. Modifique a linha de org.h2.tools.Console para org.h2.tools.Server.
    1. Salve o arquivo e execute-o.
    1. Abra o navegador e acesse http://127.0.1.1:8082/login.jsp
    1. Na combo Saved Settings escolha Generic H2 (Server)
    1. No campo JDBC URL digite jdbc:h2:tcp://localhost//HOME\_USER/walmart, trocando HOME\_USER pelo diretório raiz do home do usuário. Exemplo: jdbc:h2:tcp://localhost//home/anderson/walmart
    1. No campo User Name digite sa
    1. No campo Password digite sa
    1. Após o login, copie o conteúdo do script SQL localizado no diretório sql/001.create-tables.sql e execute-o na interface administrativa do H2 Database para criar as tabelas.
    1. O banco de dados está pronto!
     
  * Wildfly 8.1.0 Final
    1. Acesse http://download.jboss.org/wildfly/8.1.0.Final/wildfly-8.1.0.Final.zip e realize o download do servidor de aplicação Wildfly 8.1.0.Final.
    1. Descompacte o arquivo baixado na raiz do diretório home do usuário. A partir de agora esse diretório será chamado JBOSS_HOME.
    1. Acesse o diretório JBOSS_HOME/bin e execute o script standalone.sh ou standalone.bat.
    1. Após execução desse script a interface administrativa do servidor de aplicação Wildfly estará acessível a partir do endereço http://localhost:9990/console. Para acessar a interface administrativa é necessário criar um usuário e senha.
    1. Para criar o usuário e senha execute o script add-user.sh.
    1. Para a pergunta What type of user do you wish to add? digite a opção _a_ e aperte _enter_.
    1. Digite admin para o Username.
    1. Digite @dmin123 para o Password.
    1. Tecle _enter_ para a pergunta What groups do you want this user to belong to?
    1. Digite yes para a Is this correct yes/no?
    1. Responda no para a pergunta Is this new user going to be used for one AS process to connect to another AS process?
    1. O usuário foi criado.
    1. Acesse a http://localhost:9990/console e realize login com o usuário que acabou de ser criado.
    1. Após o login, na seção Create a Datasources, clique em Datasources.
    1. Na tela que surge clique em Add.
    1. Informe WalmartDS no campo Name e java:jboss/datasources/WalmartDS no campo JNDI Name e clique em Next.
    1. Na tela seguinte verifique se o driver h2 está selecionado e clique em Next.
    1. Na próxima tela, no campo Connection URL digite a JDBC URL informada na configuração do H2 Database 1.3.176, informa também usuário e senha. Clique em Test Connection. A mensagem Successfully created JDBC connection deve ser exibida. Clique Ok e em seguida em Done.
    1. O servidor de aplicações está pronto!

  * Apache Maven 3.2.3
    1. Acesse http://maven.apache.org e realize o download do Apache Maven 3.2.3.
    1. Descompacte o arquivo baixado na raiz do diretório home do usuário.
    1. Crie a variável de ambiente MAVEN_HOME apontando para a raiz do diretório onde o Apache Maven foi descompactado.
    1. Edite o arquivo pom.xml na raiz do diretório e altere a propriedade wildfly.home para o valor correto, considerando o valor da variável JBOSS_HOME. Exemplo: /home/anderson/wildfly-8.1.0.Final
    1. Em seguida execute os comandos: 
      1. mvn clean install
      1. mvn -f ear/pom.xml wildfly:deploy
    1. Se tudo correu bem, o ear deverá estar implantado no servidor de aplicações.
    1. Pronto! A aplicação já está disponível e pronta para receber requisições.

**Execução**

  * Cadastrar Malha
    1. RESTFul Web Services: http://localhost:8080/walmart/api/malha
      1. Parâmetros: nome(String) e malha(String).
      1. Restrições: style=query, level=resource, Disables URL-Encoding of the parameter value marcado e Post QueryString marcado.  

  * Calcular Rota de Menor Custo
    1. RESTFul Web Services: http://localhost:8080/walmart/api/rotamenorcusto/{malha}/{origem}/{destino}/{autonomia}/{valor}
    1. Parâmetros: 
      1. malha(String): representa o nome da malha onde se deseja pesquisar.
      1. origem(String): representa o nome do ponto de origem.
      1. destino(String): representa o nome do ponto de destino.
      1. autonomia(double): representa a autonomia do veículo usado na entrega.
      1. valor(double): representa o valor do litro do combustível usado pelo veículo na entrega.
    1. Restrições: style=template, level=resource, Disables URL-Encoding of the parameter value marcado e Post QueryString marcado.


**Restrições, premissas e suposições**

  1. Não existe duas malhas com mesmo nome.
  1. Não existe dois pontos com mesmo nome na mesma malha.
  1. Só existe uma e apenas uma distância entre um ponto de origem A e um ponto de destino B pertencentes a uma malha.
  1. O cálculo da rota de menor custo é realizado apenas se e somente se o ponto de origem e o ponto de destino pertencem a mesma malha.


**TODO**

  1. Criar testes unitários para os webservices
  1. Criar testes unitários para a camada de persistência
  

**Concluídos**
  1. Explicar a arquitetura
  1. Tutorial sobre como executar: 
    * informando os links dos web services
    * informando os parametros
  1. Tutorial sobre como instalar:
    * como configurar o banco
    * como criar datasource
    * como implantar o artefato
  1. Escrever premissas e suposições
  1. Criar script DDL de banco de dados
  1. Criar DAO
  1. Alterar o algoritmo de dijkstra
  1. Tratar exceção quando uma malha já estiver incluída
  1. Tratar exceção quando não existir malha cadastrada
  1. Melhorar javadoc
  