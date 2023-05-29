

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Client;

/**
 * Servlet implementation class ListerClientServlet
 */
public class ListerClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListerClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url_db = "jdbc:mysql://localhost:3306/eheio_db";
		String user_db = "root";
		String pwd_db = "";
		List<Client> listClients = new ArrayList<Client>();
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url_db, user_db, pwd_db);
		PreparedStatement psmt = conn.prepareStatement("select * from client");
		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {
		Client client = new Client();
		client.setId(rs.getInt("id"));
		client.setNom(rs.getString("nom"));
		client.setPrenom(rs.getString("prenom"));
		client.setAge(rs.getInt("age"));
		listClients.add(client);
		}
		rs.close();
		psmt.close();
		conn.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		request.setAttribute( "list", listClients);
		request.getRequestDispatcher("accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
