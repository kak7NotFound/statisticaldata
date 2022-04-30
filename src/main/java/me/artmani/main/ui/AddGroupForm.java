/*
 * Created by JFormDesigner on Fri Apr 29 13:31:15 MSK 2022
 */

package me.artmani.main.ui;

import me.artmani.main.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

/**
 * @author Allan
 */
public class AddGroupForm extends JFrame {
    public AddGroupForm() {
        initComponents();

        try {
            var rs = Main.getDatabase().getResultSet("select * from Groups");
            while (rs.next()) {
                comboBox1.addItem(rs.getString(1));
            }

            rs = Main.getDatabase().getResultSet("select course from Groups where %s".formatted(comboBox1.getSelectedItem()));
            if (rs.isClosed()) return;
            textField1.setText(rs.getString(1));
            rs.close();

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    private void refreshData() {

        try {
            comboBox1.removeAllItems();
            var rs = Main.getDatabase().getResultSet("select * from Groups");
            while (rs.next()) {
                comboBox1.addItem(rs.getString(1));
            }
            rs.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    private void button1ButtonEvent(ActionEvent e) {

        try {
            Main.getDatabase().executeQuery("replace into Groups (groupId, course) VALUES (%s, %s)".formatted(comboBox1.getSelectedItem(), textField1.getText()));
            refreshData();
        } catch (Exception ex) {}
    }

    private void comboBox1Event(ActionEvent e) {
        try {
            System.out.println(comboBox1.getSelectedItem());
            var rs = Main.getDatabase().getResultSet("select course from Groups where groupId = %s".formatted(comboBox1.getSelectedItem()));
            if (rs.isClosed()) return;
            textField1.setText(rs.getString(1));
            rs.close();

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    private void button2Event(ActionEvent e) {
        try {
            Main.getDatabase().executeQuery("delete from Groups where groupId = %s".formatted(comboBox1.getSelectedItem()));
            refreshData();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Allan
        comboBox1 = new JComboBox();
        textField1 = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0433\u0440\u0443\u043f\u043f\u0443");
        var contentPane = getContentPane();

        //---- comboBox1 ----
        comboBox1.setEditable(true);
        comboBox1.addActionListener(e -> comboBox1Event(e));

        //---- label5 ----
        label5.setText("\u0413\u0440\u0443\u043f\u043f\u0430:");

        //---- label6 ----
        label6.setText("\u041a\u0443\u0440\u0441");

        //---- button1 ----
        button1.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c / \u0438\u0437\u043c\u0435\u043d\u0438\u0442\u044c");
        button1.addActionListener(e -> button1ButtonEvent(e));

        //---- button2 ----
        button2.setText("\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0433\u0440\u0443\u043f\u043f\u0443");
        button2.addActionListener(e -> button2Event(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(label5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboBox1)
                        .addComponent(textField1)
                        .addComponent(label6, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(56, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(label5)
                    .addGap(4, 4, 4)
                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label6)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(button1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(button2)
                    .addContainerGap(22, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Allan
    private JComboBox comboBox1;
    private JTextField textField1;
    private JLabel label5;
    private JLabel label6;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
