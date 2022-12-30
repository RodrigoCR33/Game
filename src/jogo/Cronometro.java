package jogo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Cronometro extends BolasCopos {

	Cronometro(int qtdCopos) {
		super(qtdCopos);
		// TODO Auto-generated constructor stub
	}

	// Variável para armazenar o tempo decorrido, iniciando em 0
	private int tempo = 0;

	private int coposCheios = 0;

	@SuppressWarnings("unused")
	private Timer timer;

	// Componente de texto para exibir o tempo
	private JLabel labelTempo = new JLabel("Tempo: 0s");
	private JLabel parabens = new JLabel("Parabens!!!");

	public void iniciarCronometro(JPanel painel) {

		// Muda a cor do cronometro
		labelTempo.setForeground(Color.white);

		// Posiciona o cronometro
		labelTempo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTempo.setBorder(new EmptyBorder(0, 0, 15, 0));
		//
		
		// Muda a cor do texto
		parabens.setForeground(Color.green);
		// Posiciona o texto no centro
		parabens.setHorizontalAlignment(SwingConstants.CENTER);

		// Adiciona o componente de texto ao painel de conteúdo da janela
		painel.add(labelTempo, BorderLayout.SOUTH);

		// Cria um timer para atualizar o cronômetro a cada segundo
		this.timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Acrescenta 1 segundo
				tempo++;
				
				// Texto tempo
				labelTempo.setText("Tempo: " + tempo + "s");
				
				//Checa se os copos estao cheios com as cores certas
				checarCopos(painel);

			}
		});

		// Inicia o cronometro
		this.timer.start();

	}
	
	// Funçao para checar se os copos estao cheios de bolas com cores iguais
	void checarCopos(JPanel painel) {
		
		for (int i = 0; i < qtdCopos; i++) {
			
			// Zera a quantidade de copos cheios a cada repetiçao
			if (i == 0) {
				coposCheios = 0;
				
			}
			
			// Copos superiores
			if (coresPosicoes[i] == coresPosicoes[i + qtdCopos / 2] 
					&& coresPosicoes[i] == coresPosicoes[i + qtdCopos]
					&& coresPosicoes[i] == coresPosicoes[i + qtdCopos + qtdCopos / 2]) {
				coposCheios++;
			}
			
			// Copos inferiores
			if (coresPosicoes[(i + 12)] == coresPosicoes[(i + 12) + qtdCopos / 2] && 
					coresPosicoes[(i + 12)] == coresPosicoes[(i + 12) + qtdCopos] && 
					coresPosicoes[(i + 12)] == coresPosicoes[(i + 12) + qtdCopos + qtdCopos / 2]) {
				coposCheios++;
			}
			
			// Para o cronometro e exibe a mensagem de parabens
			if (coposCheios == qtdCopos) {
				timer.stop();
				painel.add(parabens, BorderLayout.SOUTH);
			}
			
		}
	}
}