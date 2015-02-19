package com.gps.funnymath.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JFrame;

import com.gps.funnymath.game.Pontuacao;
import com.gps.funnymath.main.Global;
import com.gps.funnymath.modelos.ProblemaEditado;

public class Loads {
JFrame FunnyMathUI;
	
	public Loads(JFrame FunnyMathUI){
		this.FunnyMathUI = FunnyMathUI;
	}
	
	//*******************************LOADS**************************************************************************
		public void loadProbsNivel1(){
			ObjectInputStream in;        
			File f = new File("ficheiros/problemasNivel1.bin");
	        
			if(f.exists()){
				try {
					in = new ObjectInputStream(new FileInputStream(f));
					ProblemaEditado e;
					
					while((e = (ProblemaEditado) in.readObject())!= null){
						Global.nivel1.add(e);
					}
					
				} catch (Exception e){}
			}
		}
		public void loadProbsNivel2(){
			ObjectInputStream in;        
			File f = new File("ficheiros/problemasNivel2.bin");
	        
			if(f.exists()){
				try {
					in = new ObjectInputStream(new FileInputStream(f));
					ProblemaEditado e;
					
					while((e = (ProblemaEditado) in.readObject())!= null){
						Global.nivel2.add(e);					
					}
					
				} catch (Exception e){}
			}
		}
		public void loadProbsNivel3(){
			ObjectInputStream in;        
			File f = new File("ficheiros/problemasNivel3.bin");
	        
			if(f.exists()){
				try {
					in = new ObjectInputStream(new FileInputStream(f));
					ProblemaEditado e;
					
					while((e = (ProblemaEditado) in.readObject())!= null){
						Global.nivel3.add(e);
					}
					
				} catch (Exception e){}
			}
		}	
		public void loadProbsNivel5(){
			ObjectInputStream in;        
			File f = new File("ficheiros/problemasNivel5.bin");
	        
			if(f.exists()){
				try {
					in = new ObjectInputStream(new FileInputStream(f));
					ProblemaEditado e;
					
					while((e = (ProblemaEditado) in.readObject())!= null){
						Global.nivel5.add(e);
					}
					
				} catch (Exception e){}
			}
		}
		public void loadPontuacoes(){
			ObjectInputStream in;        
			File f = new File("ficheiros/pontuacoes.bin");
	        
			if(f.exists()){
				try {
					in = new ObjectInputStream(new FileInputStream(f));
					Pontuacao e;
					
					while((e = (Pontuacao) in.readObject())!= null){
						Global.pontuacoes.add(e);
					}
					
				} catch (Exception e){}
			}
		}
		//*******************************END OF LOADS*********************************************************************
}
