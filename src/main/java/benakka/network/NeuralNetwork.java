package benakka.network;

import benakka.enums.NetworkStatus;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {

    private List<Layer> layers;
    private NetworkStatus status = NetworkStatus.CONSTRUCTION;

    public NeuralNetwork() {
        layers = new ArrayList<>();
    }

    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    public void train() {
        if (status == NetworkStatus.CONSTRUCTION) {
            status = NetworkStatus.TRAINING;
            System.out.println("Opération d'entraînement");
            status = NetworkStatus.TRAINED;
        }
    }

    public void fit() {
        if (status == NetworkStatus.CONSTRUCTION) {
            System.out.println("Préparation du réseau à l'exécution");
            status = NetworkStatus.TRAINED;
        }
    }

    public NetworkStatus getStatus() {
        return status;
    }

    public double[] predict() {
        if (status == NetworkStatus.TRAINED) {
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
        } else {
            System.out.println("Network is not trained");
            return null;
        }
    }
}
