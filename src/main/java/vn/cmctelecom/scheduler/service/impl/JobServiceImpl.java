package vn.cmctelecom.scheduler.service.impl;

import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;
import vn.cmctelecom.scheduler.enitiy.SchedulerJobInfo;
import vn.cmctelecom.scheduler.enitiy.response.ResponseData;
import vn.cmctelecom.scheduler.repository.SchedulerJobInfoRepository;
import vn.cmctelecom.scheduler.service.ExternalService;

@Service
public class JobServiceImpl extends QuartzJobBean {
    @Autowired
    private  SchedulerJobInfoRepository schedulerRepository;
    public JobServiceImpl(SchedulerJobInfoRepository schedulerRepository) {
        this.schedulerRepository = schedulerRepository;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) {
        System.out.println(context.getJobDetail().getKey().getName());
       SchedulerJobInfo jobInfo = schedulerRepository.findByJobName(context.getJobDetail().getKey().getName());
        ExternalFactory externalFactory = new ExternalFactory();
        ExternalService externalService= externalFactory.getFunction("EMAIL");
        ResponseEntity<ResponseData> response = externalService.restfulApi(jobInfo);
        System.out.println(response);
    }

}
