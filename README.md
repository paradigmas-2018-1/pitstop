
## Descrição

O _Pitstop_ é a representação de um pitstop de uma equipe de fórmula 1, de
maneira simplificada, em um **Sistema Multiagentes** (SMA) construído com o
framework **JADE** (Java Agent DEvelopment Framework).

## Como executar

O programa pode ser executado normalmente pela IDE _Eclipse_, desde que sejam
adicionados os seguintes argumentos na sua **configuração de execução**.

**Main Class**

```jade.Boot```

**Program Arguments**

```
-gui
carAgent:Car.CarAgent;lollipopAgent:Lollipop.LollipopAgent;tyreCarrier:TyreCarrier.TyreCarrierAgent;tyreChanger:TyreChanger.TyreChangerAgent
```

Também é necessário atualizar o **build path** do projeto, corrigindo os
caminhos para os pacotes *.jar* utilizados pelo JADE.

## Autores

Roger Lenke - Universidade de Brasília (UnB), FGA
