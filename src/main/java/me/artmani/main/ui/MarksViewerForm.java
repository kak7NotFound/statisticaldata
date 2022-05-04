/*
 * Created by JFormDesigner on Wed May 04 15:07:25 MSK 2022
 */

package me.artmani.main.ui;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author unknown
 */
public class MarksViewerForm extends JFrame {

    int group;
    String subject;
    String date;
    public MarksViewerForm(Integer group_, String subject_, String date_) {
        date = date_;
        group = group_;
        subject = subject_;
        initComponents();
        setData();
    }

    public void setData(){
        List<String> dates = new ArrayList<String>();

        dates.add("");

        List<ArrayList<String>> marks = new ArrayList<ArrayList<String>>();


        table1.setModel(new DefaultTableModel(

                new Object[][] {
                        {"fae", "adsfg", "asfg"},
                        {"asfgsaf", "asgsafd", "asfgfg"},
                },
                new String[] {
                        "ass", "afsdgg", "afdsgafsdg"
                }
        ));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel());
            scrollPane1.setViewportView(table1);
        }

        //---- button1 ----
        button1.setText("text");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(319, 319, 319)
                    .addComponent(button1)
                    .addContainerGap(321, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
