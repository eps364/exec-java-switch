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
            default -> "Tipo de notificação desconhecido.";
        };
        System.out.println("Processando Notificação (Pattern Matching): " + resultado1);

        String resultado2 = switch (obj) {
            case Integer i -> "Recebi um número inteiro: " + i;
            case String s when s.length() > 10 -> "Recebi uma string longa: " + s; 
            case String s -> "Recebi uma string curta: " + s;
            case null -> "O objeto é nulo!"; 
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
