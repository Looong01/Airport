package util.gui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

import gui.customer.Template;

public class TableCellTextAreaRender extends JTextArea implements TableCellRenderer { 
    public TableCellTextAreaRender() { 
        setLineWrap(true); 
        setWrapStyleWord(true); 
    }

    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        int maxPreferredHeight = 0; 
        for (int i = 0; i < table.getColumnCount(); i++) { 
            setText("" + table.getValueAt(row, i)); 
            setSize(table.getColumnModel().getColumn(column).getWidth(), 0); 
            table.setFont(new Font("", Font.ITALIC, (int) (30 * Template.getP())));
            maxPreferredHeight = Math.max(maxPreferredHeight, getPreferredSize().height); 
        }
        
        table.setFont(new Font("", Font.ITALIC, (int) (30 * Template.getP())));

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        table.getColumnModel().getColumn(0).setPreferredWidth((int) (250 * Template.getP()));
        table.getColumnModel().getColumn(1).setPreferredWidth((int) (150 * Template.getP()));

        if (table.getRowHeight(row) != maxPreferredHeight)
            table.setRowHeight((int) (478 * Template.getP() / (table.getRowCount())));
            

        setText(value == null ? "" : value.toString()); 
        return this; 
    } 

}
