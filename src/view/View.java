package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import model.Constants;
import model.TableModel;

public class View {

	private JTextField principleTextField = new JTextField(10);
	
	private JComboBox<String> loanList = new JComboBox<String>(Constants.LOANTYPE);
	
	private JTextField termsTextField = new JTextField(10);
	
	private JButton calButton = new JButton("calculate");
	
	private JTable table = new JTable();

	// Create table model
	private TableModel model = new TableModel();
	
	private String loanType;
	
	private JLabel payment=new JLabel();;
	
	public View(String loanType){
		
		table.setModel(model);
		// Set the view layout
		JFrame frame = new JFrame("Estimate your Monthly Loan Payment");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pane = new JPanel(new BorderLayout(3,3));
		pane.setBorder(new EmptyBorder(5,5,5,5));
		frame.setContentPane(pane);

		JPanel mainPanel = new JPanel(new GridLayout(5,1));
		JPanel prow = new JPanel(new GridLayout(1,2));
		prow.add(new JLabel("Loan Amount: "));
		prow.add(principleTextField);
		mainPanel.add(prow);
		prow = new JPanel(new GridLayout(1,2));
		prow.add(new JLabel("Loan Type: "));
		prow.add(loanList);
		//prow.add(interestRateTextFeild);
		mainPanel.add(prow);
		prow = new JPanel(new GridLayout(1,2));
		prow.add(new JLabel("Term of the Loan (years): "));
		prow.add(termsTextField);
		mainPanel.add(prow);
		
		prow = new JPanel(new GridLayout(1,2));
		prow.add(new JLabel("Monthly Payment: "));
		prow.add(payment);
		mainPanel.add(prow);
		
		mainPanel.add(calButton,BorderLayout.SOUTH);
		
		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setPreferredSize(new Dimension(700, 250));
		tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Amortization Schedule",
				TitledBorder.CENTER, TitledBorder.TOP));

		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, mainPanel, tableScrollPane);
		splitPane.setDividerLocation(120);
		splitPane.setEnabled(false);
		
		frame.add(splitPane);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);


		
	}

	public JTextField getPrincipleTextField() {
		return principleTextField;
	}

	public void setPrincipleTextField(JTextField principleTextField) {
		this.principleTextField = principleTextField;
	}

	public JComboBox<String> getLoanList() {
		return loanList;
	}

	public void setLoanList(JComboBox<String> loanList) {
		this.loanList = loanList;
	}

	public JTextField getTermsTextField() {
		return termsTextField;
	}

	public void setTermsTextField(JTextField termsTextField) {
		this.termsTextField = termsTextField;
	}

	public JButton getCalButton() {
		return calButton;
	}

	public void setCalButton(JButton calButton) {
		this.calButton = calButton;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public TableModel getModel() {
		return model;
	}

	public void setModel(TableModel model) {
		this.model = model;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public JLabel getPayment() {
		return payment;
	}

	public void setPayment(JLabel payment) {
		this.payment = payment;
	}
	
	
	
}
