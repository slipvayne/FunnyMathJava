package com.gps.funnymath.modelos;

import java.io.Serializable;

public class ProblemaEditado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5006685143271641056L;
	private String problema;
	private String questão;
	private int solution;
	private String easyTip;
	
	
	
	
	
	
	public ProblemaEditado(String problema, String questão, int solução) {
		super();
		this.problema = problema;
		this.questão = questão;
		this.solution = solução;
		
		gerarEasyTip();
	}
	
	public void gerarEasyTip(){
		//array onde vão estar as opções de resposta
				int[] etOptions = {-1,-1,-1};
				int val;
				
				//gerar uma posição aleatória no array para a solução correcta
				etOptions[(int) (Math.random() * 3)] = solution;
				
				//(TODO Nota: rever bem a partir daqui, que pode tar qualquer coisa a falhar, dps nos testes ve-se)
				
				//gerar uma posição aleatória no array para a primeira solução errada
				do{
					val = (int) (Math.random() * 3); 
				}while(etOptions[val] != -1); 
				
				
				
				//solução errada entre solução+1 e solução+10
				etOptions[val] = (int) (solution + 1 +  Math.random()*10);
				
				
				//ver qual é a posição no array que falta preencher
				val=-1;
				do{
					val++;
				}while(etOptions[val] != -1);
				
				//solução errada entre solução/1 e solução/3
				etOptions[val] =(int)(solution/(1 + Math.random()*3));
				
				
				String et = "Uma destas três opções está correcta:\n\n"+"  a) "+etOptions[0]
						+"   b) "+etOptions[1]+"  c)"+etOptions[2];
				
				easyTip = et;
	}
	
	public String getProblema() {
		return problema;
	}
	public String getQuestão() {
		return questão;
	}
	public int getSolução() {
		return solution;
	}
	public String getEasyTip() {
		return easyTip;
	}
	public void setProblema(String problema) {
		this.problema = problema;
	}
	public void setQuestão(String questão) {
		this.questão = questão;
	}
	public void setSolução(int solução) {
		this.solution = solução;
	}
	public void setEasyTip(String easyTip) {
		this.easyTip = easyTip;
	}
	
	

}
