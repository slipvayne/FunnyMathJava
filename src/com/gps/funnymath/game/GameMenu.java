package com.gps.funnymath.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.gps.funnymath.IO.Saves;
import com.gps.funnymath.gameDialogs.InserirNome_dialog;
import com.gps.funnymath.main.Global;
import com.gps.funnymath.game.TrackRewards;



public class GameMenu extends Game {
		
	private Saves save;
	private TrackRewards trackRewards; //para saber quantos problemas ja resolveu, para desbloquear os rewards

	public GameMenu(JFrame FunnyMathUI) {
		
		super(FunnyMathUI);
		
		save = new Saves(FunnyMathUI);		
		trackRewards = new TrackRewards();
		
		if(trackRewards.getCurrentReward().equals(" ") == false) //acho que no main menu tb pode ser
			setBackground(trackRewards.getCurrentReward());
		else
			setBackground(Global.background_mainmenu_default);
		
		showMenuBars();    
		showButtonsMenu();
		
		refresh();
			
	}
			
	 
	 
	 public void showButtonsMenu()
	 {
		
	 
	//Podia ser so uma imagem.. mas é mais simples usar um botao assim
	//LOGO FUNNY MATH
			JButton btnLogoFunnyMath = new JButton();
			btnLogoFunnyMath.setBounds(25, 60, 380, 45);
			btnLogoFunnyMath.setIcon(new ImageIcon("images/icon/customLogo.png"));
			btnLogoFunnyMath.setEnabled(false);
			btnLogoFunnyMath.setBorder(BorderFactory.createRaisedBevelBorder());
			btnLogoFunnyMath.setDisabledIcon(new ImageIcon("images/icon/customLogo.png"));
			FunnyMathUI.getContentPane().add(btnLogoFunnyMath);
			
   //BUTTON NOVO JOGO
			JButton btnNovoJogo = new JButton();
			btnNovoJogo.setIcon(new ImageIcon("images/imgbutton/novoJogo.png"));
			btnNovoJogo.setBounds(108, 150, 200, 50);
			FunnyMathUI.getContentPane().add(btnNovoJogo);	
			
			btnNovoJogo.addActionListener(new ActionListener() {
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
			
			
   //BUTTON PONTUAÇOES
			JButton btnPontuacoes = new JButton();
			btnPontuacoes.setIcon(new ImageIcon("images/imgbutton/pontuacoes.png"));	
			btnPontuacoes.setBounds(108, 230, 200, 50);
			FunnyMathUI.getContentPane().add(btnPontuacoes);
			
			btnPontuacoes.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent evt) {				   					   
					 			
					   		new Janela_Pontuacoes();	//Nova janela
					  
				   }
			});
			
    //BUTTON PREMIOS
			JButton btnPremios = new JButton();
			btnPremios.setIcon(new ImageIcon("images/imgbutton/premios.png"));	
			btnPremios.setBounds(108, 310, 200, 50);
			FunnyMathUI.getContentPane().add(btnPremios);
			btnPremios.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent evt) {					   
										   
					   new Janela_Premios(); //Nova janela


				   }
			});

     //BUTTON SAIR
			JButton btnSair = new JButton();
			btnSair.setIcon(new ImageIcon("images/imgbutton/sair.png"));	
			btnSair.setBounds(108, 390, 200, 50);
			FunnyMathUI.getContentPane().add(btnSair);
			
			btnSair.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent evt) {	
					   if(JOptionPane.showConfirmDialog(FunnyMathUI, "Tem a certeza que deseja sair ?","Sair", JOptionPane.OK_CANCEL_OPTION)
							   == JOptionPane.OK_OPTION)
					   {
						   save.guardaPontuacoes();
						   save.guardaProbsNivel1();
						   save.guardaProbsNivel2();
						   save.guardaProbsNivel3();
						   save.guardaProbsNivel5();
						   System.exit(0);			
					   }
				   }
			});
							
	
	 }
	
}

		
	


