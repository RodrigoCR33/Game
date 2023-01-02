package jogo;

import java.awt.Graphics;

@SuppressWarnings("serial")

//Classe responsavel por fazer a animacao de levantar a bola

public class LevantaBola extends BolasCopos {
	
	int posicaoBolaLimpar;
	boolean clique = false;
	//Variavel para armazenar a posicao a da bola a ser levantada 
		private int posicaoBolaLevantar;

	//Funcao setPosicaoBolaLevantar
	public void setPosicaoBolaLevantar(int posicaoBolaLevantar) {
		
		this.posicaoBolaLevantar = posicaoBolaLevantar;
	}

	//Funcao que levanta a bola
	public void paintComponent(Graphics g) {
		//repeticao pinta a bola selecionada para cima		

			//Seleciona a bola clicada
			if (posicaoBolaLevantar != -1) {
				
				//Trecho de codigo que arruma caso o clique for em bolas disponiveis em seguida
				if (clique) {
					g.clearRect((posicoes[posicaoBolaLimpar].x), (posicoes[posicaoBolaLimpar].y-20), 50, 50);
					g.fillOval((posicoes[posicaoBolaLimpar].x), (posicoes[posicaoBolaLimpar].y), 50, 50);
				}
				
				//
				
				//apaga a bola em sua posicao inicia;
				g.clearRect((posicoes[posicaoBolaLevantar].x), (posicoes[posicaoBolaLevantar].y), 50, 50);

				//escolhe a cor
				g.setColor(coresPosicoes[posicaoBolaLevantar]);
								
				//pinta a bola com 20 pixels para cima
				g.fillOval((posicoes[posicaoBolaLevantar].x), (posicoes[posicaoBolaLevantar].y - 20), 50, 50);
				
				posicaoBolaLimpar = posicaoBolaLevantar;
				clique = true;
				
			} else {
				
				//apaga a bola pra cima
				if (clique) {
					g.clearRect((posicoes[posicaoBolaLimpar].x), (posicoes[posicaoBolaLimpar].y-20), 50, 55);
					g.fillOval((posicoes[posicaoBolaLimpar].x), (posicoes[posicaoBolaLimpar].y), 50, 50);
					
				}
			}
		
	}

}
