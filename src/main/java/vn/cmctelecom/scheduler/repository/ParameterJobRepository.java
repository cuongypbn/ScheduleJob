package vn.cmctelecom.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.cmctelecom.scheduler.enitiy.ParameterJob;
/**
 * TODO: write you class description here
 *
 * @author cuong.nv5
 *
 */
@Repository
public interface ParameterJobRepository extends JpaRepository<ParameterJob, Long> {

}
