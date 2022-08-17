package jdbc;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class DBCPlnitListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String poolCongig = sce.getServletContext().getInitParameter("poolConfig");
		Properties prop = new Properties();
		
		try {
			prop.load(new StringReader(poolCongig));
		} catch (IOException e) {
			throw new RuntimeException("config load gial", e);
		}
		
		loadJDBCDriver(prop);
		initConnectionPool(prop);
	}

	private void loadJDBCDriver(Properties prop) {
		String driverClass = prop.getProperty("jdbcdriver");
		
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("fail to load JDBC Driver", ex);
		}
	}

	private void initConnectionPool(Properties prop) {
		
	}
}
