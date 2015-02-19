package com.gps.funnymath.main;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.gps.funnymath.IO.Loads;
import com.gps.funnymath.IO.Saves;
import com.gps.funnymath.game.GameMenu;


public class FunnyMathUI {

	private JFrame FunnyMathUI;
	private Saves save;
	private Loads load;
	
	public static void main(String[] args) {
			
		    FunnyMathUI window = new FunnyMathUI();
			window.FunnyMathUI.setVisible(true);				
		}


	
	public FunnyMathUI() {
		initialize();
	}

	
	private void initialize() {
			FunnyMathUI = new JFrame();
			FunnyMathUI.setIconImage(Toolkit.getDefaultToolkit().getImage("images/icon/icon.png"));
			FunnyMathUI.setTitle("Funny Math");		
			FunnyMathUI.setResizable(false);
			FunnyMathUI.setBounds(100, 100, 800, 600);
			FunnyMathUI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			
			save = new Saves(FunnyMathUI);
			load = new Loads(FunnyMathUI);
			
			FunnyMathUI.addWindowListener(new WindowListener(){			
			
			@Override
			public void windowActivated(WindowEvent arg0) {}

			@Override
			public void windowClosed(WindowEvent arg0) {}

			@Override
			public void windowClosing(WindowEvent arg0) {
				int exit = ExitSystem();
				

				if(exit == 1){
					save.guardaProbsNivel1();
					save.guardaProbsNivel2();
					save.guardaProbsNivel3();
					save.guardaProbsNivel5();
					save.guardaPontuacoes();
					FunnyMathUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);					
				}				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {}

			@Override
			public void windowDeiconified(WindowEvent arg0) {}

			@Override
			public void windowIconified(WindowEvent arg0) {}

			@Override
			public void windowOpened(WindowEvent arg0) {}
			
		});
		
		
		
		
		FunnyMathUI.getContentPane().setLayout(null);
		
				
		load.loadProbsNivel1();
		load.loadProbsNivel2();
		load.loadProbsNivel3();
		load.loadProbsNivel5();
		load.loadPontuacoes();
		//=========Iniciar jogo/menu=========	
				
			   new GameMenu(FunnyMathUI);
			   
		//=========Iniciar jogo/menu=========	
						
		
	}
	
		
	
	
	
	private int ExitSystem(){
		if(JOptionPane.showConfirmDialog(FunnyMathUI, "Tem a certeza que deseja sair ?","Sair", JOptionPane.OK_CANCEL_OPTION)
				   == JOptionPane.OK_OPTION)
			   return 1;
		return 0;
	}



	public JFrame getFunnyMathUI() {
		return FunnyMathUI;
	}



	public void setFunnyMathUI(JFrame funnyMathUI) {
		FunnyMathUI = funnyMathUI;
	}
}
