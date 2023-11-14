# CadastroDeAlunosV2

Projeto de sistema de cadastro de alunos, cursos e matrículas.  
Este projeto é uma segunda versão do inicial [CadastroDeAlunos](https://github.com/sbarbosadiego/CadastroDeAlunos) em que a conexão ao banco de dados é feita através do JDBC e utilização do padrão MVC (Model, View, Controller), nesta segunda versão do projeto é implementado as mesmas operações CRUD (Create, Read, Update, Delete), utilizando tecnologias como JPA/Hibernate para mapeamento objeto-relacional, Lombok para reduzir a verbosidade do código e o Maven para gerenciamento de dependências e também a adoção do padrão MVC.  
Com uma interface para uso em Java/Swing, foi alterado a abordagem para o cadastro de aluno, curso e matrícula, para que seja separado da interface de navegação, visando a redução de elementos em tela para simplificar a interação do usuário.

##
### Configurações de Ambiente
- SO: Xubuntu 22.04 / Pop!_OS 22.04 / Windows 10
- JDK: 17.0.6
- MySQL: 8.0.32 Community

### Instalação/Configuração
- Java: [Windows](https://www.youtube.com/watch?v=QekeJBShCy4) / [Linux](https://www.youtube.com/watch?v=Kn87QF1mEcY")
- MySQL: [Windows](https://www.youtube.com/watch?v=DKMrVxtJyUk) / [Linux](https://youtu.be/CBK7c1xp-zI")
- NetBeans: [Windows](https://www.youtube.com/watch?v=dmnerOpFj1E) / [Linux](https://www.youtube.com/watch?v=SiPJcbrW9K8")

### Acesso ao Banco de dados
Para realizar o acesso ao banco de dados, deve ser acessado o diretório sources\META-INF, e renomeado o arquivo persistenc.xml para persistence.xml, dentro deste informar o usuário de acesso ao banco de dados e senha do mesmo.  
Em seu banco de dados criar uma base de dados com o seguinte nome cadastrodealunosv2, ou copiar e executar o código abaixo:
<pre>
CREATE SCHEMA cadastrodealunosv2;
</pre>
A após isso pode ser executado o projeto, com o mapeamento feito através do JPA/Hibernate, as tabelas e seus relacionamentos serão configurados automaticamente.