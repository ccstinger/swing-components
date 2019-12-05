package com.ccstinger.swingcomponents.demo;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.ccstinger.swingcomponents.table.columdefinitiontablemodel.ColumnDefinitionTableModel;
import com.ccstinger.swingcomponents.table.renderers.FormatTableCellRenderer;

import static java.awt.GridBagConstraints.*;

/**
 * An application that shows how to setup a JTable based on a ColumnDefinitionGroup.
 * 
 * @author HanTunca
 * Dec 5, 2019
 *
 */
@SuppressWarnings("serial")
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
		
		FormatTableCellRenderer dollarRenderer  = new FormatTableCellRenderer(DecimalFormat.getCurrencyInstance(), SwingConstants.RIGHT);
		FormatTableCellRenderer percentRenderer = new FormatTableCellRenderer(DecimalFormat.getPercentInstance(), SwingConstants.RIGHT);
		
		table.getColumn(ColumnConfigurator.GROSS_SALARY_COLUMN_IDENTIFIER).setCellRenderer(dollarRenderer);
		table.getColumn(ColumnConfigurator.NET_SALARY_COLUMN_IDENTIFIER).setCellRenderer(dollarRenderer);
		table.getColumn(ColumnConfigurator.TAX_RATE_COLUMN_IDENTIFIER).setCellRenderer(percentRenderer);

		// layout panel
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
		
		modelData.add(new TableRecord("Dorothy", "Vaughan", "Kansas City, MO", new BigDecimal("600000"), new BigDecimal("0.132"), true));
		modelData.add(new TableRecord("Tyson", "Neil", "East Hampton, NY", new BigDecimal("300000"), new BigDecimal("0.23"), true));
		modelData.add(new TableRecord("Steve", "Jobs", "Cupertino, CA", new BigDecimal("5000000.0"), new BigDecimal("0.40"), false));
		modelData.add(new TableRecord("Carl", "Sagan", "Camrbidge, MA", new BigDecimal("1000000.0"), new BigDecimal("0.25"), false));
		modelData.add(new TableRecord("Simon", "LeBon", "Hertfordshire, England", new BigDecimal("500000"), new BigDecimal("0.14"), true));
		modelData.add(new TableRecord("Alex", "Lifeson", "Fernie, BC, Canada", new BigDecimal("400000"), new BigDecimal("0.14"), true));
		
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