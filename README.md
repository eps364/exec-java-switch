# `Switch` Case em Java

## A Evolução do `switch` em Java

A declaração `switch` em Java tem sido uma ferramenta fundamental para o controle de fluxo, permitindo que os desenvolvedores executem diferentes blocos de código com base no valor de uma variável. No entanto, o `switch` não é estático; ele passou por uma notável evolução ao longo das versões do Java, tornando-se cada vez mais poderoso, conciso e menos propenso a erros. Este artigo explora essa jornada, destacando as principais adições e transformações.

---

### O `switch` Tradicional: A Base Sólida (Java 7 e Anteriores)

Por muitos anos, o `switch` em Java era relativamente limitado em relação aos tipos de dados que podia manipular. Antes do Java 7, ele funcionava exclusivamente com tipos primitivos integrais: `byte`, `short`, `char`, `int`, e seus wrappers, além de tipos `enum`.

A principal característica do `switch` tradicional era a necessidade explícita da declaração `break` ao final de cada `case`. Sem ela, ocorreria o temido "fall-through", onde a execução continuaria para o próximo `case`, independentemente de sua correspondência.

**Características Chave:**

- **Tipos Suportados:** `byte`, `short`, `char`, `int`, e `enum`.
- **`break` Obrigatório:** Essencial para evitar o "fall-through".
- **`default` Opcional:** Captura valores não correspondentes aos `case`s.

**Exemplo de Código:**

Java

```java
public class SwitchTradicional {
    public static void main(String[] args) {
        int mes = 3; // Março
        String nomeDoMes;

        switch (mes) {
            case 1:
                nomeDoMes = "Janeiro";
                break;
            case 2:
                nomeDoMes = "Fevereiro";
                break;
            case 3:
                nomeDoMes = "Março";
                break;
            case 4:
                nomeDoMes = "Abril";
                break;
            default:
                nomeDoMes = "Mês inválido ou não coberto";
                break;
        }
        System.out.println("Mês (Tradicional): " + nomeDoMes);
    }
}

```

---

No Java 7, a capacidade de usar `enum`s com a declaração `switch` já estava presente, tornando o código mais legível e seguro para lidar com conjuntos fixos de constantes.

### `switch` com `enum` em Java 7

Quando você tem um conjunto predefinido de valores, como os dias da semana, os meses do ano ou os status de um pedido, um `enum` é a escolha perfeita. Usar um `enum` em um `switch` não só torna o código mais expressivo, mas também aproveita a segurança de tipo do Java, pois o compilador pode verificar se você cobriu todos os possíveis valores do `enum` (embora não seja uma exigência estrita antes do Pattern Matching, é uma boa prática).

**Características Principais:**

- **Legibilidade:** O código fica mais fácil de entender ao usar nomes significativos de `enum`.
- **Segurança de Tipo:** O compilador pode ajudar a identificar casos não tratados.
- **Performance:** Geralmente eficiente para múltiplas verificações de valores.

**Exemplo de Código:**

Vamos criar um `enum` para representar os níveis de prioridade e então usá-lo em um `switch`.

Java

```java
public class SwitchComEnum {

    // Define um enum para os níveis de prioridade
    public enum Prioridade {
        BAIXA, MEDIA, ALTA, URGENTE
    }

    public static void main(String[] args) {
        Prioridade tarefaPrioridade = Prioridade.ALTA;
        String mensagem;

        switch (tarefaPrioridade) {
            case BAIXA:
                mensagem = "Esta é uma tarefa de baixa prioridade. Pode ser feita quando houver tempo.";
                break;
            case MEDIA:
                mensagem = "Esta é uma tarefa de prioridade média. Deve ser feita em breve.";
                break;
            case ALTA:
                mensagem = "Esta é uma tarefa de alta prioridade! Requer atenção imediata.";
                break;
            case URGENTE:
                mensagem = "Esta é uma tarefa URGENTE! Pare o que estiver fazendo e resolva!";
                break;
            default:
                mensagem = "Prioridade desconhecida.";
                break;
        }

        System.out.println("Status da Tarefa: " + mensagem);
    }
}

```

