package com.gps.funnymath.gameDialogs;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import com.gps.funnymath.game.TrackRewards;
import com.gps.funnymath.main.Global;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InserirNome_dialog extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField inputNome; //TODO Variavel com o nome do jogador, guardar depois!
	JRadioButton rdbtnMenino = new JRadioButton("Menino"); // se menino
	JRadioButton rdbtnMenina = new JRadioButton("Menina"); // se menina
	ButtonGroup bg = new ButtonGroup(); //button group
	
	private String nome;
	private int genero; //1-menino, 2 menina
	private boolean valid;
	private boolean canceled;
	
	private TrackRewards trackRewards; //para saber qual o sexo
	
	
	public InserirNome_dialog() {
		
		trackRewards = new TrackRewards();
		
		setResizable(false);  setModal(true);
		setTitle("Novo Jogo - Inserir Dados");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblIntroduzOTeu = new JLabel("Introduz o teu nome:");
			lblIntroduzOTeu.setFont(new Font("Verdana", Font.BOLD, 14));
			lblIntroduzOTeu.setBounds(26, 31, 181, 24);
			contentPanel.add(lblIntroduzOTeu);
		}
		{
			inputNome = new JTextField();
			inputNome.setBounds(206, 31, 176, 29);
			contentPanel.add(inputNome);
			inputNome.setColumns(10);
			
			
		}
		{
			JLabel lblEuSou = new JLabel("Eu sou...");
			lblEuSou.setFont(new Font("Verdana", Font.BOLD, 14));
			lblEuSou.setBounds(173, 97, 73, 24);
			contentPanel.add(lblEuSou);
		}
		
		
		rdbtnMenino.setForeground(Color.BLUE);
		rdbtnMenino.setFont(new Font("Verdana", Font.BOLD, 14));
		rdbtnMenino.setBounds(67, 144, 109, 23);
		rdbtnMenino.setSelected(true);
		contentPanel.add(rdbtnMenino);
		
		rdbtnMenina.setForeground(Color.MAGENTA);
		rdbtnMenina.setFont(new Font("Verdana", Font.BOLD, 14));
		rdbtnMenina.setBounds(273, 144, 109, 23);
		contentPanel.add(rdbtnMenina);		
	
		bg.add(rdbtnMenino);
		bg.add(rdbtnMenina);
		
//TODO depois nao sei como se obtem o escolhido... isso é com voces :P
		
		JLabel lblOu = new JLabel("ou");
		lblOu.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblOu.setBounds(200, 148, 46, 14);
		contentPanel.add(lblOu);
		{
			JButton cancelButton = new JButton("Cancelar");
			cancelButton.setBackground(Color.LIGHT_GRAY);
			cancelButton.setFont(new Font("Verdana", Font.PLAIN, 14));
			cancelButton.setBounds(242, 195, 118, 34);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent evt) {
					   canceled = true;
					    dispose();
								  
				   }
			});
		}
		{
			JButton btnIniciarJogo = new JButton("Iniciar Jogo");
			btnIniciarJogo.setBackground(Color.ORANGE);
			btnIniciarJogo.setFont(new Font("Verdana", Font.BOLD, 14));
			btnIniciarJogo.setBounds(67, 195, 139, 34);
			contentPanel.add(btnIniciarJogo);
			btnIniciarJogo.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent evt) {	
					  
					   
					   	nome = inputNome.getText();
					   	if(nome.length()>50)
							try {
								nome = inputNome.getText(0,50);
							} catch (BadLocationException e) {								
								e.printStackTrace();
							}
						  
						 if(rdbtnMenino.isSelected())
							 genero = 1;
						  else if(rdbtnMenina.isSelected())
							 genero = 2;
						   
						  
					  if(nome.length()<= 0){
						  JOptionPane.showMessageDialog(contentPanel, "Nome Inválido!");
						  valid = false;
					  }else{
						  valid = true;
						  Global.nome = nome;
						  Global.genero = genero;
					  }
					   	
					  if(rdbtnMenino.isSelected())
						  trackRewards.setGender(1); //MENINO
					  if(rdbtnMenina.isSelected())
						  trackRewards.setGender(2); //MENINA
					  
					  canceled = false;
					  dispose();
				   }
			});
	
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	
	public boolean getCanceled(){return canceled;}
	
	public boolean getValid(){return valid;}
	
	public String getNome(){
		return nome;
	}
	
	public int getGenero(){
		return genero;
	}
	
	public JTextField getInputNome() {
		return inputNome;
	}


	public void setInputNome(JTextField inputNome) {
		this.inputNome = inputNome;
	}


	public JRadioButton getRdbtnMenino() {
		return rdbtnMenino;
	}


	public void setRdbtnMenino(JRadioButton rdbtnMenino) {
		this.rdbtnMenino = rdbtnMenino;
	}


	public JRadioButton getRdbtnMenina() {
		return rdbtnMenina;
	}


	public void setRdbtnMenina(JRadioButton rdbtnMenina) {
		this.rdbtnMenina = rdbtnMenina;
	}


	public ButtonGroup getBg() {
		return bg;
	}


	public void setBg(ButtonGroup bg) {
		this.bg = bg;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public JPanel getContentPanel() {
		return contentPanel;
	}
}
