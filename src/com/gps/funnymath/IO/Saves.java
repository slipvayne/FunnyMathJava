package com.gps.funnymath.IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.gps.funnymath.main.Global;

public class Saves {

	JFrame FunnyMathUI;
	
	public Saves(JFrame FunnyMathUI){
		this.FunnyMathUI = FunnyMathUI;
	}
	
	//*******************************SAVES**********************************************************************
		public void guardaProbsNivel1(){
			ObjectOutputStream out;        
			File f = new File("ficheiros/problemasNivel1.bin");
	        
			if(f.exists())
				f.delete();
			
			try {
				f.createNewFile();
				
				out = new ObjectOutputStream(new FileOutputStream(f));
				out.flush();
				
				for(int i = 0;i<Global.nivel1.size();i++){
					out.writeObject(Global.nivel1.get(i));
					out.flush();						
				}
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(FunnyMathUI, "Erro ao gravar ficheiros. Os dados serão perdidos!");
			}
		}
		public void guardaProbsNivel2(){
			ObjectOutputStream out;        
			File f = new File("ficheiros/problemasNivel2.bin");
	        
			if(f.exists())
				f.delete();
			
			try {
				f.createNewFile();
				
				out = new ObjectOutputStream(new FileOutputStream(f));
				out.flush();
				
				for(int i = 0;i<Global.nivel2.size();i++){
					out.writeObject(Global.nivel2.get(i));
					out.flush();						
				}
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(FunnyMathUI, "Erro ao gravar ficheiros. Os dados serão perdidos!");
			}
		}
		public void guardaProbsNivel3(){
			ObjectOutputStream out;        
			File f = new File("ficheiros/problemasNivel3.bin");
	        
			if(f.exists())
				f.delete();
			
			try {
				f.createNewFile();
				
				out = new ObjectOutputStream(new FileOutputStream(f));
				out.flush();
				
				for(int i = 0;i<Global.nivel3.size();i++){
					out.writeObject(Global.nivel3.get(i));
					out.flush();						
				}
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(FunnyMathUI, "Erro ao gravar ficheiros. Os dados serão perdidos!");
			}
		}
		public void guardaProbsNivel5(){
			ObjectOutputStream out;        
			File f = new File("ficheiros/problemasNivel5.bin");
	        
			if(f.exists())
				f.delete();
			
			try {
				f.createNewFile();
				
				out = new ObjectOutputStream(new FileOutputStream(f));
				out.flush();
				
				for(int i = 0;i<Global.nivel5.size();i++){
					out.writeObject(Global.nivel5.get(i));
					out.flush();						
				}
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(FunnyMathUI, "Erro ao gravar ficheiros. Os dados serão perdidos!");
			}
		}
		public void guardaPontuacoes(){
			ObjectOutputStream out;        
			File f = new File("ficheiros/pontuacoes.bin");
	        
			if(f.exists())
				f.delete();
			
			try {
				f.createNewFile();
				
				out = new ObjectOutputStream(new FileOutputStream(f));
				out.flush();
				
				for(int i = 0;i<Global.pontuacoes.size();i++){
					out.writeObject(Global.pontuacoes.get(i));
					out.flush();						
				}
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(FunnyMathUI, "Erro ao gravar ficheiros. Os dados serão perdidos!");
			}
		}
		//*******************************END OF SAVES**********************************************************************
}
