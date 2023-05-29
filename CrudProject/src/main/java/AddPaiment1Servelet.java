

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

import beans.Client;
import beans.Paiment;

/**
 * Servlet implementation class AddPaiment1Servelet
 */
public class AddPaiment1Servelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPaiment1Servelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
	
	
		String url_db = "jdbc:mysql://localhost:3306/eheio_db";
		String user_db = "root";
		String pwd_db = "";
		Client client = new Client();
		Paiment paiment = new Paiment();
		client.setPaiment(paiment);
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url_db, user_db, pwd_db);
		
		PreparedStatement psmt = conn.prepareStatement("select * from client c LEFT JOIN paiment p on c.id= p.id_client where c.id= ?");
		psmt.setInt(1, id);

		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
		
				client.setId(rs.getInt("id"));
				client.setNom(rs.getString("nom"));
				client.setPrenom(rs.getString("prenom"));
				client.setAge(rs.getInt("age"));
				paiment.setIdPaiment(rs.getInt("id_paiment"));
				client.setPaiment(paiment);
			
		
		
		}
		rs.close();
		psmt.close();
		conn.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		request.setAttribute( "client", client);
		request.getRequestDispatcher("ajouterPaiment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
