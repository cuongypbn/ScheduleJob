package vn.cmctelecom.scheduler.service.impl;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.cmctelecom.scheduler.repository.SchedulerJobInfoRepository;
import vn.cmctelecom.scheduler.service.ExternalService;

@Service
public class ExternalFactory  {

    @Autowired
    private SchedulerJobInfoRepository schedulerJobInfoRepository;

    public ExternalService getFunction(String tag)
    {
        String target = "localhost:50051";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();

        if (tag == null || tag.isEmpty())
            return null;
        switch (tag) {
            case "REPORT":
                return new ExternalReportServiceImpl();
            case "EMAIL":
                return new ExternalMailServiceImpl(schedulerJobInfoRepository, channel);
            default:
                throw new IllegalArgumentException("Unknown channel "+tag);
        }
    }

}
