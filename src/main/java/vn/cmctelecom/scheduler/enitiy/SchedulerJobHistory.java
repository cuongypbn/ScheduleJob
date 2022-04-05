package vn.cmctelecom.scheduler.enitiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author
 */
@Getter
@Setter
@Entity
@Table( name = "SCHEDULER_JOB_HISTORY")
public class SchedulerJobHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SCHEDULE_ID")
    private Long schedule_id;

    @Column(name = "JOB_NAME")
    private String job_name;

    @Column(name = "LAST_SUCCESS")
    private Date last_success;

    @Column(name = "LAST_FAIL")
    private Date last_fail;
}

