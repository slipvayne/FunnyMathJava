package com.gps.funnymath.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.gps.funnymath.main.Global;

public class Janela_Premios {
	
	private JFrame Premios;
	protected String background; //alterar depois para background activo ou assim
	
	private TrackRewards trackRewards; //para saber quantos problemas ja resolveu, para desbloquear os rewards
	private int imgSelect; //imagem selecionada
	
	
	public Janela_Premios() {
			
		trackRewards = new TrackRewards();
		imgSelect = -1;
		
		Premios = new JFrame();
		Premios.setIconImage(Toolkit.getDefaultToolkit().getImage("images/icon/icon.png"));
		Premios.setTitle("Funny Math - Prémios");		
		Premios.setResizable(false);
		Premios.setBounds(100, 100, 800, 600);
		//Premios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Premios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //para nao fechar a principal
		Premios.getContentPane().setLayout(null);
	
		
		setBackground(Global.background_default);
		
		showAll();
	
	}	
	
	public void showBackground()
	 {
		 		
			try {
				Premios.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(background)))));
			} catch (IOException e) {
				// TODO se a imagem não existir...
				e.printStackTrace();
			}
	    	
	 } 
	
	
	public void showAll()
	{
		showBackground();
		showButtons();
		botaoSair();		
		Premios.setVisible(true);			
		Premios.repaint();
	}
	
	
	 public void showButtons()
	 {
		 
//TODO Botoes das imagens 
//(acho mais rapido optar logo por ao clicar numa dar logo para pre-visualizar e dps escolher no final definitivamente)
		 
//Imagem 1...
			JButton btnImagem1 = new JButton();
			
			btnImagem1.setBounds(80, 41, 127, 108);
			if(trackRewards.getGender() == 1)
				btnImagem1.setIcon(new ImageIcon("images/bg_menino/background_1.jpg")); //menino
			if(trackRewards.getGender() == 2)
				btnImagem1.setIcon(new ImageIcon("images/bg_menina/background_1.jpg")); //menina
			else
				btnImagem1.setIcon(new ImageIcon("images/bg_menino/background_1.jpg")); //default
			Premios.add(btnImagem1);

//Evento imagem 1..
			btnImagem1.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent evt) {	
					  
					   imgSelect = 1;
					   
					   if(trackRewards.getGender() == 1)
						   setBackground("images/bg_menino/background_1.jpg"); //menino
						if(trackRewards.getGender() == 2)
							setBackground("images/bg_menina/background_1.jpg"); //menina
						else
							setBackground("images/bg_menino/background_1.jpg"); //default
					   
					   	
					   showAll();
					   //nao devia ser assim mas é mais rapido..
		
				   }
			}); 
			
			JButton btnImagem2 = new JButton();
			btnImagem2.setBounds(327, 41, 127, 108);
			if(trackRewards.getGender() == 1)
				btnImagem2.setIcon(new ImageIcon("images/bg_menino/background_2.jpg")); //menino
			if(trackRewards.getGender() == 2)
				btnImagem2.setIcon(new ImageIcon("images/bg_menina/background_2.jpg")); //menina
			else
				btnImagem2.setIcon(new ImageIcon("images/bg_menino/background_2.jpg")); //default
			Premios.add(btnImagem2);
			
//Evento imagem 2..
			btnImagem2.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent evt) {	
					  
					   imgSelect = 2;
					   
					   if(trackRewards.getGender() == 1)
						   setBackground("images/bg_menino/background_2.jpg"); //menino
						if(trackRewards.getGender() == 2)
							setBackground("images/bg_menina/background_2.jpg"); //menina
						else
							setBackground("images/bg_menino/background_2.jpg"); //default
					   showAll();
					   //nao devia ser assim mas é mais rapido..
				   }
			}); 
			
			JButton btnImagem3 = new JButton();
			btnImagem3.setBounds(578, 41, 127, 108);
			if(trackRewards.getGender() == 1)
				btnImagem3.setIcon(new ImageIcon("images/bg_menino/background_3.jpg")); //menino
			if(trackRewards.getGender() == 2)
				btnImagem3.setIcon(new ImageIcon("images/bg_menina/background_3.jpg")); //menina
			else
				btnImagem3.setIcon(new ImageIcon("images/bg_menino/background_3.jpg")); //default
			Premios.add(btnImagem3);

