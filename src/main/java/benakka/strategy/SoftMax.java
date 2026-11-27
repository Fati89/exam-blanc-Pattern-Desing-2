package benakka.strategy;

public class SoftMax implements ActivationFunction {

    @Override
    public double activate(double x) {
        return Math.exp(x);
    }
}