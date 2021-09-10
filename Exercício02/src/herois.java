
public class herois {
	private int id;
	private String nome;
	private String poder;
	private char sexo;
	
	public herois() {
		this.id = 0;
		this.nome = "";
		this.poder = "";
		this.sexo = '*';
	}
	public herois(int id, String nome, String poder, char sexo) {
		this.id = id;
		this.nome = nome;
		this.poder = poder;
		this.sexo = sexo;
	}
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPoder() {
		return poder;
	}
	public void setPoder(String poder) {
		this.poder = poder;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public String toString() {
		return "Nome [id=" + id +", nome=" + nome + ", poder=" + poder +", sexo=" + sexo +"]";
	}
}


