package vn.cmctelecom.scheduler.service;

/**
 * @author cuong.nv5
 * configuration external service
 */
public interface ApiConfiguration {
    static final String API_BASE_URL = "https://iam-api-dev-rnd.cmctelecom.vn/auth/realms/";
    static final String API_VERSION_SPEC = "application/vnd.github.v3+json";
    static final String JSON_CONTENT_TYPE = "application/json";
    static final String REALMS = "ctel-universe/";
}
