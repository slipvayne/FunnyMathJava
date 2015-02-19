package com.gps.funnymath.modelos.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.gps.funnymath.modelos.Modelo_2;

public class testeModelo2 {

	
	Modelo_2 m1 = new Modelo_2();

	@Before
	public void setUp() throws Exception {
				
		m1.setValor(0);
		m1.setAction1(0);
		m1.setVal1(7);
		m1.setAction2(1);
		m1.setVal2(5);
		m1.setVal3(10);
	}


	@Test
	public void test() {
		assertEquals("Test Solution",24,m1.getSolution());
		assertEquals("Test Valor",0,m1.getValor());
		assertEquals("Test Action1",0,m1.getAction1());
		assertEquals("Test Val1",7,m1.getVal1());
		assertEquals("Test Action2",1,m1.getAction2());
		assertEquals("Test Val2",5,m1.getVal2());
		assertEquals("Test Val3",10,m1.getVal3());
	}

}
