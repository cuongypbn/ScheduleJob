package vn.cmctelecom.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.cmctelecom.scheduler.enitiy.AppConfig;

public interface AppConfigRepository extends JpaRepository<AppConfig ,Long> {
    AppConfig findByValueAndType(String val,String type);
}
