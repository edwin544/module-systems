package service.provider;
import internal.ServiceKey;

public class ServiceProvider {
    public ServiceProvider() {
    }

    public String requestKey() {
        var secretKey = new ServiceKey();
        return secretKey.getKey();
    }
}
