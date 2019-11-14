import java.util.Scanner;

/*
Coloca seu nome aqu, Tredão
*/

public class Basquete {

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);
		//ler quantas entradas e o dia de hoje
		int quantidadeEntradas = input.nextInt();
		input.nextLine();
		//arranjo de entradas e de jogadores
		String entradas[] = new String[quantidadeEntradas];
		Jogador arranjoJogadores[] = new Jogador[quantidadeEntradas];

		//percorrer os i elementos lendo entrada e criando os objetos
		//o construtor já executa tudo que é necessário
		for (int i = 0; i < quantidadeEntradas; i++) {
			entradas[i] = input.nextLine();
			arranjoJogadores[i] = new Jogador(entradas[i]);
			arranjoJogadores[i].calcularAproveitamento();
			arranjoJogadores[i].calcularPontuacao();
		}
		Jogador.mostrarMaiorPontuador(arranjoJogadores);
		Jogador.mostrarMaiorAproveitamento(arranjoJogadores);
		input.close();

	}
}

class Jogador {
	private int cestas1[];
	private int cestas2[];
	private int cestas3[];
	public String nome;

	//armazenará um double, que indica a idade da pessoal, mes e dia, para facilitar comparações
	public double aproveitamento;
	public int pontuacao;

	
	Jogador(String entrada){
		inserirJogador(entrada);
	}

	/**
	 * 
	 * @param entrada string completa da entrada
	 */
	public void inserirJogador(String entrada){
		
		//dividir o arranjo em dois, pelo ;
		String arranjoParcial[] = entrada.split(";");
		this.nome = arranjoParcial[0];
		this.cestas1 = splitarPontuacaoCesta(arranjoParcial[1]);
		this.cestas2 = splitarPontuacaoCesta(arranjoParcial[2]);
		this.cestas3 = splitarPontuacaoCesta(arranjoParcial[3]);		
	}

	private int[] splitarPontuacaoCesta(String linha){
		String arranjo[] = linha.split("-");

		int arranjoInteiros[] = new int[arranjo.length];

		for (int i = 0; i < arranjo.length; i++) {
			arranjoInteiros[i] = Integer.parseInt(arranjo[i]);
		}

		return arranjoInteiros;
	}
	
	public void calcularPontuacao(){
		int totalPontos = 0;
		totalPontos += this.cestas1[1] + this.cestas2[1]*2 + this.cestas3[1]*3; 
		this.pontuacao = totalPontos;
	}
	
	public void calcularAproveitamento(){
		double total = 0;
		double elementosTotal = 0;
		//fazer as medias
		

		total += this.cestas1[1] + this.cestas2[1] + this.cestas3[1];
		elementosTotal += this.cestas1[0] + this.cestas2[0] + this.cestas3[0];

		this.aproveitamento = total / elementosTotal;
	}

	
	public static void mostrarMaiorPontuador(Jogador conjunto[]){
		
		int maiorPontuacao = 0;
		int elementoMaior = 0;
		for (int i = 0; i < conjunto.length; i++) {
			if(conjunto[i].pontuacao > maiorPontuacao){
				elementoMaior = i;
				maiorPontuacao = conjunto[i].pontuacao;
			}
		}

		System.out.printf("%s %d PONTOS\n", conjunto[elementoMaior].nome, conjunto[elementoMaior].pontuacao);
	
	}
	public static void mostrarMaiorAproveitamento(Jogador conjunto[]){
		
		double maiorAproveitamento = 0;
		int elementoMaior = 0;
		for (int i = 0; i < conjunto.length; i++) {
			if(conjunto[i].aproveitamento > maiorAproveitamento){
				elementoMaior = i;
				maiorAproveitamento = conjunto[i].aproveitamento;
			}
		}

		System.out.printf("%s %.2f %%\n", conjunto[elementoMaior].nome, conjunto[elementoMaior].aproveitamento*100);
	}
}


