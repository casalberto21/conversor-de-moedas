                     # Conversor de Moedas - Challenge Java Alura

## Descrição
Projeto de conversor de moedas em Java que utiliza a API ExchangeRate para obter taxas de câmbio atualizadas.

## Funcionalidades
- Consulta de taxas de câmbio entre moedas.
- Conversão de valores entre moedas.
- Suporte para uso da API remota com chave API segura.
- Opção para usar dados locais (arquivo JSON) para evitar chamadas à API externa.

## Como usar

### Configuração da API Key
A chave da API deve ser configurada como variável de ambiente para garantir segurança.

No IntelliJ IDEA:
1. Clique com o botão direito na classe principal (`ExchangeApiClient.java`).
2. Selecione "Edit Run Configurations...".
3. Na aba "Configuration", encontre o campo "Environment variables".
4. Clique no ícone `...` ao lado.
5. Clique em `+` para adicionar uma nova variável.
6. Em Name, coloque: `API_KEY`
7. Em Value, coloque sua chave da API (exemplo: `7699eda5811632b3744615c6`)
8. Confirme e salve.

### Executar o projeto
Rode a classe principal normalmente. O programa irá buscar as taxas pela API usando a chave configurada.

### Uso da API local (opcional)
Se preferir, você pode usar um arquivo local JSON para simular a resposta da API e evitar chamadas externas.

---

## Estrutura do projeto
- `src/` : código fonte em Java
- `out/` : arquivos compilados
- `README.md` : documentação do projeto

---

## git clone https://github.com/seuusuario/conversor-moedas.git
Importe o projeto no IntelliJ.
Adicione sua API_KEY como variável de ambiente.
Rode a classe com o método main().
