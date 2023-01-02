package jogo;

import java.awt.Graphics;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		
		//	Cria a janela
		Janela janela = new Janela();
		
		//	Get jframe
		JFrame jframe = janela.getJFrame();
		
		//	Get objeto Graphics
		Graphics g = jframe.getGraphics();	
		
		//	Instancia a classe que cria as bolas e os copos
		BolasCopos bolasCopos = new BolasCopos();
		
		//	Pinta as bolas e os copos
		bolasCopos.paintComponent(g);
		
		//	Adiciona o cronometro na janela
		janela.adicionaCronometro();
		
		//	Instancia a classe que reconhece o clique do mouse e executa as mecanicas
		MouseClique mouseClique = new MouseClique();
		mouseClique.mouseClique(jframe, g, bolasCopos.getCoresPosicoes());
		
	}

	
}
