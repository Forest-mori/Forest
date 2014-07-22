package forest;

import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFrame;
import java.awt.Dimension;

import javax.swing.JLabel;

import java.util.TreeMap;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JScrollBar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.BorderLayout;


public class ForestModel extends mvc.Model implements AdjustmentListener
{
    /**
     *Forestクラスのインスタンスを束縛する変数
     */
    private Forest aForest;
    
    /**
     * JFrameを束縛する
     */
    public JFrame aWindow;
    
    /*
     * ForestView を内包する
     */
    protected ForestView aView;
    /*
     *
     */
    public int saveHeigth = 0;
    
    public JScrollBar bar;
    
    private int barScore;
    
    /**
     * コンストラクタ
     */
    public ForestModel(){
        super();
        
        this.aWindow = null;
        
        this.aForest = new Forest(this);
        this.aView = new ForestView(this,new ForestController());
        this.aForest.read(this.Filechooser());
        this.open();
        
        int y = 1;
        for (Node aNode : this.aForest.getNode().values())
        {
            aNode.initLocation(0,y);
            System.out.println("番号：" + aNode.getNumber() + "　　　名前：" + aNode.getName());
            y += 16;
        }
        
        for(Node aNode : this.aForest.getRoot()){
            this.aForest.visit(aNode,new Point(0,this.aForest.underY));
        }
        
    }
    
    
    /**
     * ポップアップメニューの項目が選択された時の処理をするメソッド
     */
    public void actionPerformed(ActionEvent anActionEvent)
    {
        
    }
    
	/**
	 * メニューをポップアップする。
	 */
	public void showPopupMenu(MouseEvent aMouseEvent, ForestController aController)
	{

    }
    
    /**
     * ファイルを選んでくるメソッド
     */
    public File Filechooser()
    {
        JFileChooser ch = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File", "txt");
        ch.setFileFilter(filter);
        ch.showOpenDialog(null);
        return ch.getSelectedFile();
    }
    
    /**
     * ウィンドウを表示させる
     */
    public void open()
    {
        int i = 0;
        for (Node aNode : this.aForest.getNode().values())
        {
            if(aNode.getVisit() == true)
                i++;
        }
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        bar = new JScrollBar(JScrollBar.VERTICAL);
        bar.addAdjustmentListener(this);
        aView.add(bar);

        aWindow = new JFrame("test");
        aWindow.getContentPane().add(aView);
        aWindow.getContentPane().add(bar , BorderLayout.EAST);
        aWindow.setMinimumSize(d);
        aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aWindow.setSize(800,400);
        aWindow.setLocation(0,0);
        aWindow.setVisible(true);
        saveHeigth = d.height;
        return;
    }
    
    /**
     * Forestのインスタンスのゲッター
     */
    public Forest getForest()
    {
        return this.aForest;
    }
    /**
     *
     */
    public void adjustmentValueChanged(AdjustmentEvent e)
    {
        System.out.println("バーの情報["+bar.getValue()+"]");
        barScore = bar.getValue();
        changed();
        return;
	}
    /**
     *
     */
    public int getBar()
    {
        return barScore;
    }
    
    
    
    


}