
public class principal {

	public static void main(String[] args) {
		DAO dao = new DAO();
		dao.conectar();
		
		herois heroi = new herois(1, "He-man", "a força", 'M');
		if(dao.inserirPersonagem(heroi) == true) {
			System.out.println("Inserção com sucesso -> " + heroi.toString());
		}

		herois[] heroiS = dao.getHeroi();
		System.out.println("MOSTRAR HEROIS");
		for(int i = 0; i < heroiS.length; i++) {
			System.out.println(heroiS[i].toString());
			System.out.println("\n");
		}
		
		heroi.setPoder("super força");
		dao.updateHeroi(heroi);
		
		herois[] heroiM = dao.getHeroiMasculino();
		System.out.println("MOSTRAR HEROIS");
		for(int i = 0; i < heroiM.length; i++) {
			System.out.println(heroiM[i].toString());
			System.out.println("\n");
		}
		herois[] heroiF = dao.getHeroiFeminino();
		System.out.println("MOSTRAR HEROIS");
		for(int i = 0; i < heroiF.length; i++) {
			System.out.println(heroiF[i].toString());
			System.out.println("\n");
		}
	}
}
