package congo_13129589;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CategoryBean implements Serializable {
	private int id;
	private String name;
	
    public CategoryBean() {}
    public CategoryBean(int idy, String nme){
    	id = idy;
    	name = nme;
    }
    
    public int getId (){
    	return id;
    }
    public void setId (int id){
    	this.id = id;
    }
    
    public String getName(){
    	return name;
    }
    
    public void setName(String name){
    	this.name =name;
    }
	
    public String toString(){
    	return "CategoryBean [id=" + id
    			+ ", name =" + name  + "]";
    }
}
