package benakka.adapter;

import benakka.strategy.ActivationFunction;

public class ActivationAdapter implements ActivationFunction {

    private OldActivationFunction oldFunction;

    public ActivationAdapter(OldActivationFunction oldFunction) {
        this.oldFunction = oldFunction;
    }

    @Override
    public double activate(double x) {
        System.out.println("Adapting oldSigmoid to activationFunction...");
        return oldFunction.calculate(x);
    }
}