Neste exemplo, o `enum` `Prioridade` define um conjunto fechado de possíveis prioridades. O `switch` então compara o valor da variável `tarefaPrioridade` (que é do tipo `Prioridade`) com os valores definidos no `enum`, executando o bloco de código correspondente. Observe que, ao usar `enum`s no `switch`, você não precisa qualificar o valor do `enum` com o nome da classe (`Prioridade.BAIXA`), basta usar o nome da constante (`BAIXA`).

### O Salto para Strings: Mais Flexibilidade (Java 7)

Uma das adições mais aguardadas e impactantes veio com o **Java 7**: a capacidade de usar **Strings** nas declarações `switch`. Antes disso, desenvolvedores frequentemente recorriam a longas cadeias de `if-else if` para comparar valores de string, o que podia ser tedioso e propenso a erros.

Com esta atualização, o `switch` tornou-se uma opção muito mais limpa e legível para lidar com múltiplas condições baseadas em strings. É importante notar que as comparações de string são case-sensitive e que passar um `null` para o `switch` ainda resultaria em uma `NullPointerException`.

**Características Chave Adicionadas:**

- **Suporte a `String`:** A principal novidade, permitindo alternar valores textuais.

**Exemplo de Código:**

Java

```java
public class SwitchComString {
    public static void main(String[] args) {
        String comando = "iniciar";
        String acao;

        switch (comando) {
            case "iniciar":
                acao = "O sistema está sendo iniciado.";
                break;
            case "parar":
                acao = "O sistema será parado.";
                break;
            case "reiniciar":
                acao = "Reiniciando o sistema.";
                break;
            default:
                acao = "Comando desconhecido.";
                break;
        }
        System.out.println("Ação (com String): " + acao);
    }
}

```

---

### Expressões `switch`: Um Novo Paradigma (Java 14)

A verdadeira revolução para o `switch` veio com o **Java 14**, que padronizou as **Expressões `switch`** (anteriormente um recurso de pré-visualização no Java 12 e 13). Esta mudança transformou o `switch` de uma *declaração* (que realiza uma ação) para uma *expressão* (que produz um valor).

A sintaxe introduz o operador **`->` (seta)**, que automaticamente previne o "fall-through", eliminando a necessidade de `break`. Para casos mais complexos que exigem várias declarações, você pode usar um bloco `{}` e a palavra-chave **`yield`** para retornar o valor desejado. Além disso, as expressões `switch` são **exaustivas**, exigindo que todos os casos possíveis sejam cobertos (via `case` explícito ou `default`).

**Características Chave Adicionadas:**

- **Retorno de Valor:** O `switch` pode agora retornar um valor diretamente.
- **Operador `>`:** Elimina a necessidade de `break` e previne o fall-through.
- **`yield`:** Usado em blocos `case` para retornar um valor.
- **Exaustividade:** Garante que todos os caminhos de execução sejam tratados.

**Exemplo de Código:**

Java

```java
public class ExpressaoSwitch {
    public static void main(String[] args) {
        int nivel = 2;
        String descricaoNivel = switch (nivel) {
            case 1 -> "Nível Básico"; // Sintaxe concisa com '->'
            case 2, 3 -> { // Múltiplos rótulos e bloco de código
                System.out.println("Processando níveis intermediários...");
                yield "Nível Intermediário"; // Retorna o valor
            }
            case 4, 5 -> "Nível Avançado";
            default -> "Nível Indefinido"; // O 'default' é muitas vezes obrigatório para exaustividade
        };
        System.out.println("Descrição do Nível (Expressão Switch): " + descricaoNivel);
    }
}

```

---

### Pattern Matching para `switch`: O Poder da Desconstrução (Java 21 - Padrão)

