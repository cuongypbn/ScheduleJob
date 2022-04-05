package vn.cmctelecom.scheduler.service.impl;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import vn.cmctelecom.scheduler.enitiy.response.ResponseData;
import vn.cmctelecom.scheduler.repository.ParameterJobRepository;
import vn.cmctelecom.scheduler.service.ParameterJobService;

public class ParameterJobServiceImpl implements ParameterJobService {
    @Autowired
    private Gson gson;

    @Autowired
    private ParameterJobRepository parameterJobRepository;

    @Override
    public ResponseEntity<ResponseData> createParameter() {
        return null;
    }

    @Override
    public ResponseEntity<ResponseData> deleteParameter() {
        return null;
    }

    @Override
    public ResponseEntity<ResponseData> updateParameter() {
        return null;
    }
}
