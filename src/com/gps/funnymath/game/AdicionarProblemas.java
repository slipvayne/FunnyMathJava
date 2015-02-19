package com.gps.funnymath.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.gps.funnymath.main.Global;
import com.gps.funnymath.modelos.ProblemaEditado;


public class AdicionarProblemas extends Game {
	
	JTextArea textAreaProblema = new JTextArea(); //Problema	
	JTextArea textAreaPergunta = new JTextArea(); //Problema2
	@SuppressWarnings("rawtypes")
	JComboBox comboBox = new JComboBox(); //dificuldade
	
	JTextField inputResultado = new JTextField(); //Resultado
	

	public AdicionarProblemas(JFrame FunnyMathUI) {
			
		super(FunnyMathUI);		
		
		setBackground(Global.background_default); 
		
		showAdicionarProblema();
		
		refresh();
	
	}	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void showAdicionarProblema() 
	{
		

//TODO Salvar problema (text area depois)
		
		JLabel lblProblema = new JLabel("Novo Problema:");
		lblProblema.setFont(new Font("Verdana", Font.BOLD, 14));
		lblProblema.setBounds(65, 31, 150, 15);
		FunnyMathUI.add(lblProblema);
		textAreaProblema.setFont(new Font("Verdana", Font.PLAIN, 16));

				
		JScrollPane listaScroll = new JScrollPane(textAreaProblema);   //para aparecer a scroll bar se for necessário
		listaScroll.setBounds(63, 56, 671, 100);	
		FunnyMathUI.add(listaScroll);	
		
		
//Problema Pergunta
					
		JLabel lblPergunta = new JLabel("Pergunta:");
		lblPergunta.setFont(new Font("Verdana", Font.BOLD, 14));
		lblPergunta.setBounds(65, 167, 150, 20);
		FunnyMathUI.add(lblPergunta);
		
		
		textAreaPergunta.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		JScrollPane perguntaScroll = new JScrollPane(textAreaPergunta);   //para aparecer a scroll bar se for necessário
		perguntaScroll.setBounds(65, 198, 669, 69);
		FunnyMathUI.add(perguntaScroll);	
		

//TODO Salvar resposta do problema (ter cuidado com introducao de strings aki tal como no jogo)
	

		JLabel labelResposta = new JLabel("Resposta:");
		labelResposta.setFont(new Font("Verdana", Font.BOLD, 14));
		labelResposta.setBounds(130, 336, 88, 25);
		FunnyMathUI.add(labelResposta);
		inputResultado.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		inputResultado.setBounds(228, 336, 100, 25);
		FunnyMathUI.add(inputResultado);
		inputResultado.setColumns(10);
		
		JLabel labelDificuldade = new JLabel("Dificuldade:");
		labelDificuldade.setFont(new Font("Verdana", Font.BOLD, 14));
		labelDificuldade.setBounds(399, 331, 114, 30);
		FunnyMathUI.add(labelDificuldade);
	

		
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Escolha um n\u00EDvel", "1", "2", "3", "4"}));
		comboBox.setBounds(501, 334, 150, 25);
		FunnyMathUI.add(comboBox);

		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setBackground(Color.CYAN);
		btnCriar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCriar.setBounds(244, 448, 114, 44);
		FunnyMathUI.add(btnCriar);
		btnCriar.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent evt) {	
				   
				   //TODO GRAVAR NOVO PROBLEMA E APRESENTAR MSGBOX COM SUCESSO
				   //CRIA NOVO!
				   try{
					   String problema = textAreaProblema.getText();
					   String questao = textAreaPergunta.getText();
				   
					   int resposta = Integer.parseInt(inputResultado.getText());					   
					   int nivel = comboBox.getSelectedIndex();
					   
					   if(problema.length() == 0 || questao.length() == 0 || nivel<1 || nivel>4)
						   throw new Exception();
					   
					   ProblemaEditado pe = new ProblemaEditado(problema, questao, resposta);
					   switch(nivel){
						   case 1:
							   Global.nivel1.add(pe);
							   break;
						   case 2:
							   Global.nivel2.add(pe);
							   break;
						   case 3:
							   Global.nivel3.add(pe);
							   break;
						   case 4:
							   Global.nivel5.add(pe);
							   break;
					   }
					   
					   JOptionPane.showMessageDialog(FunnyMathUI, "Problema Guardado Com Sucesso");
					   textAreaProblema.setText("");
					   textAreaPergunta.setText("");
					   inputResultado.setText("");
					   comboBox.setSelectedIndex(0);
					   
				   }catch(Exception e){
					   JOptionPane.showMessageDialog(FunnyMathUI, "Valor inserido inválido!");
				   }
				   
			
			   }
		});
		
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBackground(Color.LIGHT_GRAY);
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSair.setBounds(429, 448, 114, 44);
		FunnyMathUI.add(btnSair);
		
		
		btnSair.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent evt) {
				   
				   int option = JOptionPane.showConfirmDialog(FunnyMathUI, "Tem a certeza que quer sair?", "Sair", JOptionPane.OK_CANCEL_OPTION);
				   
				   if(option == JOptionPane.OK_OPTION)
					   new GameMenu(FunnyMathUI);
			   }
		});
	}

	public JTextArea getTextAreaProblema() {
		return textAreaProblema;
	}

	public void setTextAreaProblema(JTextArea textAreaProblema) {
		this.textAreaProblema = textAreaProblema;
	}

	public JTextArea getTextAreaPergunta() {
		return textAreaPergunta;
	}

	public void setTextAreaPergunta(JTextArea textAreaPergunta) {
		this.textAreaPergunta = textAreaPergunta;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboBox() {
		return comboBox;
	}

	@SuppressWarnings("rawtypes")
	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JTextField getInputResultado() {
		return inputResultado;
	}

	public void setInputResultado(JTextField inputResultado) {
		this.inputResultado = inputResultado;
	}
	
}