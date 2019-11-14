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
		
		input.close();

	}
}

class Competidora {
	private int tempoProblema[];
	public int tempototal;
	public String nome;

	//armazenará um double, que indica a idade da pessoal, mes e dia, para facilitar comparações
	public int problemasFeitos;

	
	Competidora(String entrada){
		inserirCompetidora(entrada);
	}

	/**
	 * 
	 * @param entrada string completa da entrada
	 */
	public void inserirCompetidora(String entrada){
		
		//dividir o arranjo em dois, pelo ;
		String arranjoParcial[] = entrada.split(";");
		this.nome = arranjoParcial[0];
		System.out.println(nome);
		for (int i = 1; i < arranjoParcial.length; i++) {
			System.out.println(arranjoParcial[i]);
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
	
		int elementoEscolhido = 0;

		int respostas[] = calcularMelhoresTempos(conjunto);
		for (int i = respostas.length-1; i > 0; i--) {
			if(respostas[i] != 0){
				elementoEscolhido = i;
				i = 0;
			}
		}


		System.out.printf("%s\n", conjunto[elementoEscolhido].nome);
		System.out.printf("%d PROBLEMAS\n", conjunto[elementoEscolhido].problemasFeitos);
		System.out.printf("%d MINUTOS\n", conjunto[elementoEscolhido].tempototal);
	
	}
	private static int[] calcularMelhoresTempos(Competidora conjunto[]){
		int respostas[] = new int[6];
		int melhorPontuacao;
		int elementoMelhor;

		/**
		 * Armazena os melhores resultados para x problemas feitos, isto é,  0 problemas feitos, 1 problema feito, e ai em diante.
		 */

		for (int i = 0; i < respostas.length; i++) {
			melhorPontuacao = 120;
			elementoMelhor = 0;
			for (int j = 0; j < conjunto.length; j++) {
				if(conjunto[j].problemasFeitos == i && conjunto[j].tempototal < melhorPontuacao){
					elementoMelhor = j;

					melhorPontuacao = conjunto[elementoMelhor].tempototal;
					respostas[i] = elementoMelhor;
				}
			}
		}

		return respostas;
	}
}


