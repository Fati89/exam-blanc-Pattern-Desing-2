package benakka.network;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {

    private List<Layer> layers;

    public NeuralNetwork() {
        layers = new ArrayList<>();
    }

    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    public double[] predict() {

        double[] result = null;

        for (int i = 0; i < layers.size(); i++) {

            Layer layer = layers.get(i);

            if (i == 0) {
                result = new double[layer.getNeurons().size()];

                for (int j = 0; j < layer.getNeurons().size(); j++) {
                    result[j] = layer.getNeurons().get(j).getOutput();
                }

            } else {
                result = layer.forward(result);
            }
        }

        return result;
    }
}
