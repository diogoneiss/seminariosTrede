public class Idades {

}

class Jogador {
	public int anoNasc;
	public int mesNasc;
	public int diaNasc;
	public String nome;

	//armazenará um double, que indica a idade da pessoal, mes e dia, para facilitar comparações
	public double coeficienteIdade;

	private boolean podeParticipar;

	/**
	 * 
	 * @param entrada MARCIO;05/10/2006
	 */
	public void inserirJogador(String entrada){
		//setar o coef de idades
		this.coeficienteIdade = 0;

		//dividir o arranjo em dois, pelo ;
		String arranjoParcial[] = entrada.split(";");
		this.nome = arranjoParcial[0];

		String arranjoData[] = arranjoParcial[1].split("/");
		//converter a string splitada em ints
		this.diaNasc = Integer.parseInt(arranjoData[0]);
		this.mesNasc = Integer.parseInt(arranjoData[1]);
		this.anoNasc = Integer.parseInt(arranjoData[2]);

		this.coeficienteIdade += this.anoNasc;
		System.out.println("Coeficiente de idade agora: "+coeficienteIdade + " para " + anoNasc);
		this.coeficienteIdade += this.mesNasc / 12;
		System.out.println("Coeficiente de idade agora: "+coeficienteIdade + " para " + mesNasc);
		this.coeficienteIdade += this.diaNasc / (12*30);
		System.out.println("Coeficiente de idade agora: "+coeficienteIdade + " para " + diaNasc);
	}
	public int compareTo(Jogador outro){
		int resultado = 1;
		/*
		if(this.anoNasc == outro.anoNasc){
			if(this.mesNasc == outro.mesNasc){
				if(this.diaNasc < outro.diaNasc)
					resultado = 1;
				else
					resultado = -1;
			}
			else if(this.mesNasc < outro.mesNasc){
				resultado = 1;
			}
			else{
				resultado = -1;
			}

		}
		else if(this.anoNasc < outro.anoNasc){
			resultado = 1;
		}else{
			resultado = -1;
		}*/
		return resultado;
	}
}
