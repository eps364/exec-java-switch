public class SwitchExpressao {
    public static void main(String[] args) {
        int nivel = 2;
        String descricaoNivel = switch (nivel) {
        case 1 -> "Nível Básico";
        case 2, 3 -> {
            System.out.println("Processando níveis intermediários...");
            yield "Nível Intermediário";
        }
        case 4, 5 -> "Nível Avançado";
        default -> "Nível Indefinido";
        };
        System.out.println("Descrição do Nível (Expressão Switch): " + descricaoNivel);
    }
}
