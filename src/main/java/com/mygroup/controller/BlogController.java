package com.mygroup.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mygroup.dao.BlogDAO;
import com.mygroup.model.Blog;
import com.mygroup.model.UserDetails;
import com.mygroup.model.Error;

@RestController
public class BlogController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BlogDAO blogDao;
	
	@RequestMapping(value="/reqAddBlog",method=RequestMethod.POST)
	public ResponseEntity<?> addBlog(@RequestBody Blog blog, HttpSession session){
		logger.debug("Backend - BlogController - addBlog");
		UserDetails currentUser =  (UserDetails)session.getAttribute("user");
		if(currentUser==null){
			Error er = new Error(1,"Unauthorized user...login before adding blog");
			return new ResponseEntity<Error> (er,HttpStatus.UNAUTHORIZED);		// 401	
			// RETURND RESPONSE OBJ - DATA [ERROR]
			// FRONT END - response.data.message
		}
		else{
			blog.setBlogCreatedUser(currentUser.getFullname());
		    long millis=System.currentTimeMillis();  
	        java.sql.Date date=new java.sql.Date(millis);  
	       // System.out.println(date);  
			blog.setBlogCreationDate(date);
			blog.setBlogStatus("active");
			blogDao.createBlog(blog);					
			return new ResponseEntity<Void> (HttpStatus.OK);
		}		
	}
	
	@RequestMapping(value="/reqGetAllBlogs",method=RequestMethod.GET)
	public ResponseEntity<?> getAllBlogs(HttpSession session){
		UserDetails ud = (UserDetails)session.getAttribute("user");
		if(ud==null){
			Error er =new Error(1,"UnAutorized user");
			return new ResponseEntity<Error> (er,HttpStatus.UNAUTHORIZED);
		}
		else{
			List <Blog> blogs = blogDao.getBlogList();
			return new ResponseEntity<List<Blog>> (blogs,HttpStatus.OK);
		}		
	}
	
}
