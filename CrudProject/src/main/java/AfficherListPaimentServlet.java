

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
import beans.Paiment;

/**
 * Servlet implementation class AfficherListPaimentServlet
 */
public class AfficherListPaimentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherListPaimentServlet() {
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
		List<Client> listPaimentClient = new ArrayList<Client>();
		List<Paiment> listPaiments= new ArrayList<Paiment>();
		Client client = new Client();
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url_db, user_db, pwd_db);
		PreparedStatement psmt = conn.prepareStatement("select * from paiment p left join client c on p.id_client=c.id where c.id = ?");
		psmt.setInt(1, id);
		
		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {
			
			Paiment paiment = new Paiment();
			/*client.setPaiment(paiment);
			getPaiment().setIdPaiment(rs.getInt("idPaiment"));
			client.getPaiment().setTarifs(rs.getInt("tarifs"));
			client.getPaiment().setMontantPayee(rs.getInt("montantPayee"));
			client.getPaiment().setDatePaiment(rs.getString("datePaiment"));*/
			paiment.setIdPaiment(rs.getInt("id_paiment"));
			paiment.setTarifs(rs.getInt("tarifs"));
			paiment.setMontantPayee(rs.getInt("montantPayee"));
		
			paiment.setDatePaiment(rs.getString("datePaiment"));
			//client.setPaiment(paiment);
		
			listPaiments.add(paiment);
			client.setPaiments(listPaiments);
	
		}
		rs.close();
		psmt.close();
		conn.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		request.setAttribute( "client", client);
		request.getRequestDispatcher("afficherProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
