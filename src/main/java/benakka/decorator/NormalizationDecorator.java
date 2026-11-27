package benakka.decorator;

public class NormalizationDecorator extends LayerDecorator {

    public NormalizationDecorator(Layer layer) {
        super(layer);
    }

    @Override
    public double[] forward(double[] inputs) {
        System.out.println("Normalisation...");
        double[] outputs = layer.forward(inputs);

        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;

        for (double value : outputs) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        }

        if (max == min) {
            return outputs;
        }

        for (int i = 0; i < outputs.length; i++) {
            outputs[i] = (outputs[i] - min) / (max - min);
        }

        return outputs;
    }
}
