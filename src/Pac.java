public class Pac implements Strategy{
    @Override 
    public double calcularFrete(double peso) {
        return peso * 2 + 10;
    }
    
}
