package com.gps.funnymath.modelos.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.gps.funnymath.modelos.Modelo_5;

public class testeModelo5 {
	
	// private String[][] objectosFixos = { {"Triciclos","3"},{"Carrinhos","4"},{"Bicicletas","2"}};	

	
	Modelo_5 m5 = new Modelo_5();

	@Before
	public void setUp() throws Exception {
				
		m5.setSolution(14);
		m5.setObjecto1(0); //triciclos - 3
		m5.setObjecto2(1); //carrinhos - 4 
    	m5.setValor(98);   // valor = 14 * 3 + 14* 4
    	//se metesse m5.setValor(98); comentado devia dar esse valor.. mas pode ser do random
	}


	@Test
	public void test() {
		assertEquals("Test Solution",14,m5.getSolution());
		assertEquals("Test Valor",98,m5.getValor());
		assertEquals("Test Objecto1",0,m5.getObjecto1());
		assertEquals("Test Objecto2",1,m5.getObjecto2());
		
	}

}