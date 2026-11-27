package benakka.decorator;

import benakka.network.Neuron;

import java.util.List;

public abstract class LayerDecorator implements Layer {

    protected Layer layer;

    public LayerDecorator(Layer layer) {
        this.layer = layer;
    }

    @Override
    public void addNeuron(Neuron neuron) {
        layer.addNeuron(neuron);
    }

    @Override
    public List<Neuron> getNeurons() {
        return layer.getNeurons();
    }

    @Override
    public double[] forward(double[] inputs) {
        return layer.forward(inputs);
    }
}