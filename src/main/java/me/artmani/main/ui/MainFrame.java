package me.artmani.main.ui;

import java.awt.event.*;
import me.artmani.main.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    public MainFrame() {
        initComponents();
        refreshData();
    }

    private void button2Event(ActionEvent e) {
        new DataAdditionForm().setVisible(true);
    }

    public void refreshData(){
        try {
            var rs = Main.getDatabase().getResultSet("select count(*) from Groups");
            textField1.setText(rs.getString(1));
            rs = Main.getDatabase().getResultSet("select count(*) from Students");
            textField2.setText(rs.getString(1));
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    private void thisWindowGainedFocus(WindowEvent e) {
        refreshData();
    }

    private void thisWindowClosing(WindowEvent e) {
        System.exit(0);
    }

    private void button1Event(ActionEvent e) {
        new ViewStatisticsForm().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        button2 = new JButton();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();

        //======== this ========
        setTitle("\u041b\u0443\u0447\u043a\u0438\u0432 \u0410\u0440\u0442\u0435\u043c | \u0421\u0442\u0430\u0442\u0438\u0441\u0442\u0438\u0447\u0435\u0441\u043a\u0430\u044f \u043e\u0431\u0440\u0430\u0431\u043e\u0442\u043a\u0430 \u0434\u0430\u043d\u043d\u044b\u0445");
        addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                thisWindowGainedFocus(e);
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        var contentPane = getContentPane();

        //---- button1 ----
        button1.setText("\u041f\u0440\u043e\u0441\u043c\u043e\u0442\u0440 \u0421\u0442\u0430\u0442\u0438\u0441\u0442\u0438\u043a\u0438");
        button1.addActionListener(e -> button1Event(e));

        //---- button2 ----
        button2.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0434\u0430\u043d\u043d\u044b\u0435");
        button2.addActionListener(e -> button2Event(e));

        //---- label1 ----
        label1.setText("\u0412\u0441\u0435\u0433\u043e \u0433\u0440\u0443\u043f\u043f:");

        //---- textField1 ----
        textField1.setEditable(false);

        //---- label2 ----
        label2.setText("\u0412\u0441\u0435\u0433\u043e \u0441\u0442\u0443\u0434\u0435\u043d\u0442\u043e\u0432:");

        //---- textField2 ----
        textField2.setEditable(false);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(button1, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(button2, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)))
                    .addContainerGap(11, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(8, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    public JTextField textField1;
    private JLabel label2;
    public JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
