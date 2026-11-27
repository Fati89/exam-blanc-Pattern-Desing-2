package benakka.observer;

import benakka.enums.NetworkStatus;

public class Dashboard implements NetworkObserver {

    @Override
    public void update(NetworkStatus status) {
        System.out.println("Dashboard : nouvel état du réseau = " + status);
    }
}
