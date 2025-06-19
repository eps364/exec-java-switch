public class SwitchComEnum {

    // Define um enum para os níveis de prioridade
    public enum Prioridade {
        BAIXA, MEDIA, ALTA, URGENTE
    }

    public static void main(String[] args) {
        Prioridade tarefaPrioridade = Prioridade.ALTA; // Suponha que temos uma tarefa com prioridade ALTA
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
