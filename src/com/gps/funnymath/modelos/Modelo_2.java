package com.gps.funnymath.modelos;

import java.io.Serializable;
import java.util.ArrayList;

import com.gps.funnymath.domains.NounDomain;

public class Modelo_2 extends Modelo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5051115410020224077L;
	private ArrayList<NounDomain> sujeitos = new ArrayList<NounDomain>();
	private ArrayList<NounDomain> locais = new ArrayList<NounDomain>();
	private ArrayList<NounDomain> recipientes = new ArrayList<NounDomain>();
	private ArrayList<NounDomain> items = new ArrayList<NounDomain>();
	private String[] valores = {"Metade"};
	private String[] actions = {"Perdeu","Ganhou"};
	
	private int sujeito1, sujeito2, sujeito3, valor, action1, action2, local, recipiente, item;
	private int solution;
	private int val1,val2,val3;
	private String imageName;	
	
	
	public Modelo_2(){
		super();
		
		sujeito1 = sujeito2 = sujeito3 = valor = action1 = action2 = local = recipiente = item = -1;
		solution = val1 = val2 = val3 = -1;	
		
		sujeitos.add(new NounDomain("o João"));
		sujeitos.add(new NounDomain("o José"));
		sujeitos.add(new NounDomain("a Maria"));
		sujeitos.add(new NounDomain("a Carla"));
		
		locais.add(new NounDomain("Escola"));
		locais.add(new NounDomain("Casa"));
		locais.add(new NounDomain("Campo de Futebol"));
		locais.add(new NounDomain("Aula de ballet"));
		
		recipientes.add(new NounDomain("uma Bolsa"));
		recipientes.add(new NounDomain("uma Caixa"));
		recipientes.add(new NounDomain("um Caixote"));
		
		items.add(new NounDomain("berlindes"));
		items.add(new NounDomain("bolas"));
		items.add(new NounDomain("dados"));
		
		constructText();
		constructQuestion();
		constructEasyTip();
	}
	
	public void constructText(){
		
		
		if(sujeitos.size() == 0 || locais.size() == 0 
		   || recipientes.size() == 0 || items.size() == 0)
			return;
		
		//primeiro nome
		sujeito1 = (int) (Math.random() * (sujeitos.size()));
		
		//nome do primeiro amigo
		do{
			sujeito2 = (int) (Math.random() * (sujeitos.size()));
		}while(sujeito1 == sujeito2);
		
		
		//nome do segundo amigo
		do{
			sujeito3 = (int) (Math.random() * (sujeitos.size()));
		}while(sujeito2 == sujeito3 || sujeito1 == sujeito3);
		
		//quantidade perdida no inicio
		valor = 0;
		
		//perdeu ou ganhou
		action1 = (int) (Math.random() * 2);
		
		//perdeu ou ganhou
		action2 = (int) (Math.random() * 2);
		
		//para onde vai
		local = (int) (Math.random() *(locais.size()));
		
		//onde coloca as coisas
		recipiente = (int) (Math.random() * (recipientes.size()));
		
		//que coisas coloca
		item = (int) (Math.random() * (items.size()));
		
		do{
			//TODO
			//valores random de quantidades ganhas, perdidas e quanto chegou ao fim do dia
			val1 = (int) (1 + Math.random()*20); //REVER DEPOIS AO TESTAR (mais facil)
			val2 = (int) (1 + Math.random()*20); //REVER DEPOIS AO TESTAR (mais facil)
			val3 = (int) (1 + Math.random()*20); //REVER DEPOIS AO TESTAR (mais facil)
			
			
		}while(getSolution()<=0);
		
		if(locais.get(local).toString().equalsIgnoreCase("Escola"))
			imageName = "images/modelos/2/escola.jpg";
		else if(locais.get(local).toString().equalsIgnoreCase("Casa"))
			imageName = "images/modelos/2/casa.jpg";
		else if(locais.get(local).toString().equalsIgnoreCase("Campo de Futebol"))
			imageName = "images/modelos/2/campo.jpg";		
		else if(locais.get(local).toString().equalsIgnoreCase("Aula de ballet"))
			imageName = "images/modelos/2/ballet.jpg";
			
		
		
		String t = "Num determinado dia,\n " + sujeitos.get(sujeito1).toString() + " foi para " + locais.get(local).toString() 
				+ " com " + recipientes.get(recipiente).toString() + " de " + items.get(item).toString()
				+ ".\n Ao chegar deu " + valores[valor] + " para " + sujeitos.get(sujeito2).toString()
				+ ".\n A meio do dia brincou com " + sujeitos.get(sujeito3).toString() 
				+ " e " + actions[action1] + " " + val1 
				+ " " + items.get(item).toString() + ".\n No fim do dia ainda " 
				+ actions[action2] + " " + val2 + ".\n Quando chegou tinha "
				+ val3 + " " + items.get(item).toString() + ".";
		
		
		super.setText(t);
				
	}
	public void constructQuestion(){
		if(sujeitos.size() == 0 || locais.size() == 0 
				   || recipientes.size() == 0 || items.size() == 0)
					return;
		
		String t = "Que quantidade de " + items.get(item).toString() + ",\ntinha " 
		+ sujeitos.get(sujeito1).toString() + " quando saiu no início do dia?";
		
		super.setQuestion(t);
		
	}
	public void constructEasyTip(){
		if(super.getText() == " " || super.getQuestion() == " ")
			return;
	
	
		//array onde vão estar as opções de resposta
		int[] etOptions = {-1,-1,-1};
		int val;
		
		solution = getSolution();
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
		etOptions[val] = (int) (solution/(1 + Math.random()*3));
		
		
		String et = "Uma destas três opções está correcta:\n"+"  a)"+etOptions[0]
				+"   b)"+etOptions[1]+"  c)"+etOptions[2];
		
		super.setEasyTip(et);
		
	}
	
	public ArrayList<NounDomain> getSujeitos() {return sujeitos;}
	public void setSujeitos(ArrayList<NounDomain> sujeitos) {this.sujeitos = sujeitos;}

	public ArrayList<NounDomain> getLocais() {return locais;}
	public void setLocais(ArrayList<NounDomain> locais) {this.locais = locais;}

	public ArrayList<NounDomain> getRecipientes() {return recipientes;}
	public void setRecipientes(ArrayList<NounDomain> recipientes) {this.recipientes = recipientes;}

	public ArrayList<NounDomain> getItems() {return items;}	
	public void setItems(ArrayList<NounDomain> items) {this.items = items;}

	public String[] getValores() {return valores;}
	public void setValores(String[] valores) {this.valores = valores;}

	public String[] getActions() {return actions;}
	public void setActions(String[] actions) {this.actions = actions;}

	public int getSujeito1() {return sujeito1;}
	public void setSujeito1(int sujeito1) {this.sujeito1 = sujeito1;}

	public int getSujeito2() {return sujeito2;}
	public void setSujeito2(int sujeito2) {this.sujeito2 = sujeito2;}

	public int getSujeito3() {return sujeito3;}
	public void setSujeito3(int sujeito3) {this.sujeito3 = sujeito3;}

	public int getValor() {return valor;}
	public void setValor(int valor) {this.valor = valor;}

	public int getAction1() {return action1;}
	public void setAction1(int action1) {this.action1 = action1;}
	
	public int getAction2() {return action2;}
	public void setAction2(int action2) {this.action2 = action2;}
	
	public int getLocal() {return local;}
	public void setLocal(int local) {this.local = local;}

	public int getRecipiente() {return recipiente;}
	public void setRecipiente(int recipiente) {this.recipiente = recipiente;}

	public int getItem() {return item;}
	public void setItem(int item) {this.item = item;}

	public int getSolution() {
		if(super.getQuestion() == " ")
			return -1;
		
		//aqui faz-se a inversão das operações		
		int aux = val3;
		
		if(action2 == 0)
			aux = aux+val2;
		else
			aux = aux-val2;
		
		if(action1 == 0)
			aux = aux+val1;
		else
			aux = aux-val1;
		
		int x;
		if(valor == 0){
			x = aux*2;
			aux = x;
		}
		else if(valor == 1){
			x = aux/3;
			aux = aux+x;
			
		}			
		else if(valor == 2){
			x = aux/4;
			aux = aux+x;
		}
		
		setSolution(aux);
		
		
		return aux;
		
	}
	public void setSolution(int solution) {this.solution = solution;}
		
	public int getVal1() {return val1;}
	public void setVal1(int val1) {this.val1 = val1;}
	
	public int getVal2() {return val2;}
	public void setVal2(int val2) {this.val2 = val2;}
	
	public int getVal3() {return val3;}
	public void setVal3(int val3) {this.val3 = val3;}
	
	public String getImageName() {return imageName;}
	public void setImageName(String imageName) {this.imageName = imageName;}
	

}
