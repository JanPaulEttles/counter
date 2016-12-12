package dtc;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NaughtyServlet 
	extends HttpServlet{

	public void doGe(HttpServletRequest request, HttpServletResponse response)
			throws IOException{
		String payload = request.getParameter("payload");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello Servlet Get</h1>");
		out.println(payload);
		out.println("</body>");
		out.println("</html>");
	}
}