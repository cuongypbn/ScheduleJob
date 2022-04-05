package vn.cmctelecom.scheduler.service;

import org.springframework.http.ResponseEntity;
import vn.cmctelecom.scheduler.enitiy.SchedulerJobInfo;
import vn.cmctelecom.scheduler.enitiy.response.ResponseData;

public interface ExternalService {
    ResponseEntity<ResponseData> restfulApi(SchedulerJobInfo jobInfo);
    String grpcFunction(SchedulerJobInfo jobInfo);
    ResponseEntity<ResponseData> detectMail();
}
