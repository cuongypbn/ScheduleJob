package vn.cmctelecom.scheduler.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.cmctelecom.scheduler.enitiy.SchedulerJobInfo;
import vn.cmctelecom.scheduler.enitiy.response.ResponseData;
import vn.cmctelecom.scheduler.repository.ParameterJobRepository;
import vn.cmctelecom.scheduler.repository.SchedulerJobInfoRepository;
import vn.cmctelecom.scheduler.service.ExternalService;

@Service
public class ExternalReportServiceImpl implements ExternalService {

    @Autowired
    private  SchedulerJobInfoRepository schedulerJobInfoRepository;
    @Autowired
    private  ParameterJobRepository parameterJobRepository;

    @Override
    public ResponseEntity<ResponseData> restfulApi(SchedulerJobInfo jobInfo) {
        return null;
    }

    @Override
    public String grpcFunction(SchedulerJobInfo jobInfo) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseData> detectMail() {
        return null;
    }
}
