package vn.cmctelecom.scheduler.enitiy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "APP_CONFIG")
public class AppConfig implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_CONFIG_JOB_INFO_SEQ")
    @SequenceGenerator(sequenceName = "APP_CONFIG_JOB_INFO_SEQ", allocationSize = 1, name = "APP_CONFIG_JOB_INFO_SEQ")
    private Long id;

    public Long getId() {
        return id;
    }

    @Column(name = "USER_NAME")
    private String userName  ;

    @Column(name = "TYPE", nullable = false)
    private String type ;

    @Column(name = "TITLE")
    private String title  ;

    @Column(name = "Key")
    private String key ;

    @Column(name = "VALUE", nullable = false)
    private String value  ;


    @Column(name = "STATUS", nullable = false)
    private boolean status;

    @Column(name = "CREATE_DATE")
    private Date createDate ;

    @Column(name = "MODIFIED_DATE")
    private Date  modifiedDate ;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


}
