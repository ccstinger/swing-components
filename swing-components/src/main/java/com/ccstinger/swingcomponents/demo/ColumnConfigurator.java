package com.ccstinger.swingcomponents.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ccstinger.swingcomponents.table.columdefinitiontablemodel.ColumnDefinition;
import com.ccstinger.swingcomponents.table.columdefinitiontablemodel.ColumnDefinitionGroup;

/**
 * @author HanTunca
 * Dec 5, 2019
 *
 */
public class ColumnConfigurator 
{
	public static final String FIRST_NAME_COLUMN_IDENTIFIER   = "first name";
	public static final String LAST_NAME_COLUMN_IDENTIFIER    = "last name";
	public static final String ADDRESS_COLUMN_IDENTIFIER      = "address";
	public static final String GROSS_SALARY_COLUMN_IDENTIFIER = "gross salary";
	public static final String NET_SALARY_COLUMN_IDENTIFIER   = "net salary";
	public static final String TAX_RATE_COLUMN_IDENTIFIER     = "tax rate";
	public static final String ALIVE_COLUMN_IDENTIFIER        = "alive";
	
	private ColumnConfigurator()
	{
		throw new AssertionError();
	}
	
	public static ColumnDefinitionGroup<TableRecord> getColumnDefinitionGroup()
	{
		List<ColumnDefinition<TableRecord, Object>> columnDefinitions = new ArrayList<>();
		
		columnDefinitions.add(new ColumnDefinition<>(FIRST_NAME_COLUMN_IDENTIFIER, TableRecord::getFirstName, String.class));
		columnDefinitions.add(new ColumnDefinition<>(LAST_NAME_COLUMN_IDENTIFIER, TableRecord::getLastName, String.class));
		columnDefinitions.add(new ColumnDefinition<>(ADDRESS_COLUMN_IDENTIFIER, TableRecord::getAddress, String.class));
		columnDefinitions.add(new ColumnDefinition<>(ALIVE_COLUMN_IDENTIFIER, TableRecord::isAlive, Boolean.class));
		columnDefinitions.add(new ColumnDefinition<>(GROSS_SALARY_COLUMN_IDENTIFIER, TableRecord::getGrossSalary, BigDecimal.class));
		columnDefinitions.add(new ColumnDefinition<>(TAX_RATE_COLUMN_IDENTIFIER, TableRecord::getTaxRate, BigDecimal.class));

		// calculated column
		columnDefinitions.add(new ColumnDefinition<>(NET_SALARY_COLUMN_IDENTIFIER, f -> f.getGrossSalary().subtract(f.getGrossSalary().multiply(f.getTaxRate())), BigDecimal.class));
		
		return new ColumnDefinitionGroup<>(columnDefinitions);
	}
}
