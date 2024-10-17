package run.halo.fingerprint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FingerprintService {

    private final FingerprintDatabase fingerprintDatabase;

    @Autowired
    public FingerprintService(FingerprintDatabase fingerprintDatabase) {
        this.fingerprintDatabase = fingerprintDatabase;
    }

    public void saveFingerprint(String userId, String fingerprint) {
        fingerprintDatabase.saveFingerprint(userId, fingerprint);
        logFingerprintEntry(userId, fingerprint);
    }

    public List<String> getFingerprintsForUser(String userId) {
        return fingerprintDatabase.getFingerprintsForUser(userId);
    }

    private void logFingerprintEntry(String userId, String fingerprint) {
        // Implement logging functionality to record each fingerprint entry in the database
        System.out.println("Fingerprint entry logged for user: " + userId + " with fingerprint: " + fingerprint);
    }
}
