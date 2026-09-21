public class TransportadoraExpressa implements Strategy{
    @Override
    public double calcularFrete(double peso) {
        return peso * 3 + 15;
    }
    
}
