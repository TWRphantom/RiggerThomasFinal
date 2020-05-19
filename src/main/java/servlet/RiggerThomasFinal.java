
// package servlet;
// Import Java Libraries
import java.io.*;
import java.util.*;

//Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "RiggerThomasFinal", 
		urlPatterns = { "/RiggerThomasFinal" })


public class RiggerThomasFinal extends HttpServlet {

   out.print("<html>");
   out.print("<input type="text" name="username" value="bool"\n");
   out.print("<br>\n");
   out.print("<input type="submit" value="submit" name="submit">\n");
   out.print("</html>\n");
	
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
   {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      out.print("<html>\n<head>\n\n");
      out.print("<title>SWE 432: Name echoing</title>\n");
      out.print("</head>\n");
      out.print("<body>\n");
      out.print("<center><h2>Name echoing</h2></center>\n");
      out.print("<hr>\n");

      String Nm = request.getParameter("username");
      out.print("Your name is: <font color=green>");
      out.print(Nm);
      out.print("</font>\n");
      out.print("</body>\n");
      
	   
	   
	   out.print("</html>\n");

      out.close ();
   }
} 
