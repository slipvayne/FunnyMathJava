package com.gps.funnymath.game;


//CLASSE PARA SABER QUANTOS REWARDS JA FORAM DESBLOQUEADOS
public class TrackRewards {

	static int numProbResolvidos = 0; //nº probs resolvidos correctamente
	static int gender = 0; //0-unselected, 1-menino, 2-menina
	static String currentReward = " "; //imagem actualmente selecionada
	
	
	public TrackRewards(){}

	//para executar sempre que tenha resolvido bem um problema
	public void SolveProblem(){
		numProbResolvidos++;
	}
	
	//GETS E SETS
	public int getNumProbResolvidos() {
		return numProbResolvidos;
	}
	public void setNumProbResolvidos(int numProbResolvidos) {
		TrackRewards.numProbResolvidos = numProbResolvidos;
	}

	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		TrackRewards.gender = gender;
	}

	public String getCurrentReward() {
		return currentReward;
	}
	public void setCurrentReward(String currentReward) {
		TrackRewards.currentReward = currentReward;
	}
	
	
	
}
