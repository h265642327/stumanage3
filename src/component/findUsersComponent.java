package component;

import listener.ActionDoneListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class findUsersComponent extends JDialog {
    final int WIDTH = 400;
    final int HEIGHT = 180;
    ActionDoneListener listener;
    DefaultTableModel tableModel;

    public findUsersComponent(JFrame jf, String title, Boolean isModel, DefaultTableModel tableModel, ActionDoneListener listener) {
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


        Box btnBox = Box.createHorizontalBox();

        JButton fineBtn1 = new JButton("查找名字");
        fineBtn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int x=0,y=0;
                String name = nameField.getText().trim();
                int columnCount = tableModel.getColumnCount();
                int rowCount = tableModel.getRowCount();
                for(int i=0;i<rowCount;i++){
                    for (int j=0;j<columnCount;j++){
                        if(tableModel.getValueAt(i,j).equals(name)){
                            x=i;
                            y=j;
                            break;
                        }
                    }
                    if(tableModel.getValueAt(x,y).equals(name)){
                            break;
                    }
                }

                new show(jf,"展示",true,x,tableModel).setVisible(true);
            }
        });
        JButton fineBtn2 = new JButton("查找学号");
        fineBtn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int x=0,y=0;
                String id = idField.getText().trim();
                int columnCount = tableModel.getColumnCount();
                int rowCount = tableModel.getRowCount();
                for(int i=0;i<rowCount;i++){
                    for (int j=0;j<columnCount;j++){
                        if(tableModel.getValueAt(i,j).equals(id)){
                            x=i;
                            y=j;
                            break;
                        }
                    }
                    if(tableModel.getValueAt(x,y).equals(id)){
                        break;
                    }
                }

                new show2(jf,"展示",true,x,tableModel).setVisible(true);
            }
        });
        btnBox.add(fineBtn1);
        btnBox.add(Box.createHorizontalStrut(20));
        btnBox.add(fineBtn2);

        vBox.add(Box.createVerticalStrut(20));
        vBox.add(idBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(nameBox);
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
