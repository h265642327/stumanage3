package component;

import listener.ActionDoneListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//无法阻止空行的出现


public class sortUsersComponent extends JDialog {
    final int WIDTH = 400;
    final int HEIGHT = 100;
    ActionDoneListener listener;
    DefaultTableModel tableModel;

    public sortUsersComponent(JFrame jf, String title, Boolean isModel, DefaultTableModel tableModel, ActionDoneListener listener) {
        super(jf, title, isModel);
        this.listener = listener;
        this.tableModel = tableModel;

        this.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);


        JButton idBtn = new JButton("按学号升序");
        JButton nameBtn= new JButton("按姓名升序");

        Box hBox = Box.createHorizontalBox();
        hBox.add(idBtn);
        hBox.add(Box.createHorizontalStrut(20));
        hBox.add(nameBtn);

        Box hole = Box.createHorizontalBox();
        hole.add(Box.createHorizontalStrut(20));
        hole.add(hBox);
        hole.add(Box.createHorizontalStrut(20));

        idBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jf,"听杰哥的双击学号");
                dispose();
            }
        });
        nameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jf,"听杰哥的双击名字");
                dispose();
            }
        });






        this.add(hole);
    }


}