A mais recente e talvez a mais poderosa evolução do `switch` é o **Pattern Matching para `switch`**, que se tornou um recurso padrão no **Java 21** (após pré-visualizações no Java 17, 18, 19 e 20). Esta funcionalidade permite não apenas alternar com base no *tipo* de um objeto, mas também "desconstruir" esse objeto para extrair seus componentes, e vincular variáveis diretamente no `case`.

Isso simplifica drasticamente o código que antes exigia encadeamentos de `if-instanceof-cast`. Agora, você pode verificar o tipo, extrair dados e adicionar condições (`when`) tudo em uma única linha do `case`. Além disso, há tratamento explícito para o `null`, tornando o código ainda mais seguro.

**Características Chave Adicionadas:**

- **Padrões de Tipo:** O `case` pode agora verificar o tipo de um objeto e criar uma variável de um tipo específico.
- **Cláusula `when` (Padrões Guardados):** Permite adicionar condições adicionais a um `case` baseado em tipo.
- **`case null`:** Permite lidar explicitamente com valores `null` sem lançar `NullPointerException`.
- **Exaustividade Aprimorada:** O compilador ajuda a garantir que todos os tipos possíveis (ou subconjuntos relevantes) sejam cobertos.

**Exemplo de Código:**

Java

```java
public class SwitchComPatternMatching {

    interface Notificacao {}
    record Email(String destinatario, String assunto, String corpo) implements Notificacao {}
    record SMS(String numero, String mensagem) implements Notificacao {}
    record Push(String dispositivoId, String titulo) implements Notificacao {}

    public static void main(String[] args) {
        Notificacao n1 = new Email("contato@example.com", "Oferta", "Grande promoção!");
        Notificacao n2 = new SMS("99999-8888", "Seu pedido foi enviado.");
        Object obj = "uma string simples";
        Object objNulo = null;

        String resultado1 = switch (n1) {
            case Email e -> "Email para " + e.destinatario() + " com assunto: " + e.assunto();
            case SMS s -> "SMS para " + s.numero() + ": " + s.mensagem();
            case Push p -> "Notificação Push para " + p.dispositivoId();
            // Nenhuma cláusula default necessária aqui se todos os tipos de Notificacao forem cobertos
        };
        System.out.println("Processando Notificação (Pattern Matching): " + resultado1);

        String resultado2 = switch (obj) {
            case Integer i -> "Recebi um número inteiro: " + i;
            case String s when s.length() > 10 -> "Recebi uma string longa: " + s; // Padrão guardado
            case String s -> "Recebi uma string curta: " + s;
            case null -> "O objeto é nulo!"; // Tratamento explícito para null
            default -> "Recebi um tipo desconhecido de objeto.";
        };
        System.out.println("Processando Objeto (Pattern Matching): " + resultado2);

        String resultado3 = switch (objNulo) {
            case String s -> "Isto é uma string: " + s;
            case Integer i -> "Isto é um inteiro: " + i;
            case null -> "Valor nulo explicitamente tratado.";
            default -> "Outro tipo, ou nulo se não houvesse case para nulo.";
        };
        System.out.println("Processando Objeto Nulo (Pattern Matching): " + resultado3);
    }
}

```

---

### Conclusão

A jornada do `switch` em Java é um testemunho do compromisso da linguagem com a evolução e a melhoria contínua da produtividade do desenvolvedor. De uma ferramenta básica e por vezes "frágil" (devido ao fall-through), ele se transformou em uma expressão versátil e poderosa, capaz de lidar com cenários complexos de forma concisa e segura.

Ao escrever código Java moderno, especialmente com as versões mais recentes, é altamente recomendável adotar as **Expressões `switch`** e o **Pattern Matching para `switch`**. Eles não apenas tornam o código mais legível e elegante, mas também reduzem a chance de erros, elevando a qualidade e a manutenibilidade das suas aplicações.

Essa evolução demonstra como o Java continua a se adaptar, fornecendo ferramentas mais robustas para os desafios de programação atuais.

# Fonte

### 1. `switch` Tradicional (com `int`, `enum`) e `switch` com `String` (Java 7)

