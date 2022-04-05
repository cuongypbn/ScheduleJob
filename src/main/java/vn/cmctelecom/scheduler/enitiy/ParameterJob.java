package vn.cmctelecom.scheduler.enitiy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PARAMETER_JOB")
public class ParameterJob implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARAMETER_JOB_INFO_SEQ")
    @SequenceGenerator(sequenceName = "PARAMETER_JOB_INFO_SEQ", allocationSize = 1, name = "PARAMETER_JOB_INFO_SEQ")
    private Long id;

    @Column(name = "PARAMETER_NAME", nullable = false)
    private String parameterName;

    @Column(name = "PARAMETER_VALUE", nullable = false)
    private String parameterValue;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "APP_CONFIG_ID", referencedColumnName = "id")
    private AppConfig appConfig;

    @Column(name = "USER_NAME")
    private String userName  ;

    @Column(name = "STATUS", nullable = false)
    private boolean status;

    @Column(name = "CREATE_DATE")
    private Date  createDate ;

    @Column(name = "MODIFIED_DATE")
    private Date  modifiedDate ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "JOB_INFO_ID" ,name = "JOB_INFO_ID")
    private SchedulerJobInfo jobInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }
    public SchedulerJobInfo getJobInfo() {
        return jobInfo;
    }

    public void setJobInfo(SchedulerJobInfo jobInfo) {
        this.jobInfo = jobInfo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public AppConfig getAppConfig() {
        return appConfig;
    }

    public void setAppConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
    }
}
