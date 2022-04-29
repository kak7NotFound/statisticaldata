/*
 * Created by JFormDesigner on Fri Apr 29 13:31:56 MSK 2022
 */

package me.artmani.main.ui;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Allan
 */
public class AddSubjectForm extends JFrame {
    public AddSubjectForm() {
        initComponents();
    }

    private void button1ButtonEvent(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Allan
        label5 = new JLabel();
        label6 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        label1 = new JLabel();
        comboBox1 = new JComboBox();
        comboBox2 = new JComboBox();

        //======== this ========
        setTitle("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u043f\u0440\u0435\u0434\u043c\u0435\u0442");
        var contentPane = getContentPane();

        //---- label5 ----
        label5.setText("\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u0430:");

        //---- label6 ----
        label6.setText("\u0423\u0447\u0438\u0442\u0435\u043b\u044c:");

        //---- button1 ----
        button1.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c / \u0438\u0437\u043c\u0435\u043d\u0438\u0442\u044c");
        button1.addActionListener(e -> button1ButtonEvent(e));

        //---- button2 ----
        button2.setText("\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u043f\u0440\u0435\u0434\u043c\u0435\u0442");

        //---- label1 ----
        label1.setText("(\u0432\u043c\u0435\u0441\u0442\u0435 \u0441 \u0441\u0442\u0443\u0434\u0435\u043d\u0442\u0430\u043c\u0438)");

        //---- comboBox1 ----
        comboBox1.setEditable(true);

        //---- comboBox2 ----
        comboBox2.setEditable(true);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(label1))
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(7, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
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
                    .addGap(6, 6, 6)
                    .addComponent(label1)
                    .addContainerGap(8, Short.MAX_VALUE))
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
    private JLabel label1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
