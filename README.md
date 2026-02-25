# Projeto de aula - Desenvolvimento WEB

# Banco de dados docker - excutar no terminal
docker run --name meu-postgres -e POSTGRES_USER=admin  -e POSTGRES_PASSWORD=123456 -e POSTGRES_DB=meubanco -p 5432:5432 -d postgres:16

# Ferramentas utilizadas
* Doocker -> Criação e manutenção do banco de dados em container
* Visual Studio code (Extensão - Thunder Client ) -> Testagem da API criada
* STS Spring (Eclise) -> IDE para o desenvolvimento do backend
