package com.ccstinger.swingcomponents.demo.columndefinitiontablemodel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import com.ccstinger.swingcomponents.table.columdefinitiontablemodel.ColumnDefinitionTableModel;

import static java.awt.GridBagConstraints.*;

public class App extends JPanel 
{
	private final ColumnDefinitionTableModel<TableRecord> model;
	private final JTable                                  table;
	
	public App(ColumnDefinitionTableModel<TableRecord> model)
	{
		super(new GridBagLayout());
		
		this.model = model;
		this.table = new JTable(this.model);
		
		construct();
	}
	
	private final void construct()
	{
		table.setAutoCreateRowSorter(true);
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridheight = REMAINDER;
		c.gridwidth  = REMAINDER;
		c.fill       = BOTH;
		c.weightx    = 1;
		c.weighty    = 1;
		c.insets     = new Insets(5, 5, 5, 5);
		
		add(new JScrollPane(table), c);
	}
	
	public static void main(String[] args)
	{
		List<TableRecord> modelData = new ArrayList<>();
		
		modelData.add(new TableRecord("Steve", "Jobs", "Cupertino, CA", new BigDecimal("5000000.0"), new BigDecimal("0.40")));
		modelData.add(new TableRecord("Carl", "Sagan", "Camrbidge, MA", new BigDecimal("1000000.0"), new BigDecimal("0.25")));
		modelData.add(new TableRecord("Simon", "LeBon", "Hertfordshire, England", new BigDecimal("500000"), new BigDecimal("0.14")));
		modelData.add(new TableRecord("Alex", "Lifeson", "Fernie, BC, Canada", new BigDecimal("400000"), new BigDecimal("0.14")));
		
		ColumnDefinitionTableModel<TableRecord> model = new ColumnDefinitionTableModel<>(ColumnConfigurator.getColumnDefinitionGroup(), modelData);
		
		JFrame frame = new JFrame("Column Definition Table Model Demo");
		
		frame.setContentPane(new App(model));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setSize(400, 400);
		
		SwingUtilities.invokeLater(() -> {
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}
}