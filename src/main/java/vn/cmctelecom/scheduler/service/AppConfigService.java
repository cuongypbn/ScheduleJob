package vn.cmctelecom.scheduler.service;

import org.springframework.http.ResponseEntity;
import vn.cmctelecom.scheduler.enitiy.response.ResponseData;

public interface AppConfigService {
    ResponseEntity<ResponseData> createApp();
    ResponseEntity<ResponseData> deleteApp();
    ResponseEntity<ResponseData> updateApp();

}
