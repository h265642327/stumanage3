package component;

import listener.ActionDoneListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.util.Vector;

public class userManageComponent extends Box {
    final int WIDTH = 850;
    final int HEIGHT = 600;

    JFrame jf = null;
    private JTable jTable = new JTable();
    private Vector<String> titles;
    private Vector<Vector> titlesData;
    private DefaultTableModel tableModel;

    public userManageComponent(JFrame jf) {
        super(BoxLayout.Y_AXIS);
        this.jf = jf;
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnPanel.setMaximumSize(new Dimension(WIDTH, 80));

        JButton addUsers = new JButton("添加");
        addUsers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addUsersComponent(jf, "添加信息", true, tableModel, new ActionDoneListener() {
                    @Override
                    public void done(Object result) {
//                      检查是否为空行,若是则删掉
                    }
                }).setVisible(true);
            }
        });


        JButton revise = new JButton("修改");
        revise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jf, "双击数据修改即可！");
            }
        });
        JButton delete = new JButton("删除");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = jTable.getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(jf,"请选择对象进行删除");
                }else {
                    tableModel.removeRow(row);
                }
            }
        });
        JButton findBtn = new JButton("查找");
        findBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new findUsersComponent(jf, "添加信息", true, tableModel, new ActionDoneListener() {
                    @Override
                    public void done(Object result) {
//                      检查是否为空行,若是则删掉
                    }
                }).setVisible(true);
            }
        });

        JButton sortBtn = new JButton("排序");
        sortBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new sortUsersComponent(jf, "排序列表", true, tableModel, null).setVisible(true);
            }
        });

        btnPanel.add(addUsers);
        btnPanel.add(revise);
        btnPanel.add(delete);
        btnPanel.add(findBtn);
        btnPanel.add(sortBtn);

        this.add(btnPanel);

//        六门学科
        String[] title = {"学号", "姓名", "语文", "数学", "英语", "物理", "化学", "生物"};
        titles = new Vector<>();
        for (String i : title) {
            titles.add(i);
        }


//        鼠标单选一行
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

//        表格数据
        titlesData = new Vector<>();

//        初始化数据
        String[][] a = {
                {"202113407367", "黄家杰", "102", "97", "119", "87", "91", "81"}
        };
//        集合存储数据
        Vector<Vector> vector = new Vector<>();
        for (int i = 0; i < a.length; i++) {
            Vector<String> dataV = new Vector<>();
            for (int j = 0; j < a[i].length; j++) {
                dataV.add(a[i][j]);
            }
            vector.add(dataV);
        }
        for (Vector vector1 : vector) {
            titlesData.add(vector1);
        }


        tableModel = new DefaultTableModel(titlesData, titles);

        jTable = new JTable(tableModel);
//                是否可以修改表格数据
/*        jTable = new JTable(tableModel)
        {
            @Override

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };*/
//          每列的拖动权限
        jTable.getTableHeader().setReorderingAllowed(false);
//        滚动
        JScrollPane jScrollPane = new JScrollPane(jTable);




        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
        jTable.setRowSorter(sorter);
        this.add(jScrollPane);
//        System.exit(0);

    }


}
