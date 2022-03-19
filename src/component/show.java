package component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class show extends Dialog {
    int row;
    final int WIDTH = 400;
    final int HEIGHT = 400;
    DefaultTableModel tableModel;

    public show(JFrame jf, String title, Boolean isModel, int row, DefaultTableModel tableModel){
        super(jf,title,isModel);
        this.row=row;
        this.tableModel=tableModel;
        this.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);



        Box vBox = Box.createVerticalBox();




        Box idBox = Box.createHorizontalBox();
        JLabel idLabel = new JLabel("学号");
        JTextField idField = new JTextField(15);
        idField.setText((String) tableModel.getValueAt(row,0));
        idBox.add(idLabel);
        idBox.add(Box.createVerticalStrut(20));
        idBox.add(idField);

        Box nameBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("姓名");
        JTextField nameField = new JTextField(15);
        nameField.setText((String) tableModel.getValueAt(row,1));
        nameBox.add(nameLabel);
        nameBox.add(Box.createVerticalStrut(20));
        nameBox.add(nameField);

        Box chineseBox = Box.createHorizontalBox();
        JLabel chineseLabel = new JLabel("语文");
        JTextField chineseField = new JTextField(15);
        chineseField.setText((String) tableModel.getValueAt(row,2));
        chineseBox.add(chineseLabel);
        chineseBox.add(Box.createVerticalStrut(20));
        chineseBox.add(chineseField);

        Box mBox = Box.createHorizontalBox();
        JLabel mLabel = new JLabel("数学");
        JTextField mField = new JTextField(15);
        mField.setText((String) tableModel.getValueAt(row,3));
        mBox.add(mLabel);
        mBox.add(Box.createVerticalStrut(20));
        mBox.add(mField);

        Box eBox = Box.createHorizontalBox();
        JLabel eLabel = new JLabel("英语");
        JTextField eField = new JTextField(15);
        eField.setText((String) tableModel.getValueAt(row,4));
        eBox.add(eLabel);
        eBox.add(Box.createVerticalStrut(20));
        eBox.add(eField);

        Box pBox = Box.createHorizontalBox();
        JLabel pLabel = new JLabel("物理");
        JTextField pField = new JTextField(15);
       pField.setText((String) tableModel.getValueAt(row,5));
        pBox.add(pLabel);
        pBox.add(Box.createVerticalStrut(20));
        pBox.add(pField);

        Box cBox = Box.createHorizontalBox();
        JLabel cLabel = new JLabel("化学");
        JTextField cField = new JTextField(15);
        cField.setText((String) tableModel.getValueAt(row,6));
        cBox.add(cLabel);
        cBox.add(Box.createVerticalStrut(20));
        cBox.add(cField);

        Box bBox = Box.createHorizontalBox();
        JLabel bLabel = new JLabel("生物");
        JTextField bField = new JTextField(15);
        bField.setText((String) tableModel.getValueAt(row,7));
        bBox.add(bLabel);
        bBox.add(Box.createVerticalStrut(20));
        bBox.add(bField);

        JButton jButton = new JButton("确认");

        vBox.add(Box.createVerticalStrut(20));
        vBox.add(idBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(nameBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(chineseBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(mBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(eBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(pBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(cBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(bBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(jButton);


        Box hole = Box.createHorizontalBox();
        hole.add(Box.createHorizontalStrut(20));
        hole.add(vBox);
        hole.add(Box.createHorizontalStrut(20));
        this.add(hole);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean selected = jButton.isSelected();
                dispose();
            }
        });
    }
}
