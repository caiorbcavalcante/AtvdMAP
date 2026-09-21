public class Sedex implements Strategy {
    @Override
    public double calcularFrete(double peso) {
        return peso * 5 + 20;
    }
    
}
