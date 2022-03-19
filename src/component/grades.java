package component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class grades extends Box{
    final int WIDTH = 850;
    final int HEIGHT = 600;

    JFrame jf = null;
    DefaultTableModel jmodel;

    public grades(JFrame jf,DefaultTableModel jmodel){
        super(BoxLayout.Y_AXIS);
        this.jf=jf;
        this.jmodel=jmodel;
        int [][] sum = new int[0][];
        int row = jmodel.getRowCount();
        int column = jmodel.getColumnCount();
        for(int i=0;i<row;i++){
            for(int j=2;j<column;j++){
                if(jmodel.getValueAt(i,j)!=null){
                    sum[i][j]++;
                }
            }
        }





    }
}
