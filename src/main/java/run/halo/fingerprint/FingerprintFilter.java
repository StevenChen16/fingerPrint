package run.halo.fingerprint;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class FingerprintFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(FingerprintFilter.class);
    private final FingerprintRepository fingerprintRepository;

    public FingerprintFilter(FingerprintRepository fingerprintRepository) {
        this.fingerprintRepository = fingerprintRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Check if the user is logged in
        if (isUserLoggedIn(request)) {
            // Extract the browser fingerprint
            String fingerprint = extractFingerprint(request);
            // Log the fingerprint
            logger.info("Visitor fingerprint: {}", fingerprint);
            // Save the fingerprint to the database
            saveFingerprint(fingerprint);
        }
        filterChain.doFilter(request, response);
    }

    private boolean isUserLoggedIn(HttpServletRequest request) {
        // Implement logic to check if the user is logged in
        // This can be done by inspecting the session or authentication context
        return request.getSession().getAttribute("user") != null;
    }

    private String extractFingerprint(HttpServletRequest request) {
        // Implement logic to extract the browser fingerprint from the request
        // This can be done by using a library like FingerprintJS
        return request.getHeader("User-Agent");
    }

    private void saveFingerprint(String fingerprint) {
        // Implement logic to save the fingerprint to the database
        // This can be done by calling the repository method
        fingerprintRepository.saveFingerprintForUser("userId", fingerprint);
    }
}
