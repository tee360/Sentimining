package co.grandcircus.finalproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Provides connections to a MySQL database.
 */
@Component
public class JdbcConnectionFactory {
	
	private static final Logger logger = LoggerFactory.getLogger(JdbcConnectionFactory.class);
	
	private String driverClass = "com.mysql.jdbc.Driver";
	
	//@Value("${db.url}")
	private String dbUrl="jdbc:mysql://localhost:3306/reflect";
	
	//@Value("${db.username}")
	private String username="root";
	
	//@Value("${db.password}")
	private String password="password";
	
	public Connection getConnection() {
		try {
			boolean passwordPresent = password != null & !password.isEmpty();
			logger.info("DB Connection. url:" + dbUrl + " user:" + username + "password:" + ( passwordPresent ? "present" : "ABSENT!" ));
			
			Class.forName(driverClass); 
		    return DriverManager.getConnection(dbUrl, username, password);
		} catch (SQLException | ClassNotFoundException ex) {
		    throw new RuntimeException("Connection Failure", ex);
		}
	}

<<<<<<< HEAD
}
=======
}
>>>>>>> f86dfb1d8411d1c18cb47f4d42552c738810c366
