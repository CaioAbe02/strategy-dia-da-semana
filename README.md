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
2. Qual padrão de projeto pode ser utilizado para representar a ausência de uma estratégia de
forma segura?
3. Explique brevemente como esse padrão seria incorporado à solução.