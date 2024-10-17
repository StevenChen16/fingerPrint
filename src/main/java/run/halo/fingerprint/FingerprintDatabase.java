package run.halo.fingerprint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FingerprintDatabase {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FingerprintDatabase(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveFingerprint(String userId, String fingerprint) {
        String sql = "INSERT INTO fingerprints (user_id, fingerprint) VALUES (?, ?)";
        jdbcTemplate.update(sql, userId, fingerprint);
    }

    public List<String> getFingerprintsForUser(String userId) {
        String sql = "SELECT fingerprint FROM fingerprints WHERE user_id = ?";
        return jdbcTemplate.queryForList(sql, new Object[]{userId}, String.class);
    }
}
