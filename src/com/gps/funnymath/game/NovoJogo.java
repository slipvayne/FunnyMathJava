package com.gps.funnymath.game;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.gps.funnymath.main.Global;
import com.gps.funnymath.modelos.Modelo_1;
import com.gps.funnymath.modelos.Modelo_2;
import com.gps.funnymath.modelos.Modelo_3;
//import com.gps.funnymath.modelos.Modelo_4;
import com.gps.funnymath.modelos.Modelo_5;



public class NovoJogo extends Game {
	
	JProgressBar progressBar_Problema = new JProgressBar(); //Progress Bar problema
	JProgressBar progressBar_Nivel = new JProgressBar(); //Progress Bar Nivel
	
	//Imagem do problema (como botao)
	JButton btnImagemProblema = new JButton(); 
	
	JTextArea ProblemaPart1 = new JTextArea(); //Problema
	JScrollPane Problem1Scroll = new JScrollPane(ProblemaPart1);   //para aparecer o scroll caso o problema seja grande

	JTextArea ProblemaPart2_question = new JTextArea(); //ProblemaQuestion
	JScrollPane Problem2Scroll = new JScrollPane(ProblemaPart2_question);   //para aparecer o scroll caso o problema seja grande
	
	JTextArea ProblemaDica = new JTextArea(); //Dica
	JScrollPane DicaScroll = new JScrollPane(ProblemaDica);   //para aparecer o scroll
	JButton btnDica = new JButton("Dica");
	
	JTextField inputResposta = new JTextField(); //Resposta que é inserida..
	
	JLabel lblPontuacao_dinamico = new JLabel("0"); //Label da pontuacao..
	
	
	private int nivel;
	private int problema;
	private int pontuacao;
	private int solution;
	private int nresp;
	
	private String nome;
	
	private ArrayList<Modelo_1> modelos1 = new ArrayList<Modelo_1>();
	private ArrayList<Modelo_2> modelos2 = new ArrayList<Modelo_2>();
	private ArrayList<Modelo_3> modelos3 = new ArrayList<Modelo_3>();
	//private ArrayList<Modelo_4> modelos4 = new ArrayList<Modelo_4>();
	private ArrayList<Modelo_5> modelos5 = new ArrayList<Modelo_5>();
	private int[] nivel1 = new int[3];
	private int[] nivel2 = new int[3];
	private int[] nivel3 = new int[3];
	//private int[] nivel4 = new int[3];
	private int[] nivel5 = new int[3];
	private int size1 = 0;
	private int size2 = 0;
	private int size3 = 0;
	//private int size4 = 0;
	private int size5 = 0;
	
	private TrackRewards trackRewards; //para saber quantos problemas ja resolveu, para desbloquear os rewards
	
	public NovoJogo(JFrame FunnyMathUI, String nome, int genero) {
			
		super(FunnyMathUI);		
		
		trackRewards = new TrackRewards();
		this.nome = nome;
		if(trackRewards.getCurrentReward().equals(" ") == false)
			setBackground(trackRewards.getCurrentReward());
		else
			setBackground(Global.background_default);
		
		//ALTERAR PARA TESTAR CADA NIVEL (excepto 4..)		
		nivel = 1;  
		//ALTERAR PARA TESTAR CADA NIVEL (excepto 4..)
		
		problema = pontuacao = nresp = 0;
		
		
		geraProblemas();
		showProblema();
		botaoSair();
		refresh();
		
		
	
	}	
	
		
	private void geraProblemas(){
		
		geraProblemasM1();
		geraProblemasM2();
		geraProblemasM3();
		//geraProblemasM4();
		geraProblemasM5();
	}
	
