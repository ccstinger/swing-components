package com.ccstinger.swingcomponents.demo.columndefinitiontablemodel;

import java.math.BigDecimal;

public class TableRecord 
{
	private final String     firstName;
	private final String     lastName;
	private final String     address;
	private final BigDecimal grossSalary;
	private final BigDecimal taxRate;
	
	public TableRecord(String firstName, String lastName, String address, BigDecimal grossSalary, BigDecimal taxRate)
	{
		this.firstName   = firstName;
		this.lastName    = lastName;
		this.address     = address;
		this.grossSalary = grossSalary;
		this.taxRate     = taxRate;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public String getAddress() 
	{
		return address;
	}

	public BigDecimal getGrossSalary() 
	{
		return grossSalary;
	}

	public BigDecimal getTaxRate() 
	{
		return taxRate;
	}
}
