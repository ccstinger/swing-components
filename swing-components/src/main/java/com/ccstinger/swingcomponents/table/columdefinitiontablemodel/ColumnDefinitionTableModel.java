package com.ccstinger.swingcomponents.table.columdefinitiontablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * A concrete implementation of the AbstractTableModel that uses a ColumnDefinitionGroup to
 * display rows of type T.
 * 
 * Note that this class is not thread safe, and assumes modifications of instances of this class
 * will occur within the Swing thread.
 * 
 * @author HanTunca
 * Dec 5, 2019
 *
 * @param <T> class that represents a row of data
 * 
 */
@SuppressWarnings("serial")
public class ColumnDefinitionTableModel<T> extends AbstractTableModel 
{
	private final ColumnDefinitionGroup<T> columnDefinitionGroup;
	private final List<T>                  modelData = new ArrayList<>();
	
	public ColumnDefinitionTableModel(ColumnDefinitionGroup<T> columnDefinitionGroup)
	{
		this.columnDefinitionGroup = columnDefinitionGroup;
	}
	
	public ColumnDefinitionTableModel(ColumnDefinitionGroup<T> columnDefinitionGroup, List<T> modelData)
	{
		this.columnDefinitionGroup = columnDefinitionGroup;
		
		this.modelData.addAll(modelData);
	}
	
	public void setModelData(List<T> modelData)
	{
		this.modelData.clear();
		this.modelData.addAll(modelData);
		
		fireTableDataChanged();
	}
	
	public List<T> getModelData()
	{
		return modelData;
	}
	
	public ColumnDefinitionGroup<T> getColumnDefinitionGroup()
	{
		return columnDefinitionGroup;
	}
	
	@Override
	public int getColumnCount() 
	{
		return columnDefinitionGroup.getColumnDefinitionCount();
	}

	@Override
	public int getRowCount() 
	{
		return modelData.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) 
	{
		return columnDefinitionGroup.getColumnDefinition(columnIndex).getValueFunction().apply(modelData.get(rowIndex));
	}

	@Override
	public String getColumnName(int columnIndex) 
	{
		return columnDefinitionGroup.getColumnDefinition(columnIndex).getColumnIdentifier().toString();
	}
	
	public Object getColumnIdentifier(int columnIndex)
	{
		return columnDefinitionGroup.getColumnDefinition(columnIndex).getColumnIdentifier();
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) 
	{
		return columnDefinitionGroup.getColumnDefinition(columnIndex).getColumnClass();
	}
}
