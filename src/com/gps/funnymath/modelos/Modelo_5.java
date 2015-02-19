package com.gps.funnymath.modelos;

import java.io.Serializable;
import java.util.ArrayList;

import com.gps.funnymath.domains.NounDomain;

public class Modelo_5 extends Modelo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5021357540844299236L;
	private ArrayList<NounDomain> sujeitos = new ArrayList<NounDomain>();
	private String[][] objectosFixos = { {"Triciclos","3"},{"Carrinhos","4"},{"Bicicletas","2"}};	                                                              
		
	private int sujeito;
	private int solution;
	private int valor;
	private int objecto1, objecto2;
	private int mat;
	private String imageName;
	
	
	public Modelo_5(){
		super();
		
		sujeito = solution = valor = objecto1 = objecto2 = mat = -1;
		
		sujeitos.add(new NounDomain("o João"));
		sujeitos.add(new NounDomain("o José"));
		sujeitos.add(new NounDomain("a Maria"));
		sujeitos.add(new NounDomain("a Carla"));
		
		constructText();
		constructQuestion();
		constructEasyTip();
	}
	
	
	public void constructText(){
		if(sujeitos.size() == 0)
			return;
		
				
		//primeiro nome
		sujeito = (int) (Math.random() * (sujeitos.size())); //pode.. nao ha prob		
	
		//nome(index) do 1º objecto(fixo)	
		objecto1 = (int) (Math.random() *3);	
				
		//nome(index) do outro objecto(fixo)
		do{
			objecto2 = (int) (Math.random() *3); 
		}while(objecto1 == objecto2);
		
		//material (rodas)
		 
		
        //Primeiro gera-se a soluçao, que depois cria o numero total de rodas				
		// (de 2 a 30) (aperfeiçoar niveis caso necessario)
		solution = (int) (2 + Math.random()*29);
		
				
		//valor total de rodas 		
		          //TRICICLO ou CARRO ou BICICLETA consoante o random...
		valor = (solution*Integer.parseInt(objectosFixos[objecto1][1])) 
					+ (solution*Integer.parseInt(objectosFixos[objecto2][1]));
					
				
		
		//[SUJEITO] tem [OBJECTO1] e [OBJECTO2] na sua caixa de brinquedos.
		//Contou [NUMERO] [MATERIAL-RODAS] e o numero de [OBJECTO1] é o mesmo que o número de [OBJECTO2].
		
		imageName = "images/modelos/5/modelo5.png";


		String t = sujeitos.get(sujeito).toString() + " tem " + objectosFixos[objecto1][0] + " e "
				+ objectosFixos[objecto2][0] + " na sua caixa de brinquedos.\n" 
				+ "Contou " + valor + " rodas" + ",\ne o número de "
				+ objectosFixos[objecto1][0] + " é o mesmo que o numero de " 
				+ objectosFixos[objecto2][0] + ".\n";
				
	
		super.setText(t);
	}
	
	public void constructQuestion(){
		if(sujeitos.size() == 0)
			return;
		
		//Quantos [OBJECTO1] e [OBJECTO2] tem [SUJEITO] na sua caixa?
		String t = "Quantos " +objectosFixos[objecto1][0] +" e " 
				+ objectosFixos[objecto2][0] + " tem " + sujeitos.get(sujeito).toString()
				+ " na sua caixa?";
						
		super.setQuestion(t);
		
	}
	
	
	public void constructEasyTip(){
		if(super.getText() == " " || super.getQuestion() == " ")
			return;
		
		//array onde vão estar as opções de resposta
		int[] etOptions = {-1,-1,-1};
		int val;
			
		//gerar uma posição aleatória no array para a solução correcta
		etOptions[(int) (Math.random() * 3)] = solution;
						
		//gerar uma posição aleatória no array para a primeira solução errada
		do{
			val = (int) (Math.random() * 3);
		}while(etOptions[val] != -1);
				
				
		//solução errada entre solução+1 e solução+10
		etOptions[val] =(int)(solution + 1 +  Math.random()*10);
			
		//ver qual é a posição no array que falta preencher
		val=-1;
		do{
			val++;
		}while(etOptions[val] != -1);
		
		//solução errada entre solução/1 e solução/3
		etOptions[val] = (int)(solution/(1 + Math.random()*3));
				
		String et = "Uma destas três opções está correcta:\n"+"  a) "+etOptions[0]
				+"   b) "+etOptions[1]+"  c)"+etOptions[2];
				
		super.setEasyTip(et);
		
	}
	
	public int getSolution(){
		if(super.getQuestion() == " ")
			return -1;	
		

	   if(this.solution!=-1) 
		   return solution; //a solucao é automaticamente criada ao criar o problema (aleatoriamente)
	   else
		   return -1;
	}

	public void setSolution(int solution) {this.solution = solution;}
	
	public ArrayList<NounDomain> getSujeitos() {return sujeitos;}
	public void setSujeitos(ArrayList<NounDomain> sujeitos) {this.sujeitos = sujeitos;}
	
	public String[][] getObjectos() {return objectosFixos;}
	public void setObjectos(String[][] objectos) {this.objectosFixos = objectos;}


	public int getSujeito() {return sujeito;}
	public void setSujeito(int sujeito) {this.sujeito = sujeito;}


	public int getValor() {return valor;}
	public void setValor(int valor) {this.valor = valor;}


	public int getObjecto1() {return objecto1;}
	public void setObjecto1(int objecto1) {this.objecto1 = objecto1;}


	public int getObjecto2() {return objecto2;}
	public void setObjecto2(int objecto2) {this.objecto2 = objecto2;}


	public int getMat() {return mat;}
	public void setMat(int mat) {this.mat = mat;}


	public String[][] getObjectosFixos() {
		return objectosFixos;
	}


	public void setObjectosFixos(String[][] objectosFixos) {
		this.objectosFixos = objectosFixos;
	}
	
	public String getImageName() {return imageName;}
	public void setImageName(String imageName) {this.imageName = imageName;}


	
}
