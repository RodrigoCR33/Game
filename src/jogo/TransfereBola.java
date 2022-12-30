package jogo;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class TransfereBola extends BolasCopos {
	
	TransfereBola() {
		super(qtdCopos);
		// TODO Auto-generated constructor stub
	}

	// Posicao do clique
	private int posicaoClique = 0;

	// Controle se a bola transferiu
	boolean controle;

	// Construtor

	// Funcao que realiza a transferencia da bola
	public void paintComponent(Graphics g, int copo) {


		// Começa com o controle de se a bola foi transferida como True
		controle = true;

		// Checa se o copo esta vazio para fazer a transferencia
		for (int i = 0; i < qtdCopos; i++) {

			// Checa o copo em que foi dado o clique
			if (i == copo) {
				// System.out.println("Copo: " + copo);

				if (i < qtdCopos/2) {

					// Checa se a ultima bola do copo esta vazia para realizar a transferencia
					if (coresPosicoes[i + 12] == Color.black) {
						transfere((i + 12), g);
						break;

					} else {

						// Checa se a penultima bola do copo esta vazia para realizar a transferencia
						if (coresPosicoes[i + 8] == Color.black && coresPosicoes[i + 12] == coresPosicoes[posicaoClique]
								&& posicaoClique != i + 12) {
							transfere((i + 8), g);
							break;

						} else {

							// Checa se a segunda bola do copo esta vazia para realizar a transferencia
							if (coresPosicoes[i + 4] == Color.black
									&& coresPosicoes[i + 8] == coresPosicoes[posicaoClique] && posicaoClique != i + 8) {
								transfere((i + 4), g);
								break;

							} else {

								// Checa se a primeira bola do copo esta vazia para realizar a transferencia
								if (coresPosicoes[i] == Color.black
										&& coresPosicoes[i + 4] == coresPosicoes[posicaoClique]
										&& posicaoClique != i + 4) {

									transfere((i), g);
									break;

								} else {
									// Pinta a bola que foi selecionada mas nao realizou transferencia
									
									Color corSelecionada = (coresPosicoes[posicaoClique]);
									g.setColor(corSelecionada);
									g.fillOval((posicoes[posicaoClique].x), (posicoes[posicaoClique].y), 50, 50);
									BolasCopos.coresPosicoes[posicaoClique] = corSelecionada;
									controle = false;
									break;

									//

								}
							}
						}
					}
				} else {
					
					if (coresPosicoes[i + 24] == Color.black) {
						transfere((i + 24), g);
						break;

					} else {

						if (coresPosicoes[i + 20] == Color.black
								&& coresPosicoes[i + 24] == coresPosicoes[posicaoClique] && posicaoClique != i + 24) {
							transfere((i + 20), g);
							break;

						} else {
							if (coresPosicoes[i + 16] == Color.black
									&& coresPosicoes[i + 20] == coresPosicoes[posicaoClique]
									&& posicaoClique != i + 20) {
								transfere((i + 16), g);
								break;

							} else {
								if (coresPosicoes[i + 12] == Color.black
										&& coresPosicoes[i + 16] == coresPosicoes[posicaoClique]
										&& posicaoClique != i + 16) {
									transfere((i + 12), g);
									break;

								} else {
									Color corSelecionada = (coresPosicoes[posicaoClique]);

									 System.out.println("Cor selecionada: "+corSelecionada);
									g.setColor(corSelecionada);

									g.fillOval((posicoes[posicaoClique].x), (posicoes[posicaoClique].y), 50, 50);
									// System.out.println("Posicao pintada: "+posicaoClique);

									BolasCopos.coresPosicoes[posicaoClique] = corSelecionada;
									controle = false;
									break;
								}
							}
						}
					}
				}

			}

		}

		// Pinta a posicao da bola que foi transferida de preto
		if (controle) {
			BolasCopos.coresPosicoes[posicaoClique] = Color.black;
			g.setColor(Color.black);
			g.fillOval((posicoes[posicaoClique].x-5), (posicoes[posicaoClique].y-20), 60, 70);

		}

	}

	// Funcao que pinta a bola disponivel no copo
	private void transfere(int i, Graphics g) {
		g.setColor(coresPosicoes[posicaoClique]);
		g.fillOval((posicoes[i].x), (posicoes[i].y), 50, 50);
		BolasCopos.coresPosicoes[i] = coresPosicoes[posicaoClique];
	}

	// Set posicao clique
	public void posicaoClique(int posicaoClique) {

		this.posicaoClique = posicaoClique;
	}

}
