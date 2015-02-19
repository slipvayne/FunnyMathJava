package com.gps.funnymath.game;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.gps.funnymath.main.Global;

public class Janela_Pontuacoes {
	
  protected  String nomes[][]; //PARA A LISTA DE PONTUACOES (ex.. deve buscar de outro sitio, ou txt/bin)

	  
	protected DefaultListModel<String> modelListaJogos = new DefaultListModel<String>();  //novo ListModel		
	protected JList<String> lista = new JList<String>(modelListaJogos);	//Lista options
	
	protected JFrame Pontuacoes; //visto ke é numa janela a parte..
	
	protected String background; //alterar depois para background activo ou assim
	

	

	public Janela_Pontuacoes() {
		
				
		Pontuacoes = new JFrame();
		Pontuacoes.setIconImage(Toolkit.getDefaultToolkit().getImage("images/icon/icon.png"));
		Pontuacoes.setTitle("Funny Math - Pontuações");		
		Pontuacoes.setResizable(false);
		Pontuacoes.setBounds(100, 100, 800, 600);
		//Pontuacoes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Pontuacoes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //para nao fechar a principal
		Pontuacoes.getContentPane().setLayout(null);
		
		carregaNomes();
		Pontuacoes.addWindowListener( new WindowAdapter() {     //para so fexar esta janela e nao o programa todo!
		      public void windowClosing( WindowEvent we ) {
		    	  Pontuacoes.dispose();		       
		      }
		    } );
	
		
		setBackground(Global.background_default);
		
		showBackground();
		showButtons();
		showPontuacoes();
		botaoSair();
		
		Pontuacoes.setVisible(true);
		Pontuacoes.repaint(); //comentar se nao necessario
		
	
	}	
	
	 private void carregaNomes(){
		 nomes = new String[Global.pontuacoes.size()][2];
		 
		 for(int i = 0;i<Global.pontuacoes.size();i++){				 
			 nomes[i][0] = Global.pontuacoes.get(i).getNome();
			 nomes[i][1] = Integer.toString(Global.pontuacoes.get(i).getPontos());			 
		 }
	 }
	
	 private void showBackground()
	 {
		 		
			try {
			   Pontuacoes.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(background)))));
			} catch (IOException e) {}
	    	
	 } 
		
	
	 private void showButtons()
	 {
		  
		 	JButton btnLogoFunnyMath = new JButton();
			btnLogoFunnyMath.setBounds(200, 30, 380, 45);
			btnLogoFunnyMath.setIcon(new ImageIcon("images/icon/customLogo.png"));
			btnLogoFunnyMath.setEnabled(false);
			btnLogoFunnyMath.setBorder(BorderFactory.createRaisedBevelBorder());
			btnLogoFunnyMath.setDisabledIcon(new ImageIcon("images/icon/customLogo.png"));
			Pontuacoes.getContentPane().add(btnLogoFunnyMath);
	
			
			JButton btnTop10 = new JButton();
			btnTop10.setBounds(290, 95, 189, 78);
			btnTop10.setIcon(new ImageIcon("images/imgbutton/top10.png"));
			btnTop10.setEnabled(false);	
		
			btnTop10.setDisabledIcon(new ImageIcon("images/imgbutton/top10.png"));
				
			
			Pontuacoes.getContentPane().add(btnTop10);	
			

					
			
	 }
	 
	 private void showPontuacoes() 
	 {		

		  String titulo[] = {"Nome", "Pontuação"};		  		
		  
		  JTable tabelaPontuacoes = new JTable( nomes, titulo );
		  tabelaPontuacoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  tabelaPontuacoes.setEnabled(false);
		  JScrollPane pane = new JScrollPane( tabelaPontuacoes );
		  pane.setBounds(285, 200, 200, 185);
		  Pontuacoes.add( pane );	    
		    
			
			
	 }

	
		public DefaultListModel<String> getModelListaJogos() {
			return modelListaJogos;
		}

		public void setModelListaJogos(DefaultListModel<String> modelListaJogos) {
			this.modelListaJogos = modelListaJogos;
		}

		public JList<String> getLista() {
			return lista;
		}

		public void setLista(JList<String> lista) {
			this.lista = lista;
		}

		public JFrame getPontuacoes() {
			return Pontuacoes;
		}

		public void setPontuacoes(JFrame pontuacoes) {
			Pontuacoes = pontuacoes;
		}

		public String getBackground() {
			return background;
		}

		public void setBackground(String background) {
			this.background = background;
		}
		
		
		
		public String[][] getNomes() {
			return nomes;
		}

		public void setNomes(String[][] nomes) {
			this.nomes = nomes;
		}

		public void botaoSair() //volta ao menu
		 {
			JButton btnSair = new JButton();
			btnSair.setIcon(new ImageIcon("images/imgbutton/botaoSair.png"));	
			btnSair.setBounds(50, 450, 150, 50);
			Pontuacoes.getContentPane().add(btnSair);
				
			btnSair.addActionListener(new ActionListener() {
					   public void actionPerformed(ActionEvent evt) {							  
							   Pontuacoes.dispose();
					   }
				}); 
		 }

	
	
}
