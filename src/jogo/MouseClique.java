package jogo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MouseClique extends BolasCopos {

	MouseClique(int qtdCopos) {
		super(qtdCopos);
		// TODO Auto-generated constructor stub
	}

	// Instancia classe que transfere as bolas entre os copos
	private TransfereBola transfereBola = new TransfereBola();

	// Instancia Classe que levanta as bolas
	private LevantaBola levantaBola = new LevantaBola(qtdCopos);

	// Controle de lógica do clique
	boolean bolaSelecionada;
	boolean bolaClicada;
	boolean copoClicado;
	boolean bolaAtiva;
	boolean cliquefora;
	//

	public void mouseClique(JFrame janela, Graphics g, Color[] coresPosicoes) {
		

		// Evento do mouse
		janela.addMouseListener((MouseListener) new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

				// Levanta a bola que foi clicada
				levantaBola.setPosicaoBolaLevantar(posicaoClique(e));
				levantaBola.paintComponent(g);
				//

				// Mecanica para passar bola

				if (bolaSelecionada) {
					// Bola selecionada

					if (bolaClicada) {
						// Outra bola clicada
						colunaClique(e);

						if (cliquefora) {
							// Clique fora do copo
							cliquefora = false;
							bolaSelecionada = false;
							bolaClicada = false;

						} else {
							// Clique dentro do copo
							transfereBola.paintComponent(g, colunaClique(e));
							cliquefora = false;
							bolaSelecionada = false;
							bolaClicada = false;
						}

					} else {
						// Passa a posicao do clique da bola que nao passou
						transfereBola.posicaoClique(posicaoClique(e));

					}
				}
			}
		});
	}

	// Funcao que descobre a posicao do clique
	int posicaoClique(MouseEvent e) {

		for (int i = 0; i < 4; i++) {

			if ((e.getX() > 80 + (180 * i) && e.getX() < 135 + (180 * i)) && (e.getY() > 75 && e.getY() < 125)
					&& (coresPosicoes[i] != Color.black)) {
				// System.out.println("bola " + i);
				bolaSelecionada = true;
				return i;
			}

			if ((e.getX() > 80 + (180 * i) && e.getX() < 135 + (180 * i)) && (e.getY() > 125 && e.getY() < 175)
					&& coresPosicoes[i] == Color.black && (coresPosicoes[i + 4] != Color.black)) {
				// System.out.println("bola " + (i + 4));
				bolaSelecionada = true;
				return i + 4;
			}

			if ((e.getX() > 80 + (180 * i) && e.getX() < 135 + (180 * i)) && (e.getY() > 175 && e.getY() < 225)
					&& coresPosicoes[i + 4] == Color.black && (coresPosicoes[i + 8] != Color.black)) {
				// System.out.println("bola " + (i + 8));
				bolaSelecionada = true;
				return i + 8;
			}

			if ((e.getX() > 80 + (180 * i) && e.getX() < 135 + (180 * i)) && (e.getY() > 225 && e.getY() < 275)
					&& coresPosicoes[i + 8] == Color.black && (coresPosicoes[i + 12] != Color.black)) {
				// System.out.println("bola " + (i + 12));
				bolaSelecionada = true;
				return i + 12;
			}

			// Parte de baixo

			if ((e.getX() > 80 + (180 * i) && e.getX() < 135 + (180 * i)) && (e.getY() > 325 && e.getY() < 375)
					&& (coresPosicoes[i + 16] != Color.black)) {
				// System.out.println("bola " + (i + 16));
				bolaSelecionada = true;
				return i + 16;
			}

			if ((e.getX() > 80 + (180 * i) && e.getX() < 135 + (180 * i)) && (e.getY() > 375 && e.getY() < 425)
					&& coresPosicoes[i + 16] == Color.black && (coresPosicoes[i + 20] != Color.black)) {
				// System.out.println("bola " + (i + 20));
				bolaSelecionada = true;
				return i + 20;
			}

			if ((e.getX() > 80 + (180 * i) && e.getX() < 135 + (180 * i)) && (e.getY() > 425 && e.getY() < 475)
					&& coresPosicoes[i + 20] == Color.black && (coresPosicoes[i + 24] != Color.black)) {
				// System.out.println("bola " + (i + 24));
				bolaSelecionada = true;
				return i + 24;
			}

			if ((e.getX() > 80 + (180 * i) && e.getX() < 135 + (180 * i)) && (e.getY() > 475 && e.getY() < 525)
					&& coresPosicoes[i + 24] == Color.black && (coresPosicoes[i + 28] != Color.black)) {
				// System.out.println("bola " + (i + 28));
				bolaSelecionada = true;
				return i + 28;
			}

		}

		if (bolaSelecionada) {
			bolaClicada = true;
		}

		return -1;
	}

	// Funcao que descobre o copo do clique
	int colunaClique(MouseEvent e) {

		// copo 1
		if (e.getX() > 60 && e.getX() < 150 && e.getY() > 60 && e.getY() < 280) {
			return 0;
		}

		// copo 2
		if (e.getX() > 240 && e.getX() < 330 && e.getY() > 60 && e.getY() < 280) {
			return 1;
		}

		// copo 3
		if (e.getX() > 390 && e.getX() < 480 && e.getY() > 60 && e.getY() < 280) {
			return 2;
		}

		// copo 4
		if (e.getX() > 600 && e.getX() < 690 && e.getY() > 60 && e.getY() < 280) {

			return 3;
		}

		// Parte de baixo

		// copo 5
		if (e.getX() > 60 && e.getX() < 150 && e.getY() > 320 && e.getY() < 540) {
			return 4;
		}

		// copo 6
		if (e.getX() > 240 && e.getX() < 330 && e.getY() > 320 && e.getY() < 540) {
			return 5;
		}

		// copo 7
		if (e.getX() > 390 && e.getX() < 480 && e.getY() > 320 && e.getY() < 540) {
			return 6;
		}

		// copo 8
		if (e.getX() > 600 && e.getX() < 690 && e.getY() > 320 && e.getY() < 540) {
			return 7;
		}

		cliquefora = true;
		return -1;
	}
}
