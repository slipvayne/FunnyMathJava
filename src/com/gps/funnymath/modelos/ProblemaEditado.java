package com.gps.funnymath.modelos;

import java.io.Serializable;

public class ProblemaEditado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5006685143271641056L;
	private String problema;
	private String quest�o;
	private int solution;
	private String easyTip;
	
	
	
	
	
	
	public ProblemaEditado(String problema, String quest�o, int solu��o) {
		super();
		this.problema = problema;
		this.quest�o = quest�o;
		this.solution = solu��o;
		
		gerarEasyTip();
	}
	
	public void gerarEasyTip(){
		//array onde v�o estar as op��es de resposta
				int[] etOptions = {-1,-1,-1};
				int val;
				
				//gerar uma posi��o aleat�ria no array para a solu��o correcta
				etOptions[(int) (Math.random() * 3)] = solution;
				
				//(TODO Nota: rever bem a partir daqui, que pode tar qualquer coisa a falhar, dps nos testes ve-se)
				
				//gerar uma posi��o aleat�ria no array para a primeira solu��o errada
				do{
					val = (int) (Math.random() * 3); 
				}while(etOptions[val] != -1); 
				
				
				
				//solu��o errada entre solu��o+1 e solu��o+10
				etOptions[val] = (int) (solution + 1 +  Math.random()*10);
				
				
				//ver qual � a posi��o no array que falta preencher
				val=-1;
				do{
					val++;
				}while(etOptions[val] != -1);
				
				//solu��o errada entre solu��o/1 e solu��o/3
				etOptions[val] =(int)(solution/(1 + Math.random()*3));
				
				
				String et = "Uma destas tr�s op��es est� correcta:\n\n"+"  a) "+etOptions[0]
						+"   b) "+etOptions[1]+"  c)"+etOptions[2];
				
				easyTip = et;
	}
	
	public String getProblema() {
		return problema;
	}
	public String getQuest�o() {
		return quest�o;
	}
	public int getSolu��o() {
		return solution;
	}
	public String getEasyTip() {
		return easyTip;
	}
	public void setProblema(String problema) {
		this.problema = problema;
	}
	public void setQuest�o(String quest�o) {
		this.quest�o = quest�o;
	}
	public void setSolu��o(int solu��o) {
		this.solution = solu��o;
	}
	public void setEasyTip(String easyTip) {
		this.easyTip = easyTip;
	}
	
	

}
