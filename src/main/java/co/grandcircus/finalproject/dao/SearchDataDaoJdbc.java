package co.grandcircus.finalproject.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

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
	public String addTweets(String name, Double avg, String type) {

		String sql = "INSERT INTO data_repo (search_name,score_average,type) VALUES (?, ?,?)";

		//Double avg = null;
		if (avg.isNaN()) {
			avg = 0.0;
		}
		try (Connection connection = connectionFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, name);
			statement.setDouble(2, avg);
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
	public Double retrieveRunningAvg(String keyword) {
		String sql = "SELECT AVG (score_average) AS avg FROM data_repo  where search_name ='" + keyword + "'";

		try {
			Connection connection = connectionFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery(sql);

			Double avgData = 0.0;
			while (result.next()) {
				avgData = result.getDouble("avg");

			}
			result.close();
			statement.close();
			connection.close();

			return avgData;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public SentimentAnalyzer getMaxScore() {
		String sql = "select  search_name, MAX(score_average) as score from ebdb.data_repo";

		SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
		try {
			Connection connection = connectionFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				sentimentAnalyzer.setKeyword(result.getString("search_name"));
				sentimentAnalyzer.setScoreValue(result.getDouble("score"));
			//	System.out.println("Max score Keyword" + sentimentAnalyzer.getKeyword());
			//	System.out.println("Max score" + sentimentAnalyzer.getScoreValue());
			}
			result.close();
			statement.close();
			connection.close();
			return sentimentAnalyzer;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}

	}

	
	
	

	@Override
	public SentimentAnalyzer getMinScore() {
		String sql = "select  search_name, MIN(score_average) as score from ebdb.data_repo";

		SentimentAnalyzer sentimentanalyzer = new SentimentAnalyzer();

		try {
			Connection connection = connectionFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				sentimentanalyzer.setKeyword(result.getString("search_name"));
				sentimentanalyzer.setScoreValue(result.getDouble("score"));
				System.out.println("MIN score Keyword" + sentimentanalyzer.getKeyword());
				System.out.println("MIN score" + sentimentanalyzer.getScoreValue());
			}

			return sentimentanalyzer;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}

	}
	
}
