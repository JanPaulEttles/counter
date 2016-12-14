package dtc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * in webapps, create a folder /naughty/WEB-INF/classes/dtc/
 * 
 * place the NaughtyServlet.java in /naughty/WEB-INF/classes/dtc/
 * place web.xml in /naughty/WEB-INF/
 * 
 * javac NaughtyServlet.java -cp container/lib/servlet.api.jar
 * 
 */


/* 
 * test naughty
 * /naughty/naughty?payload=<script>alert(1)</alert>&username=username&password=password
 *	
 * test hello world
 * /naughty/naughty?payload=hello  
 */
public class NaughtyServlet 
	extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException {
		
		String payload = request.getParameter("payload");
		
		if(payload.equals("hello")) {
			doHelloWorld(response);			
		}
		else {
			doXSS(request, response);
			
			try {
				doSQLi(request, response);
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	private static void doHelloWorld(HttpServletResponse response) 
		throws IOException {

		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.println("{ \"response\" : \"world\"}");			
		out.flush();
	}	

	
	private static void doXSS(HttpServletRequest request, HttpServletResponse response) 
		throws IOException {

		String payload = request.getParameter("payload");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello Servlet Get</h1>");
		out.println(payload);
		out.println("</body>");
		out.println("</html>");
	}	
	
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:fridj";
	private static final String DB_USERNAME = "admin";
	private static final String DB_PASSWORD = "admin";
	
	//oh dear oh dear... so much wrongness.... (-;
	private static void doSQLi(HttpServletRequest request, HttpServletResponse response) 
		throws SQLException {
		
		String select = "SELECT USERID, USERNAME FROM TBL_USER WHERE USERNAME = " + request.getParameter("username") + " AND PASSWORD = " + request.getParameter("password");
		PreparedStatement preparedStatement = getDBConnection().prepareStatement(select);
		ResultSet rs = preparedStatement.executeQuery(select);
		while (rs.next()) {
			String userid = rs.getString("USERID");
			String username = rs.getString("USERNAME");
		}

	}

	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {
			Class.forName(DB_DRIVER);

		} 
		catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USERNAME, DB_PASSWORD);
			return dbConnection;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}
}