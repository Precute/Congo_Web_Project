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
@WebServlet("/video-listing")
public class VideoListing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoListing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**Connection conn =null; // Create connection object
		String database = "igbinoso"; // Name of database
		String user = "igbinoso"; // 
		String password = "droogooP9";
		String url = "jdbc:mysql://localhost:3306/" + database;
		//String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk/" + database;
		String docType =
			    "<!DOCTYPE HTML >";

			response.setContentType("text/html"); 
			PrintWriter out = response.getWriter();
			String title = "Congo Video Listing";*/
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();
		VideoDAO pconnect = new VideoDAO(); 
		ArrayList<VideoRecordingBean> video_recordings = pconnect.allVideoRecording();
		String title = "Congo Video Listing";

		String docType =
		    "<!DOCTYPE HTML >";
		  
	        
			out.println(docType +"<h1>Congo Video Listing </h1>");
			
			     
			    // Retrieve the results
		    out.println("<table border=\"1\"><tr><th>recording_id</th>"
		    		+ "<th>director</th>"
		    		+ "<th>title</th>"
		    		+ "<th>category</th>"
		    		+ "<th>image_name</th>"
		    		+ "<th>duration</th>"
		    		+ "<th>rating</th>"
		    		+ "<th>year_released</th>"
		    		+ "<th>price</th>"
		    		+ "<th>stock_count</></tr>");
		    for (VideoRecordingBean v : video_recordings){
				out.println("<tr><td> "+ v.getRecording_id() + "</td>");
				out.println("<td>" + v.getDirector() + "</td>"); 	  
				out.println("<td> " + v.getTitle() + "</td>");
				out.println("<td> " + v.getCategory() + "</td>");
				out.println("<td>" + v.getImage_name() + "</td>"); 	  
				out.println("<td> " + v.getDuration() + "</td>");
				out.println("<td>" + v.getRating() + "</td>"); 	  
				out.println("<td> " + v.getYear_released() + "</td>");
				out.println("<td>" + v.getPrice() + "</td>"); 	  
				out.println("<td> " + v.getStock_count() + "</td>");
				out.println("</tr>");
			    }
			    out.println("</table>");
			
		    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