//Evento imagem 3..
			btnImagem3.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent evt) {	
					   
					   imgSelect = 3;
					   
					   if(trackRewards.getGender() == 1)
						   setBackground("images/bg_menino/background_3.jpg"); //menino
						if(trackRewards.getGender() == 2)
							setBackground("images/bg_menina/background_3.jpg"); //menina
						else
							setBackground("images/bg_menino/background_3.jpg"); //default	
					   showAll();
					  
					   //TODO
				   }
			}); 
			
			JButton btnImagem4 = new JButton();
			btnImagem4.setBounds(80, 191, 127, 108);
			if(trackRewards.getGender() == 1)
				btnImagem4.setIcon(new ImageIcon("images/bg_menino/background_4.jpg")); //menino
			if(trackRewards.getGender() == 2)
				btnImagem4.setIcon(new ImageIcon("images/bg_menina/background_4.jpg")); //menina
			else
				btnImagem4.setIcon(new ImageIcon("images/bg_menino/background_4.jpg")); //default
			Premios.add(btnImagem4);
			
//Evento imagem 4..
			btnImagem4.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent evt) {	
					   
					   imgSelect = 4;
					   
					   if(trackRewards.getGender() == 1)
						   setBackground("images/bg_menino/background_4.jpg"); //menino
						if(trackRewards.getGender() == 2)
							setBackground("images/bg_menina/background_4.jpg"); //menina
						else
							setBackground("images/bg_menino/background_4.jpg"); //default	
					   showAll();
					  
					   //TODO
				   }
			}); 
			
			JButton btnImagem5 = new JButton();
			btnImagem5.setBounds(327, 191, 127, 108);
			if(trackRewards.getGender() == 1)
				btnImagem5.setIcon(new ImageIcon("images/bg_menino/background_5.jpg")); //menino
			if(trackRewards.getGender() == 2)
				btnImagem5.setIcon(new ImageIcon("images/bg_menina/background_5.jpg")); //menina
			else
				btnImagem5.setIcon(new ImageIcon("images/bg_menino/background_5.jpg")); //default
			Premios.add(btnImagem5);
			
//Evento imagem 5..
			btnImagem5.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent evt) {	
					  
					   imgSelect = 5;
					   
					   if(trackRewards.getGender() == 1)
						   setBackground("images/bg_menino/background_5.jpg"); //menino
						if(trackRewards.getGender() == 2)
							setBackground("images/bg_menina/background_5.jpg"); //menina
						else
							setBackground("images/bg_menino/background_5.jpg"); //default	
					   showAll();
					   //TODO
				   }
			}); 
			
			JButton btnImagem6 = new JButton();
			btnImagem6.setBounds(578, 191, 127, 108);
			if(trackRewards.getGender() == 1)
				btnImagem6.setIcon(new ImageIcon("images/bg_menino/background_6.jpg")); //menino
			if(trackRewards.getGender() == 2)
				btnImagem6.setIcon(new ImageIcon("images/bg_menina/background_6.jpg")); //menina
			else
				btnImagem6.setIcon(new ImageIcon("images/bg_menino/background_6.jpg")); //default
			Premios.add(btnImagem6);
			
