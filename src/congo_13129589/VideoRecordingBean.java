package congo_13129589;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class VideoBean
 */


public class VideoRecordingBean implements Serializable {
	private int recording_id;
	private String director;
	private String title;
	private String category;
	private String image_name;
	private int duration;
	private String rating;
	private int year_released;
	private float price;
	private int stock_count;
	
	public VideoRecordingBean(){	
	} // setting a constructor that defines video recording
	public VideoRecordingBean(int rec_id, String dir, String tlt,String Catg, String img_nme, 
			int length, String rate, int yr_rld, float p, int stk_count){
		recording_id = rec_id;
		director = dir;
		title =  tlt;
		category = Catg;
		image_name = img_nme;
		duration = length;
		rating = rate;
	    year_released = yr_rld;
		price = p;
		stock_count = stk_count;
	}
	//1
	public int getRecording_id(){
		return recording_id;
	}
	public void setRecording_id(int recording_id){
		this.recording_id = recording_id;
	}
	//2
	public String getDirector(){
		return director;
	}
	public void setDirector(String director){
		this.director=director;
	}
	//3
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	//4
	public String getCategory(){
		return category ;
	}
	public void setCategory(String category ){
		this.category =category;
	}
	//5
	public String getImage_name(){
		return image_name;
	}
	public void setImage_name(String image_name ){
		this.image_name =image_name;
	}
	//6
	public int getDuration(){
		return duration;
	}
	public void setDuration(int duration ){
		this.duration = duration;
	}
	//7
	public String getRating(){
		return rating;
	}
	public void setRating(String rating){
		this.rating = rating;
	}
	//8
	public int getYear_released(){
		return year_released;
	}
	public void setYear_released(int year_released){
		this.year_released = year_released;
	}
	//9
	public float getPrice(){
		return price;
	}
	public void setPrice(float price ){
		this.price = price;
	}
	//10
	public int getStock_count(){
		return stock_count;
	}
	public void setStock_count(int stock_count){
		this.stock_count = stock_count;
	}
	
	@Override
	public String toString (){
		return  "VideoRecordingBean [recording_id=" + recording_id 
				+ ", director=" + director
				+ ", title=" + title 
				+ ", category=" + category 
				+ ", image_name=" + image_name 
				+  ", duration=" + duration 
				+ ", rating=" + rating  
				+ ", year_released=" + year_released 
				+ ", price=" + price 
				+ ", stock_count=" + stock_count+ "]";
	}
	}

