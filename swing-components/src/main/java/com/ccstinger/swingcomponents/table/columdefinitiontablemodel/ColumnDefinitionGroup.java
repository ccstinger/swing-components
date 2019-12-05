package com.ccstinger.swingcomponents.table.columdefinitiontablemodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A class that contains a list of ColumnDefinition objects. The list of 
 * ColumnDefinition objects are ordered by the user and will be displayed in
 * the table by that order, i.e. ColumnDefinition at index 1 = column A, ColumnDefinition
 * at index 2 = column B, etc.
 * 
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
    
    /**
     * Get an unmodifiable list of column definitions.
     * 
     * @return list of column definitions
     */
    public List<ColumnDefinition<T, Object>> getColumnDefinitions()
    {
    	return Collections.unmodifiableList(columnDefinitions);
    }
    
    /**
     * Get a map of all of the column definitions using the ColumnDefinition's columnIdentifier as
     * the key.  It is assumed that each ColumnDefinition object has a unique columnIdentifier.
     * 
     * @return map of ColumnDefinition objects whose key is ColumneDefintion's columnIdentifier
     */
    public Map<Object, ColumnDefinition<T, Object>> getColumnDefintionsByIdentifier()
    {
    	return columnDefinitions.stream().collect(Collectors.toMap(ColumnDefinition::getColumnIdentifier, f -> f));
    }
    
    /**
     * @return get number of column definitions
     */
    public int getColumnDefinitionCount()
    {
    	return columnDefinitions.size();
    }
    
    /**
     * Get ColumnDefinition at index columnIndex
     * 
     * @param columnIndex
     * @return ColumnDefinition at columnIndex
     */
    public ColumnDefinition<T, Object> getColumnDefinition(int columnIndex)
    {
    	return columnDefinitions.get(columnIndex);
    }
}
