package benakka.observer;

import benakka.enums.NetworkStatus;

public interface NetworkObserver {
    void update(NetworkStatus status);
}