

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import beans.Client;
import beans.Paiment;

/**
 * Servlet implementation class AddPaimentServelet
 */
public class AddPaimentServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPaimentServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		int  tarif =Integer.parseInt(request.getParameter("tarifs")) ;
		int montantpayee = Integer.parseInt(request.getParameter("montantpayee"));
		String date =request.getParameter("date");
		String url_db = "jdbc:mysql://localhost:3306/eheio_db";
		String user_db = "root";
		String pwd_db = "";
		Client client = new Client();
		Paiment paiment = new Paiment();
		client.setPaiment(paiment);
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url_db, user_db, pwd_db);
		
		PreparedStatement psmt = conn.prepareStatement("insert into paiment(tarifs,montant_payee,id_client,date_paiment) values(?,?,?,?)");
		/*psmt.setInt(1, tarif);
		psmt.setInt(2, montantpayee);
		psmt.setInt(3, id);
		psmt.setString(4, date);*/
		
		psmt.setInt(1, tarif);
		psmt.setInt(2, montantpayee);
		psmt.setInt(3, id);
		psmt.setString(4,date);
		psmt.executeUpdate();
  
		
	
		psmt.close();

		conn.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
	
		request.getRequestDispatcher("AfficherListPaiment").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
