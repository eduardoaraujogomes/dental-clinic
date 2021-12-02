# Sistema de reserva de consultas
Desejamos implementar um sistema que permita administrar a reserva/marcação de consultas para uma clínica odontológica. Os requisitos que devem ser atendidos são os seguintes:

- Administração de dados odontológicos: Adicionar e modificar os dados dos dentistas. Registrar nome, sobrenome e matrícula de cadastro.
- Administração de pacientes: Registrar, modificar e excluir pacientes. De cada um se armazenam: nome, sobrenome, endereço, RG, data de alta.
- Registrar consulta: Deve ser possível permitir que um paciente seja atribuído a uma consulta com um dentista em uma determinada data e hora. 

## Requerimentos técnicos
- A aplicação deve ser desenvolvida em camadas:
- Camada de apresentação (MVC): São as telas web que teremos que desenvolver usando o framework Spring Boot MVC os controladores.
- Camada de negócio: São as classes Java de nosso negócio modelado através do paradigma orientado a objetos.
- Camada de acesso a dados (DAO/Repository): São as classes que se encarregam de acessar o banco de dados.
- Camada de Dados (banco de dados): É o banco de dados de nosso sistema modelado por meio de um modelo entidade-relacionamento. Usaremos a base H2 pela sua praticidade.


