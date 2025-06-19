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
