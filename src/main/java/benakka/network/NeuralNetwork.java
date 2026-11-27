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

    public double[] predict(double[] input) {

        double[] result = input;

        for (Layer layer : layers) {
            result = layer.forward(result);
        }

        return result;
    }
}
