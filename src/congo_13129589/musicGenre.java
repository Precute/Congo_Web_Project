package congo_13129589;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VideoListing
 */
@WebServlet("/searchByGenre")
public class musicGenre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public musicGenre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn =null; // Create connection object
		String database = "igbinoso"; // Name of database
		String user = "igbinoso"; // 
		String password = "droogooP9";
		String url = "jdbc:mysql://localhost:3306/" + database;
		//String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk/" + database;
		String docType =
			    "<!DOCTYPE HTML >";

			response.setContentType("text/html"); 
			PrintWriter out = response.getWriter();
			String title = "Congo Video Listing";
		    out.println(docType +
	                "<HTML>\n" +
	                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
	                "<BODY>\n" +
	                "<UL>\n" +
	                "</BODY></HTML>");
			out.println(docType +"<h1>Congo Video Listing </h1>");
			try{
			    Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch(Exception e) {
			    System.err.println(e);
			}
			
			// connecting to database
			try{
			    conn = DriverManager.getConnection(url, user, password);
				
			}
			catch(SQLException se) {
			    System.err.println(se);
			}
			try{
			String musicGenre =request.getParameter("categ-name");
			    String selectSQL = "select * from Video_Recordings where category = '"+musicGenre+"'";
			    Statement stmt = conn.createStatement();
			    ResultSet rs1 = stmt.executeQuery(selectSQL);
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
			    while(rs1.next()){
				out.println("<tr><td> "+ rs1.getInt("recording_id") + "</td>");
				out.println("<td>" + rs1.getString("director") + "</td>"); 	  
				out.println("<td> " + rs1.getString("title") + "</td>");
				out.println("<td>" + rs1.getString("image_name") + "</td>"); 	  
				out.println("<td> " + rs1.getInt("duration") + "</td>");
				out.println("<td>" + rs1.getString("rating") + "</td>"); 	  
				out.println("<td> " + rs1.getString("year_released") + "</td>");
				out.println("<td>" + rs1.getFloat("price") + "</td>"); 	  
				out.println("<td> " + rs1.getInt("stock_count") + "</td>");
				out.println("</tr>");
			    }
			    out.println("</table>");
			    conn.close();
			} catch(SQLException se) {
			    System.err.println(se);
			}
		    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
