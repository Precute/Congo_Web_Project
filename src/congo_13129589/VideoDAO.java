package congo_13129589;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Servlet implementation class VideoDAO
 */
public class VideoDAO {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet rs1 = null;

	public VideoDAO() {

	}
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionPoint.getInstance().getConnection();
		return conn;
	}
	public ArrayList<VideoRecordingBean> allVideoRecording() {
		ArrayList<VideoRecordingBean> video_recordings= null;
		try {
			String queryString = "SELECT * FROM video_recordings";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			
			video_recordings = new ArrayList<VideoRecordingBean>();
			while (rs1.next()) {
				VideoRecordingBean temp= new VideoRecordingBean();
				temp.setRecording_id(rs1.getInt("recording_id"));
				temp.setDirector(rs1.getString("director"));
				temp.setTitle(rs1.getString("title"));
				temp.setCategory(rs1.getString("category"));
				temp.setImage_name(rs1.getString("image_name"));
				temp.setDuration(rs1.getInt("duration"));
				temp.setRating(rs1.getString("rating"));
				temp.setYear_released(rs1.getInt("year_released"));
				temp.setPrice(rs1.getFloat("price"));
				temp.setStock_count(rs1.getInt("stock_count"));
				video_recordings.add(temp);
								
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		return video_recordings;
	}
	
	public ArrayList<VideoRecordingBean> VideoGenre() {
		ArrayList<VideoRecordingBean> video_recordings= null;
		try {
			String queryString = "SELECT DISTINCT category FROM video_recordings WHERE catergory = catergory";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			
			video_recordings = new ArrayList<VideoRecordingBean>();
			while (rs1.next()) {
				VideoRecordingBean temp= new VideoRecordingBean();
				temp.setCategory(rs1.getString("category"));
				video_recordings.add(temp);
								
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return video_recordings;
	}
	
}




