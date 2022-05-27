package gui.staff.page;

import gui.customer.Template;
import gui.staff.Page;
import util.gui.Display;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.Border;

import java.awt.*;
import java.util.Objects;

/**
 * Check user page
 *
 * @author Zelong Li & Shuzhou Zhao
 * @version 1.5
 */
public class CheckUser extends JPanel implements Page {

    public JTextField textField1 = new JTextField();
    public JTextField textField2 = new JTextField();
    JPanel panel1 = new JPanel();
    table2 panel2 = new table2();
    table3 panel3 = new table3();
    JLabel label1 = new JLabel("Information", JLabel.CENTER);
    JLabel label2 = new JLabel("All passengers", JLabel.CENTER);
    JLabel label3 = new JLabel("Choose one flight:    ");

    public CheckUser() {
        this.setLayout(null);
        Border blackline = BorderFactory.createLineBorder(Color.black); 
        label1.setBorder(blackline);
        label2.setBorder(blackline);
        panel1.setBorder(blackline);
        label3.setBounds(0, 0, 800, 30);
        panel1.setBounds(0, 0, (int) (900 * Template.getP()), (int) (50 * Template.getP()));
        panel2.setBounds(0, (int) (101 * Template.getP()), (int) (300 * Template.getP()), (int) (500 * Template.getP()));
        panel3.setBounds((int) (301 * Template.getP()), (int) (101 * Template.getP()), (int) (600 * Template.getP()), (int) (500 * Template.getP()));
        label1.setBounds(0, (int) (51 * Template.getP()), (int) (300 * Template.getP()), (int) (50 * Template.getP()));
        label2.setBounds((int) (301 * Template.getP()), (int) (51 * Template.getP()), (int) (600 * Template.getP()), (int) (50 * Template.getP()));
        String[] idInt = SERVICE.getFlightIds();
        JComboBox<String> comboBox = new JComboBox<>();
        for (String j : idInt) {
            comboBox.addItem(String.valueOf(j));
        }
        comboBox.setPreferredSize(new Dimension((int) (200 * Template.getP()), (int) (35 * Template.getP())));
        panel1.add(label3);
        panel1.add(comboBox);
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(label1);
        this.add(label2);
        Display.setPanelFont(this);
        comboBox.addItemListener(e -> {
            String id = (String) Objects.requireNonNull(comboBox.getSelectedItem());
            panel2.setdata(id);
            panel3.setdata(id);
        });
    }

    @Override
    public String getTitle() {
        return "User Information";
    }

    @Override
    public String getLabel() {
        return "Here is User information";
    }

    @Override
    public boolean back() {
        return true;
    }

    @Override
    public boolean cont() {
        return true;
    }

    @Override
    public void syncPage() {

    }
    private static class table2 extends JPanel implements Page {
        String[] idInt = SERVICE.getFlightIds();
        int[] statusInt = SERVICE.checkFlight(idInt[0]);
        String s1 = Integer.toString(statusInt[0]);
        String s2 = Integer.toString(statusInt[1]);
        String s3 = Integer.toString(statusInt[2]);
        String s4 = Integer.toString(statusInt[3]);
        Object[][] obj = { { "Not check-in", s1 }, { "Not boarded", s2 }, { "Finished boarding", s3 },
                { "Total", s4 } };
        TableModel model = new DefaultTableModel(obj, new String[] { "", "" });
        JTable table = new JTable(model);
        table2() {
            this.setLayout(new GridLayout(1, 1));
            table.setEnabled(false);
            table.setFont(new Font("", Font.ITALIC, (int) (30 * Template.getP())));
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            table.getColumnModel().getColumn(0).setPreferredWidth((int) (250 * Template.getP()));
            table.getColumnModel().getColumn(1).setPreferredWidth((int) (48 * Template.getP()));
            table.setRowHeight((int) (483 * Template.getP() / (table.getRowCount())));
            table.getTableHeader().setVisible(false);
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setPreferredSize(new Dimension(0, 0));
            table.getTableHeader().setDefaultRenderer(renderer);
            JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            this.add(scrollPane);
        }

        public void setdata(String id) {
            int[] statusInt = SERVICE.checkFlight(id);
            String s1 = Integer.toString(statusInt[0]);
            String s2 = Integer.toString(statusInt[1]);
            String s3 = Integer.toString(statusInt[2]);
            String s4 = Integer.toString(statusInt[3]);
            Object[][] obj = { { "Not check-in", s1 }, { "Not boarded", s2 },
                    { "Finished boarding", s3 },
                    { "Total", s4 } };
            TableModel model = new DefaultTableModel(obj, new String[] { "", "" });
            JTable table = new JTable(model);
            table.setFont(new Font("", Font.ITALIC, (int) (30 * Template.getP())));
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            table.getColumnModel().getColumn(0).setPreferredWidth((int) (250 * Template.getP()));
            table.getColumnModel().getColumn(1).setPreferredWidth((int) (48 * Template.getP()));
            table.setRowHeight((int) (483 * Template.getP() / (table.getRowCount())));
            table.getTableHeader().setVisible(false);
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setPreferredSize(new Dimension(0, 0));
            table.getTableHeader().setDefaultRenderer(renderer);
            JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            this.removeAll();
            this.add(scrollPane);
            this.paintAll(this.getGraphics());
        }

