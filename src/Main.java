public class Main {
    public static void main(String[] args) {
        double peso = 10.0;

        Pedido pedido = new Pedido(new Sedex());
        System.out.printf("Sedex: R$ %.2f%n", pedido.calcularFrete(peso));

        pedido.setStrategy(new Pac());
        System.out.printf("PAC: R$ %.2f%n", pedido.calcularFrete(peso));

        pedido.setStrategy(new RetiradaNaLoja());
        System.out.printf("Retirada na loja: R$ %.2f%n", pedido.calcularFrete(peso));

        pedido.setStrategy(new TransportadoraExpressa());
        System.out.printf("Transportadora expressa: R$ %.2f%n", pedido.calcularFrete(peso));

        pedido.setStrategy(new FreteInternacional());
        System.out.printf("Frete internacional: R$ %.2f%n", pedido.calcularFrete(peso));
    }
}