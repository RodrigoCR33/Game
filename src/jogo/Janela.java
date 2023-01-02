package jogo;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Janela {
	
	//Jframe
	private JFrame janela = new JFrame();
	
	//Largura e altura da janela
	private int larguraJanela;
	private int alturaJanela = 600;
	
	//Painel no Jframe
	private JPanel painel = new JPanel(new BorderLayout());
	
	//Qtd copos
	private int qtdCopos;
	
	//Metodo construtor
	Janela(int qtdCopos) {
		this.qtdCopos = qtdCopos;
	    this.larguraJanela = 355 + (qtdCopos*50);
		this.painel.setBackground(Color.black); // Define a cor de fundo do painel
		this.janela.setBackground(Color.black); // Define a cor de fundo da janela
		this.janela.setContentPane(painel); // Define painel principal
	    this.janela.setSize(larguraJanela, alturaJanela); // Altura e largura da Janela
	    this.janela.setLocationRelativeTo(null); // Centraliza a janela ao abrir
	    this.janela.setResizable(false); // Não pode ser redimensionada
	    this.janela.setVisible(true); // Visivel true
	    this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit on close
	    }
	
	//Adiciona o cronometro ao Painel
	void adicionaCronometro() {
		Cronometro cronometro = new Cronometro(qtdCopos);
		cronometro.iniciarCronometro(painel);
	}
	
	//GetJframe
	JFrame getJFrame() {	
		return this.janela;	
	}
	
	//SetLargura
	void setLargura(int largura) {
		this.larguraJanela = largura;
	}
	
}
