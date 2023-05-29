package beans;

import java.sql.Date;

public class Paiment {


	private int idPaiment;
	private int tarifs;
	private int montantPayee;
	private String datePaiment;
	

	
	public Integer getIdPaiment() {
		return idPaiment;
	}
	public void setIdPaiment(Integer idPaiment) {
		this.idPaiment = idPaiment;
	}
	public int getTarifs() {
		return tarifs;
	}
	public void setTarifs(int tarifs) {
		this.tarifs = tarifs;
	}
	public int getMontantPayee() {
		return montantPayee;
	}
	public void setMontantPayee(int montantPayee) {
		this.montantPayee = montantPayee;
	}
	public String getDatePaiment() {
		return datePaiment;
	}
	public void setDatePaiment(String datePaiment) {
		this.datePaiment = datePaiment;
	}
	public Paiment() {
		
	}
	
}
