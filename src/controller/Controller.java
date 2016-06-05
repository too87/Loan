package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.View;
import model.Constants;
import model.LoanInitial;

public class Controller {
	
	private LoanInitial loan;
	
	private View view;
	
	private ActionListener buttonListener;
	
	private ActionListener comboBoxListener;
	
	private String LoanType;
	
	public Controller(LoanInitial loan, View view){
		
        this.loan = loan;
        
        this.view = view;               
    }
	
	public void contol(){     

        comboBoxListener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				LoanType = (String) view.getLoanList().getSelectedItem();
				loan.setLoanType(LoanType);
			}
        };
        view.getLoanList().addActionListener(comboBoxListener);
        
        buttonListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {
            	  String p = (String)view.getPrincipleTextField().getText();
            	  String t = (String)view.getTermsTextField().getText();
            	  if (LoanType != null && p!= null && t !=null
          				&&!" ".equals(LoanType) &&!"".equals(p)
          				&& !"".equals(t)){
            		  if(Double.parseDouble(p)>0 && Double.parseDouble(t)>0){
	            		  loan.setPrincipal(Double.parseDouble(p));
	                	  loan.setTerms(Integer.parseInt(t));
	                	  Double payment = calculatePayment();
	                	  printTable(payment);
            		  }
            		  else{
            			  JOptionPane.showMessageDialog(null,
                					"Loan amount and Term of Loan need " +
                					"to be greater than 0", "Error",
                					JOptionPane.ERROR_MESSAGE);
            		  }
            	  }
            	  else{
            		  view.getPayment().setText(" ");
            		  view.getModel().setDataVector(Constants.DATA, Constants.TABLE_HEADER);
            		  JOptionPane.showMessageDialog(null,
          					"Please fill in all three fields", "Error",
          					JOptionPane.ERROR_MESSAGE);
            		  
            	  }
            	  
              }
		
        };                
        view.getCalButton().addActionListener(buttonListener);   
        
    }
	
	 private Double calculatePayment(){
	        Double payment = loan.calMonthlyPayment();                
	        view.getPayment().setText("$ "+Double.toString(payment));
	        return payment;
	    }  

	 private void printTable(Double payment) {
		
		 int num = loan.getTerms()*12;
		 Double rate = loan.getAnnualInterestRate()/1200;
		 Double balance = loan.getPrincipal();
		 Double interest = 0.0;
		 Double principal = 0.0;
		 Double totalInterest = 0.0;
		 Double totalPayment = payment*num;
		 Object[][] newData = new Object[num+1][Constants.COLUMN];

		 for (int row=0; row<num; row++) {
			 interest = balance*rate;
			 totalInterest += interest;
			 principal = payment-interest;
			 balance -=principal;
		     newData[row][0] = row+1;
		     newData[row][1] = round2Decimal(payment);
		     newData[row][2] = round2Decimal(principal);
		     newData[row][3] = round2Decimal(interest);
		     newData[row][4] = round2Decimal(balance);
		     
		 }
		 	newData[num][0] = "Total";
		 	newData[num][1] = round2Decimal(totalPayment);
		 	newData[num][2] = loan.getPrincipal();
		 	newData[num][3] = round2Decimal(totalInterest);
		 	newData[num][4] = "-";
			view.getModel().setDataVector(newData, Constants.TABLE_HEADER);
		}
	 
	 private Double round2Decimal(Double value){
		if(value>0.9){
			 value = (double) Math.round(value*100);
			 return (double) value/100;
		}
		return 0.0;
			
		 
	 }
}
