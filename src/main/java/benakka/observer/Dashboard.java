package benakka.observer;

import benakka.aspects.Log;
import benakka.aspects.SecuredByAsppect;
import benakka.enums.NetworkStatus;
import org.springframework.stereotype.Component;

@Component
public class Dashboard implements NetworkObserver {

    @Override
    @Log
    @SecuredByAsppect(roles = {"ADMIN"})
    public void update(NetworkStatus status) {
        System.out.println("Dashboard : nouvel état du réseau = " + status);
    }
}