	private void geraProblemasM1(){
		
		modelos1.clear();
		if(Global.nivel1.size() == 0){			
			int [] array = new int [5];
			for(int i = 0;i<5;i++){
				int num = (int) (1 + Math.random() * 5); //alterado
				
				if(i>0)
					while(verificaExistencia(array,i,num))
						num = (int) (1 + Math.random() * 5);
				
				array[i] = num;
				switch(num){
					case 1:
						Modelo_1 model1 = new Modelo_1("images/modelos/1/modelo_1 39.png",39);
						modelos1.add(model1);
						break;
					case 2:
						Modelo_1 model2 = new Modelo_1("images/modelos/1/modelo_2 55.png",55);
						modelos1.add(model2);
						break;
					case 3:
						Modelo_1 model3 = new Modelo_1("images/modelos/1/modelo_3 56.png",56);
						modelos1.add(model3);
						break;
					case 4:
						Modelo_1 model4 = new Modelo_1("images/modelos/1/modelo_4 59.png",59);
						modelos1.add(model4);
						break;
					case 5:
						Modelo_1 model5 = new Modelo_1("images/modelos/1/modelo_5 67.png",67);
						modelos1.add(model5);
						break;
						/*
					case 6:
						Modelo_1 model6 = new Modelo_1("images/modelos/1/modelo_6 70.png",70);
						modelos1.add(model6);
						break;
					case 7:
						Modelo_1 model7 = new Modelo_1("images/modelos/1/modelo_7 78.png",78);
						modelos1.add(model7);
						break;
						*/
				}
					
			}
		}else{
			int n = Global.nivel1.size();
			int tam = 0; 
			
			if(n == 1){
				nivel1[size1] = 0;	
				size1++;
				tam = n;
			}
			if(n==2){
				nivel1[size1] = 0;	
				size1++;
				
				nivel1[size1] = 1;	
				size1++;
				tam = n;			
			}
			if(n>=3){
				nivel1[size1] = (int) (Math.random() * Global.nivel1.size());
				size1++;
				int num = (int) (Math.random() * Global.nivel1.size());
				 
				while(verificaExistencia(nivel1,size1,num))
					num = (int) (Math.random() * Global.nivel1.size());
				
				nivel1[size1] = (int) (Math.random() * Global.nivel1.size());
				size1++;
				
				while(verificaExistencia(nivel1,size1,num))
					num = (int) (Math.random() * Global.nivel1.size());
				
				nivel1[size1] = (int) (Math.random() * Global.nivel1.size());
				size1++;
				
				tam = 3;
			}
				
			int [] array = new int [5-tam];
			for(int i = 0;i<5-tam;i++){
				int num = (int) (1 + Math.random() * 5); //alterado
				if(i>0)
					while(verificaExistencia(array,i,num))
						num = (int) (1 + Math.random() * 5);
				
				array[i] = num;
				switch(num){
				case 1:
					Modelo_1 model1 = new Modelo_1("images/modelos/1/modelo_1 39.png",39);
					modelos1.add(model1);
					break;
				case 2:
					Modelo_1 model2 = new Modelo_1("images/modelos/1/modelo_2 55.png",55);
					modelos1.add(model2);
					break;
				case 3:
					Modelo_1 model3 = new Modelo_1("images/modelos/1/modelo_3 56.png",56);
					modelos1.add(model3);
					break;
				case 4:
					Modelo_1 model4 = new Modelo_1("images/modelos/1/modelo_4 59.png",59);
					modelos1.add(model4);
					break;
				case 5:
					Modelo_1 model5 = new Modelo_1("images/modelos/1/modelo_5 67.png",67);
					modelos1.add(model5);
					/*
					break;
				case 6:
					Modelo_1 model6 = new Modelo_1("images/modelos/1/modelo_6 70.png",70);
					modelos1.add(model6);
					break;
				case 7:
					Modelo_1 model7 = new Modelo_1("images/modelos/1/modelo_7 78.png",78);
					modelos1.add(model7);
					break;*/
				}
			}
		}
		
	}
	private void geraProblemasM2(){
		
		modelos2.clear();
		if(Global.nivel2.size() == 0){
			for(int i = 0;i<5;i++)
				modelos2.add(new Modelo_2());					
			
		}else{
			int n = Global.nivel2.size();
			int tam = 0; 
			
			if(n == 1){
				nivel2[size2] = 0;	
				size2++;
				tam = n;
			}
			if(n==2){
				nivel2[size2] = 0;	
				size2++;
				
				nivel2[size2] = 1;	
				size2++;
				tam = n;			
			}
			if(n>=3){
				nivel2[size2] = (int) (Math.random() * Global.nivel2.size());
				size2++;
				int num = (int) (Math.random() * Global.nivel2.size());
				 
				while(verificaExistencia(nivel2,size2,num))
					num = (int) (Math.random() * Global.nivel2.size());
				
				nivel2[size2] = (int) (Math.random() * Global.nivel2.size());
				size2++;
				
				while(verificaExistencia(nivel2,size2,num))
					num = (int) (Math.random() * Global.nivel2.size());
				
				nivel2[size2] = (int) (Math.random() * Global.nivel2.size());
				size2++;
				
				tam = 3;
			}
				
			for(int i = 0;i<5-tam;i++)
				modelos2.add(new Modelo_2());
			
		}
	}
	private void geraProblemasM3(){
		
		modelos3.clear();
		if(Global.nivel3.size() == 0){
			for(int i = 0;i<5;i++)
				modelos3.add(new Modelo_3());
					
			
		}else{
			int n = Global.nivel3.size();
			int tam = 0; 
			
			if(n == 1){
				nivel3[size3] = 0;	
				size3++;
				tam = n;
			}
			if(n==2){
				nivel3[size3] = 0;	
				size3++;
				
				nivel3[size3] = 1;	
				size3++;
				tam = n;			
			}
			if(n>=3){
				nivel3[size3] = (int) (Math.random() * Global.nivel3.size());
				size3++;
				int num = (int) (Math.random() * Global.nivel3.size());
				 
				while(verificaExistencia(nivel3,size3,num))
					num = (int) (Math.random() * Global.nivel3.size());
				
				nivel3[size3] = (int) (Math.random() * Global.nivel3.size());
				size3++;
				
				while(verificaExistencia(nivel3,size3,num))
					num = (int) (Math.random() * Global.nivel3.size());
				
				nivel3[size3] = (int) (Math.random() * Global.nivel3.size());
				size3++;
				
				tam = 3;
			}
				
			for(int i = 0;i<5-tam;i++)
				modelos3.add(new Modelo_3());		
			
		}
	}
	/*private void geraProblemasM4(){
		if(Global.nivel4.size() == 0){
			int [] array = new int [5];
			for(int i = 0;i<5;i++){
				int num = (int) (1 + Math.random() * 7);
				if(i>0)
					while(verificaExistencia(array,i,num))
						num = (int) (1 + Math.random() * 7);
				
				array[i] = num;
				switch(num){
					case 1:
						Modelo_4 model1 = new Modelo_4("imagesModel4\\problema1");
						modelos4.add(model1);
						break;
					case 2:
						Modelo_4 model2 = new Modelo_4("imagesModel4\\problema2");
						modelos4.add(model2);
						break;
					case 3:
						Modelo_4 model3 = new Modelo_4("imagesModel4\\problema3");
						modelos4.add(model3);
						break;
					case 4:
						Modelo_4 model4 = new Modelo_4("imagesModel4\\problema4");
						modelos4.add(model4);
						break;
					case 5:
						Modelo_4 model5 = new Modelo_4("imagesModel4\\problema5");
						modelos4.add(model5);
						break;
					case 6:
						Modelo_4 model6 = new Modelo_4("imagesModel4\\problema6");
						modelos4.add(model6);
						break;
					case 7:
						Modelo_4 model7 = new Modelo_4("imagesModel4\\problema7");
						modelos4.add(model7);
						break;
				}
					
			}
		}else{
			int n = Global.nivel4.size();
			int tam = 0; 
			
			if(n == 1){
				nivel4[size4] = 0;	
				size4++;
				tam = n;
			}
			if(n==2){
				nivel4[size4] = 0;	
				size4++;
				
				nivel4[size4] = 1;	
				size4++;
				tam = n;			
			}
			if(n>=3){
				nivel4[size4] = (int) (Math.random() * Global.nivel4.size());
				size4++;
				int num = (int) (Math.random() * Global.nivel4.size());
				 
				while(verificaExistencia(nivel4,size4,num))
					num = (int)( Math.random() * Global.nivel4.size());
				
				nivel4[size4] = (int) (Math.random() * Global.nivel4.size());
				size4++;
				
				while(verificaExistencia(nivel4,size4,num))
					num = (int) (Math.random() * Global.nivel4.size());
				
				nivel4[size4] = (int) (Math.random() * Global.nivel4.size());
				size4++;
				
				tam = 3;
			}
				
			int [] array = new int [5-tam];
			for(int i = 0;i<5-tam;i++){
				int num = (int) (1 + Math.random() * 7);
				if(i>0)
					while(verificaExistencia(array,i,num))
						num = (int) (1 + Math.random() * 7);
				
				array[i] = num;
				switch(num){
					case 1:
						Modelo_4 model1 = new Modelo_4("imagesModel4\\problema1.png");
						modelos4.add(model1);
						break;
					case 2:
						Modelo_4 model2 = new Modelo_4("imagesModel4\\problema.png");
						modelos4.add(model2);
						break;
					case 3:
						Modelo_4 model3 = new Modelo_4("imagesModel4\\problema3.png");
						modelos4.add(model3);
						break;
					case 4:
						Modelo_4 model4 = new Modelo_4("imagesModel4\\problema4.png");
						modelos4.add(model4);
						break;
					case 5:
						Modelo_4 model5 = new Modelo_4("imagesModel4\\problema5.png");
						modelos4.add(model5);
						break;
					case 6:
						Modelo_4 model6 = new Modelo_4("imagesModel4\\problema6.png");
						modelos4.add(model6);
						break;
					case 7:
						Modelo_4 model7 = new Modelo_4("imagesModel4\\problema7.png");
						modelos4.add(model7);
						break;
				}
			}
		}
	}*/
	private void geraProblemasM5(){
		
		modelos5.clear();
		if(Global.nivel5.size() == 0){
			for(int i = 0;i<5;i++)
				modelos5.add(new Modelo_5());					
			
		}else{
			int n = Global.nivel5.size();
			int tam = 0; 
			
			if(n == 1){
				nivel5[size5] = 0;	
				size5++;
				tam = n;
			}
			if(n==2){
				nivel5[size5] = 0;	
				size5++;
				
				nivel5[size5] = 1;	
				size5++;
				tam = n;			
			}
			if(n>=3){
				nivel5[size5] = (int) (Math.random() * Global.nivel5.size());
				size5++;
				int num = (int) (Math.random() * Global.nivel5.size());
				 
				while(verificaExistencia(nivel5,size5,num))
					num = (int) (Math.random() * Global.nivel5.size());
				
				nivel5[size5] = (int) (Math.random() * Global.nivel5.size());
				size5++;
				
				while(verificaExistencia(nivel5,size5,num))
					num = (int) (Math.random() * Global.nivel5.size());
				
				nivel5[size5] = (int) (Math.random() * Global.nivel5.size());
				size5++;
				
				tam = 3;
			}
				
			for(int i = 0;i<5-tam;i++)
				modelos5.add(new Modelo_5());
				
		}
	}
	
