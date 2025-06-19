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
