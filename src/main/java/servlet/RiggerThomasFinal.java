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
	

static String Domain ="swe432RiggerThomasFinal.herokuapp.com";
static String Path    = "/";
static String Servlet = "RiggerThomasFinal";

	
private void PrintBody (PrintWriter out)
{
   out.println("<body>");
   out.println("<p>");
   out.println("Thomas Rigger");
   out.println("</p>");
	 //Read information from user. Then send it to doPost
   //out.println("<form method=\"doPost\"");
   out.println("<form name=\"persist\" method=\"post\"");
	out.println(" action=\""+Domain+Path+Servlet+"\">");
   out.println("<td><input type=\"text\" name=\"input\"  size=30 required></td>");
   out.println("<input type=\"submit\" onclick=\"doGet()\" value=\"Submit\">");
  // out.println("<action=\"https://" + Domain + Path + Servlet + "\">");
   
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
      if(input == null){
       out.print("<li>input is required</li>");
       input = "";
     }
      int length = input.length();
	
      int i;
      int clauseNum, openParen, closedParen;
      clauseNum = 1;
      openParen = 1;
      closedParen = 1;
      for(i = 0; i < length; i++){//Count how many clauses in parenthesis there are
      	 if(input.charAt(i) == '('){
	     openParen = 1;
	 }
	 else if(input.charAt(i) == ')'){
	     closedParen = 1;
	 }
	 if((openParen > 1) && (closedParen > 1))
	 {
		clauseNum++;
		openParen--;
		closedParen--;
	 }
      }
	int[] vals = new int[clauseNum];
      String result = printTruthTable(clauseNum, 0, vals);
      out.print("<li>Your input is: " + input + "<font color=green><li>");
      out.print("<li>Your output is: " + result + "<font color=green><li>");
      out.print(input);
      out.print("</font>\n");
      out.print("</body>\n");
      out.print("</html>\n");

      
      
      out.close ();
   }
	
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		PrintBody(out);
}
	
	
public String printTruthTable(int N, int index, int[] truthVals) {
      int i;
      String ret = "";
      if (index == N) {
      	 for (i=0; i<N; i++){
            ret += " " + truthVals[i] + "\n";// + //out.println("<p> " + truthVals[i] + " </p>"); 
	 }
      } 
      else {
    	for (i=0; i<2; i++) {
         truthVals[index] = i;
         ret += printTruthTable(N, index + 1, truthVals);
  	}
     }
     return ret;
   }



} // End 
