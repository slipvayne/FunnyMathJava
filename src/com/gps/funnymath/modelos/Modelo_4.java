package com.gps.funnymath.modelos;

import java.io.Serializable;

public class Modelo_4 extends Modelo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6301908678679267384L;

	private String imageName;
	
	private int cir1, cir2, cir3;
	private int qua1, qua2, qua3;
	private int et_i, et_j, et_k; //respostas certas para a easy tip
	
	
	public Modelo_4(String imageName){
		super();
		
		this.imageName = "images\\"+imageName+".png"; //nota: esta imagem deve ser fixa (triangulo)
		//imageName = "images\\problema4.png";
		
		cir1 = cir2 = cir3 = qua1 = qua2 = qua3 = -1;
		et_i = et_j = et_k = -1;
		constructText();
		constructQuestion();
		constructEasyTip();
	}
	
	public void constructText(){
		
		boolean combinacao = false; //combinação de valores do quadrado ok?
		
		
		do{
			//gerar os numeros dos quadrados
			qua1 = (int) ( (1 + Math.random()*9) * (2 + Math.random()*9)); // (1-9) * (2-10)
			qua2 = (int) ( (1 + Math.random()*9) * (2 + Math.random()*9));
			qua3 = (int) ( (1 + Math.random()*9) * (2 + Math.random()*9));
		
			//verificar se é uma boa combinação
            principal : for(int i=1; i<=10; i++){ //principal é a label para fazer o break
            	for(int j=1; j<=10; j++){
            		if( (i*j) == qua1) { //quadrado 1 ok?
            			et_i = i;
            			et_j = j;
                        for(int k=1; k<=10; k++){
                        	if( (j*k) == qua2 ){ //quadrado 2 ok?
                        		et_k = k;
                                if( (i*k) == qua3){ //quadrado 3 ok?
                                	combinacao = true; //numeros gerados ok!
                                    break principal;
                                }
                        	}
                        }
            		}
            	}
            }
			
		}while(combinacao == false);
		
		
		String t = "Completa de acordo com o seguinte dado:\n"
				+ "Se multiplicares os numeros que estao nos circulos,"
				+ " obtens o numero que esta escrito no quadrado, entre eles.\n";
			
		super.setText(t);
	}
	
	public void constructQuestion(){
		
		String t = "Descobre-os.\n";
				
		super.setQuestion(t);
	}
	
	public void constructEasyTip(){
	  //GERAR 3 NUMEROS PARA CADA SOLUÇÃO
		
		//array onde vão estar as opções de resposta
		int[] etOptions1 = {-1,-1,-1};
		int[] etOptions2 = {-1,-1,-1};
		int[] etOptions3 = {-1,-1,-1};
		int val;
		int posicao_certa;
			
		//gerar uma posição aleatória no array para a solução correcta
		posicao_certa = (int) (Math.random() * 3);
		etOptions1[posicao_certa] = et_i;
		etOptions2[posicao_certa] = et_j;
		etOptions3[posicao_certa] = et_k;
		
		
		//gerar uma posição aleatória no array para a primeira solução errada
		do{
			val = (int) (Math.random() * 3);
		}while( (etOptions1[val] != -1) && (etOptions2[val] != -1) && (etOptions3[val] != -1) );
			
		//solução errada entre solução+1 e solução+10
		etOptions1[val] = et_i + 1 + ((int) Math.random()*10);
		etOptions2[val] = et_j + 1 + ((int) Math.random()*10);
		etOptions3[val] = et_k + 1 + ((int) Math.random()*10);
			
			
		//ver qual é a posição no array que falta preencher
		val=-1;
		do{
			val++;
		}while( (etOptions1[val] != -1) && (etOptions2[val] != -1) && (etOptions3[val] != -1) );
			
		//solução errada entre solução/1 e solução/3
		etOptions1[val] = et_i/(1 + ((int) Math.random()*3));
		etOptions2[val] = et_j/(1 + ((int) Math.random()*3));
		etOptions3[val] = et_k/(1 + ((int) Math.random()*3));
			
			
		String et = "Uma destas três opções está correcta:\n"
		+"  a) "+etOptions1[0]+"/"+etOptions2[0]+"/"+etOptions3[0]
				+"   b) "+etOptions1[1]+"/"+etOptions2[1]+"/"+etOptions3[1]
				+"  c)"+etOptions1[2]+"/"+etOptions2[2]+"/"+etOptions3[2];
		
		super.setEasyTip(et);
	}

	
	public String getImageName() {return imageName;}
	public void setImageName(String imageName) {this.imageName = imageName;}

	public int getCir1() {return cir1;}
	public void setCir1(int cir1) {this.cir1 = cir1;}

	public int getCir2() {return cir2;}
	public void setCir2(int cir2) {this.cir2 = cir2;}

	public int getCir3() {return cir3;}
	public void setCir3(int cir3) {this.cir3 = cir3;}

	public int getQua1() {return qua1;}
	public void setQua1(int qua1) {this.qua1 = qua1;}

	public int getQua2() {return qua2;}
	public void setQua2(int qua2) {this.qua2 = qua2;}

	public int getQua3() {return qua3;}
	public void setQua3(int qua3) {this.qua3 = qua3;}

	public int getEt_i() {return et_i;}
	public void setEt_i(int et_i) {this.et_i = et_i;}

	public int getEt_j() {return et_j;}
	public void setEt_j(int et_j) {this.et_j = et_j;}

	public int getEt_k() {return et_k;}
	public void setEt_k(int et_k) {this.et_k = et_k;}
	
	
}
