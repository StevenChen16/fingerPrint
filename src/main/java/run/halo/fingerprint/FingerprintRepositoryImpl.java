package run.halo.fingerprint;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class FingerprintRepositoryImpl implements FingerprintRepository {

    private final List<FingerprintData> fingerprints = new ArrayList<>();

    @Override
    public void save(FingerprintData data) {
        fingerprints.add(data);
        System.out.println("Fingerprint saved: " + data.getVisitorId() + " at " + data.getTimestamp());
    }

    public List<FingerprintData> getAll() {
        return fingerprints;
    }
}
