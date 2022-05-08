/*
 * Created by JFormDesigner on Wed May 04 15:07:25 MSK 2022
 */

package me.artmani.main.ui;

import lombok.SneakyThrows;
import me.artmani.main.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
        setTitle("Просмотр оценок за " + date + " | " + subject + " | Группа " + group);
    }


    @SneakyThrows
    public void setData() {

        List<String> marks = new ArrayList<String>();
        List<String> dates = new ArrayList<String>();
        List<String> students = new ArrayList<String>();

        var splitDate = date.split("\\.");
        date = splitDate[0] + "." + (Integer.parseInt(splitDate[1]) - 1900);

        System.out.println("select student, date from Marks where groupId = %s and subject = '%s' and date like '%s%s'"
                .formatted(group, subject, "%" ,date));
        var rs = Main.getDatabase().getResultSet("select student, date from Marks where groupId = %s and subject = '%s' and date like '%s%s'"
                .formatted(group, subject, "%" , date ));

        if (rs.isClosed()) System.out.println("rs closed");

        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2));
            if (!(students.contains(rs.getString(1)))) {
                students.add(rs.getString(1));
            }
            if (!(dates.contains(rs.getString(2)))) {
                var a = rs.getString(2).split("\\.");
                dates.add(a[0] + "." + a[1]);
            }
        }

        for (String student : students) {
            marks.add(student);
            rs = Main.getDatabase().getResultSet("select mark from Marks where groupId = %s and subject = '%s' and student = '%s' and date like '%s%s'"
                    .formatted(group, subject, student, "%", date));
            if (rs.isClosed()) continue;
            while (rs.next()) {
                marks.add(rs.getString(1));
            }

        }

        table1.setModel(new DefaultTableModel(
        new Object[][]{},
                dates.toArray()
                /*new Object[]{"ads", "asd", "asd"}*/
        ));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel());
            scrollPane1.setViewportView(table1);
        }

        //---- button1 ----
        button1.setText("\u0417\u0430\u043a\u0440\u044b\u0442\u044c");

        //---- button2 ----
        button2.setText("\u0423\u0434\u0430\u043b\u0438\u0442\u044c");

        //---- button3 ----
        button3.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(171, 171, 171)
                    .addComponent(button1)
                    .addGap(73, 73, 73)
                    .addComponent(button2)
                    .addGap(66, 66, 66)
                    .addComponent(button3)
                    .addContainerGap(172, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2)
                        .addComponent(button3))
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
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
