# Contextualização

Implementação de um programa orientado a objeto que identifica o dia atual da semana ou um dia informado manualmente e delega a execução de uma ação para uma estratégia específica.

# Instruções de execução

No terminal, digite

```bash
git clone https://github.com/CaioAbe02/strategy-dia-da-semana.git
cd strategy-dia-da-semana
```

Depois, digite

```bash
javac main.java
java Main
```

O programa solicitará um dígito (1 ou 2) para saber se o usuário deseja usar a data atual ou informar um dia, respectivamente. Faça a sua escolha. Caso seja o número 1, a saída será exibida imediatamente. Caso seja o número 2, a aplicação solicitará o dia da semana e, após digitar e apertar Enter, a saída será exibida.

# Estrutura das estratégias

A solução é composta por:

1 - Interface StrategyDia

Define o contrato que todas as estratégias devem seguir:

- String executar(String info) –> executa a ação específica do dia, recebendo uma informação adicional.

- String prioridade() – retorna a prioridade do dia (ALTA, MÉDIA, BAIXA ou INDEFINIDA).

2 - Estratégias concretas

- Cada dia da semana possui sua própria classe que implementa StrategyDia.
  - SegundaFeira – retorna "Organize suas prioridades: " + a informação adicional, prioridade ALTA.

  - Sabado – retorna "Realize estudo livre ou descanse. " + a informação, prioridade MÉDIA.

  - Domingo – retorna "Planeje a próxima semana. " + a informação, prioridade BAIXA.

As demais classes (TercaFeira, QuartaFeira, QuintaFeira, SextaFeira) seguem o mesmo padrão, cada uma com sua mensagem e prioridade.

3 - Estratégia Ausente (StrategyAusente)

Implementa a mesma interface e é usada quando o dia consultado não possui uma estratégia definida (ex.: dia inexistente). Sua mensagem informa que não há estratégia para aquele dia e sua prioridade é "INDEFINIDA". Essa classe evita que o programa retorne null e elimina a necessidade de verificações nulas no código principal.

4 - Catálogo de estratégias (Catalogo)

Centraliza o mapeamento entre o nome do dia e a estratégia correspondente. Utiliza um Map<String, StrategyDia> e o método getEstrategia(String dia) que:

- Procura a chave no mapa. Se encontrada, retorna a estratégia daquele dia. Se não encontrada, retorna uma instância de StrategyAusente (via getOrDefault).

5 - Classe Main

Obtém a data atual ou lê o dia informado pelo usuário, normaliza a string (remove acentos para garantir correspondência com as chaves do mapa), solicita a informação adicional e, por fim, delega a execução para a estratégia obtida do catálogo.

# Exemplos de saída

## Entrada válida

1 - Usar data atual  
2 - Informar um dia  
Escolha: 1  
Dia consultado: sabado  
Prioridade: MÉDIA  
Mensagem: Realize estudo livre ou descanse. Relatório final do projeto, limpar aquário e responder e-mails pendentes.

## Entrada inválida

1 - Usar data atual  
2 - Informar um dia  
Escolha: 2  
Digite um dia da semana: feriado  
Dia consultado: feriado  
Prioridade: INDEFINIDA  
Mensagem: Nenhuma estratégia definida para o dia: feriado

# Questões de reflexão

Considere que, em determinado momento, uma estratégia não tenha sido definida ou que não
exista uma estratégia associada ao dia informado.

1. Como evitar verificações repetidas de valores nulos no código principal?

Em vez de retornar null quando nenhuma estratégia é encontrada, retornamos um objeto que implementa a mesma interface (StrategyDia) e que fornece um comportamento neutro (mensagem de “não definido” e prioridade INDEFINIDA). Assim, o código principal nunca precisa testar if (estrategia == null), pois sempre haverá uma estratégia disponível para executar os métodos.

2. Qual padrão de projeto pode ser utilizado para representar a ausência de uma estratégia de
   forma segura?

   Null Object Pattern (Objeto Nulo). Ele fornece um substituto para a ausência de um objeto, implementando a mesma interface e definindo operações que não produzem efeitos colaterais ou que geram uma resposta padrão.

3. Explique brevemente como esse padrão seria incorporado à solução.

   No código, a incorporação é feita da seguinte forma:

- Criamos a classe StrategyAusente que implementa StrategyDia.

- No método executar, ela retorna uma mensagem informando que o dia não tem estratégia.

- No método prioridade, retorna "INDEFINIDA".

- No Catalogo, em vez de retornar null quando o dia não é encontrado, usamos Map.getOrDefault para retornar uma instância de StrategyAusente (passando o nome do dia para a mensagem).

- Essa abordagem elimina qualquer necessidade de verificação nula no main e garante que o programa sempre terá um comportamento definido, mesmo para entradas inválidas.