//Evento imagem 6..
			btnImagem6.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent evt) {	
					  
					   imgSelect = 6;
					   
					   if(trackRewards.getGender() == 1)
						   setBackground("images/bg_menino/background_6.jpg"); //menino
						if(trackRewards.getGender() == 2)
							setBackground("images/bg_menina/background_6.jpg"); //menina
						else
							setBackground("images/bg_menino/background_6.jpg"); //default	
					   showAll();
					   //TODO
				   }
			}); 
			
			JButton btnImagem7 = new JButton();
			btnImagem7.setBounds(80, 348, 127, 108);
			if(trackRewards.getGender() == 1)
				btnImagem7.setIcon(new ImageIcon("images/bg_menino/background_7.jpg")); //menino
			if(trackRewards.getGender() == 2)
				btnImagem7.setIcon(new ImageIcon("images/bg_menina/background_7.jpg")); //menina
			else
				btnImagem7.setIcon(new ImageIcon("images/bg_menino/background_7.jpg")); //default
			Premios.add(btnImagem7);

//Evento imagem 7..
			btnImagem7.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent evt) {	
					  
					   imgSelect = 7;
					   
					   if(trackRewards.getGender() == 1)
						   setBackground("images/bg_menino/background_7.jpg"); //menino
						if(trackRewards.getGender() == 2)
							setBackground("images/bg_menina/background_7.jpg"); //menina
						else
							setBackground("images/bg_menino/background_7.jpg"); //default	
					   showAll();
					   //TODO
				   }
			}); 
			
			JButton btnImagem8 = new JButton();
			btnImagem8.setBounds(327, 348, 127, 108);
			if(trackRewards.getGender() == 1)
				btnImagem8.setIcon(new ImageIcon("images/bg_menino/background_8.jpg")); //menino
			if(trackRewards.getGender() == 2)
				btnImagem8.setIcon(new ImageIcon("images/bg_menina/background_8.jpg")); //menina
			else
				btnImagem8.setIcon(new ImageIcon("images/bg_menino/background_8.jpg")); //default
			Premios.add(btnImagem8);
			
//Evento imagem 8..
			btnImagem8.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent evt) {	
					  
					   imgSelect = 8;
					   
					   if(trackRewards.getGender() == 1)
						   setBackground("images/bg_menino/background_8.jpg"); //menino
						if(trackRewards.getGender() == 2)
							setBackground("images/bg_menina/background_8.jpg"); //menina
						else
							setBackground("images/bg_menino/background_8.jpg"); //default	
					   showAll();
					   //TODO
				   }
			}); 
			
			JButton btnImagem9 = new JButton();
			btnImagem9.setBounds(578, 348, 127, 108);
			if(trackRewards.getGender() == 1)
				btnImagem9.setIcon(new ImageIcon("images/bg_menino/background_9.jpg")); //menino
			if(trackRewards.getGender() == 2)
				btnImagem9.setIcon(new ImageIcon("images/bg_menina/background_9.jpg")); //menina
			else
				btnImagem9.setIcon(new ImageIcon("images/bg_menino/background_9.jpg")); //default
			Premios.add(btnImagem9);
			
//Evento imagem 9..
			btnImagem9.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent evt) {	
					  
					   imgSelect = 9;
					   
					   if(trackRewards.getGender() == 1)
						   setBackground("images/bg_menino/background_9.jpg"); //menino
						if(trackRewards.getGender() == 2)
							setBackground("images/bg_menina/background_9.jpg"); //menina
						else
							setBackground("images/bg_menino/background_9.jpg"); //default	
					   showAll();
					   //TODO
				   }
			}); 
			
			JButton btnEscolher = new JButton("Escolher");
			btnEscolher.setFont(new Font("Tahoma", Font.BOLD, 21));
			btnEscolher.setBackground(Color.GREEN);
			btnEscolher.setForeground(Color.black);
			btnEscolher.setBounds(590, 480, 150, 50);
			Premios.add(btnEscolher);
			
