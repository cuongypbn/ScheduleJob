package vn.cmctelecom.scheduler.service.impl;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import vn.cmctelecom.scheduler.enitiy.AppConfig;
import vn.cmctelecom.scheduler.enitiy.response.ResponseData;
import vn.cmctelecom.scheduler.repository.AppConfigRepository;
import vn.cmctelecom.scheduler.service.AppConfigService;

public class AppConfigServiceImpl implements AppConfigService {
    @Autowired
    private Gson gson;

    @Autowired
    private AppConfigRepository appConfigRepository;

    @Override
    public ResponseEntity<ResponseData> createApp() {
        return null;
    }

    @Override
    public ResponseEntity<ResponseData> deleteApp() {
        return null;
    }

    @Override
    public ResponseEntity<ResponseData> updateApp() {
        return null;
    }
}
