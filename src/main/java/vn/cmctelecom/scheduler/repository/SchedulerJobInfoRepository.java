package vn.cmctelecom.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.cmctelecom.scheduler.enitiy.SchedulerJobInfo;
import vn.cmctelecom.scheduler.enitiy.dto.SchedulerJobInfoDto;

/**
 * TODO: write you class description here
 *
 * @author
 */

@Repository
public interface SchedulerJobInfoRepository extends JpaRepository<SchedulerJobInfo, Long> {
	SchedulerJobInfo findByJobName(String jobName);
	SchedulerJobInfo findById(long id);
}