//Evento BOTAO ESCOLHER..
			btnEscolher.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent evt) {	
					   
					   if(imgSelect == -1)
						   System.out.print("nada selecionado");
					   switch(imgSelect){
					   		case 1:
					   			//verificar se tem X problemas resolvidos
					   			if(trackRewards.getNumProbResolvidos() < 1)
					   				JOptionPane.showMessageDialog(Premios, "Ainda não resolveste problemas suficientes :(");
					   			else{
					   				if(trackRewards.getGender() == 1) //menino
					   					trackRewards.setCurrentReward("images/bg_menino/background_1.jpg");
					   				else if(trackRewards.getGender() == 2) //menina
					   					trackRewards.setCurrentReward("images/bg_menina/background_1.jpg");
					   				else //default
					   					trackRewards.setCurrentReward("images/bg_menino/background_1.jpg");
					   				
					   				Premios.dispose();
					   			}
					   			break;
					   		case 2:
					   			if(trackRewards.getNumProbResolvidos() < 2)
					   				JOptionPane.showMessageDialog(Premios, "Ainda não resolveste problemas suficientes :(");
					   			else{
					   				if(trackRewards.getGender() == 1) //menino
					   					trackRewards.setCurrentReward("images/bg_menino/background_2.jpg");
					   				else if(trackRewards.getGender() == 2) //menina
					   					trackRewards.setCurrentReward("images/bg_menina/background_2.jpg");
					   				else //default
					   					trackRewards.setCurrentReward("images/bg_menino/background_2.jpg");
					   				
					   				Premios.dispose();
					   			}
					   			break;
					   		case 3:
					   			if(trackRewards.getNumProbResolvidos() < 3)
					   				JOptionPane.showMessageDialog(Premios, "Ainda não resolveste problemas suficientes :(");
					   			else{
					   				if(trackRewards.getGender() == 1) //menino
					   					trackRewards.setCurrentReward("images/bg_menino/background_3.jpg");
					   				else if(trackRewards.getGender() == 2) //menina
					   					trackRewards.setCurrentReward("images/bg_menina/background_3.jpg");
					   				else //default
					   					trackRewards.setCurrentReward("images/bg_menino/background_3.jpg");
					   				
					   				Premios.dispose();
					   			}
					   			break;
					   		case 4:
					   			if(trackRewards.getNumProbResolvidos() < 4)
					   				JOptionPane.showMessageDialog(Premios, "Ainda não resolveste problemas suficientes :(");
					   			else{
					   				if(trackRewards.getGender() == 1) //menino
					   					trackRewards.setCurrentReward("images/bg_menino/background_4.jpg");
					   				else if(trackRewards.getGender() == 2) //menina
					   					trackRewards.setCurrentReward("images/bg_menina/background_4.jpg");
					   				else //default
					   					trackRewards.setCurrentReward("images/bg_menino/background_4.jpg");	
					   				
					   				Premios.dispose();
					   			}
					   			break;
					   		case 5:
					   			if(trackRewards.getNumProbResolvidos() < 5)
					   				JOptionPane.showMessageDialog(Premios, "Ainda não resolveste problemas suficientes :(");
					   			else{
					   				if(trackRewards.getGender() == 1) //menino
					   					trackRewards.setCurrentReward("images/bg_menino/background_5.jpg");
					   				else if(trackRewards.getGender() == 2) //menina
					   					trackRewards.setCurrentReward("images/bg_menina/background_5.jpg");
					   				else //default
					   					trackRewards.setCurrentReward("images/bg_menino/background_5.jpg");	
					   				
					   				Premios.dispose();
					   			}
					   			break;
					   		case 6:
					   			if(trackRewards.getNumProbResolvidos() < 7)
					   				JOptionPane.showMessageDialog(Premios, "Ainda não resolveste problemas suficientes :(");
					   			else{
					   				if(trackRewards.getGender() == 1) //menino
					   					trackRewards.setCurrentReward("images/bg_menino/background_6.jpg");
					   				else if(trackRewards.getGender() == 2) //menina
					   					trackRewards.setCurrentReward("images/bg_menina/background_6.jpg");
					   				else //default
					   					trackRewards.setCurrentReward("images/bg_menino/background_6.jpg");
					   				
					   				Premios.dispose();
					   			}
					   			break;
					   		case 7:
					   			if(trackRewards.getNumProbResolvidos() < 10)
					   				JOptionPane.showMessageDialog(Premios, "Ainda não resolveste problemas suficientes :(");
					   			else{
					   				if(trackRewards.getGender() == 1) //menino
					   					trackRewards.setCurrentReward("images/bg_menino/background_7.jpg");
					   				else if(trackRewards.getGender() == 2) //menina
					   					trackRewards.setCurrentReward("images/bg_menina/background_7.jpg");
					   				else //default
					   					trackRewards.setCurrentReward("images/bg_menino/background_7.jpg");	
					   				
					   				Premios.dispose();
					   			}
					   			break;
					   		case 8:
					   			if(trackRewards.getNumProbResolvidos() < 15)
					   				JOptionPane.showMessageDialog(Premios, "Ainda não resolveste problemas suficientes :(");
					   			else{
					   				if(trackRewards.getGender() == 1) //menino
					   					trackRewards.setCurrentReward("images/bg_menino/background_8.jpg");
					   				else if(trackRewards.getGender() == 2) //menina
					   					trackRewards.setCurrentReward("images/bg_menina/background_8.jpg");
					   				else //default
					   					trackRewards.setCurrentReward("images/bg_menino/background_8.jpg");	
					   				
					   				Premios.dispose();
					   			}
					   			break;
					   		case 9:
					   			if(trackRewards.getNumProbResolvidos() < 25)
					   				JOptionPane.showMessageDialog(Premios, "Ainda não resolveste problemas suficientes :(");
					   			else{
					   				if(trackRewards.getGender() == 1) //menino
					   					trackRewards.setCurrentReward("images/bg_menino/background_9.jpg");
					   				else if(trackRewards.getGender() == 2) //menina
					   					trackRewards.setCurrentReward("images/bg_menina/background_9.jpg");
					   				else //default
					   					trackRewards.setCurrentReward("images/bg_menino/background_9.jpg");	
					   				
					   				Premios.dispose();
					   			}
					   			break;
					   		default:
					   			JOptionPane.showMessageDialog(Premios, "Escolhe uma imagem primeiro");
						 
					   			
					   			
					   }
					   //TODO deve saber o background activo (pre-visualizado on the fly, e salvar para definitivo)
				   }
			}); 

