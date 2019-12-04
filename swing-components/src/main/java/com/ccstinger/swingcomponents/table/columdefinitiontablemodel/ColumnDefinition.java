package com.ccstinger.swingcomponents.table.columdefinitiontablemodel;

import java.util.function.Function;

/**
 * @author HanTunca
 * Dec 4, 2019
 *
 */
public class ColumnDefinition<T,R> 
{
	private final Object         columnIdentifier;
	private final Class<?>       columnClass;
	private final Function<T, R> valueFunction;
	
	public ColumnDefinition(Object columnIdentifier, Function<T, R> valueFunction, Class<?> columnClass)
	{
		this.columnIdentifier = columnIdentifier;
		this.valueFunction    = valueFunction;
		this.columnClass      = columnClass;
	}

	public Object getColumnIdentifier() 
	{
		return columnIdentifier;
	}

	public Class<?> getColumnClass() 
	{
		return columnClass;
	}

	public Function<T, R> getValueFunction() 
	{
		return valueFunction;
	}
}
