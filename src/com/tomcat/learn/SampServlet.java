package com.tomcat.learn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


@WebServlet("/SampServlet")
public class SampServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SampServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, 
	IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, 
	IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			out.println("<h3>Testing Servlets</h3>");
		}
		finally {
			out.close();
		}
		
	}

}
