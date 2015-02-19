package com.gps.funnymath.game;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.gps.funnymath.gameDialogs.AddProblemPass_dialog;
import com.gps.funnymath.gameDialogs.InserirNome_dialog;
import com.gps.funnymath.main.Global;

public class Game {
	
	protected JFrame FunnyMathUI;	
	protected String background; //alterar depois para background activo ou assim

		
	public Game(JFrame FunnyMathUI) {
		
		this.FunnyMathUI=FunnyMathUI;	
	
	}
	
		
	 public void showBackground()
	 {
		 		
			try {
			   FunnyMathUI.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(background)))));
			} catch (IOException e) {
				// TODO se a imagem não existir...
				e.printStackTrace();
			}
	    	
	 } 
	 
	 
	 public void showMenuBars()
	 {
						
			JMenuBar menuBar = new JMenuBar();
			FunnyMathUI.setJMenuBar(menuBar);
			
//Menu: Jogo			
			JMenu mnJogo = new JMenu("Jogo");
			mnJogo.setFont(new Font("Verdana", Font.PLAIN, 14));
			menuBar.add(mnJogo);

//Menu: Jogo -> Iniciar
			JMenuItem mntmIniciar = new JMenuItem("Iniciar");
			mntmIniciar.setFont(new Font("Verdana", Font.PLAIN, 14));
			mnJogo.add(mntmIniciar);
			
			mntmIniciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) { 
					InserirNome_dialog dialog;
					do{
						dialog = new InserirNome_dialog(); //TODO melhorar...
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					}while(!dialog.getValid() && !dialog.getCanceled());
				 						 	
					
					if(!dialog.getCanceled())
					   	new NovoJogo(FunnyMathUI,Global.nome,Global.genero);
					
				}
			});

//Menu: Jogo -> Sair (falta na janela confirmar)
			JMenuItem mntmSair = new JMenuItem("Sair");
			mntmSair.setFont(new Font("Verdana", Font.PLAIN, 14));
			mnJogo.add(mntmSair);
			
			mntmSair.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent evt) {	
					   if(JOptionPane.showConfirmDialog(FunnyMathUI, "Tem a certeza que deseja sair ?","Sair", JOptionPane.OK_CANCEL_OPTION)
							   == JOptionPane.OK_OPTION)
						   System.exit(0);
				   }
			});

//Menu: Premios TODO
			JMenu mnPrmios = new JMenu("Pr\u00E9mios");
			mnPrmios.setFont(new Font("Verdana", Font.PLAIN, 14));
			menuBar.add(mnPrmios);			
			
			mnPrmios.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {	
					
				new Janela_Premios(); //Nova Janela
				  
				}			
			});
			
//Menu: Pontuacoes TODO
			JMenu mnNPontuacoes = new JMenu("Pontua\u00E7\u00F5es");
			mnNPontuacoes.setFont(new Font("Verdana", Font.PLAIN, 14));
			menuBar.add(mnNPontuacoes);
			
			mnNPontuacoes.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {	
					
					   new Janela_Pontuacoes(); //Nova Janela
				   }
			});
			

			
			JMenu mnEditorDeProblemas = new JMenu("Adicionar Problemas");
			mnEditorDeProblemas.setFont(new Font("Verdana", Font.PLAIN, 14));			
			menuBar.add(mnEditorDeProblemas);	
			
			mnEditorDeProblemas.addMouseListener(new MouseAdapter() {
				   
				public void mouseClicked(MouseEvent evt) {					   
					   
					   AddProblemPass_dialog dialog = new AddProblemPass_dialog();
					   dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					   dialog.setVisible(true);			   
					   
					   
					   if(dialog.getChecked())
						   new AdicionarProblemas(FunnyMathUI);
						
				}
			});				
	 }
	 
	 public void botaoSair() //volta ao menu
	 {
		 	JButton btnSair = new JButton();
			btnSair.setIcon(new ImageIcon("images/imgbutton/botaoSair.png"));	
			btnSair.setBounds(50, 450, 150, 50);
			FunnyMathUI.getContentPane().add(btnSair);
				
			btnSair.addActionListener(new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {	
						  							
									   if(JOptionPane.showConfirmDialog(FunnyMathUI, "Tem a certeza que deseja sair do jogo?","Terminar Jogo", JOptionPane.OK_CANCEL_OPTION)
											   == JOptionPane.OK_OPTION){
										   verificaSavePontuacao(Global.pontuacao);										   
											new GameMenu(FunnyMathUI);	
									   }
									   
									   //TODO LIMPAR TUDO OU SALVAR KK COISA
								   }
							});
	
	 }
	 
	 private void verificaSavePontuacao(int pontos){
		 Pontuacao p; 
		 System.out.println("Pontos = "+pontos);
		 if(Global.pontuacoes.size()<10){
			 p = new Pontuacao(Global.pontuacao,Global.nome);
			 Global.pontuacoes.add(p);
		 }else
			 if(pontos > Global.pontuacoes.get(9).getPontos()){				 
				 p = new Pontuacao(Global.pontuacao,Global.nome);
				 Global.pontuacoes.remove(9);
				 Global.pontuacoes.add(p);
			 }
		 
		 
		 sortArray();	
		 Global.pontuacao = -1;
		 Global.genero = -1;
		 Global.nome = "";
			 
	 }
	 private void sortArray(){		
			boolean houveTroca = true;
			 
	        while (houveTroca) {
	                houveTroca = false;
	                for (int i = 0; i < Global.pontuacoes.size()-1; i++){
	                        if (Global.pontuacoes.get(i).getPontos() < Global.pontuacoes.get(i+1).getPontos()){
	                                Pontuacao variavelAuxiliar = Global.pontuacoes.get(i+1);
	                                Global.pontuacoes.set(i+1, Global.pontuacoes.get(i));
	                                Global.pontuacoes.set(i, variavelAuxiliar);
	                                houveTroca = true;
	                        }
	                }
	        } 
		}
	 
	 public void limpatudo()
	{	
		 FunnyMathUI.removeAll(); //limpa tudo do menu
		 FunnyMathUI.revalidate();
		 FunnyMathUI.repaint();
		   
	}

	 public void refresh()
	 {
		FunnyMathUI.setVisible(true);			
		FunnyMathUI.repaint();
	 }


	public JFrame getFunnyMathUI() {
		return FunnyMathUI;
	}



	public void setFunnyMathUI(JFrame funnyMathUI) {
		FunnyMathUI = funnyMathUI;
	}



	public String getBackground() {
		return background;
	}



	public void setBackground(String background) {
		this.background = background;
		showBackground();
	}


}

		
	


