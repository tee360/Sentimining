package co.grandcircus.finalproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import co.grandcircus.finalproject.model.Twitter;

@Repository
@Primary
public class TwitterDaoJdbc implements TwitterDao{
	
	@Autowired
	JdbcConnectionFactory connectionFactory;
	
	@Override
	public String addTweets(Twitter tweet) {
		long tweetID = tweet.getId();
		String text = tweet.getText();
		String sql = "INSERT INTO user (id, text) VALUES (?, ?)";
		try (Connection connection = connectionFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			statement.setLong(1, tweet.getId());
			statement.setString(2, tweet.getText());
			
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Creating users failed, no rows affected.");
			}				

			return tweet.getText();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	

	
	

}
