package component;

import listener.ActionDoneListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Locale;
import java.util.function.ObjIntConsumer;

//无法阻止空行的出现





public class addUsersComponent extends JDialog {
    final int WIDTH = 400;
    final int HEIGHT = 400;
    ActionDoneListener listener;
    DefaultTableModel tableModel;

    public addUsersComponent(JFrame jf, String title, Boolean isModel, DefaultTableModel tableModel, ActionDoneListener listener) {
        super(jf, title, isModel);
        this.listener = listener;
        this.tableModel = tableModel;
        this.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);

        Box vBox = Box.createVerticalBox();

        Box idBox = Box.createHorizontalBox();
        JLabel idLabel = new JLabel("学号");
        JTextField idField = new JTextField(15);
        idBox.add(idLabel);
        idBox.add(Box.createVerticalStrut(20));
        idBox.add(idField);

        Box nameBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("姓名");
        JTextField nameField = new JTextField(15);
        nameBox.add(nameLabel);
        nameBox.add(Box.createVerticalStrut(20));
        nameBox.add(nameField);

        Box chineseBox = Box.createHorizontalBox();
        JLabel chineseLabel = new JLabel("语文");
        JTextField chineseField = new JTextField(15);
        chineseBox.add(chineseLabel);
        chineseBox.add(Box.createVerticalStrut(20));
        chineseBox.add(chineseField);

        Box mBox = Box.createHorizontalBox();
        JLabel mLabel = new JLabel("数学");
        JTextField mField = new JTextField(15);
        mBox.add(mLabel);
        mBox.add(Box.createVerticalStrut(20));
        mBox.add(mField);

        Box eBox = Box.createHorizontalBox();
        JLabel eLabel = new JLabel("英语");
        JTextField eField = new JTextField(15);
        eBox.add(eLabel);
        eBox.add(Box.createVerticalStrut(20));
        eBox.add(eField);

        Box pBox = Box.createHorizontalBox();
        JLabel pLabel = new JLabel("物理");
        JTextField pField = new JTextField(15);
        pBox.add(pLabel);
        pBox.add(Box.createVerticalStrut(20));
        pBox.add(pField);

        Box cBox = Box.createHorizontalBox();
        JLabel cLabel = new JLabel("化学");
        JTextField cField = new JTextField(15);
        cBox.add(cLabel);
        cBox.add(Box.createVerticalStrut(20));
        cBox.add(cField);

        Box bBox = Box.createHorizontalBox();
        JLabel bLabel = new JLabel("生物");
        JTextField bField = new JTextField(15);
        bBox.add(bLabel);
        bBox.add(Box.createVerticalStrut(20));
        bBox.add(bField);

        Box btnBox = Box.createHorizontalBox();

        JButton addBtn = new JButton("添加");
        addBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                    String    id = idField.getText().trim();
                    String  name = nameField.getText().trim();
                    String   chinese = chineseField.getText().trim();
                    String  math = mField.getText().trim();
                    String  english = eField.getText().trim();
                    String  physic = pField.getText().trim();
                    String  chemistry = cField.getText().trim();
                    String  biology = bField.getText().trim();


                Object[] a = {id, name, chinese, math, english, physic, chemistry, biology};
                Boolean examine = false;
                for(Object i: a){
                    if(i!=null){
                        examine = true;
                        break;
                    }
                }
                if (examine) {
                    tableModel.addRow(a);
                    JOptionPane.showMessageDialog(jf, "添加成功");
                } else {
                    JOptionPane.showMessageDialog(jf, "添加失败,请确保输入数据");
                }
                dispose();
            }
        });
        btnBox.add(addBtn);


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
        vBox.add(btnBox);

//        左右间距
        Box hole = Box.createHorizontalBox();
        hole.add(Box.createHorizontalStrut(20));
        hole.add(vBox);
        hole.add(Box.createHorizontalStrut(20));
        this.add(hole);
    }


}
