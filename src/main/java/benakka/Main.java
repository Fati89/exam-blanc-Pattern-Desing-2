package benakka;

import benakka.network.Connection;
import benakka.network.Layer;
import benakka.network.NeuralNetwork;
import benakka.network.Neuron;
import benakka.strategy.ActivationFunction;
import benakka.strategy.Identity;
import benakka.strategy.Sigmoid;
import benakka.strategy.SoftMax;

import java.util.Arrays;

public class Main {
    static void main() {
        NeuralNetwork neuralNetwork = new NeuralNetwork();

        ActivationFunction sgmoid = new Sigmoid();
        ActivationFunction softmax = new SoftMax();
        ActivationFunction identity = new Identity();

        Neuron ni1 = new Neuron(1, identity, 2);
        Neuron ni2 = new Neuron(1, identity, 3);
        Neuron nh1 = new Neuron(0, identity);
        Neuron nh2 = new Neuron(0, identity);
        Neuron no1 = new Neuron(1, identity);
        // startegy changer dynamiquement la startegy d'activation
        no1.setActivationFunction(softmax);

        Connection c11 = new Connection(0.2, ni1, nh1);
        Connection c12 = new Connection(0.3, ni1, nh2);
        Connection c21 = new Connection(0.4, ni2, nh1);
        Connection c22 = new Connection(0.5, ni2, nh2);
        Connection c3 = new Connection(0.6, nh1, no1);
        Connection c4 = new Connection(0.5, nh2, no1);

        Layer input = new Layer();
        input.addNeuron(ni1);
        input.addNeuron(ni2);
        Layer hidden = new Layer();
        hidden.addNeuron(nh1);
        hidden.addNeuron(nh2);
        Layer output = new Layer();
        output.addNeuron(no1);

        neuralNetwork.addLayer(input);
        neuralNetwork.addLayer(hidden);
        neuralNetwork.addLayer(output);

        System.out.println(Arrays.toString(neuralNetwork.predict()));

    }
}
