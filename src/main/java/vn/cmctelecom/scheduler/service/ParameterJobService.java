package vn.cmctelecom.scheduler.service;

import org.springframework.http.ResponseEntity;
import vn.cmctelecom.scheduler.enitiy.response.ResponseData;

public interface ParameterJobService {
    ResponseEntity<ResponseData> createParameter();
    ResponseEntity<ResponseData> deleteParameter();
    ResponseEntity<ResponseData> updateParameter();
}
