package com.ccstinger.swingcomponents.table.columdefinitiontablemodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author HanTunca
 * Dec 4, 2019
 *
 * @param <T>
 */
public class ColumnDefinitionGroup<T> 
{
    private final List<ColumnDefinition<T, Object>> columnDefinitions = new ArrayList<>();

    public ColumnDefinitionGroup(List<ColumnDefinition<T, Object>> columnDefinitions)
    {
    	this.columnDefinitions.addAll(columnDefinitions);
    }
    
    public List<ColumnDefinition<T, Object>> getColumnDefinitions()
    {
    	return Collections.unmodifiableList(columnDefinitions);
    }
    
    public Map<Object, ColumnDefinition<T, Object>> getColumnDefintionsByIdentifier()
    {
    	return columnDefinitions.stream().collect(Collectors.toMap(ColumnDefinition::getColumnIdentifier, f -> f));
    }
    
    public int getColumnDefinitionCount()
    {
    	return columnDefinitions.size();
    }
    
    public ColumnDefinition<T, Object> getColumnDefinition(int columnIndex)
    {
    	return columnDefinitions.get(columnIndex);
    }
}
