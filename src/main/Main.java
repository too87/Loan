package main;

import javax.swing.SwingUtilities;

import controller.Controller;


import model.Constants;
import model.Imp.HousingLoan;
import model.LoanInitial;

import view.View;

public class Main {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void createAndShowGUI() throws Exception {
		
		LoanInitial model = new HousingLoan(Constants.HOUSINGLOAN);
        View view = new View("-"); 
        Controller controller = new Controller(model,view);
        controller.contol();
	}
	
}
