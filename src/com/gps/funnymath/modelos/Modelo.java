package com.gps.funnymath.modelos;

import java.io.Serializable;

public class Modelo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8378031325148747484L;
	private String text;
	private String question;
	private String easyTip;
	
	
	public Modelo(){
		text = question = easyTip = null;
	}
	
	public String getText() 
	{return text;}
	
	public void setText(String text) {this.text = text;}
	
	public String getQuestion() 
	{return question;}
	
	public void setQuestion(String question) 
	{this.question = question;}
	
	public String getEasyTip() 
	{return easyTip;}
	
	public void setEasyTip(String easyTip)
	{this.easyTip = easyTip;}
}