	private boolean verificaExistencia(int [] array, int tam, int num){
		for(int i = 0; i< tam; i++)
			if(array[i] == num)
				return true;
		
		return false;
	}
	
		 
	 private void showProblema() 
	 {
				setProgressBarNivel();
				setProgressbarProblema();
				setProblemText();
				setQuestionText();
				setTipText();
				 
				JButton btnResponder = new JButton();
				btnResponder.setBounds(575, 450, 151, 50);
				btnResponder.setIcon(new ImageIcon("images/imgbutton/botaoResponder.png"));
				FunnyMathUI.add(btnResponder);
				
				JLabel lblResposta = new JLabel("Resposta:");
				lblResposta.setFont(new Font("Verdana", Font.BOLD, 18));
				lblResposta.setBounds(89, 365, 105, 30);
				lblResposta.setBackground(Color.DARK_GRAY);
				lblResposta.setForeground(Color.WHITE);
				lblResposta.setOpaque(true);
				FunnyMathUI.add(lblResposta);
	
	//INSERE RESPOSTA...			
				
				inputResposta.setFont(new Font("Verdana", Font.PLAIN, 16));
				inputResposta.setBounds(199, 364, 98, 32);
				FunnyMathUI.add(inputResposta);
				inputResposta.setColumns(10);
				
				JLabel lblPontuao = new JLabel("Pontua\u00E7\u00E3o: ");
				lblPontuao.setFont(new Font("Verdana", Font.BOLD, 16));
				lblPontuao.setOpaque(true);
				lblPontuao.setBounds(305, 7, 105, 25);
				FunnyMathUI.add(lblPontuao);
				
								
				//Alterar o label conforme a pontuacao..			
				lblPontuacao_dinamico.setFont(new Font("Verdana", Font.PLAIN, 14));
				lblPontuacao_dinamico.setOpaque(true);
				lblPontuacao_dinamico.setBounds(420, 9, 48, 20);
				FunnyMathUI.add(lblPontuacao_dinamico);
				
				
			
		//EVENTO RESPONDER			
				btnResponder.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {	
						
						try{
							
							int resposta = Integer.parseInt(inputResposta.getText());
						
						if(resposta == solution){
							JOptionPane.showMessageDialog(FunnyMathUI, "Certo!");
							nresp++;
							trackRewards.SolveProblem(); //resolveu um problema bem, adicionar ao total
							int pont = 10*(nivel+1);
							
							if(!btnDica.isEnabled())
								 pont = pont/2;
							
							pontuacao += pont;
							Global.pontuacao = pontuacao;
							lblPontuacao_dinamico.setText(Integer.toString(pontuacao));
						}else
							JOptionPane.showMessageDialog(FunnyMathUI, "Errado");
						
						problema++;
						if(problema>=5){
							problema = 0;
							
							if(nresp >2){
								if(nivel == 3)								
									nivel += 2;
								else
									nivel++;
							}else{
								JOptionPane.showMessageDialog(FunnyMathUI, "Não conseguiste passar de nível :( ");
								geraProblemas();
							}	
							
							if(nivel<5)
								JOptionPane.showMessageDialog(FunnyMathUI, "NÍVEL "+ nivel);							
							if(nivel >= 5){								
								JOptionPane.showMessageDialog(FunnyMathUI, "Chegaste ao fim com "+pontuacao+" pontos!" );
								verificaSavePontuacao(pontuacao);								
								
								return;
							}
							
							
							nresp = 0;
						}
						
						setProgressBarNivel();
						setProgressbarProblema();
						setProblemText();
						setQuestionText();
						setTipText();
							
						inputResposta.setText("");		
						
						btnDica.setEnabled(true); //depois de responder o botao da dica fica disponivel
						//ter em atencao de kd se erra mantem o mm problema ou nao...
						
						
						}catch(NumberFormatException e){
							JOptionPane.showMessageDialog(FunnyMathUI, "Escreve só números na resposta.");
							return;
						}
					}
						
						
				});
								
				
				btnDica.setBackground(Color.ORANGE);
				btnDica.setFont(new Font("Verdana", Font.BOLD, 16));
				btnDica.setBounds(356, 296, 123, 37);
				btnDica.setEnabled(true); 
				FunnyMathUI.add(btnDica);	
	//EVENTO BOTAO DICA
				btnDica.addActionListener(new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {						   
						   pontuacao -= (10*(nivel+1))/2;
						   
						   if(pontuacao<=0)
							   pontuacao = 0;
						   
						   Global.pontuacao = pontuacao;
						   ProblemaDica.setVisible(true);	   
						   lblPontuacao_dinamico.setText(Integer.toString(pontuacao));
						   btnDica.setEnabled(false); //depois de usar.. nao deve estar enabled
					   }
				});
			
			
		 
		 			
	 }

	 private void verificaSavePontuacao(int pontos){
		 Pontuacao p; 
		 Global.pontuacao = pontos;
		 if(Global.pontuacoes.size()<10){			 
			 p = new Pontuacao(Global.pontuacao,nome);
			 Global.pontuacoes.add(p);
		 }else
			 if(pontos > Global.pontuacoes.get(9).getPontos()){
				 p = new Pontuacao(Global.pontuacao,nome);
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
	 
	 private void setProgressBarNivel(){
		 switch(nivel){
			case 1:
				progressBar_Nivel.setToolTipText("Nivel 1");			
				progressBar_Nivel.setValue(0);
				break;
			case 2:
				progressBar_Nivel.setToolTipText("Nivel 2");			
				progressBar_Nivel.setValue(25);
				break;
			case 3:
				progressBar_Nivel.setToolTipText("Nivel 3");			
				progressBar_Nivel.setValue(50);
				break;
			case 4:
				progressBar_Nivel.setToolTipText("Nivel 4");			
				progressBar_Nivel.setValue(75);
				break;
			case 5:
				progressBar_Nivel.setToolTipText("Nivel 5");			
				progressBar_Nivel.setValue(100);
				break;
		}			
		
		progressBar_Nivel.setStringPainted(true);
		progressBar_Nivel.setBounds(575, 11, 164, 23);
		FunnyMathUI.add(progressBar_Nivel);
	 }
	 private void setProgressbarProblema(){
		 switch(problema){
			case 0:
				progressBar_Problema.setToolTipText("Problema 1");			
				progressBar_Problema.setValue(0);
				break;
			case 1:
				progressBar_Problema.setToolTipText("Problema 2");			
				progressBar_Problema.setValue(25);
				break;
			case 2:
				progressBar_Problema.setToolTipText("Problema 3");			
				progressBar_Problema.setValue(50);
				break;
			case 3:
				progressBar_Problema.setToolTipText("Problema 4");			
				progressBar_Problema.setValue(75);
				break;
			case 4:
				progressBar_Problema.setToolTipText("Problema 5");			
				progressBar_Problema.setValue(100);
				break;
		}	
		 
		progressBar_Problema.setStringPainted(true);
		progressBar_Problema.setBounds(30, 11, 164, 23);
		FunnyMathUI.add(progressBar_Problema);
		
	 }
	 private void setProblemText(){
		ProblemaPart1.setFont(new Font("Verdana", Font.PLAIN, 14));
		ProblemaPart1.setEditable(false);
		ProblemaPart1.setForeground(Color.black);
		
		String s = "";
		switch(nivel){		
			case 1:
				s = getTextNivel1();
				break;
			case 2:
				s = getTextNivel2();
				break;
			case 3:
				s = getTextNivel3();
				break;
			//case 4:
			//	s = getTextNivel4();
				//break;
			case 5:
				s = getTextNivel5();
				break;
		}
		ProblemaPart1.setText(s);	
		Problem1Scroll.setBounds(30, 70, 470, 115);		
		FunnyMathUI.add(Problem1Scroll);
	 }
	  
	 private String getTextNivel1(){
		 String s ="";
		 
		 if(problema<size1)
			 s += Global.nivel1.get(nivel1[problema]).getProblema();
		 
		 else
			 s += modelos1.get(problema).getText();
		 		 
		
		btnImagemProblema.setIcon(new ImageIcon(modelos1.get(problema).getImageName()));
	    btnImagemProblema.setEnabled(false); //para nao clicar
	    btnImagemProblema.setDisabledIcon(new ImageIcon(modelos1.get(problema).getImageName()));
		btnImagemProblema.setBounds(505, 50, 287, 330);
			
		FunnyMathUI.add(btnImagemProblema);
			 
		 
		 return s;
	 }
	 private String getTextNivel2(){
		 String s ="";
		 
		 if(problema<size2)
			 s += Global.nivel2.get(nivel2[problema]).getProblema();
		 
		 else
			 s += modelos2.get(problema).getText();
		 

		btnImagemProblema.setIcon(new ImageIcon(modelos2.get(problema).getImageName()));
		btnImagemProblema.setEnabled(false); //para nao clicar
		btnImagemProblema.setDisabledIcon(new ImageIcon(modelos2.get(problema).getImageName()));
		btnImagemProblema.setBounds(532, 70, 206, 262);
		FunnyMathUI.add(btnImagemProblema);
			 
		 return s;
	 }
	 private String getTextNivel3(){
		 String s ="";
		 
		 if(problema<size3)
			 s += Global.nivel3.get(nivel3[problema]).getProblema();
		 
		 else
			 s += modelos3.get(problema).getText();
		 
		 	btnImagemProblema.setIcon(new ImageIcon(modelos3.get(problema).getImageName()));
			btnImagemProblema.setEnabled(false); //para nao clicar
			btnImagemProblema.setDisabledIcon(new ImageIcon(modelos3.get(problema).getImageName()));
			btnImagemProblema.setBounds(532, 70, 206, 262);
			FunnyMathUI.add(btnImagemProblema);
			 
		 
		 return s;
	 }
	 /*private String getTextNivel4(){
		 String s ="";
		 
		 if(problema<size4)
			 s += Global.nivel.get(nivel4[problema]).getProblema();
		 
		 else
			 s += modelos4.get(problema).getText();
			 
		 
		btnImagemProblema.setIcon(new ImageIcon("images/monkey.jpg"));
		btnImagemProblema.setEnabled(false); //para nao clica
		btnImagemProblema.setDisabledIcon(new ImageIcon("images/monkey.jpg"));
		btnImagemProblema.setBounds(532, 70, 206, 262);
		FunnyMathUI.add(btnImagemProblema);
			 
		 
		 return s;
	 }*/
	 private String getTextNivel5(){
		 String s ="";
		 
		 if(problema<size5)
			 s += Global.nivel5.get(nivel5[problema]).getProblema();
		 
		 else
			 s += modelos5.get(problema).getText();
			 
		 	btnImagemProblema.setIcon(new ImageIcon(modelos5.get(problema).getImageName()));
			btnImagemProblema.setEnabled(false); //para nao clicar
			btnImagemProblema.setDisabledIcon(new ImageIcon(modelos5.get(problema).getImageName()));
			btnImagemProblema.setBounds(532, 70, 206, 262);
			FunnyMathUI.add(btnImagemProblema);
		 
		 return s;
	 }
	 
	 
	 private void setQuestionText(){
		 
		 String s = "";
			switch(nivel){		
				case 1:
					s = getQuestionNivel1();
					break;
				case 2:
					s = getQuestionNivel2();
					break;
				case 3:
					s = getQuestionNivel3();
					break;
				//case 4:
					//s = getQuestionNivel4();
					//break;
				case 5:
					s = getQuestionNivel5();
					break;
			}
			
	
		ProblemaPart2_question.setForeground(Color.black);		 
		ProblemaPart2_question.setFont(new Font("Verdana", Font.PLAIN, 14));
		ProblemaPart2_question.setEditable(false);
		ProblemaPart2_question.setText(s);			
		Problem2Scroll.setBounds(30, 203, 470, 70);		
		FunnyMathUI.add(Problem2Scroll);
	 }
	 
	 private String getQuestionNivel1(){
		 String s ="";
		 
		 if(problema<size1)
			 s += Global.nivel1.get(nivel1[problema]).getQuestão();
		 
		 else
			 s += modelos1.get(problema).getQuestion();
			 
		 
		 return s;
	 }
	 private String getQuestionNivel2(){
		 String s ="";
		 
		 if(problema<size2)
			 s += Global.nivel2.get(nivel2[problema]).getQuestão();
		 
		 else
			 s += modelos2.get(problema).getQuestion();
			 
		 
		 return s;
	 }
	 private String getQuestionNivel3(){
		 String s ="";
		 
		 if(problema<size3)
			 s += Global.nivel3.get(nivel3[problema]).getQuestão();
		 
		 else
			 s += modelos3.get(problema).getQuestion();
			 
		 
		 return s;
	 }
	 /*private String getQuestionNivel4(){
		 String s ="";
		 
		 if(problema<size4)
			 s += Global.nivel4.get(nivel4[problema]).getQuestão();
		 
		 else
			 s += modelos4.get(problema).getQuestion();
			 
		 
		 return s;
	 }*/
	 private String getQuestionNivel5(){
		 String s ="";
		 
		 if(problema<size5)
			 s += Global.nivel5.get(nivel5[problema]).getQuestão();
		 
		 else
			 s += modelos5.get(problema).getQuestion();
			 
		 
		 return s;
	 }
	 
	 
	 private void setTipText(){
		 String s = "";
			switch(nivel){		
				case 1:
					s = getTipNivel1();
					break;
				case 2:
					s = getTipNivel2();
					break;
				case 3:
					s = getTipNivel3();
					break;
				//case 4:
				//	s = getTipNivel4();
				//	break;
				case 5:
					s = getTipNivel5();
					break;
			}
			
			ProblemaDica.setFont(new Font("Verdana", Font.PLAIN, 14));
			ProblemaDica.setText(s);
			ProblemaDica.setEditable(false);
			ProblemaDica.setForeground(Color.black);
			DicaScroll.setBounds(30, 296, 290, 40);
			ProblemaDica.setVisible(false); //ainda nao..
			FunnyMathUI.add(DicaScroll);	
	 }
	 	 
	 private String getTipNivel1(){
		 String s ="";
		 
		 if(problema<size1){
			 s += Global.nivel1.get(nivel1[problema]).getEasyTip();
			 solution = Global.nivel1.get(nivel1[problema]).getSolução();
		 }
		 
		 else{
			 s += modelos1.get(problema).getEasyTip();
			 solution = modelos1.get(problema).getSolution();
		 }
			 
		 
		 return s;
	 }
	 private String getTipNivel2(){
		 String s ="";
		 
		 if(problema<size2){
			 s += Global.nivel2.get(nivel2[problema]).getEasyTip();
			 solution = Global.nivel2.get(nivel2[problema]).getSolução();
		 }
		 
		 else{
			 s += modelos2.get(problema).getEasyTip();
			 solution = modelos2.get(problema).getSolution();
		 }
			 
		 
		 return s;
	 }
	 private String getTipNivel3(){
		 String s ="";
		 
		 if(problema<size3){
			 s += Global.nivel3.get(nivel3[problema]).getEasyTip();
			 solution = Global.nivel3.get(nivel3[problema]).getSolução();
		 }else{
			 s += modelos3.get(problema).getEasyTip();
			 solution = modelos3.get(problema).getSolution();
		 }
		 
		 return s;
	 }
	/* private String getTipNivel4(){
		 String s ="";
		 
		 if(problema<size4){
			 s += Global.nivel4.get(nivel4[problema]).getEasyTip();
			 solution = Global.nivel4.get(nivel4[problema]).getSolução();
		 
		 }else{
			 s += modelos4.get(problema).getEasyTip();
			 
		 }
			 
		 
		 return s;
	 }*/
	 private String getTipNivel5(){
		 String s ="";
		 
		 if(problema<size5){
			 s += Global.nivel5.get(nivel5[problema]).getEasyTip();
			 solution = Global.nivel5.get(nivel5[problema]).getSolução();
		 
		 }else{
			 s += modelos5.get(problema).getEasyTip();
			 solution = modelos5.get(problema).getSolution();
		 }
			 
		 
		 return s;
	 }
	 
	 
	 
	 public JProgressBar getProgressBar_Problema() {
		return progressBar_Problema;
	}




	public void setProgressBar_Problema(JProgressBar progressBar_Problema) {
		this.progressBar_Problema = progressBar_Problema;
	}




	public JProgressBar getProgressBar_Nivel() {
		return progressBar_Nivel;
	}




	public void setProgressBar_Nivel(JProgressBar progressBar_Nivel) {
		this.progressBar_Nivel = progressBar_Nivel;
	}




	public JButton getBtnImagemProblema() {
		return btnImagemProblema;
	}




	public void setBtnImagemProblema(JButton btnImagemProblema) {
		this.btnImagemProblema = btnImagemProblema;
	}




	public JTextArea getProblemaPart1() {
		return ProblemaPart1;
	}




	public void setProblemaPart1(JTextArea problemaPart1) {
		ProblemaPart1 = problemaPart1;
	}




	public JTextArea getProblemaPart2_question() {
		return ProblemaPart2_question;
	}




	public void setProblemaPart2_question(JTextArea problemaPart2_question) {
		ProblemaPart2_question = problemaPart2_question;
	}




	public JTextArea getProblemaDica() {
		return ProblemaDica;
	}




	public void setProblemaDica(JTextArea problemaDica) {
		ProblemaDica = problemaDica;
	}




	public JTextField getInputResposta() {
		return inputResposta;
	}




	public void setInputResposta(JTextField inputResposta) {
		this.inputResposta = inputResposta;
	}




	public JLabel getLblPontuacao_dinamico() {
		return lblPontuacao_dinamico;
	}




	public void setLblPontuacao_dinamico(JLabel lblPontuacao_dinamico) {
		this.lblPontuacao_dinamico = lblPontuacao_dinamico;
	}



	
	
}
			
	 
	 

