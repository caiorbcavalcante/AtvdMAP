public class FreteInternacional implements Strategy {
    private static final double TAXA_IMPORTACAO = 25.0;

    @Override
    public double calcularFrete(double peso) {
        return peso * 12 + TAXA_IMPORTACAO;
    }
}