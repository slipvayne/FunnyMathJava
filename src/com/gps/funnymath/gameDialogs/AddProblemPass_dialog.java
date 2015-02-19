package com.gps.funnymath.gameDialogs;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class AddProblemPass_dialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField; //Password introduzida..
	private boolean checked = false;

	
	public AddProblemPass_dialog() {
		setTitle("Adicionar Problemas");
		setModal(true);
		setBounds(100, 100, 450, 203);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblInsiraAPassword = new JLabel("Insira a Password:");
			lblInsiraAPassword.setFont(new Font("Verdana", Font.BOLD, 18));
			lblInsiraAPassword.setBounds(31, 48, 209, 29);
			contentPanel.add(lblInsiraAPassword);
		}
		
		passwordField = new JPasswordField();
		passwordField.setBounds(236, 48, 168, 29);
	
		contentPanel.add(passwordField);
		{
			JButton okButton = new JButton("OK");
			okButton.setFont(new Font("Verdana", Font.BOLD, 14));
			okButton.setBounds(166, 111, 91, 29);
			contentPanel.add(okButton);
			
			okButton.addMouseListener(new MouseAdapter() {
				   public void mouseClicked(MouseEvent evt) {	
					 //TODO
					   
					   char [] pass = passwordField.getPassword();
					   
					   	if(isPasswordCorrect(pass))
					   		checked = true;
					   	else{
					   		checked = false;
					   		JOptionPane.showMessageDialog(contentPanel,"Password Incorrecta!");
					   	}
					   
					   	
					   dispose();
								  
				   }
			});
		}
	}
	
	
	private boolean isPasswordCorrect(char [] pass){
		boolean isCorrect = true;
	    char[] correctPassword = { 'p', 'a', 's', 's', 'w', 'o', 'r', 'd','0' };

	    if (pass.length != correctPassword.length) {
	        isCorrect = false;
	    } else {
	        isCorrect = Arrays.equals (pass, correctPassword);
	    }

	    //Zero out the password.
	    Arrays.fill(correctPassword,'0');

	    return isCorrect;
	}
	
	public JPasswordField getPasswordField() {
		return passwordField;
	}


	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public JPanel getContentPanel() {
		return contentPanel;
	}
	
	public boolean getChecked(){return checked;}
}
