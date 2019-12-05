package com.ccstinger.swingcomponents.table.renderers;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * A renderer that displays only the enum's name.
 * 
 * @author HanTunca
 * Dec 5, 2019
 *
 */
@SuppressWarnings("serial")
public class EnumNameTableCellRenderer extends DefaultTableCellRenderer
{
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
	{
		if (value instanceof Enum)
			return super.getTableCellRendererComponent(table, ((Enum<?>) value).name(), isSelected, hasFocus, row, column);
		else
			return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}
}
