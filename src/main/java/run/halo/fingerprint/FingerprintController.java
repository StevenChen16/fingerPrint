package run.halo.fingerprint;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

// Data model for storing fingerprint info
class FingerprintData {
    private String visitorId;
    private LocalDateTime timestamp;

    public FingerprintData(String visitorId) {
        this.visitorId = visitorId;
        this.timestamp = LocalDateTime.now();
    }

    public String getVisitorId() {
        return visitorId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

// Repository interface for saving fingerprints
interface FingerprintRepository {
    void save(FingerprintData data);
}

@RestController
public class FingerprintController {

    @Autowired
    private FingerprintRepository repository;
}
