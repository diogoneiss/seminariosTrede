import java.util.Scanner;

/*
Coloca seu nome aqu, Tredão
*/

public class Idades {

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);
		//ler quantas entradas e o dia de hoje
		int quantidadeEntradas = input.nextInt();
		input.nextLine();
		String hoje = input.nextLine();

		//arranjo de entradas e de jogadores
		String entradas[] = new String[quantidadeEntradas];
		Jogador arranjoJogadores[] = new Jogador[quantidadeEntradas];

		Jogador.setarHoje(hoje);

		//percorrer os i elementos lendo entrada e criando os objetos
		//o construtor já executa tudo que é necessário
		for (int i = 0; i < quantidadeEntradas; i++) {
			entradas[i] = input.nextLine();
			arranjoJogadores[i] = new Jogador(entradas[i]);
			arranjoJogadores[i].validarParticipacao();
		}
		Jogador.mostrarCapitao(arranjoJogadores);
		input.close();

	}
}

class Jogador {
	public static double coeficienteHoje;
	public int anoNasc;
	public int mesNasc;
	public int diaNasc;
	public String nome;

	//armazenará um double, que indica a idade da pessoal, mes e dia, para facilitar comparações
	private double coeficienteIdade;
	public double idade;

	public boolean podeParticipar;
	
	Jogador(String entrada){
		inserirJogador(entrada);
	}

	/**
	 * 
	 * @param entrada string completa da entrada, no formato MARCIO;05/10/2006
	 */
	public void inserirJogador(String entrada){
		
		//dividir o arranjo em dois, pelo ;
		String arranjoParcial[] = entrada.split(";");
		this.nome = arranjoParcial[0];

		String arranjoData[] = arranjoParcial[1].split("/");
		//converter a string splitada em ints
		this.diaNasc = Integer.parseInt(arranjoData[0]);
		this.mesNasc = Integer.parseInt(arranjoData[1]);
		this.anoNasc = Integer.parseInt(arranjoData[2]);

		//setar o coef de idades
		this.coeficienteIdade = calcularCoeficiente(this.anoNasc, this.mesNasc, this.diaNasc);
		
	}
	private double calcularCoeficiente(int ano, int mes, int dia){
		double coeficienteCalculado = 0;		

		coeficienteCalculado += ano;
		//System.out.printf("Coeficiente de idade agora: %.5f, com ano %d\n",coeficienteCalculado ,ano);
		coeficienteCalculado += (double) mes / 12;
		//System.out.printf("Coeficiente de idade agora: %.5f, com mes %d \n",coeficienteCalculado , mes);
		coeficienteCalculado+= (double) dia / (12*30);
		//System.out.printf("Coeficiente de idade agora: %.5f, com dia %d\n",coeficienteCalculado, dia);

		return coeficienteCalculado;
	}
	
	public void validarParticipacao(){
		this.podeParticipar = true;
		this.idade = coeficienteHoje - coeficienteIdade;
		//System.out.println("Idade do "+this.nome+" é de "+(coeficienteHoje - this.coeficienteIdade));
		if(idade >= 15)
			this.podeParticipar = false;
		
		if(this.podeParticipar)
			System.out.println(this.nome);

	}
	
	public static void setarHoje(String entrada){
		//System.out.println("Entrada do dia de hoje: "+entrada);
		String arranjoData[] = entrada.split("/");
		//converter a string splitada em ints
		int dia = Integer.parseInt(arranjoData[0]);
		int mes = Integer.parseInt(arranjoData[1]);
		int ano = Integer.parseInt(arranjoData[2]);

		double coeficienteCalculado = 0;		

		coeficienteCalculado += ano;
		coeficienteCalculado += (double) mes / 12;
		coeficienteCalculado+= (double) dia / (12*30);
		
		coeficienteHoje = coeficienteCalculado;
	}
	public static void mostrarCapitao(Jogador conjunto[]){
		
		double maiorIdade = 0;
		String capitao = "";
		for (Jogador elemento : conjunto) {
			if(elemento.podeParticipar && elemento.idade > maiorIdade ){
				maiorIdade = elemento.idade;
				capitao = elemento.nome;
			}
		}

		System.out.println("CAPITAO: "+capitao);
	}
}


