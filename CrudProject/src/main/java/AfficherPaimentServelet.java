

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
 * Servlet implementation class AfficherPaimentServelet
 */
public class AfficherPaimentServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherPaimentServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id= Integer.parseInt(request.getParameter("id"));
		String url_db = "jdbc:mysql://localhost:3306/eheio_db";
		String user_db = "root";
		String pwd_db = "";
		Paiment paiment = new Paiment();
		Client client = new Client();
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url_db, user_db, pwd_db);
		PreparedStatement psmt = conn.prepareStatement("select * from paiment p FULL JOIN client c on p.id_client =c.id where id_client = ? ");
		
		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {
			
		 paiment.setIdPaiment(rs.getInt("idPaiment"));
		 paiment.setTarifs(rs.getInt("tarifs"));
		 paiment.setMontantPayee(rs.getInt("montantPayee"));
	
		 paiment.setDatePaiment(rs.getString("datePaiment"));
		 client.setPaiment(paiment);
		 client.setId(id);
		request.getAttribute("client");
		
		 
	
		
		}
		rs.close();
		psmt.close();
		conn.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		request.setAttribute( "client", client);
		request.getRequestDispatcher("afficherPaiment.jsp").forward(request, response);
	}

		
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
