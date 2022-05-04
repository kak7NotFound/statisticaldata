package me.artmani.main.ui;

import java.awt.event.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.GroupLayout;
import com.toedter.calendar.*;
import lombok.SneakyThrows;
import me.artmani.main.Main;

public class AddMarkForm extends JFrame {
    public AddMarkForm() {
        initComponents();
        refreshData();
    }

    @SneakyThrows
    public void refreshData(){

        spinner1.setModel(new SpinnerNumberModel(3, 1, 5, 1));

        var rs = Main.getDatabase().getResultSet("select * from Groups");
        if (rs.isClosed()) return;
        while (rs.next()){
            comboBox3.addItem(rs.getString(1));
        }

        rs = Main.getDatabase().getResultSet("select title from Subjects");
        if (rs.isClosed()) return;
        while (rs.next()){
            comboBox5.addItem(rs.getString(1));
        }

    }

    @SneakyThrows
    private void comboBox3ItemStateChanged(ItemEvent e) {

        var rs = Main.getDatabase().getResultSet("select * from Students where groupId = %s"
                .formatted(comboBox3.getSelectedItem()));
        comboBox4.removeAllItems();
        if (rs.isClosed()) return;
        while (rs.next()){
            comboBox4.addItem(rs.getString(1));
        }


    }

    @SneakyThrows
    private void button1Event(ActionEvent e) {
        Main.getDatabase().executeQuery("insert into Marks (student, groupId, mark, subject, date) values ('%s', %s, %s, '%s', '%s')"
                .formatted(comboBox4.getSelectedItem(), Integer.parseInt(comboBox3.getSelectedItem().toString()), spinner1.getValue(), comboBox5.getSelectedItem(), (calendar2.getDate().getDate() + "." + calendar2.getDate().getMonth() + "." + calendar2.getDate().getYear())));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Allan
        label15 = new JLabel();
        comboBox3 = new JComboBox();
        label16 = new JLabel();
        comboBox4 = new JComboBox();
        label17 = new JLabel();
        comboBox5 = new JComboBox();
        label18 = new JLabel();
        calendar2 = new JCalendar();
        button1 = new JButton();
        spinner1 = new JSpinner();
        label19 = new JLabel();

        //======== this ========
        setTitle("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u043e\u0446\u0435\u043d\u043a\u0443");
        var contentPane = getContentPane();

        //---- label15 ----
        label15.setText("\u0413\u0440\u0443\u043f\u043f\u0430:");

        //---- comboBox3 ----
        comboBox3.addItemListener(e -> comboBox3ItemStateChanged(e));

        //---- label16 ----
        label16.setText("\u0421\u0442\u0443\u0434\u0435\u043d\u0442:");

        //---- label17 ----
        label17.setText("\u041f\u0440\u0435\u0434\u043c\u0435\u0442:");

        //---- label18 ----
        label18.setText("\u0414\u0430\u0442\u0430");

        //---- button1 ----
        button1.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c");
        button1.addActionListener(e -> button1Event(e));

        //---- label19 ----
        label19.setText("\u041e\u0446\u0435\u043d\u043a\u0430:");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label17, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label15, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label16, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label18, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                .addComponent(calendar2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                .addComponent(label19, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinner1))
                            .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(comboBox5, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(28, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label15)
                            .addGap(4, 4, 4)
                            .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(label16)
                            .addGap(4, 4, 4)
                            .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(label17)
                            .addGap(4, 4, 4)
                            .addComponent(comboBox5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label19)
                                .addComponent(spinner1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(7, 7, 7))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label18)
                            .addGap(6, 6, 6)
                            .addComponent(calendar2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(button1)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Allan
    private JLabel label15;
    private JComboBox comboBox3;
    private JLabel label16;
    private JComboBox comboBox4;
    private JLabel label17;
    private JComboBox comboBox5;
    private JLabel label18;
    private JCalendar calendar2;
    private JButton button1;
    private JSpinner spinner1;
    private JLabel label19;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
