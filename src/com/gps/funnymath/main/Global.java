package com.gps.funnymath.main;

import java.util.ArrayList;

import com.gps.funnymath.game.Pontuacao;
import com.gps.funnymath.modelos.ProblemaEditado;

public class Global {
	
	public static ArrayList<Pontuacao> pontuacoes = new ArrayList<Pontuacao>();
	public static ArrayList<ProblemaEditado> nivel1 = new ArrayList<ProblemaEditado>();
	public static ArrayList<ProblemaEditado> nivel2 = new ArrayList<ProblemaEditado>();
	public static ArrayList<ProblemaEditado> nivel3 = new ArrayList<ProblemaEditado>();
	//public static ArrayList<ProblemaEditado> nivel4 = new ArrayList<ProblemaEditado>();
	public static ArrayList<ProblemaEditado> nivel5 = new ArrayList<ProblemaEditado>();
	
	
	public static int genero;
	public static String nome;
	public static int pontuacao;
	public static String background_default = "images/bg_menino/background_default.jpg"; //background por defeito
	public static String background_mainmenu_default = "images/bg_menino/background_main_menu.jpg"; //background por defeito
	
	private Global(){}

}
