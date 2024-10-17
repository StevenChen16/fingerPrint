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

    @Override
    public void saveFingerprintForUser(String userId, String fingerprint) {
        // Implement logic to save the fingerprint for a user
        // This can be done by updating the user's record in the database
        System.out.println("Fingerprint saved for user: " + userId + " with fingerprint: " + fingerprint);
    }

    public List<FingerprintData> getAll() {
        return fingerprints;
    }
}
