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
        // 计算当下行的最佳高度 
        int maxPreferredHeight = 0; 
        for (int i = 0; i < table.getColumnCount(); i++) { 
            setText("" + table.getValueAt(row, i)); 
            setSize(table.getColumnModel().getColumn(column).getWidth(), 0); 
            table.setFont(new Font("", Font.ITALIC, (int) (30 * Template.getP())));
            maxPreferredHeight = Math.max(maxPreferredHeight, getPreferredSize().height); 
        }
        
        table.setFont(new Font("", Font.ITALIC, (int) (30 * Template.getP())));
        // table.getTableHeader().setFont(new Font("", Font.ITALIC, (int) (30 * Template.getP())));

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // 必须禁止table自适应大小，不然table默认会适应scrollpane的宽度，就用不了滚动条了

        table.getColumnModel().getColumn(0).setPreferredWidth((int) (250 * Template.getP()));
        table.getColumnModel().getColumn(1).setPreferredWidth((int) (150 * Template.getP()));

        if (table.getRowHeight(row) != maxPreferredHeight)  // 少了这行则处理器瞎忙 
            table.setRowHeight((int) (478 * Template.getP() / (table.getRowCount()))); // 这里指定表格的行高，600P是容器高度，用行数来平均分，+1算入了表头行
            

        setText(value == null ? "" : value.toString()); 
        return this; 
    } 

}
