package benakka.network;

import benakka.decorator.Layer;

import java.util.ArrayList;
import java.util.List;

public class BasicLayer implements Layer {

    protected List<Neuron> neurons;

    public BasicLayer() {
        neurons = new ArrayList<>();
    }

    @Override
    public void addNeuron(Neuron neuron) {
        neurons.add(neuron);
    }

    @Override
    public List<Neuron> getNeurons() {
        return neurons;
    }

    @Override
    public double[] forward(double[] inputs) {

        double[] outputs = new double[neurons.size()];

        for (int i = 0; i < neurons.size(); i++) {
            outputs[i] = neurons.get(i).calculate();
        }

        return outputs;
    }
}
