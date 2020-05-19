
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String Domain = "";
	static String Path = "/";
	static String Servlet = "assignment8";
	
// Button labels
	static String OperationAdd = "Add";
	static String OperationSub = "Subtract";
	static String OperationMult = "Multiply";

// Other strings.
	static String Style = "https://www.cs.gmu.edu/~offutt/classes/432/432-style.css";
	
	
	  static enum Data {NAME};
  static String RESOURCE_FILE = "entries.txt";
  static final String VALUE_SEPARATOR = ";";

	/**
	 * ***************************************************** Overrides HttpServlet's
	 * doPost(). Converts the values in the form, performs the operation indicated
	 * by the submit button, and sends the results back to the client.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter(Data.NAME.name());
     
     String error = "";
     if(name == null){
       error= "<li>Name is required</li>";
       name = "";
     }


     response.setContentType("text/html");
     PrintWriter out = response.getWriter();

     if (error.length() == 0){
       PrintWriter entriesPrintWriter = new PrintWriter(new FileWriter(RESOURCE_FILE, true), true);
       entriesPrintWriter.println(name);
       entriesPrintWriter.close();

       PrintHead(out);
       PrintResponseBody(out, RESOURCE_FILE);
       PrintTail(out);
     }else{
       PrintHead(out);
       //PrintBody(out, name, year, jc, fw, rb, ss, vse, error);
       PrintTail(out);
     }
		
	}
	
	  /** *****************************************************
   *  Prints the <BODY> of the HTML page
  ********************************************************* */
  private void PrintResponseBody (PrintWriter out, String resourcePath){
    out.println("<body onLoad=\"setFocus()\">");
    out.println("<p>");
    out.println("Results Database");
    out.println("</p>");
    out.println("");
	  
	out.println(" <style> able, th, td { border: 1px solid black; } </style> ");
    out.println(" <table>");
	
    try {
	 out.println("  <table>");
        out.println("  <tr>");
        out.println("   <th>Name</th>");
        out.println("  </tr>");
        File file = new File(resourcePath);
        if(!file.exists()){
          out.println("  <tr>");
          out.println("   <td>No entries persisted yet.</td>");
          out.println("  </tr>");
          return;
        }

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
          String []  entry= line.split(VALUE_SEPARATOR);
          out.println("  <tr>");
          for(String value: entry){
              out.println("   <td>"+value+"</td>");
          }
          out.println("  </tr>");
        }
        bufferedReader.close();
      } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
     out.println(" </table>");
     out.println("");
     out.println("</body>");
  }

	/**
	 * ***************************************************** Overrides HttpServlet's
	 * doGet(). Prints an HTML page with a blank form.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		PrintHead(out);
		PrintBody(out);
		PrintTail(out);
		
	
						
		   HttpSession session = request.getSession();
   String name   = request.getParameter("attrib_name");
   String value  = request.getParameter("attrib_value");
   String remove = request.getParameter("attrib_remove");

      String action = request.getParameter("action");

   if (action != null && action.equals("invalidate"))
   {  // Called from the invalidate button, kill the session.
      // Get session object
      session.invalidate();

      response.setContentType("text/html");

      out.println("<html>");
      out.println("<head>");
      out.println(" <title>Session lifecycle</title>");
      out.println("</head>");
      out.println("");
      out.println("<body>");

      out.println("<p>Your session has been invalidated.</P>");
      }
	
		
		   
            String lifeCycleURL = "/assignment8"; // --------------------------------------------
      out.print  ("<br><a href=\"" + lifeCycleURL + "?action=invalidate\">");
      out.println("Invalidate the session</a>");
       out.println("<br>");
		
		
	} // End PrintHead

	/**
	 * ***************************************************** Prints the <BODY> of
	 * the HTML page with the form data values from the parameters.
	 */
	private void PrintBody (PrintWriter out, String name){

	
	    
     out.println("<body onLoad=\"setFocus()\">");
     out.println("<p>");
     // out.println("<b>Name:</b> Megan Ngo");
   		 out.println("<b>SWE 432: </b> Final Exam");
		out.println("<p>");
		out.println("Thomas Rigger");
		out.println("</p>");
		
		out.println("<br>");
		out.println("<p><b>Survey Instructions:</b> Please enter a boolean value</p>");
     out.println("</p>");

     if(error != null && error.length() > 0){
       out.println("<p style=\"color:red;\">Please correct the following and resubmit.</p>");
       out.println(error);
     }
		
		  out.print  ("<form name=\"persist2file\" method=\"post\"");
     out.println(" action=\""+Domain+Path+Servlet+"\">");
     out.println("");
		
		  
     out.println("");
     out.println("</body>");
		out.println("</form>");
		
	
	} // End doGet

	/**
	 * ***************************************************** Prints the <head> of
	 * the HTML page, no <body>.
	 */
	private void PrintHead(PrintWriter out) {
	/*	out.println("<html>");
		out.println("");

		out.println("<head>");
		out.println("<title>Assignment 8</title>");
		out.println(" <link rel=\"stylesheet\" type=\"text/css\" href=\"" + Style + "\">");
		out.println("</head>");
		out.println("");
		
		out.println("");
		out.println("</body>"); */
		
		
	out.println("<html>");
		
     out.println("");
     out.println("<head>");
     out.println("<title>Assignment 8</title>");
     // Put the focus in the name field
     out.println ("<script>");
     out.println ("  function setFocus(){");
     out.println ("    document.persist2file.NAME.focus();");
     out.println ("  }");
     out.println ("</script>");
     out.println("</head>");
     out.println("");
	} // End PrintBody

	/**
	 * ***************************************************** Overloads PrintBody
	 * (out,lhs,rhs,rslt) to print a page with blanks in the form fields.
	 */
	private void PrintBody(PrintWriter out) {
		PrintBody(out, "", null, null, null, null, null, null, null);
	}


	/**
	 * ***************************************************** Prints the bottom of
	 * the HTML page.
	 */
	private void PrintTail(PrintWriter out) {
		out.println("");
		out.println("</html>");
	} // End PrintTail

} // End assignment6
