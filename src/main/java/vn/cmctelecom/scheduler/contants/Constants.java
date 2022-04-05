package vn.cmctelecom.scheduler.contants;

/**
 * TODO: write you class description here
 *
 * @author
 */

public class Constants {

	private static final String app_config = "application.properties";

	public final class SCHEDULE_FLAG {
		public static final int STOP = 0;
		public static final int RUNNING = 1;
		public static final int PAUSE = 2;
	}

	public final class MAIL_DETECT_STATUS {
		public static final int EXECUTED = 1;
		public static final int NOT_EXECUTE = 0;
	}

	public final class MAIL_DETECT_TYPE_SCAN {
		public static final String BUSSINESS = "BUS";
		public static final String INVOICE = "INV";
	}

	public final class HEADER_FIELD {
		public static final String AUTHORIZATION = "Authorization";
		public static final String CONTENT_TYPE = "Content-Type";
	}

	public static final String sso_client_id = ConfigProperties.getConfigProperties("sso.client_id", app_config);
	public static final String sso_secret_id = ConfigProperties.getConfigProperties("sso.secret_id", app_config);
	public static final String sso_redirect_uri = ConfigProperties.getConfigProperties("sso.redirect_uri", app_config);
	public static final String sso_tokenUrl = ConfigProperties.getConfigProperties("sso.tokenUrl", app_config);
	public static final String sso_getUsernameUrl = ConfigProperties.getConfigProperties("sso.getUsernameUrl", app_config);
	public static final String authen2Server = ConfigProperties.getConfigProperties("server.authen2", app_config);

	public static final String db_driver = ConfigProperties.getConfigProperties("db.driver", app_config);
	public static final String db_url = ConfigProperties.getConfigProperties("db.url", app_config);
	public static final String db_username = ConfigProperties.getConfigProperties("db.username", app_config);
	public static final String db_password = ConfigProperties.getConfigProperties("db.password", app_config);
	public static final String db_dialect = ConfigProperties.getConfigProperties("db.dialect", app_config);


	public static final String s3Url = ConfigProperties.getConfigProperties("s3.url", app_config);
	public static final String s3AccessKey = ConfigProperties.getConfigProperties("s3.accessKey", app_config);
	public static final String s3SecretKey = ConfigProperties.getConfigProperties("s3.secretKey", app_config);


	public static final String swagger = ConfigProperties.getConfigProperties("swagger", app_config);

	public static final String job_login_domain = "SynchronizeCronJob";
	// 1 phút
	public static final String cron_login_domain = "0 */1 * ? * *";//"0 10 11,21,22,23 * * ?";
//
}
