public class Pedido {
    private Strategy strategy;

    public Pedido(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public double calcularFrete(double peso) {
        return strategy.calcularFrete(peso);
    }
}