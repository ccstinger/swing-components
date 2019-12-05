package com.ccstinger.swingcomponents.table.columdefinitiontablemodel;

import java.util.function.Function;

/**
 * A class that provides column information including the column identifier,
 * the class type of objects in the column, and a passed in value function that 
 * is used to populate the table.
 * 
 * The class is parameterized with objects of type T that represent individual table
 * rows, and objects of type R that represent the return object for an individual cell
 * in the row.
 * 
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

	/**
	 * Identifier for the column.  The ColumnDefinitionTableModel will use the
	 * identifier for column names.
	 * 
	 * @return an object that identifies the column
	 */
	public Object getColumnIdentifier() 
	{
		return columnIdentifier;
	}

	/**
	 * Get the class type for objects displayed in the column.  NOTE: the class
	 * returned can be different from the actual class of the return object.
	 * 
	 * @return Object.class
	 */
	public Class<?> getColumnClass() 
	{
		return columnClass;
	}

	/**
	 * Returns the function used to generate values for each cell.
	 * 
	 * @return Function used to generate cell values.
	 */
	public Function<T, R> getValueFunction() 
	{
		return valueFunction;
	}
}
