package me.artmani.main.ui;

import java.awt.event.*;
import lombok.SneakyThrows;
import me.artmani.main.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class AddSubjectForm extends JFrame {
    public AddSubjectForm() {
        initComponents();
        refreshData();
    }

    @SneakyThrows
    public void refreshData() {
        var rs = Main.getDatabase().getResultSet("select * from Subjects");
        comboBox1.removeAllItems();
        comboBox2.removeAllItems();
        if (rs.isClosed()) {
            return;
        }
        var teachers = new ArrayList<String>();
        while (rs.next()) {
            comboBox2.addItem(rs.getString(1));
            if (!teachers.contains(rs.getString(2))) {
                teachers.add(rs.getString(2));
                comboBox1.addItem(rs.getString(2));
            }
        }

    }

    @SneakyThrows
    private void button1ButtonEvent(ActionEvent e) {
        Main.getDatabase().executeQuery("replace into Subjects (title, teacher) VALUES ('%s', '%s')"
                .formatted(comboBox2.getSelectedItem(), comboBox1.getSelectedItem()));
        refreshData();
    }

    @SneakyThrows
    private void button2Event(ActionEvent e) {
        Main.getDatabase().executeQuery("delete from Subjects where title = '%s' and teacher = '%s'"
                .formatted(comboBox2.getSelectedItem(), comboBox1.getSelectedItem()));
        refreshData();
    }

    @SneakyThrows
    private void comboBox2ItemStateChanged(ItemEvent e) {
        var rs = Main.getDatabase().getResultSet("select teacher from Subjects where title = '%s'"
                .formatted(comboBox2.getSelectedItem()));
        if (rs.isClosed()) return;
        while (rs.next()){
            comboBox1.setSelectedItem(rs.getString(1));
        }
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Allan
        label5 = new JLabel();
        label6 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        comboBox1 = new JComboBox();
        comboBox2 = new JComboBox();

        //======== this ========
        setTitle("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u043f\u0440\u0435\u0434\u043c\u0435\u0442");
        var contentPane = getContentPane();

        //---- label5 ----
        label5.setText("\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u0430:");

        //---- label6 ----
        label6.setText("\u041f\u0440\u0435\u043f\u043e\u0434\u0430\u0432\u0430\u0442\u0435\u043b\u044c:");

        //---- button1 ----
        button1.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c / \u0438\u0437\u043c\u0435\u043d\u0438\u0442\u044c");
        button1.addActionListener(e -> button1ButtonEvent(e));

        //---- button2 ----
        button2.setText("\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u043f\u0440\u0435\u0434\u043c\u0435\u0442");
        button2.addActionListener(e -> button2Event(e));

        //---- comboBox1 ----
        comboBox1.setEditable(true);

        //---- comboBox2 ----
        comboBox2.setEditable(true);
        comboBox2.addItemListener(e -> comboBox2ItemStateChanged(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(69, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(label5)
                    .addGap(4, 4, 4)
                    .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label6)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(button1)
                    .addGap(6, 6, 6)
                    .addComponent(button2)
                    .addContainerGap(25, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Allan
    private JLabel label5;
    private JLabel label6;
    private JButton button1;
    private JButton button2;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
