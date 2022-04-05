
package vn.cmctelecom.scheduler.enitiy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * TODO: write you class description here
 *
 * @author
 */

@Entity
@Table(name = "SCHEDULER_JOB_INFO")
@NoArgsConstructor
@AllArgsConstructor
public class SchedulerJobInfo implements Serializable {
	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="JOB_INFO_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCHEDULER_JOB_INFO_SEQ")
    @SequenceGenerator(sequenceName = "SCHEDULER_JOB_INFO_SEQ", allocationSize = 1, name = "SCHEDULER_JOB_INFO_SEQ")
    private Long id;

    @Column(name = "JOB_NAME",nullable = false, unique = true)
    private String jobName;

    @Column(name = "JOB_FULL_NAME")
    private String jobFullName;

    @Column(name = "JOB_Host", nullable = false)
    private String jobHost;

    @Column(name = "JOB_PATH", nullable = false)
    private String jobPath;

    @Column(name = "METHOD", nullable = false)
    private String method;

    @Column(name = "JOB_GROUP",nullable = false)
    private String jobGroup;

    @Column(name = "CRON_EXPRESSION",nullable = false)
    private String cronExpression;

    @Column(name = "REPEAT_TIME")
    private Long repeatTime;

    @Column(name = "CRON_JOB",nullable = false)
    private Boolean cronJob;

    @Column(name = "TYPE_SYN",nullable = false)
    private String typeSyn;

    @Column(name = "MONTH")
    private Long month;

    @Column(name = "YEAR")
    private Long year;

    @Column(name = "HOUR")
    private Long hour;

    @Column(name = "MINUTE")
    private Long minute;

    @Column(name = "SECOND")
    private Long second;

    @Column(name = "WEEK_DAY")
    private String weekDay;

    @Column(name = "MONTH_DAY")
    private String monthDay;

    @Column(name = "SCHEDULE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduleTime;

    @Column(name = "FLAG",nullable = false)
    private Integer flag;

    @Column(name = "CREATE_DATE")
    private Date  createDate ;

    @Column(name = "MODIFIED_DATE")
    private Date  modifiedDate ;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "jobInfo", fetch = FetchType.EAGER)
    private Set<ParameterJob> parameterJobList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobFullName() {
        return jobFullName;
    }

    public void setJobFullName(String jobFullName) {
        this.jobFullName = jobFullName;
    }

    public String getJobPath() {
        return jobPath;
    }

    public void setJobPath(String jobPath) {
        this.jobPath = jobPath;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public Long getRepeatTime() {
        return repeatTime;
    }

    public void setRepeatTime(Long repeatTime) {
        this.repeatTime = repeatTime;
    }

    public Boolean getCronJob() {
        return cronJob;
    }

    public void setCronJob(Boolean cronJob) {
        this.cronJob = cronJob;
    }

    public String getTypeSyn() {
        return typeSyn;
    }

    public void setTypeSyn(String typeSyn) {
        this.typeSyn = typeSyn;
    }

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long month) {
        this.month = month;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getHour() {
        return hour;
    }

    public void setHour(Long hour) {
        this.hour = hour;
    }

    public Long getMinute() {
        return minute;
    }

    public void setMinute(Long minute) {
        this.minute = minute;
    }

    public Long getSecond() {
        return second;
    }

    public void setSecond(Long second) {
        this.second = second;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(String monthDay) {
        this.monthDay = monthDay;
    }

    public Date getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Set<ParameterJob> getParameterJobList() {
        return parameterJobList;
    }

    public void setParameterJobList(Set<ParameterJob> parameterJobList) {
        this.parameterJobList = parameterJobList;
        for (ParameterJob parameterJob : parameterJobList){
            parameterJob.setJobInfo(this);
        }
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getJobHost() {
        return jobHost;
    }

    public void setJobHost(String jobHost) {
        this.jobHost = jobHost;
    }
}
