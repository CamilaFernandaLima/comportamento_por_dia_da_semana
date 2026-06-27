# Comportamento por Dia da Semana

Programa que identifica o dia da semana e delega a execução de uma ação para uma estratégia específica.


## Instruções de execução

### Pré-requisitos
- Java 11 ou superior instalado

### Compilar

```bash
javac -encoding UTF-8 *.java
```

### Executar

```bash
java -Dstdout.encoding=UTF-8 Main
```

## Exemplos de execução - respostas esperadas:

**Exemplo 1 - Entrada válida: quarta-feira**
```
> Simulação 1: dia válido
Usuário: Ana
Dia consultado: quarta-feira
Prioridade: MÉDIA
Mensagem: Dia de revisão: verifique o andamento da atividade "Implementar relatório".
```

**Exemplo 2 - entrada inválida: dia inexistente**
```
> Simulação 2: dia inválido
Usuário: Ana
Dia consultado: feriado
Prioridade: INDEFINIDA
Mensagem: Dia inválido ou sem estratégia associada. Nenhuma ação foi executada.
```

---

## Estrutura das estratégias

O projeto tem a seguinte estrutura:

```
DiaStrategy.java ← Interface Strategy: contrato de executar() e getPrioridade()
[SegundaStrategy.java - DomingoStrategy.java] ← Estratégias concretas — uma para cada dia da semana 
TercaStrategy.java ← Estratégia concreta — terça-feira  (ALTA)
QuartaStrategy.java ← Estratégia concreta — quarta-feira (MÉDIA)
QuintaStrategy.java ← Estratégia concreta — quinta-feira (MÉDIA)
SextaStrategy.java ← Estratégia concreta — sexta-feira  (MÉDIA)
SabadoStrategy.java ← Estratégia concreta — sábado       (BAIXA)
DomingoStrategy.java ← Estratégia concreta — domingo      (BAIXA)
NullDiaStrategy.java ← Null Object: estratégia segura para dia inválido/ausente
DiaStrategyFactory.java ← Factory Method: cria a estratégia correta pelo nome do dia
Main.java ← Ponto de entrada, executa as simulações
```
### observação: 
As prioridades das tarefas dependem dos seus dias de execução, e seguem o padrão: 
- segunda e terça: ALTA
- quarta, quinta e sexta: MÉDIA
- sábado e domingo: BAIXA

### Padrões utilizados

| Padrão             | Onde é aplicado                | Papel na solução                                          |
|--------------------|--------------------------------|-----------------------------------------------------------|
| **Strategy**       | `DiaStrategy` + implementações | Define contrato e encapsula comportamento por dia         |
| **Factory Method** | `DiaStrategyFactory`           | Centraliza a criação da estratégia pelo nome do dia       |
| **Null Object**    | `NullDiaStrategy`              | Ausência de estratégia sem lançar exceção                 |

---

## Questões de reflexão

### 1. Como evitar verificações repetidas de valores nulos no código principal?

Centralizando a criação das estratégias na `DiaStrategyFactory`, que **nunca retorna `null`**.
Quando o dia informado não tem estratégia mapeada, a factory retorna uma instância de `NullDiaStrategy`, que implementa a mesma interface `DiaStrategy`. Assim, o código simplesmente chama `strategy.executar(...)` sem nenhuma verificação de nulo, pois sempre recebe um objeto válido.

### 2. Qual padrão de projeto pode ser utilizado para representar a ausência de uma estratégia de forma segura?

O padrão **Null Object**. Em vez de retornar `null` quando não existe uma estratégia para o dia, retorna-se um objeto que implementa a mesma interface, mas cujo comportamento é neutro e seguro (não lança exceção, não interrompe o fluxo, somente informa o usuário sobre a falha de forma controlada).

### 3. Explique brevemente como esse padrão seria incorporado à solução.

Na verdade, ele basicamente foi implementado. Nesse projeto, a classe `NullDiaStrategy` implementa `DiaStrategy` normalmente, com `executar()` exibindo uma mensagem informativa e `getPrioridade()` retornando `"INDEFINIDA"`. Assim, `DiaStrategyFactory` verifica se o mapa de estratégias contém o dia solicitado e, dependendo da resposta, executa um tipo de ação (se sim, retorna a estratégia concreta; se não, retorna `new NullDiaStrategy(dia)`). Dessa forma, o cliente nunca precisa tratar ausência de estratégia, já que o Null Object absorve o caso sem propagar erros.