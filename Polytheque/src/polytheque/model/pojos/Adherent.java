package polytheque.model.pojos;

public class Adherent {

	private String nom;
	private String prenom;
	private int age;
	private String rue;
	private int CP;
	private String ville;
	private String mail;
	private int telephone;
	private String pseudo;
	private String mdp;
	private boolean estAJour;
	private boolean peutEmprunter;
	
	public Adherent(String nom, String prenom, int age, String adresse, int cp, String Ville, String mail, int tel, String pseudo, String MDP, boolean estAJour, boolean peutEmprunter){
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.rue = adresse;
		this.CP = cp;
		this.ville = Ville;
		this.mail = mail;
		this.pseudo = pseudo;
		this.mdp = MDP;
		this.estAJour = estAJour;
		this.peutEmprunter = peutEmprunter;
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

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCP() {
		return CP;
	}

	public void setCP(int cP) {
		CP = cP;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public boolean isEstAJour() {
		return estAJour;
	}

	public void setEstAJour(boolean estAJour) {
		this.estAJour = estAJour;
	}

	public boolean isPeutEmprunter() {
		return peutEmprunter;
	}

	public void setPeutEmprunter(boolean peutEmprunter) {
		this.peutEmprunter = peutEmprunter;
	}

}
