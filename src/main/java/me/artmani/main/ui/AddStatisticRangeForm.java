/*
 * Created by JFormDesigner on Wed May 04 14:34:36 MSK 2022
 */

package me.artmani.main.ui;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import com.toedter.calendar.*;

/**
 * @author unknown
 */
public class AddStatisticRangeForm extends JFrame {

    JButton button;
    public AddStatisticRangeForm(JButton button_) {
        button = button_;
        initComponents();
    }

    private void button1Event(ActionEvent e) {
        var date = calendar1.getDate();
        button.setText(date.getDate() + "." + date.getMonth() + "." + (date.getYear() + 1900));
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        calendar1 = new JCalendar();
        button1 = new JButton();

        //======== this ========
        setTitle("\u0412\u044b\u0431\u0435\u0440\u0438 \u0434\u0438\u0430\u043f\u043e\u0437\u043e\u043d");
        var contentPane = getContentPane();

        //---- button1 ----
        button1.setText("\u041f\u0440\u0438\u043d\u044f\u0442\u044c");
        button1.addActionListener(e -> button1Event(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(calendar1, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(8, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(calendar1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(13, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JCalendar calendar1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
