package com.gps.funnymath.modelos;

import java.io.Serializable;
import java.util.ArrayList;

import com.gps.funnymath.domains.NounDomain;

public class Modelo_3 extends Modelo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9123099871211122866L;
	private ArrayList<NounDomain> sujeitos = new ArrayList<NounDomain>();
	private ArrayList<NounDomain> objectos = new ArrayList<NounDomain>();
	private ArrayList<NounDomain> materiais = new ArrayList<NounDomain>();
	
		
	private int sujeito1, sujeito2;
	private int solution;
	private int val1, val2, val3;
	private int val1_1, val2_1, val3_1;
	private int objecto;
	private int mat1, mat2, mat3;
	private String imageName;
	
	public Modelo_3(){
		super();
		
		sujeito1 = sujeito2 = solution = val1 = val2 = val3 = -1;
		val1_1 = val2_1 = val3_1 = objecto = mat1 = mat2 = mat3 = -1;
		
		sujeitos.add(new NounDomain("o João"));
		sujeitos.add(new NounDomain("o José"));
		sujeitos.add(new NounDomain("a Maria"));
		sujeitos.add(new NounDomain("a Carla"));
		
		objectos.add(new NounDomain("Baloiço"));
		objectos.add(new NounDomain("Brinquedo"));
		objectos.add(new NounDomain("Jogo"));
		
		materiais.add(new NounDomain("Cilindros"));
		materiais.add(new NounDomain("Cartões"));
		materiais.add(new NounDomain("Tábuas"));
		
		constructText();
		constructQuestion();
		constructEasyTip();
	}
	
	public void constructText(){
		if(sujeitos.size() == 0 || materiais.size() == 0 || objectos.size() == 0)
			return;
		
	    //primeiro nome
		sujeito1 = (int) (Math.random() * (sujeitos.size()));
		
		//nome do outro sujeito
		do{
			sujeito2 = (int) (Math.random() * (sujeitos.size()));
		}while(sujeito1 == sujeito2);
		
		//que objecto vai fazer
		objecto = (int) (Math.random() *(objectos.size()));
		
		//quais os materiais
		do{
			mat1 = (int) (Math.random() * (materiais.size()));
			mat2 = (int) (Math.random() * (materiais.size()));
			mat3 = (int) (Math.random() * (materiais.size()));
		}while(mat1 == mat2 || mat1 == mat3 || mat2 == mat3);
		
		//valores random de quantidades dos materiais
		do{
			val1 = (int) (1 + Math.random()*9);
			val2 = (int) (1 + Math.random()*4);
			val3 = (int) (1 + Math.random()*2);
			
			//"entao se tiver X materiais quantos objectos pode fazer?"
			val1_1 = val1 * (int) (1 + Math.random()*9);
			val2_1 = val2 * (int) (1 + Math.random()*9);
			val3_1 = val3 * (int) (1 + Math.random()*5);
		}while(getSolution()<=0);
		
		
		//[SUJEITO] decidiu construir [OBJECTO]S para oferecer a [SUJEITOS].
		//Cada [OBJECTO] necessita de:
		//-[NUMERO_1] [MATERIAL_1]; [NUMERO_2] [MATERIAL_2]; [NUMERO_3] [MATERIAL_3].
		//Em casa há:
		//-[NUMERO_1.1] [MATERIAL_1]; [NUMERO_2.1] [MATERIAL_2]; [NUMERO_3.1] [MATERIAL_3].
		
		imageName = "images/modelos/3/modelo3.jpg";
		
		String t = sujeitos.get(sujeito1).toString() + " decidiu construir " + objectos.get(objecto).toString() 
				+ "s para levar para " + sujeitos.get(sujeito2).toString() + ".\n"
				+ "Cada " + objectos.get(objecto).toString() + " necessita de: \n"
				+ val1 + " " + materiais.get(mat1).toString() + "; "
				+ val2 + " " + materiais.get(mat2).toString() + "; "
				+ val3 + " " + materiais.get(mat3).toString() + ";\n"
				+ "Em casa tem:\n"
				+ val1_1 + " " + materiais.get(mat1).toString() + "; " + val2_1 + " " + materiais.get(mat2).toString() + "; "
				+ val3_1 + " " + materiais.get(mat3).toString() + ".";
		
		super.setText(t);

	}
	
	public void constructQuestion(){
		if(sujeitos.size() == 0 || materiais.size() == 0 || objectos.size() == 0)
			return;
		
		//Quantos [OBJECTO]S foram construidos?
		String t = "Quantos " + objectos.get(objecto).toString() +"s foram construidos?";
				
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
		etOptions[val] = (int) (solution + 1 + Math.random()*10);
		
		//ver qual é a posição no array que falta preencher
		val=-1;
		do{
			val++;
		}while(etOptions[val] != -1);
		
		//solução errada entre solução/1 e solução/3
		etOptions[val] = (int)(solution/(1 +  Math.random()*3));
		
		String et = "Uma destas três opções está correcta:\n"+"  a) "+etOptions[0]
				+"   b) "+etOptions[1]+"  c)"+etOptions[2];
		
		super.setEasyTip(et);
		
	}
	
	public int getSolution(){
		if(super.getQuestion() == " ")
			return -1;
		
		//verificar quantas partes é possivel fazer, com os materiais disponiveis
		//quantidade do material 1
		int temp1 = val1_1 - val1;
		int counter1=0;
		do{
			temp1 = temp1 - val1;
			if(temp1 >= 0)
				counter1++;
		}while(temp1>0);
		
		//quantidade do material 2
		int temp2 = val2_1 - val2;
		int counter2=0;
		do{
			temp2 = temp2 - val2;
			if(temp2 >= 0)
				counter2++;
		}while(temp2>0);
		
		//quantidade do material 3
		int temp3 = val3_1 - val3;
		int counter3=0;
		do{
			temp3 = temp3 - val3;
			if(temp3 >= 0)
				counter3++;
		}while(temp3>0);
		
		//o menor numero será a solução (so pode fazer X objectos porque tem menos de um certo...
		//...  tipo de material
		if( (counter1 <= counter2) && (counter1 <= counter3) ){
			setSolution(counter1);
			return counter1;
		}
		if( (counter2 <= counter1) && (counter2 <= counter3) ){
			setSolution(counter2);
			return counter2;
		}
		if( (counter3 <= counter1) && (counter3 <= counter2) ){
			setSolution(counter3);
			return counter3;
		}
		
		//erro
		return -1;
	}
	
	public void setSolution(int solution) {this.solution = solution;}

	public ArrayList<NounDomain> getSujeitos() {return sujeitos;}
	public void setSujeitos(ArrayList<NounDomain> sujeitos) {this.sujeitos = sujeitos;}

	public ArrayList<NounDomain> getObjectos() {return objectos;}
	public void setObjectos(ArrayList<NounDomain> objectos) {this.objectos = objectos;}

	public ArrayList<NounDomain> getMateriais() {return materiais;}
	public void setMateriais(ArrayList<NounDomain> materiais) {this.materiais = materiais;}

	public int getSujeito1() {return sujeito1;}
	public void setSujeito1(int sujeito1) {this.sujeito1 = sujeito1;}

	public int getSujeito2() {return sujeito2;}
	public void setSujeito2(int sujeito2) {this.sujeito2 = sujeito2;}

	public int getVal1() {return val1;}
	public void setVal1(int val1) {this.val1 = val1;}

	public int getVal2() {return val2;}
	public void setVal2(int val2) {this.val2 = val2;}

	public int getVal3() {return val3;}
	public void setVal3(int val3) {this.val3 = val3;}

	public int getVal1_1() {return val1_1;}
	public void setVal1_1(int val1_1) {this.val1_1 = val1_1;}

	public int getVal2_1() {return val2_1;}
	public void setVal2_1(int val2_1) {this.val2_1 = val2_1;}

	public int getVal3_1() {return val3_1;}
	public void setVal3_1(int val3_1) {this.val3_1 = val3_1;}

	public int getObjecto() {return objecto;}
	public void setObjecto(int objecto) {this.objecto = objecto;}

	public int getMat1() {return mat1;}
	public void setMat1(int mat1) {this.mat1 = mat1;}

	public int getMat2() {return mat2;}
	public void setMat2(int mat2) {this.mat2 = mat2;}

	public int getMat3() {return mat3;}
	public void setMat3(int mat3) {this.mat3 = mat3;}
	
	public String getImageName() {return imageName;}
	public void setImageName(String imageName) {this.imageName = imageName;}

	
}
