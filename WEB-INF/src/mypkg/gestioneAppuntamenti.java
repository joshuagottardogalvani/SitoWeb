package mypkg;
 
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
 
public class gestioneAppuntamenti extends HttpServlet {
 
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      response.setContentType("text/html; charset=UTF-8");
      
      PrintWriter out = response.getWriter();
      
      try {
         out.println("<!DOCTYPE html>");
         out.println("<html><head>");
         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
         out.println("<title>Echo Servlet</title></head>");
 
         String cognome = request.getParameter("cognome");
         
         if (cognome == null || (cognome = htmlFilter(cognome.trim())).length() == 0) {
            out.println("<h2>Attenzione! Inserire il cognome</h2>");
         } else {
            out.println("<h2>Benvenuto, " + cognome + " ! </h2>");
         }
         
         out.println("<a href='formGestioneAppuntamenti.jsp'>Torna indietro</a>");
         out.println("</body></html>");
      } finally {
         out.close();
      }
   }
 
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      doGet(request, response);
   }
   
   private static String htmlFilter(String message) {
      if (message == null) return null;
      int len = message.length();
      StringBuffer result = new StringBuffer(len + 20);
      char aChar;
 
      for (int i = 0; i < len; ++i) {
         aChar = message.charAt(i);
         switch (aChar) {
             case '<': result.append("&lt;"); break;
             case '>': result.append("&gt;"); break;
             case '&': result.append("&amp;"); break;
             case '"': result.append("&quot;"); break;
             default: result.append(aChar);
         }
      }
      return (result.toString());
   }
}