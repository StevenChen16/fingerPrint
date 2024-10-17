package run.halo.fingerprint;

public interface FingerprintRepository {
    void save(FingerprintData data);
    void saveFingerprintForUser(String userId, String fingerprint);
}