//Atençao ao fundo de background (para as label se verem, tratar disso later)
			
			JLabel lblImagem = new JLabel("Imagem 1");
			lblImagem.setFont(new Font("Verdana", Font.PLAIN, 14));
			lblImagem.setBounds(107, 20, 70, 18);
			lblImagem.setOpaque(true);
			Premios.add(lblImagem);
			
			JLabel lblImagem_1 = new JLabel("Imagem 2");
			lblImagem_1.setFont(new Font("Verdana", Font.PLAIN, 14));
			lblImagem_1.setBounds(352, 20, 70, 18);
			lblImagem_1.setOpaque(true);
			Premios.add(lblImagem_1);
			
			JLabel lblImagem_2 = new JLabel("Imagem 3");
			lblImagem_2.setFont(new Font("Verdana", Font.PLAIN, 14));
			lblImagem_2.setBounds(601, 20, 70, 18);
			lblImagem_2.setOpaque(true);
			Premios.add(lblImagem_2);
			
			JLabel lblImagem_3 = new JLabel("Imagem 4");
			lblImagem_3.setFont(new Font("Verdana", Font.PLAIN, 14));
			lblImagem_3.setBounds(111, 172, 70, 18);
			lblImagem_3.setOpaque(true);
			Premios.add(lblImagem_3);
			
			JLabel lblImagem_4 = new JLabel("Imagem 5");
			lblImagem_4.setFont(new Font("Verdana", Font.PLAIN, 14));
			lblImagem_4.setBounds(352, 172, 70, 18);
			lblImagem_4.setOpaque(true);
			Premios.add(lblImagem_4);
			
			JLabel lblImagem_5 = new JLabel("Imagem 6");
			lblImagem_5.setFont(new Font("Verdana", Font.PLAIN, 14));
			lblImagem_5.setBounds(601, 172, 70, 18);
			lblImagem_5.setOpaque(true);
			Premios.add(lblImagem_5);
			
			JLabel lblImagem_6 = new JLabel("Imagem 7");
			lblImagem_6.setFont(new Font("Verdana", Font.PLAIN, 14));
			lblImagem_6.setBounds(111, 330, 70, 18);
			lblImagem_6.setOpaque(true);
			Premios.add(lblImagem_6);
			
			JLabel lblImagem_7 = new JLabel("Imagem 8");
			lblImagem_7.setFont(new Font("Verdana", Font.PLAIN, 14));
			lblImagem_7.setBounds(352, 330, 70, 18);
			lblImagem_7.setOpaque(true);
			Premios.add(lblImagem_7);
			
			JLabel lblImagem_8 = new JLabel("Imagem 9");
			lblImagem_8.setFont(new Font("Verdana", Font.PLAIN, 14));
			lblImagem_8.setBounds(601, 330, 70, 18);
			lblImagem_8.setOpaque(true);
			Premios.add(lblImagem_8);
			
			JLabel lblResolverProblema;
			if(trackRewards.getNumProbResolvidos() < 1){
				lblResolverProblema = new JLabel("     Resolver 1 Problema");
				lblResolverProblema.setBackground(Color.RED);
				lblResolverProblema.setForeground(Color.WHITE);
			}else{
				lblResolverProblema = new JLabel("          Desbloqueada");
				lblResolverProblema.setBackground(Color.GREEN);
			}
			lblResolverProblema.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblResolverProblema.setBounds(80, 147, 127, 14);
			lblResolverProblema.setOpaque(true);
			Premios.add(lblResolverProblema);
			
			JLabel lblResolverProblemas;
			if(trackRewards.getNumProbResolvidos() < 2){
				lblResolverProblemas = new JLabel("     Resolver 2 Problemas");
				lblResolverProblemas.setBackground(Color.RED);
				lblResolverProblemas.setForeground(Color.WHITE);
			}else{
				lblResolverProblemas = new JLabel("          Desbloqueada");
				lblResolverProblemas.setBackground(Color.GREEN);
			}
			lblResolverProblemas.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblResolverProblemas.setBounds(327, 147, 127, 14);
			lblResolverProblemas.setOpaque(true);
			Premios.add(lblResolverProblemas);
			
			JLabel lblResolverProblema_1;
			if(trackRewards.getNumProbResolvidos() < 3){
				lblResolverProblema_1 = new JLabel("     Resolver 3 Problemas");
				lblResolverProblema_1.setBackground(Color.RED);
				lblResolverProblema_1.setForeground(Color.WHITE);
			}else{
				lblResolverProblema_1 = new JLabel("          Desbloqueada");
				lblResolverProblema_1.setBackground(Color.GREEN);
			}
			lblResolverProblema_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblResolverProblema_1.setBounds(578, 147, 127, 14);
			lblResolverProblema_1.setOpaque(true);
			Premios.add(lblResolverProblema_1);
			
			JLabel lblResolverProblemas_1;
			if(trackRewards.getNumProbResolvidos() < 4){
				lblResolverProblemas_1 = new JLabel("     Resolver 4 Problemas");
				lblResolverProblemas_1.setBackground(Color.RED);
				lblResolverProblemas_1.setForeground(Color.WHITE);
			}else{
				lblResolverProblemas_1 = new JLabel("          Desbloqueada");
				lblResolverProblemas_1.setBackground(Color.GREEN);
			}
			lblResolverProblemas_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblResolverProblemas_1.setBounds(80, 300, 127, 14);
			lblResolverProblemas_1.setOpaque(true);
			Premios.add(lblResolverProblemas_1);
			
			JLabel lblResolverProblemas_2;
			if(trackRewards.getNumProbResolvidos() < 5){
				lblResolverProblemas_2 = new JLabel("     Resolver 5 Problemas");
				lblResolverProblemas_2.setBackground(Color.RED);
				lblResolverProblemas_2.setForeground(Color.WHITE);
			}else{
				lblResolverProblemas_2 = new JLabel("          Desbloqueada");
				lblResolverProblemas_2.setBackground(Color.GREEN);
			}
			lblResolverProblemas_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblResolverProblemas_2.setBounds(327, 300, 127, 14);
			lblResolverProblemas_2.setOpaque(true);
			Premios.add(lblResolverProblemas_2);
			
			JLabel lblResolverProblema_2 = new JLabel("     Resolver 7 Problemas");
			if(trackRewards.getNumProbResolvidos() < 7){
				lblResolverProblema_2 = new JLabel("     Resolver 7 Problemas");
				lblResolverProblema_2.setBackground(Color.RED);
				lblResolverProblema_2.setForeground(Color.WHITE);
			}else{
				lblResolverProblema_2 = new JLabel("          Desbloqueada");
				lblResolverProblema_2.setBackground(Color.GREEN);
			}
			lblResolverProblema_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblResolverProblema_2.setBounds(578, 300, 127, 14);
			lblResolverProblema_2.setOpaque(true);
			Premios.add(lblResolverProblema_2);
			
			JLabel lblResolverProblemas_3;
			if(trackRewards.getNumProbResolvidos() < 10){
				lblResolverProblemas_3 = new JLabel("     Resolver 10 Problemas");
				lblResolverProblemas_3.setBackground(Color.RED);
				lblResolverProblemas_3.setForeground(Color.WHITE);
			}else{
				lblResolverProblemas_3 = new JLabel("          Desbloqueada");
				lblResolverProblemas_3.setBackground(Color.GREEN);
			}
			lblResolverProblemas_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblResolverProblemas_3.setBounds(78, 456, 127, 14);
			lblResolverProblemas_3.setOpaque(true);
			Premios.add(lblResolverProblemas_3);
			
			JLabel lblResolverProblema_3;
			if(trackRewards.getNumProbResolvidos() < 15){
				lblResolverProblema_3 = new JLabel("     Resolver 15 Problemas");
				lblResolverProblema_3.setBackground(Color.RED);
				lblResolverProblema_3.setForeground(Color.WHITE);
			}else{
				lblResolverProblema_3 = new JLabel("          Desbloqueada");
				lblResolverProblema_3.setBackground(Color.GREEN);
			}
			lblResolverProblema_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblResolverProblema_3.setBounds(325, 456, 127, 14);
			lblResolverProblema_3.setOpaque(true);
			Premios.add(lblResolverProblema_3);
			
			JLabel lblResolverProblema_4;
			if(trackRewards.getNumProbResolvidos() < 25){
				lblResolverProblema_4 = new JLabel("     Resolver 25 Problemas");
				lblResolverProblema_4.setBackground(Color.RED);
				lblResolverProblema_4.setForeground(Color.WHITE);
			}else{
				lblResolverProblema_4 = new JLabel("          Desbloqueada");
				lblResolverProblema_4.setBackground(Color.GREEN);
			}
			lblResolverProblema_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblResolverProblema_4.setBounds(576, 456, 127, 14);
			lblResolverProblema_4.setOpaque(true);
			Premios.add(lblResolverProblema_4);
		 
	 }
	 
	 
	 public void botaoSair() //volta ao menu
	 {
		 JButton btnSair = new JButton();
		btnSair.setIcon(new ImageIcon("images/imgbutton/botaoSair.png"));	
		btnSair.setBounds(30, 480, 150, 50);
		Premios.getContentPane().add(btnSair);
			
		btnSair.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent evt) {	
					  
					   Premios.dispose();
					   	
				   }
			}); 
	 }

	public JFrame getPremios() {
		return Premios;
	}

	public void setPremios(JFrame premios) {
		Premios = premios;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}
	 
}
