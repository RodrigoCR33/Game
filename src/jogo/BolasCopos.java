package jogo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")

//Clase responsavel por desenhar os copos, gerar as posicoes das bolas, as cores de cada uma e pinta-las

public class BolasCopos extends JPanel {

	// Quantidade de copos a serem gerados
	protected static int qtdCopos = 8;

	// Quantidade de bolas a serem geradas
	protected static int qtdBolas = qtdCopos * 4;
	
	// Cores a serem utilizadas
	protected static Color[] cores = {Color.red, Color.pink, Color.blue, Color.green, Color.yellow, Color.gray, Color.cyan, Color.magenta, Color.getHSBColor(15, 100, 100), Color.white};

	// Variavel que controla a quantidade maxima de cores nas bolas
	private int[] contadores = new int[qtdBolas];

	// Variavel da cor da bola a ser pintada
	private Color color = Color.black;

	// Variavel das posicoes das bolas na tela
	protected static Point[] posicoes = new Point[qtdBolas];

	// Variavel que grava a cor das bolas por posicao
	protected static Color[] coresPosicoes = new Color[qtdBolas];

	// Variavel da imagem do copo
	private BufferedImage image;

	// Construtor que grava as posicoes automaticamente e salva a var
	BolasCopos(int qtdCopos) {
		
		BolasCopos.qtdCopos = qtdCopos;
		
		// Grava as posicoes das bolas na tela
		gravarPosicoes();
		
		// Zera os contadores de quantidade de cor
		zerarContadores();
		
		// Salva a variavel do copo
		try {
			// Copo:
			image = ImageIO.read(new File("copo.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// funcao para desenhar as bolas e os copos na tela
	public void paintComponent(Graphics g) {
		
		// Desenha os copos
		desenhaCopos(g);

		// Desenha as bolas
		desenhaBolas(g, posicoes);
	}
	

	// funcao para gravar as posicoes das bolas
	private void gravarPosicoes() {

		int espacamento = 180;
		int[] coordenadasY = { 75, 125, 175, 225, 335, 385, 435, 485 };

		for (int i = 0; i < qtdCopos / 2; i++) {
			int x = 80 + i * espacamento;

			for (int j = 0; j < coordenadasY.length; j++) {
				BolasCopos.posicoes[i + j * qtdCopos / 2] = new Point(x, coordenadasY[j]);

			}
		}
	}

	// funcao para zerar Contadores
	private void zerarContadores() {
		for (int i = 0; i < qtdBolas; i++) {
			this.contadores[i] = 0;
		}
	}
	
	// Funcao que define as cores das bolas
	private Color gravarCores(int i, Color[] cores) {

		color = Color.black;

		int[] indicesCoposVazios = {qtdBolas - (qtdCopos+2+qtdCopos/2), qtdBolas - (qtdCopos+1+qtdCopos/2), qtdBolas - (qtdCopos+2), qtdBolas - (qtdCopos+1), qtdBolas - (qtdCopos/2+2), qtdBolas - (qtdCopos/2+1), qtdBolas - 2, qtdBolas - 1};

		for (int indice : indicesCoposVazios) {
		    if (i == indice) {
		        return Color.black;
		    }
		}

		double random = Math.round(Math.random() * (qtdCopos - 3));
		
		if (this.contadores[(int) random] < 4) {
		    this.contadores[(int) random]++;
		    return cores[(int) random];
		}
		
		if (color == Color.black) {
			for (int j = 0; j < this.contadores.length; j++) {
				if (contadores[j] < (qtdCopos / 2)) {
					contadores[j]++;
					return color = cores[j];

				}
			}		
		}
		
		return color = Color.black;

	}

	// Desenhar Copos
	private void desenhaCopos(Graphics g) {

		super.paintComponent(g);

		// Desenha os copos
		for (int i = 0; i < (qtdCopos / 2); i++) {
			// Copos superiores
			g.drawImage(image, 9 + (180 * i), 25, null);
			// Copos inferiores
			g.drawImage(image, 9 + (180 * i), 285, null);

		}
	}

	// Desenhar Bolas
	private void desenhaBolas(Graphics g, Point[] posicoes) {
		for (int i = 0; i < qtdBolas; i++) {

			// Obtem a cor da bola a ser pintada
			Color cor = gravarCores(i, cores);

			// Define a cor da bola a ser pintada
			BolasCopos.coresPosicoes[i] = cor;

			// define a cor para o desenho
			g.setColor(cor);

			// desenha a bola com coordenadas e tamanho
			g.fillOval((posicoes[i].x), (posicoes[i].y), 50, 50);

		}
	}

	// GetPosicoes
	public static Point[] getPosicoes() {
		// System.out.println("Posicao: "+posicoes[0]);
		return posicoes;
	}

	// GetCoresDasPosicoes
	public Color[] getCoresPosicoes() {
		// System.out.println("Cor: "+coresPosicoes[0]);
		return coresPosicoes;
	}
}
