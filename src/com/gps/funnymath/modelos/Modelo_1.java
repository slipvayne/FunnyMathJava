package com.gps.funnymath.modelos;

import java.io.Serializable;
import java.util.ArrayList;

import com.gps.funnymath.domains.NounDomain;

public class Modelo_1 extends Modelo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5639724634560068329L;
	private String imageName;   //O nome tem de ser no formato "imagem1 22" onde 22 é a solução
	private String sujeitoImage1;
	private String sujeitoImage2;
	
	private int solution;
	private int sujeito1, sujeito2, nome ;
	
	private ArrayList<NounDomain> sujeitos = new ArrayList<NounDomain>();
	private ArrayList<NounDomain> nomesProprios = new ArrayList<NounDomain>();
	
	
	public Modelo_1(String imageName, int Solution){
		super();
		
				
		this.imageName = imageName;
		
		solution = sujeito1 = sujeito2 = nome = -1;
		
		if(solution<-1 ||  solution > 1000)//verificar se 1000 é um valor adequado
			solution = -1;
		
		solution = Solution; //recebida como argumento (better)
		
		
			
		criarSujeitos();
		criarNomesProprios();	

		constructText();
		setImages();

		
		constructQuestion();
		constructEasyTip();
	
	}
	
	public void criarSujeitos(){
		NounDomain e1 = new NounDomain("o Gato");
		NounDomain e2 = new NounDomain("o Peixe");
		NounDomain e3 = new NounDomain("o Cão");
		NounDomain e4 = new NounDomain("o Pássaro");
		
		sujeitos.add(e1);
		sujeitos.add(e2);
		sujeitos.add(e3);
		sujeitos.add(e4);
	}
	
	public void criarNomesProprios(){
		NounDomain e1 = new NounDomain("Tico");
		NounDomain e2 = new NounDomain("Pantufa");
		NounDomain e3 = new NounDomain("Biscoito");
		NounDomain e4 = new NounDomain("Tareca");
		NounDomain e5 = new NounDomain("Niko");
		
		nomesProprios.add(e1);
		nomesProprios.add(e2);
		nomesProprios.add(e3);
		nomesProprios.add(e4);
		nomesProprios.add(e5);
	}
	
	private void setImages(){
		if(sujeito1<0 || sujeito2<0 || nome<0)
			return;
		
		//Os nomes das imagesn serão iguais ao nome dado aos elementos do dominio
	// sujeitoImage1 = "imagesModel1\\"+sujeitos.get(sujeito1).toString()+".png";
	//	sujeitoImage2 = "imagesModel1\\"+sujeitos.get(sujeito2).toString()+".png";
		
		//TODO LATER
		
	}
	
	public void constructText(){
		
	
				
		if(sujeitos.size() == 0 || nomesProprios.size() == 0)
				return;
		

		//escolher o primeiro sujeito para o texto
		sujeito1 = (int) (Math.random() * (sujeitos.size()));
		
		
		//escolher o segundo sujeito para o texto e garantir que é diferente do primeiro

		do{
			sujeito2 = (int) (Math.random() * (sujeitos.size()));	
		}while(sujeito1 == sujeito2);
	
		
		//escolher o nbome proprio do texto
		nome = (int) (Math.random() * (nomesProprios.size()));
		
			//concatenar todo o texto
		String t = "Para chegar até ao Peixe" 
				//sujeitos.get(sujeito1)
				+",\no Gato "
				//+",\n"+sujeitos.get(sujeito2)
				+ nomesProprios.get(nome)+
				" tem de seguir o percurso assinalado na figura.";
		
		setImages();
		
		//fazer set do texto
		super.setText(t);
	}
	public void constructQuestion(){
		if(super.getText() == " ")
			return;
		
		String q = "Que distância, em metros, terá de percorrer?";
		super.setQuestion(q);
		
	}
	public void constructEasyTip(){
		if(super.getText() == " " || super.getQuestion() == " ")
				return;
		
		
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
		etOptions[val] = (int)(solution + 1 +  Math.random()*10);
		
		
		//ver qual é a posição no array que falta preencher
		val=-1;
		do{
			val++;
		}while(etOptions[val] != -1);
		
		//solução errada entre solução/1 e solução/3
		etOptions[val] = (int) (solution/(1 + Math.random()*3));
		
		
		String et = "Uma destas três opções está correcta:\n"+"  a) "+etOptions[0]
				+"   b) "+etOptions[1]+"  c)"+etOptions[2];
		
		super.setEasyTip(et);
		
	}

	public String getImageName() {return imageName;}
	public void setImageName(String imageName) {this.imageName = imageName;}

	public String getSujeitoImage1() {return sujeitoImage1;}
	public void setSujeitoImage1(String sujeitoImage1) {this.sujeitoImage1 = sujeitoImage1;}

	public String getSujeitoImage2() {return sujeitoImage2;}
	public void setSujeitoImage2(String sujeitoImage2) {this.sujeitoImage2 = sujeitoImage2;}

	public int getSolution() {
		
			return solution;
		}

	public int getSujeito1() {return sujeito1;}
	public void setSujeito1(int sujeito1) {this.sujeito1 = sujeito1;}

	public int getSujeito2() {return sujeito2;}
	public void setSujeito2(int sujeito2) {this.sujeito2 = sujeito2;}

	public int getNome() {return nome;}
	public void setNome(int nome) {this.nome = nome;}

	public ArrayList<NounDomain> getSujeitos() {return sujeitos;}
	public void setSujeitos(ArrayList<NounDomain> sujeitos) {this.sujeitos = sujeitos;}

	public ArrayList<NounDomain> getNomesProprios() {return nomesProprios;}
	public void setNomesProprios(ArrayList<NounDomain> nomesProprios) {this.nomesProprios = nomesProprios;}

	public void setSolution(int solution) {
		this.solution = solution;
	}
	
	
}
