package com.ccstinger.swingcomponents.table.renderers;

import java.awt.Component;
import java.text.Format;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author HanTunca
 * Dec 5, 2019
 *
 */
@SuppressWarnings("serial")
public class FormatTableCellRenderer extends DefaultTableCellRenderer 
{
	private final Format format;

	public FormatTableCellRenderer(Format format)
	{
		this.format = format;
	}
	
	public FormatTableCellRenderer(Format format, int horizontalAlignment)
	{
		this.format = format;
		
		super.setHorizontalAlignment(horizontalAlignment);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
	{
		return super.getTableCellRendererComponent(table, format.format(value), isSelected, hasFocus, row, column);
	}
}
