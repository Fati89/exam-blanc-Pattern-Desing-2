package benakka.network;

import benakka.Main;

public class Connection {

    private double weight;
    private Neuron source;
    private Neuron destination;

    public Connection(double weight, Neuron source, Neuron destination) {
        if(weight>=0 && weight<=1) this.weight = weight;
        else {
            System.out.println("Le poid doit etre compris entre 0 et 1 \n on va vous affecter une valeur avec random");
            this.weight = Math.random();
        }
        this.source = source;
        this.destination = destination;
        destination.addConnection(this);
    }

    public double transmit() {
        return source.getOutput() * weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Neuron getSource() {
        return source;
    }

    public Neuron getDestination() {
        return destination;
    }
}