        @Override
        public String getTitle() {
            return null;
        }

        @Override
        public String getLabel() {
            return null;
        }

        @Override
        public boolean back() {
            return true;
        }

        @Override
        public boolean cont() {
            return true;
        }

        @Override
        public void syncPage() {

        }
    }

    private static class table3 extends JPanel implements Page {
        String[] idInt = SERVICE.getFlightIds();
        int[] userId = SERVICE.getUserIds(idInt[0]);
        Object[][] obj2 = new Object[userId.length][3];
        JTable table = new JTable(obj2, new String[] { "Name", "CardID", "Status" });

        table3() {

            this.setLayout(new GridLayout(1, 1));
            String[] orderids = new String[userId.length];
            for (int m = 0; m < userId.length; m++) {
                String[] orderid = SERVICE.getOrderId(userId[m]);
                for (String i : orderid) {
                    if (Objects.equals(SERVICE.getFlightId(i), idInt[0])) {
                        orderids[m] = i;
                        break;
                    }
                }
            }
            String[] name = new String[userId.length];
            for (int flag = 0; flag < userId.length; flag++) {
                name[flag] = SERVICE.getName(userId[flag]);
            }
            String[] card = new String[userId.length];
            for (int flag2 = 0; flag2 < userId.length; flag2++) {
                card[flag2] = SERVICE.getCardId(userId[flag2]);
            }
            String[] status = new String[orderids.length];
            for (int flag3 = 0; flag3 < orderids.length; flag3++) {
                status[flag3] = SERVICE.getStatus(orderids[flag3]);
            }
            for (int i = 0; i < userId.length; i++) {
                obj2[i][0] = name[i];
                obj2[i][1] = card[i];
                obj2[i][2] = status[i];
            }

            table.setEnabled(false);
            table.setFont(new Font("", Font.ITALIC, (int) (30 * Template.getP())));
            table.getTableHeader().setFont(new Font("", Font.ITALIC, (int) (30 * Template.getP())));

            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 

            table.getColumnModel().getColumn(0).setPreferredWidth((int) (200 * Template.getP()));
            table.getColumnModel().getColumn(1).setPreferredWidth((int) (310 * Template.getP()));
            table.getColumnModel().getColumn(2).setPreferredWidth((int) (100 * Template.getP()));

            table.setRowHeight((int) (428 * Template.getP() / (table.getRowCount())));

            JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

            this.add(scrollPane);
        }

        public void setdata(String id) {
            userId = SERVICE.getUserIds(id);
            obj2 = new Object[userId.length][3];
            String[] orderids = new String[userId.length];
            for (int m = 0; m < userId.length; m++) {
                String[] orderid = SERVICE.getOrderId(userId[m]);
                for (String i : orderid) {
                    if (Objects.equals(SERVICE.getFlightId(i), id)) {
                        orderids[m] = i;
                        break;
                    }
                }
            }
            String[] name = new String[userId.length];
            for (int flag = 0; flag < userId.length; flag++) {
                name[flag] = SERVICE.getName(userId[flag]);
            }

            String[] card = new String[userId.length];
            for (int flag2 = 0; flag2 < userId.length; flag2++) {
                card[flag2] = SERVICE.getCardId(userId[flag2]);
            }
            String[] status = new String[orderids.length];
            for (int flag3 = 0; flag3 < orderids.length; flag3++) {
                status[flag3] = SERVICE.getStatus(orderids[flag3]);
            }
            for (int i = 0; i < userId.length; i++) {
                obj2[i][0] = name[i];
                obj2[i][1] = card[i];
                obj2[i][2] = status[i];
            }
            table = new JTable(obj2, new String[] { "Name", "CardID", "Status" });
            table.setEnabled(false);
            table.setFont(new Font("", Font.ITALIC, (int) (30 * Template.getP())));
            table.getTableHeader().setFont(new Font("", Font.ITALIC, (int) (30 * Template.getP())));

            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            table.getColumnModel().getColumn(0).setPreferredWidth((int) (200 * Template.getP()));
            table.getColumnModel().getColumn(1).setPreferredWidth((int) (310 * Template.getP()));
            table.getColumnModel().getColumn(2).setPreferredWidth((int) (100 * Template.getP()));

            table.setRowHeight((int) (428 * Template.getP() / (table.getRowCount())));

            JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

            this.removeAll();
            this.add(scrollPane);
            this.paintAll(this.getGraphics());
        }

        @Override
        public String getTitle() {
            return null;
        }
    
        @Override
        public String getLabel() {
            return null;
        }

        @Override
        public boolean back() {
            return true;
        }

        @Override
        public boolean cont() {
            return true;
        }

        @Override
        public void syncPage() {

        }
    }
}