/*
 * Created by JFormDesigner on Fri Apr 29 13:31:27 MSK 2022
 */

package me.artmani.main.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import com.toedter.calendar.*;

/**
 * @author Allan
 */
public class AddMarkGroup extends JFrame {
    public AddMarkGroup() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Allan
        label8 = new JLabel();
        label15 = new JLabel();
        comboBox3 = new JComboBox();
        label16 = new JLabel();
        comboBox4 = new JComboBox();
        label17 = new JLabel();
        comboBox5 = new JComboBox();
        label18 = new JLabel();
        calendar2 = new JCalendar();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label8 ----
        label8.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u043e\u0446\u0435\u043d\u043a\u0443");
        label8.setHorizontalAlignment(SwingConstants.CENTER);
        label8.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- label15 ----
        label15.setText("\u0413\u0440\u0443\u043f\u043f\u0430:");

        //---- label16 ----
        label16.setText("\u0421\u0442\u0443\u0434\u0435\u043d\u0442:");

        //---- label17 ----
        label17.setText("\u041f\u0440\u0435\u0434\u043c\u0435\u0442:");

        //---- label18 ----
        label18.setText("\u0414\u0430\u0442\u0430");

        //---- button1 ----
        button1.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c / \u0438\u0437\u043c\u0435\u043d\u0438\u0442\u044c");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label16, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
                        .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label17, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label15, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label18, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                .addComponent(calendar2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addComponent(comboBox5, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(88, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label8)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label15)
                            .addGap(4, 4, 4)
                            .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(label16))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label18)
                            .addGap(6, 6, 6)
                            .addComponent(calendar2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addComponent(button1, GroupLayout.Alignment.TRAILING))
                    .addGap(4, 4, 4)
                    .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addComponent(label17)
                    .addGap(4, 4, 4)
                    .addComponent(comboBox5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(52, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Allan
    private JLabel label8;
    private JLabel label15;
    private JComboBox comboBox3;
    private JLabel label16;
    private JComboBox comboBox4;
    private JLabel label17;
    private JComboBox comboBox5;
    private JLabel label18;
    private JCalendar calendar2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
