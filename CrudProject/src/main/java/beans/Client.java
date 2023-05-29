package beans;

import java.util.ArrayList;
import java.util.List;

public class Client {
	List<Paiment> paiments = new ArrayList<Paiment>();
	public List<Paiment> getPaiments() {
		return paiments;
	}
	public void setPaiments(List<Paiment> paiments) {
		this.paiments = paiments;
	}
	Paiment paiment ;
	public Paiment getPaiment() {
		return paiment;
	}
	public void setPaiment(Paiment paiment) {
		this.paiment = paiment;
	}
	private int id;
	private String nom;
	private String prenom;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Client() {
		
	}
	
}
