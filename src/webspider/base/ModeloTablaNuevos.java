/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webspider.base;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author lachi
 */
public class ModeloTablaNuevos implements TableModel {
    
    final Class<?>[] columnClass = new Class<?>[]{Integer.class, String.class, String.class};
    final String[] columnName = new String[]{"Numero", "Enlace web", "Tipo de enlace"};
    List<Object[]> values = null;
    
    public ModeloTablaNuevos(List<Object[]> values) {
        this.values = values;
    }

    @Override
    public int getRowCount() {
        return values.size();
    }

    @Override
    public int getColumnCount() {
        return columnClass.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnName[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return ((Object[]) values.get(rowIndex))[columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    
    }
    
}
