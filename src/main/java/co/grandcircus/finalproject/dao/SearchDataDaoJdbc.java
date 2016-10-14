package co.grandcircus.finalproject.dao;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.Statement;




import co.grandcircus.finalproject.dao.JdbcConnectionFactory;

/**
 * Responsibility: To provide access to the
 */
@Repository
@Primary
public class SearchDataDaoJdbc implements SearchDataDao {
	
	@Autowired
	JdbcConnectionFactory connectionFactory;

	@Override
	public String addTweets(String name, Double avg, String type) {
		String sql = "INSERT INTO searchdata (search_name,score_average,type) VALUES (?, ?,?)";
		
		try (Connection connection = connectionFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1,name);
			statement.setDouble(2,avg);
			statement.setString(3, type);
			
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Creating users failed, no rows affected.");
			}
			
			return "Success";
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		
	}
 
	

	
	
	
}