As especificações para o `switch` que opera com tipos primitivos (como `int`, `char`, `byte`, `short`), `enum`s e, a partir do Java 7, `String`s, podem ser encontradas no capítulo sobre **"Statements" (Declarações)** da JLS da versão correspondente.

- **Java SE 7 (JLS 7):**
    - **Capítulo 14.11. The `switch` Statement:** Este capítulo detalha a sintaxe e a semântica do `switch` statement, incluindo o comportamento de "fall-through" e a necessidade do `break`. A adição de `String` no `switch` foi um refinamento a essa seção.
    - **Link:** Você pode encontrar a JLS 7 aqui: [The Java® Language Specification, Java SE 7 Edition](https://docs.oracle.com/javase/specs/jls/se7/html/jls-14.html%23jls-14.11)
    - **Específicamente para `enum`:** A capacidade de usar `enum`s em `switch` statements é inerente ao tipo `enum` em si, que pode ser convertido para um `int` ordinal internamente pelo compilador para fins de `switch`. A JLS 7 (e anteriores) aborda a validade dos tipos no seletor do `switch`.

---

### 2. Expressões `switch` (Java 14)

As Expressões `switch` foram introduzidas como um "preview feature" no Java 12 e 13, e padronizadas no Java 14. A especificação principal para essa mudança é descrita em uma JEP (Java Enhancement Proposal) e refletida nas seções da JLS que tratam de expressões e declarações.

- **JEP 361: Switch Expressions (Standard)**: Esta JEP detalha a motivação, o design e as mudanças na linguagem para introduzir as expressões `switch` e a nova sintaxe `case L ->`.
    - **Link da JEP:** [JEP 361: Switch Expressions (Standard)](https://openjdk.org/jeps/361)
- **Java Language Specification (JLS) para Java 14 (ou posterior):** As alterações foram integradas ao capítulo sobre "Expressions" (Expressões) e "Statements" (Declarações).
    - **Capítulo 15.28. Switch Expressions:** Detalha a sintaxe e semântica das expressões `switch`.
    - **Capítulo 14.11. The `switch` Statement:** Esta seção foi atualizada para incluir as novas "switch rules" (`case L ->`) que também podem ser usadas em `switch` statements (embora não retornem um valor).
    - **Link (JLS 14 ou posterior):** Você pode consultar a JLS mais recente, que inclui essas especificações: [The Java® Language Specification (última versão)](https://docs.oracle.com/javase/specs/jls/se21/html/jls-14.html%23jls-14.11) (procure pelas seções `14.11` e `15.28` e as referências a `switch rules` e `switch expressions`).

---

### 3. Pattern Matching para `switch` (Java 21 - Padrão)

O Pattern Matching para `switch` passou por várias fases de "preview" (Java 17, 18, 19, 20) antes de ser padronizado no Java 21. A especificação detalhada também é encontrada em uma JEP e, posteriormente, na JLS.

- **JEP 441: Pattern Matching for `switch` (Standard)**: Esta JEP descreve a capacidade de usar padrões nos rótulos `case`, a cláusula `when`, e o tratamento explícito para `null`.
    - **Link da JEP:** [JEP 441: Pattern Matching for switch (Standard)](https://openjdk.org/jeps/441)
- **Java Language Specification (JLS) para Java 21:** As regras de Pattern Matching para `switch` estão integradas no capítulo de "Blocks, Statements, and Patterns".
    - **Capítulo 14.11. The `switch` Statement (e subseções):** Esta seção foi significativamente expandida para cobrir `case` labels com padrões de tipo (`case Type t`), padrões guardados (`when`), e o `case null`.
    - **Link (JLS 21):** [The Java® Language Specification, Java SE 21 Edition](https://docs.oracle.com/javase/specs/jls/se21/html/jls-14.html%23jls-14.11) (procure por "Pattern Matching for switch" e "case patterns").

### 4. Repositório do Git:

Link do respositório no github (https://github.com/eps364/exec-java-switch)