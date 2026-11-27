package benakka.network;

import java.util.ArrayList;
import java.util.List;

public class Layer {

    protected List<Neuron> neurons;

    public Layer() {
        neurons = new ArrayList<>();
    }

    public void addNeuron(Neuron neuron) {
        neurons.add(neuron);
    }

    public List<Neuron> getNeurons() {
        return neurons;
    }

    public double[] forward(double[] inputs) {

        double[] outputs = new double[neurons.size()];

        for (int i = 0; i < neurons.size(); i++) {
            outputs[i] = neurons.get(i).calculate();
        }

        return outputs;
    }
}
