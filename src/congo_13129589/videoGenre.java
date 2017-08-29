package congo_13129589;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class VideoListing
 */
@WebServlet("/search-by-genre")
public class videoGenre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public videoGenre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();
		VideoDAO pconnect = new VideoDAO(); 
		ArrayList<VideoRecordingBean> video_recordings = pconnect.allVideoRecording();
		String title = "Congo Video Listing";

		String docType =
		    "<!DOCTYPE HTML >";
		out.println(docType +"<h1>Congo Video Listing </h1>");
		out.println("<form action =\"video-listing\"><h3>Select Video Genre</h3>"
				+ "<select category=\"category\">");
		for (VideoRecordingBean v : video_recordings){
			out.println("<option value=\""+v.getCategory()+"\">"
					+ v.getCategory()+"</option>");
		}
	
				out.println("</select>"
						+ "<input type = \"submit\">"
						+ "</form>");
		  
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
