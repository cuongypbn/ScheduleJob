package vn.cmctelecom.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.cmctelecom.scheduler.enitiy.SchedulerJobHistory;

/**
 * TODO: write you class description here
 *
 * @author
 */

@Repository
public interface SchedulerJobHistoryRepository extends JpaRepository<SchedulerJobHistory, Long> {

}
