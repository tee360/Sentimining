package co.grandcircus.finalproject.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import co.grandcircus.finalproject.dao.JdbcConnectionFactory;
import co.grandcircus.finalproject.model.SentimentAnalyzer;

/**
 * Responsibility: To provide access to the
 */
@Repository
@Primary
public class SearchDataDaoJdbc implements SearchDataDao {

	@Autowired
	JdbcConnectionFactory connectionFactory;

	@Override
	public String addTweets(String name, int score, String type) {
		String sql = "INSERT INTO data_repo (search_name,score_average,type) VALUES (?, ?,?)";

		try (Connection connection = connectionFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, name);
			statement.setDouble(2, score);
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

	@Override
	public SentimentAnalyzer retrieveRunningAvg() {
		String sql = "SELECT AVG(score_average) AS avg FROM data_repo";

		SentimentAnalyzer stringAnalyzer = new SentimentAnalyzer();

		try (Connection connection = connectionFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				int runningAvg = result.getInt("avg");
				stringAnalyzer.setRunningAvg(runningAvg);
				System.out.println("Testing" + stringAnalyzer.getRunningAvg());
			}

//			int affectedRows = statement.executeUpdate();
//			if (affectedRows == 0) {
//				throw new SQLException("Finding average failed, no rows affected.");
//
//			}

			//
			// while (result.next()) {
			// int runningAvg = result.getInt("avg");
			// System.out.println("HELLO!!! LOOP HERE!!");
			// System.out.println(runningAvg);
			// stringAnalyzer.setRunningAvg(runningAvg);
			// System.out.println("Testing " + stringAnalyzer.getRunningAvg());
			// }
			//
			//// int affectedRows = statement.executeUpdate();
			//// if (affectedRows == 0) {
			//// throw new SQLException("Finding average failed, no rows
			// affected.");
			////
			//// }
			//
			// result.close();
			// statement.close();
			// connection.close();
			//
			return stringAnalyzer;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

}