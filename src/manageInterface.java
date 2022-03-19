import component.userManageComponent;
import component.ScreenUtils;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class manageInterface {
    final int WIDTH = 1000;
    final int HEIGHT = 600;


    JFrame jf = new JFrame("杰哥牌成绩管理系统：");
    JMenuBar jmb = new JMenuBar();
    JMenu menu = new JMenu("菜单");
    JMenuItem exit = new JMenuItem("退出");


    public void init() {
        jf.setBounds((ScreenUtils.getScreenWidth()-WIDTH)/2,(ScreenUtils.getScreenHeight()-HEIGHT)/2,WIDTH,HEIGHT);
        jf.setResizable(false);
//        jf.setIconImage();
        menu.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jmb.add(menu);
        jf.setJMenuBar(jmb);

//        面板
        JSplitPane jsp =new JSplitPane();
        jsp.setContinuousLayout(true);
        jsp.setDividerLocation(150);
        jsp.setDividerSize(7);

//        左侧
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("系统管理");
        DefaultMutableTreeNode user = new DefaultMutableTreeNode("学生管理");
        DefaultMutableTreeNode grades =new DefaultMutableTreeNode("成绩管理");

        root.add(user);
        root.add(grades);

        JTree jTree =new JTree(root);
        jTree.setSelectionRow(1);
        jsp.setRightComponent(new userManageComponent(jf));
        jsp.setLeftComponent(jTree);
//        节点反馈右侧内容
        jTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                Object path = e.getNewLeadSelectionPath().getLastPathComponent();
                if(path.equals(user)){
                    jsp.setRightComponent(new userManageComponent(jf));
                    jsp.setDividerLocation(150);
                }
                else if(path.equals(grades)){
                    jsp.setRightComponent(new JLabel("这里是成绩管理"));
                    jsp.setDividerLocation(150);
                }
            }
        });






        jf.add(jsp);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new manageInterface().init();
    }


}


