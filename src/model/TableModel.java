package model;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class TableModel extends DefaultTableModel {

	public TableModel() {
		super(Constants.DATA, Constants.TABLE_HEADER);
	}

}