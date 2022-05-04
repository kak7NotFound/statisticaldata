package me.artmani.main.ui;

import lombok.SneakyThrows;
import me.artmani.main.Main;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class ViewStatisticsForm extends JFrame {

    HashMap<String, ArrayList<String>> data = new HashMap<>();
    boolean hadInit = false;

    public ViewStatisticsForm() {
        initComponents();
        setData();
    }

    @SneakyThrows
    private void setData() {

        var params = new ArrayList<String>();
        var rs = Main.getDatabase().getResultSet("select date from Marks");

        // год
        while (rs.next()) {
            var year = Integer.parseInt(rs.getString(1).split("\\.")[2]) + 1900;
            if (params.contains(year + "")) {
                continue;
            }
            params.add(year + "");
        }
        data.put("Год", (ArrayList<String>) params.clone());

        params.clear();

        rs = Main.getDatabase().getResultSet("select date from Marks");
        // семестр
        while (rs.next()) {
            var year = Integer.parseInt(rs.getString(1).split("\\.")[2]) + 1900;
            if (params.contains("Семестр 1 " + year)) {
                continue;
            }
            for (String a : new String[]{"Семестр 1", "Семестр 2"}) {
                params.add(a + " " + year);
            }
        }

        data.put("Семестр", (ArrayList<String>) params.clone());
        params.clear();

        rs = Main.getDatabase().getResultSet("select date from Marks");
        // семестр
        while (rs.next()) {
            var year = Integer.parseInt(rs.getString(1).split("\\.")[2]) + 1900;
            var month = Integer.parseInt(rs.getString(1).split("\\.")[1]);
            if (params.contains(month + "." + year)) {
                continue;
            }
            params.add(month + "." + year);
            // todo sort
//            params.sort();

        }

        data.put("Месяц", (ArrayList<String>) params.clone());
        params.clear();

        // диапозон
        while (rs.next()) {
            var year = Integer.parseInt(rs.getString(1).split("\\.")[2]) + 1900;
            var month = Integer.parseInt(rs.getString(1).split("\\.")[1]);
            if (params.contains(month + "." + year)) {
                continue;
            }
            params.add(month + "." + year);
            // todo sort
//            params.sort();

        }

        hadInit = true;

        for (String a : new String[]{"Год", "Семестр", "Месяц", "Диапозон"}) {
            comboBox1.addItem(a);
        }

        rs = Main.getDatabase().getResultSet("select * from Groups");
        while (rs.next()) {
            comboBox4.addItem(rs.getString(1));
        }


    }

    private void comboBox1ItemStateChanged(ItemEvent e) {

        if (!hadInit) return;

        comboBox2.removeAllItems();
        button2.setEnabled(false);
        button2.setText("Начало");
        button3.setEnabled(false);
        button3.setText("Конец");
        switch (comboBox1.getSelectedItem().toString()) {
            case "Год":
                for (String d : data.get("Год")) comboBox2.addItem(d);
                break;
            case "Семестр":
                for (String d : data.get("Семестр")) comboBox2.addItem(d);
                break;
            case "Месяц":
                for (String d : data.get("Месяц")) comboBox2.addItem(d);
                break;
            case "Диапозон":
                button2.setEnabled(true);
                button3.setEnabled(true);
                break;
        }
    }

    private void comboBox2ItemStateChanged(ItemEvent e) {
        // диапозон сменился
        if (!hadInit) return;

        refreshStatisticalData();
    }

    @SneakyThrows
    private void comboBox4ItemStateChanged(ItemEvent e) {
        // group changed
        var rs = Main.getDatabase().getResultSet("select * from Students where groupId = %s".formatted(comboBox4.getSelectedItem()));
        comboBox5.removeAllItems();
        while (rs.next()) {
            comboBox5.addItem(rs.getString(1));
        }

        textField1.setText(Main.getDatabase().getResultSet("select count(*) from Students where groupId = %s".formatted(comboBox4.getSelectedItem())).getString(1));

        rs = Main.getDatabase().getResultSet("select subject from Marks where groupId = %s".formatted(comboBox4.getSelectedItem()));
        ArrayList<String> subjects = new ArrayList<>();
        while (rs.next()) {
            if (subjects.contains(rs.getString(1))) {
                continue;
            }
            subjects.add(rs.getString(1));
        }
        textField2.setText(subjects.size() + "");

        textField11.setText(Main.getDatabase().getResultSet("select course from Groups where groupId = %s".formatted(comboBox4.getSelectedItem())).getString(1));

        checkBox1StateChanged(null);

    }

    @SneakyThrows
    private void comboBox5ItemStateChanged(ItemEvent e) {
        // student changed
        var rs = Main.getDatabase().getResultSet("select * from Students where name = '%s'".formatted(comboBox5.getSelectedItem()));
        if (rs.isClosed()) return;
        textField3.setText(rs.getString(1));
        textField4.setText(rs.getString(3));
        textField5.setText(rs.getString(5));
    }

    private void button2Event(ActionEvent e) {
        new AddStatisticRangeForm(button2).setVisible(true);
    }

    private void button3Event(ActionEvent e) {
        new AddStatisticRangeForm(button3).setVisible(true);
    }

    @SneakyThrows
    private void checkBox1StateChanged(ChangeEvent e) {
        // show hidden
        comboBox6.removeAllItems();
        var subjects = new ArrayList<String>();
        ResultSet rs;

        if (checkBox1.isSelected()) {
            rs = Main.getDatabase().getResultSet("select subject from Marks where groupId = %s".formatted(comboBox4.getSelectedItem()));
        } else {
            rs = Main.getDatabase().getResultSet("select title from Subjects");
        }

        if (rs.isClosed()) return;
        while (rs.next()) {
            if (subjects.contains(rs.getString(1))) continue;
            subjects.add(rs.getString(1));
            comboBox6.addItem(rs.getString(1));
        }

    }

    @SneakyThrows
    private void comboBox6ItemStateChanged(ItemEvent e) {
        // subject changed
        var rs = Main.getDatabase().getResultSet("select teacher from Subjects where title = '%s'".formatted(comboBox6.getSelectedItem()));
        if (rs.isClosed()) return;

        textField10.setText(rs.getString(1));
        refreshStatisticalData();
    }

    @SneakyThrows
    public void refreshStatisticalData() {
        String startDate = button2.getText();
        String endDate = button3.getText();

        ResultSet rs;
        switch (comboBox1.getSelectedItem().toString()) {
            case "Год":
                textField6.setText(Main.getDatabase().getResultSet("select count(mark) from Marks where groupId = %s and date like '%s%s'"
                        .formatted(comboBox4.getSelectedItem(), "%", (Integer.parseInt(comboBox2.getSelectedItem().toString())) - 1900)).getString(1).substring(0, 1));
                textField7.setText(Main.getDatabase().getResultSet("select avg(mark) from Marks where groupId = %s and date like '%s%s'"
                        .formatted(comboBox4.getSelectedItem(), "%", (Integer.parseInt(comboBox2.getSelectedItem().toString())) - 1900)).getString(1).substring(0, 1));
                break;
            case "Семестр":
                break;
            case "Месяц":
                break;
            case "Диапозон":
                startDate = button2.getText();
                endDate = button3.getText();
                break;
        }
    }

    private void button1Event(ActionEvent e) {
        new MarksViewerForm(1, "a").setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        comboBox1 = new JComboBox();
        comboBox2 = new JComboBox();
        label3 = new JLabel();
        comboBox4 = new JComboBox();
        label4 = new JLabel();
        textField1 = new JTextField();
        label5 = new JLabel();
        textField2 = new JTextField();
        comboBox5 = new JComboBox();
        label6 = new JLabel();
        label7 = new JLabel();
        textField3 = new JTextField();
        label8 = new JLabel();
        textField4 = new JTextField();
        label9 = new JLabel();
        textField5 = new JTextField();
        label10 = new JLabel();
        textField6 = new JTextField();
        label11 = new JLabel();
        comboBox6 = new JComboBox();
        label12 = new JLabel();
        textField7 = new JTextField();
        textField8 = new JTextField();
        label13 = new JLabel();
        label14 = new JLabel();
        textField9 = new JTextField();
        label15 = new JLabel();
        textField10 = new JTextField();
        label16 = new JLabel();
        label17 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label18 = new JLabel();
        textField11 = new JTextField();
        checkBox1 = new JCheckBox();

        //======== this ========
        setTitle("\u0421\u0442\u0430\u0442\u0438\u0441\u0442\u0438\u043a\u0430");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u0422\u0438\u043f \u0432\u0440\u0435\u043c\u0435\u043d\u0438:");

        //---- label2 ----
        label2.setText("\u0414\u0438\u0430\u043f\u043e\u0437\u043e\u043d:");

        //---- comboBox1 ----
        comboBox1.addItemListener(e -> comboBox1ItemStateChanged(e));

        //---- comboBox2 ----
        comboBox2.addItemListener(e -> comboBox2ItemStateChanged(e));

        //---- label3 ----
        label3.setText("\u0413\u0440\u0443\u043f\u043f\u0430:");

        //---- comboBox4 ----
        comboBox4.addItemListener(e -> comboBox4ItemStateChanged(e));

        //---- label4 ----
        label4.setText("\u0412\u0441\u0435\u0433\u043e \u0441\u0442\u0443\u0434\u0435\u043d\u0442\u043e\u0432:");

        //---- textField1 ----
        textField1.setEditable(false);

        //---- label5 ----
        label5.setText("\u0412\u0441\u0435\u0433\u043e \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432:");

        //---- textField2 ----
        textField2.setEditable(false);

        //---- comboBox5 ----
        comboBox5.addItemListener(e -> comboBox5ItemStateChanged(e));

        //---- label6 ----
        label6.setText("\u0421\u0442\u0443\u0434\u0435\u043d\u0442:");

        //---- label7 ----
        label7.setText("\u041f\u043e\u043b\u043d\u043e\u0435 \u0438\u043c\u044f:");

        //---- textField3 ----
        textField3.setEditable(false);

        //---- label8 ----
        label8.setText("\u0422\u0435\u043b\u0435\u0444\u043e\u043d\u043d\u044b\u0439 \u043d\u043e\u043c\u0435\u0440:");

        //---- textField4 ----
        textField4.setEditable(false);

        //---- label9 ----
        label9.setText("\u041c\u0435\u0441\u0442\u043e \u0436\u0438\u0442\u0435\u043b\u044c\u0441\u0442\u0432\u0430:");

        //---- textField5 ----
        textField5.setEditable(false);

        //---- label10 ----
        label10.setText("\u0412\u0441\u0435\u0433\u043e \u043e\u0446\u0435\u043d\u043e\u043a:");

        //---- textField6 ----
        textField6.setEditable(false);

        //---- label11 ----
        label11.setText("\u041f\u0440\u0435\u0434\u043c\u0435\u0442:");

        //---- comboBox6 ----
        comboBox6.addItemListener(e -> comboBox6ItemStateChanged(e));

        //---- label12 ----
        label12.setText("\u0421\u0440\u0435\u0434\u043d\u044f\u044f \u043e\u0446\u0435\u043d\u043a\u0430:");

        //---- textField7 ----
        textField7.setEditable(false);

        //---- textField8 ----
        textField8.setEditable(false);

        //---- label13 ----
        label13.setText("\u0412\u0441\u0435\u0433\u043e \u043e\u0446\u0435\u043d\u043e\u043a:");

        //---- label14 ----
        label14.setText("\u0421\u0440\u0435\u0434\u043d\u044f\u044f \u043e\u0446\u0435\u043d\u043a\u0430:");

        //---- textField9 ----
        textField9.setEditable(false);

        //---- label15 ----
        label15.setText("\u041f\u0440\u0435\u043f\u043e\u0434\u0430\u0432\u0430\u0442\u0435\u043b\u044c:");

        //---- textField10 ----
        textField10.setEditable(false);

        //---- label16 ----
        label16.setText("\u041f\u043e \u0433\u0440\u0443\u043f\u043f\u0435:");

        //---- label17 ----
        label17.setText("\u041f\u043e \u0441\u0442\u0443\u0434\u0435\u043d\u0442\u0443:");

        //---- button1 ----
        button1.setText("\u041f\u043e\u0441\u043c\u043e\u0442\u0440\u0435\u0442\u044c \u043e\u0446\u0435\u043d\u043a\u0438");
        button1.addActionListener(e -> button1Event(e));

        //---- button2 ----
        button2.setText("\u041d\u0430\u0447\u0430\u043b\u043e");
        button2.setEnabled(false);
        button2.addActionListener(e -> button2Event(e));

        //---- button3 ----
        button3.setText("\u041a\u043e\u043d\u0435\u0446");
        button3.setEnabled(false);
        button3.addActionListener(e -> button3Event(e));

        //---- label18 ----
        label18.setText("\u041a\u0443\u0440\u0441:");

        //---- textField11 ----
        textField11.setEditable(false);

        //---- checkBox1 ----
        checkBox1.setText("\u0421\u043a\u0440\u044b\u0442\u044c \u043f\u0443\u0441\u0442\u044b\u0435");
        checkBox1.setSelected(true);
        checkBox1.addChangeListener(e -> checkBox1StateChanged(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(label1)
                                                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(32, 32, 32)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(button2)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(button3)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(button1))
                                                        .addComponent(label2)))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(label3)
                                                        .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label4)
                                                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label5)
                                                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label18)
                                                        .addComponent(textField11, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                                                .addGap(48, 48, 48)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(comboBox5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label6)
                                                        .addComponent(label8)
                                                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label7)
                                                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label9)
                                                        .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                                                .addGap(35, 35, 35)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                        .addComponent(label12)
                                                                        .addComponent(textField7, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                .addGap(1, 1, 1)
                                                                                .addComponent(textField6, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(label10)
                                                                        .addComponent(label16))
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                .addGap(15, 15, 15)
                                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                                        .addComponent(label17)
                                                                                        .addComponent(label13)))
                                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(textField8, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                .addGap(12, 12, 12)
                                                                                .addComponent(label14))
                                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(textField9, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                        .addComponent(label15)
                                                                        .addComponent(label11))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(textField10, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(comboBox6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(checkBox1)))
                                                .addGap(5, 5, 5)))
                                .addContainerGap(16, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1)
                                        .addComponent(label2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(button2)
                                        .addComponent(button3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(label3)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(comboBox5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(label11)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(comboBox6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(checkBox1))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(label4)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                .addComponent(label5)
                                                                                .addGap(6, 6, 6)
                                                                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                .addComponent(label8)
                                                                                .addGap(6, 6, 6)
                                                                                .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                .addGap(12, 12, 12)
                                                                                .addComponent(label9)
                                                                                .addGap(6, 6, 6)
                                                                                .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(label18)
                                                                                .addGap(6, 6, 6)
                                                                                .addComponent(textField11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(label10)
                                                                        .addComponent(label13))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(textField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(label12)
                                                                        .addComponent(label14))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(textField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(textField9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(label7)
                                                        .addComponent(label15)
                                                        .addComponent(textField10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(6, 6, 6)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label16)
                                                        .addComponent(label17))))
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JLabel label3;
    private JComboBox comboBox4;
    private JLabel label4;
    private JTextField textField1;
    private JLabel label5;
    private JTextField textField2;
    private JComboBox comboBox5;
    private JLabel label6;
    private JLabel label7;
    private JTextField textField3;
    private JLabel label8;
    private JTextField textField4;
    private JLabel label9;
    private JTextField textField5;
    private JLabel label10;
    private JTextField textField6;
    private JLabel label11;
    private JComboBox comboBox6;
    private JLabel label12;
    private JTextField textField7;
    private JTextField textField8;
    private JLabel label13;
    private JLabel label14;
    private JTextField textField9;
    private JLabel label15;
    private JTextField textField10;
    private JLabel label16;
    private JLabel label17;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label18;
    private JTextField textField11;
    private JCheckBox checkBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
