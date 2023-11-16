Projeto de Gerenciamento de Usuários
Este projeto consiste em uma aplicação web para o gerenciamento de usuários, com operações de cadastro, listagem, edição, exclusão e validação de senha. A aplicação é desenvolvida em Java, utilizando o framework Spring, tanto no frontend quanto no backend.

Frontend
Estrutura do Projeto
O frontend é construído em HTML, CSS e JavaScript, proporcionando uma interface amigável para os usuários interagirem. A estrutura do projeto inclui:

HTML (index.html): Define a estrutura da página de inscrição, com campos para nome, e-mail, senha e um botão de inscrição.

CSS (style.css): Gerencia o estilo visual da aplicação, utilizando esquemas de cores suaves e um design responsivo.

JavaScript (script.js): Adiciona lógica do cliente para validar campos, enviar dados ao backend e exibir mensagens de feedback.

Funcionalidades
Cadastro de Usuário:

Preencha os campos obrigatórios (Nome, E-mail, Senha) e clique em "Inscrever-se".
Mensagens de feedback são exibidas, indicando sucesso, campos obrigatórios não preenchidos ou e-mail duplicado.
Lógica do Cliente:

JavaScript implementa validações no campo de telefone, limitando o número de caracteres e removendo caracteres não numéricos.
Funções registrar e limpar são responsáveis por enviar dados ao backend e resetar os campos após o cadastro.
Backend
Estrutura do Projeto
O backend é desenvolvido em Java com o framework Spring, dividido em camadas de controle e serviço. A estrutura do projeto inclui:

UserController: Gerencia as requisições relacionadas aos usuários, implementando métodos para listar, criar, editar, excluir e validar senhas.

UserService: Contém a lógica de negócios relacionada aos usuários, utiliza um repositório para acessar o banco de dados e adota a criptografia de senhas.

Funcionalidades
Listagem de Usuários:

Endpoint GET /usuarios retorna a lista de usuários cadastrados.
Cadastro de Usuário:

Endpoint POST /usuarios recebe dados de usuário e retorna o usuário cadastrado.
Edição de Usuário:

Endpoint PUT /usuarios recebe dados atualizados do usuário e retorna o usuário editado.
Validação de Senha:

Endpoint POST /usuarios/login valida a senha do usuário e retorna status 200 em caso de sucesso ou status 401 em caso de falha.
Exclusão de Usuário:

Endpoint DELETE /usuarios/{id} exclui o usuário com o ID especificado.
Tratamento de Exceções:

O tratamento de exceções para validações é realizado no método lidarComExcecaoDeValidacao.
Fluxo da Aplicação
O usuário preenche o formulário no frontend e clica em "Inscrever-se".
A lógica em JavaScript valida os campos e envia uma requisição POST para o backend.
O backend recebe a requisição, valida os dados e realiza operações necessárias.
O backend responde ao frontend com mensagens indicando sucesso, erro ou validações específicas.
O JavaScript exibe mensagens de feedback ao usuário com base nas respostas recebidas do backend.
Este projeto oferece uma solução integrada para o gerenciamento de usuários, com uma interface amigável no frontend e uma estrutura robusta no backend.
