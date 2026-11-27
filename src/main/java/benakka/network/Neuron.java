package benakka.network;

import benakka.strategy.ActivationFunction;

import java.util.ArrayList;
import java.util.List;

public class Neuron {

    private double bias;
    private double output;

    public void setActivationFunction(ActivationFunction activationFunction) {
        System.out.println("change activation de "+this.activationFunction.getClass().getName()+" à "+activationFunction.getClass().getName());
        this.activationFunction = activationFunction;
    }

    private ActivationFunction activationFunction;
    private List<Connection> connections = new ArrayList<>();

    public Neuron(double bias, ActivationFunction activationFunction) {
        this.bias = bias;
        this.activationFunction = activationFunction;
    }

    public Neuron(double bias, ActivationFunction activationFunction, double output) {
        this.bias = bias;
        this.activationFunction = activationFunction;
        this.output = output;
    }

    public void addConnection(Connection connection) {
        connections.add(connection);
    }

    public double calculate() {
        double S = 0;

        for (Connection c : connections) {
            S += c.transmit();
        }
        S += bias;

        output = activationFunction.activate(S);
        return output;
    }

    public double getOutput() {
        return output;
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }
}
