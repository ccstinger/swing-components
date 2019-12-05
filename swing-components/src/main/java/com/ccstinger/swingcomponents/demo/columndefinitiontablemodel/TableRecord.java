package com.ccstinger.swingcomponents.demo.columndefinitiontablemodel;

import java.math.BigDecimal;

/**
 * @author HanTunca
 * Dec 5, 2019
 *
 */
public class TableRecord 
{
	private final String     firstName;
	private final String     lastName;
	private final String     address;
	private final BigDecimal grossSalary;
	private final BigDecimal taxRate;
	private final boolean    alive;
	
	public TableRecord(String firstName, String lastName, String address, BigDecimal grossSalary, BigDecimal taxRate, boolean alive)
	{
		this.firstName   = firstName;
		this.lastName    = lastName;
		this.address     = address;
		this.grossSalary = grossSalary;
		this.taxRate     = taxRate;
		this.alive       = alive;
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

	public boolean isAlive() 
	{
		return alive;
	}
}
