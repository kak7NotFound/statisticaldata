/*
 * Created by JFormDesigner on Fri Apr 29 13:31:35 MSK 2022
 */

package me.artmani.main.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import com.toedter.calendar.*;

/**
 * @author Allan
 */
public class AddStudentForm extends JFrame {
    public AddStudentForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Allan
        label10 = new JLabel();
        comboBox2 = new JComboBox();
        label11 = new JLabel();
        button2 = new JButton();
        textField3 = new JTextField();
        label12 = new JLabel();
        label13 = new JLabel();
        calendar1 = new JCalendar();
        label14 = new JLabel();
        textField4 = new JTextField();
        comboBox6 = new JComboBox();
        button4 = new JButton();

        //======== this ========
        setTitle("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0441\u0442\u0443\u0434\u0435\u043d\u0442\u0430 ");
        var contentPane = getContentPane();

        //---- label10 ----
        label10.setText("\u0413\u0440\u0443\u043f\u043f\u0430:");

        //---- comboBox2 ----
        comboBox2.setEditable(true);

        //---- label11 ----
        label11.setText("\u0418\u043c\u044f");

        //---- button2 ----
        button2.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c / \u0438\u0437\u043c\u0435\u043d\u0438\u0442\u044c");

        //---- label12 ----
        label12.setText("\u041d\u043e\u043c\u0435\u0440 \u0442\u0435\u043b\u0435\u0444\u043e\u043d\u0430");

        //---- label13 ----
        label13.setText("\u0414\u0430\u0442\u0430 \u0440\u043e\u0436\u0434\u0435\u043d\u0438\u044f");

        //---- label14 ----
        label14.setText("\u041c\u0435\u0441\u0442\u043e \u0436\u0438\u0442\u0435\u043b\u044c\u0441\u0442\u0432\u0430");

        //---- button4 ----
        button4.setText("\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0441\u0442\u0443\u0434\u0435\u043d\u0442\u0430");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(81, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(button4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))
                    .addGap(40, 40, 40))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label10, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label11, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBox6, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
                            .addGap(36, 36, 36)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label12, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                .addComponent(calendar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label13, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 22, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label14, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(225, Short.MAX_VALUE))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label10)
                        .addComponent(label12))
                    .addGap(4, 4, 4)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(4, 4, 4)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label13)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(calendar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label11)
                            .addGap(8, 8, 8)
                            .addComponent(comboBox6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label14)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(button2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(button4)
                    .addContainerGap(37, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Allan
    private JLabel label10;
    private JComboBox comboBox2;
    private JLabel label11;
    private JButton button2;
    private JTextField textField3;
    private JLabel label12;
    private JLabel label13;
    private JCalendar calendar1;
    private JLabel label14;
    private JTextField textField4;
    private JComboBox comboBox6;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
