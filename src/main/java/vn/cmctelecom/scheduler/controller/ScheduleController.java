package vn.cmctelecom.scheduler.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.cmctelecom.scheduler.enitiy.ScheduleReq;
import vn.cmctelecom.scheduler.enitiy.SchedulerJobInfo;
import vn.cmctelecom.scheduler.enitiy.response.ResponseData;
import vn.cmctelecom.scheduler.service.SchedulerService;
import vn.cmctelecom.scheduler.util.Result;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final SchedulerService _schedulerService;

    public ScheduleController(SchedulerService schedulerService) {
        this._schedulerService = schedulerService;
    }
    @PostMapping("/startAll")
    public ResponseEntity<ResponseData> onAllCrontab(HttpServletRequest request) {
        try {
            _schedulerService.startAllSchedulers();
            return new ResponseEntity<>(new ResponseData<>(Result.SUCCESS), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseData(Result.SERVER_ERROR), HttpStatus.OK);
        }
    }

    @PostMapping("/stop")
    public ResponseEntity<ResponseData> stopSchedule(@RequestBody ScheduleReq dto) {
        try {
            logger.info("Start call API /api/schedule/stopSchedule | " + dto.toString());
            if (!this._schedulerService.isJobRunning(dto.getJobName(), dto.getJobGroup())) {
                return new ResponseEntity<>(new ResponseData(Result.SCHEDULE_ERR_OFF), HttpStatus.OK);
            }
            if (_schedulerService.stopJob(dto.getJobName(), dto.getJobGroup())) {
                logger.info("End call API /api/schedule/stopSchedule | result success");
                return new ResponseEntity<>(new ResponseData<>(Result.SUCCESS), HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ResponseData(Result.SERVER_ERROR), HttpStatus.OK);
    }

    @PostMapping("/start")
    public ResponseEntity<ResponseData> startSchedule(@RequestBody ScheduleReq dto) {
        try {
            logger.info("Start call API /api/schedule/startSchedule | " + dto.toString());
            if (this._schedulerService.isJobRunning(dto.getJobName(), dto.getJobGroup())) {
                return new ResponseEntity<>(new ResponseData(Result.SCHEDULE_ERR_ONRUNING), HttpStatus.OK);
            }
            if (_schedulerService.startScheduler(dto.getJobName())) {
                logger.info("End call API /api/schedule/startSchedule | result success");
                return new ResponseEntity<>(new ResponseData<>(Result.SUCCESS), HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ResponseData(Result.SERVER_ERROR), HttpStatus.OK);
    }

    @PostMapping("/pause")
    public ResponseEntity<ResponseData> pauseSchedule(@RequestBody ScheduleReq dto) {
        try {
            logger.info("Start call API /api/schedule/pauseSchedule | " + dto.toString());
            if (this._schedulerService.isJobRunning(dto.getJobName(), dto.getJobGroup())) {
                return new ResponseEntity<>(new ResponseData(Result.SCHEDULE_ERR_OFF), HttpStatus.OK);
            }
            if (_schedulerService.pauseJob(dto.getJobName(), dto.getJobGroup())) {
                logger.info("End call API /api/schedule/pauseSchedule | result success");
                return new ResponseEntity<>(new ResponseData<>(Result.SUCCESS), HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ResponseData(Result.SERVER_ERROR), HttpStatus.OK);
    }

    @PostMapping("/resume")
    public ResponseEntity<ResponseData> resumeSchedule(@RequestBody ScheduleReq dto) {
        try {
            logger.info("Start call API /api/schedule/resumeSchedule | " + dto.toString());
            if (!this._schedulerService.isJobRunning(dto.getJobName(), dto.getJobGroup())) {
                return new ResponseEntity<>(new ResponseData(Result.SCHEDULE_ERR_OFF), HttpStatus.OK);
            }
            if (_schedulerService.resumeJob(dto.getJobName(), dto.getJobGroup())) {
                logger.info("End call API /api/schedule/resumeSchedule | result success");
                return new ResponseEntity<>(new ResponseData<>(Result.SUCCESS), HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ResponseData(Result.SERVER_ERROR), HttpStatus.OK);
    }

    @PostMapping("/createJobInfo")
    public ResponseEntity<ResponseData> createSchedulerJobInfo(@RequestBody SchedulerJobInfo jobInfo){
        return _schedulerService.createSchedulerJobInfo(jobInfo);
    }
    @GetMapping("/JobInfo")
    public ResponseEntity<ResponseData> createSchedulerJobInfo(long id){
        return _schedulerService.getJobInfo(id);
    }

}
