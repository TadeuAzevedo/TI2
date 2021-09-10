import java.sql.*;

public class DAO {
	private Connection conexao;
	
	public DAO() {
		conexao = null;
	}
	
	public boolean conectar() {
		String driverName = "org.postgresql.Driver"; 
		String serverName = "localhost";
		String mydatabase = "exercicio2";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "";
		String password = "123";
		boolean status = false;
		
		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada!");
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexão não efetuada - Driver não encontrado" + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão não efetuada" + e.getMessage());
		}

		return status;
	}
	public boolean inserirPersonagem(herois heroi) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO personagens(nome, poder, sexo) VALUES ('"+heroi.getNome()+"','"+heroi.getPoder()+"', '"+heroi.getSexo()+"')");
			st.close();
			status = true;
		}catch(SQLException u){
			throw new RuntimeException(u);
		}
		return status;
	}
	public boolean updateHeroi(herois heroi) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE personagens SET nome = '"+heroi.getNome()+"','"+heroi.getPoder()+"','"+heroi.getSexo()+"' WHERE id = '"+heroi.getId()+"'";
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch(SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	public boolean excluirHeroi(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM personagens WHERE id = " + id);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	public herois[] getHeroi() {
		herois[] heroi = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM personagens");
			if(rs.next()) {
				rs.last();
				heroi = new herois[rs.getRow()];
				rs.beforeFirst();
				
				for(int i = 0; rs.next(); i++) {
					heroi[i] = new herois(rs.getInt("id"), rs.getString("nome"), rs.getString("poder"), rs.getString("sexo").charAt(0));
				}
			}
			st.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return heroi;
	}
	public herois[] getHeroiMasculino() {
		herois[] heroi = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM personagens WHERE sexo = 'M'");
			if(rs.next()) {
				rs.last();
				heroi = new herois[rs.getRow()];
				rs.beforeFirst();
				
				for(int i = 0; rs.next(); i++) {
					heroi[i] = new herois(rs.getInt("id"), rs.getString("nome"), rs.getString("poder"), rs.getString("sexo").charAt(0));
				}
			}
			st.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return heroi;
	}
	public herois[] getHeroiFeminino() {
		herois[] heroi = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM personagens WHERE sexo = 'F'");
			if(rs.next()) {
				rs.last();
				heroi = new herois[rs.getRow()];
				rs.beforeFirst();
				
				for(int i = 0; rs.next(); i++) {
					heroi[i] = new herois(rs.getInt("id"), rs.getString("nome"), rs.getString("poder"), rs.getString("sexo").charAt(0));
				}
			}
			st.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return heroi;
	}
	
}
