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

@WebServlet(name = "RiggerThomasFinal", // "MyServlet2",
		urlPatterns = { "/RiggerThomasFinal" })


public class RiggerThomasFinal extends HttpServlet {
	

static String Domain ="swe432RiggerThomasFinal.herokuapp.com";
static String Path    = "/";
static String Servlet = "RiggerThomasFinal";

	
private void PrintBody (PrintWriter out)
{
   out.println("<body>");
   out.println("<p>");
   out.println("Thomas Rigger");
   out.println("</p>");
   out.println("<form method=\"doPost\"");
	 out.println("<td><input type=\"text\" name=\"+input+\" value=\"+name+\" size=30 required></td>");
   out.println(" action=\"https://" + Domain + Path + Servlet + "\">");
   out.println("");
   
   out.println("</form>");
   out.println("</body>");
} // End PrintBody
	
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
   {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      out.print("<html>\n<head>\n\n");
      out.print("<title>BooleanOutput</title>\n");
      out.print("</head>\n");
      out.print("<body>\n");
      out.print("<center><h2>BooleanOutput</h2></center>\n");
      out.print("<hr>\n");

      String input = request.getParameter("input");
      out.print("Your input is: <font color=green>");
      out.print(input);
      out.print("</font>\n");
      out.print("</body>\n");
      out.print("</html>\n");

      out.close ();
   }

} // End 
