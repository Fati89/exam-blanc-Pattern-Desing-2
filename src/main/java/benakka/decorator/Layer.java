package benakka.decorator;

import benakka.network.Neuron;

import java.util.List;

public interface Layer {
    void addNeuron(Neuron neuron);
    List<Neuron> getNeurons();
    double[] forward(double[] inputs);
}
