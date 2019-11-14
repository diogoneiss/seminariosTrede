import java.util.Scanner;

/*
Coloca seu nome aqu, Tredão
*/

public class Programadoras {

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);
		//ler quantas entradas e o dia de hoje
		int quantidadeEntradas = input.nextInt();
		input.nextLine();
		//arranjo de entradas e de Competidoras
		String entradas[] = new String[quantidadeEntradas];
		Competidora arranjoCompetidoraes[] = new Competidora[quantidadeEntradas];

		//percorrer os i elementos lendo entrada e criando os objetos
		//o construtor já executa tudo que é necessário
		for (int i = 0; i < quantidadeEntradas; i++) {
			entradas[i] = input.nextLine();
			arranjoCompetidoraes[i] = new Competidora(entradas[i]);
			arranjoCompetidoraes[i].calcularAproveitamento();
		}
		Competidora.mostrarMaiorPontuador(arranjoCompetidoraes);
		input.close();

	}
}

class Competidora {
	private int tempoProblema[];
	public int tempototal;
	public String nome;

	public int problemasFeitos;

	
	Competidora(String entrada){
		inserirCompetidora(entrada);
	}
	public void imprimir(){
		System.out.println("Nome+ "+nome);
		System.out.println("Tempo total+ "+tempototal);
		System.out.println("Problemas feitos+ "+problemasFeitos);
		System.out.println();
	}
	/**
	 * 
	 * @param entrada string completa da entrada
	 */
	public void inserirCompetidora(String entrada){

		this.tempoProblema = new int[6];

		//dividir o arranjo em dois, pelo ;
		String arranjoParcial[] = entrada.split(";");
		this.nome = arranjoParcial[0];
		for (int i = 1; i < arranjoParcial.length; i++) {
			this.tempoProblema[i-1] = Integer.parseInt(arranjoParcial[i]);
		}		
		this.problemasFeitos = 6;
	}
	
	public void calcularAproveitamento(){
		int total = 0;
		//fazer as medias
		for (int i : this.tempoProblema) {
			total += i;
			if(i == 0){
				this.problemasFeitos--;
			}
		}
		this.tempototal = total;
	}

	
	public static void mostrarMaiorPontuador(Competidora conjunto[]){
		int resposta = calcularMelhoresTempos(conjunto);

		System.out.printf("%s\n", conjunto[resposta].nome);
		System.out.printf("%d PROBLEMAS\n", conjunto[resposta].problemasFeitos);
		System.out.printf("%d MINUTOS\n", conjunto[resposta].tempototal);
	}
	//retorna a pos no arranjo que o melhor tempo está
	private static int calcularMelhoresTempos(Competidora conjunto[]){
		int maiorNumProblemas = 0;
		int melhorPontuacao = 120;
		int elementoMelhor = 0;

		//achar maior numero de problemas resolvidos
		for (int i = 0; i < conjunto.length; i++) {
			if(conjunto[i].problemasFeitos > maiorNumProblemas){
				maiorNumProblemas = conjunto[i].problemasFeitos;
			}
		}

		//achar a posicao com o melhor elemento para aquele num de problemas
		for (int j = 0; j < conjunto.length; j++) {
			if(conjunto[j].problemasFeitos == maiorNumProblemas && conjunto[j].tempototal < melhorPontuacao){
					elementoMelhor = j;
					melhorPontuacao = conjunto[elementoMelhor].tempototal;	
			}
		}
		
		return elementoMelhor;
	}
}


