package forest;

import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFrame;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPopupMenu;

import java.util.TreeMap;

import javax.swing.JMenuItem;
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
    public JScrollBar bar2;


    private int barScore=0;
    private int barScore2=0;


    /**
     * 整列を止めるか止めないかを決める変数
     */
    public boolean flag;

    /**
     * File chooserの初期パス指定
     */
    public String aFileChooserDirectory = "./texts";

    /**
     * コンストラクタ
     */
    public ForestModel(){
        super();

        this.aWindow = null;
        this.flag = false;
        this.aForest = new Forest(this);
        this.aView = new ForestView(this,new ForestController(this));
        File aFile = this.Filechooser(aFileChooserDirectory);
        if(aFile == null)
            return;
        this.aForest.read(aFile);
        this.open();

        int y = 1;
        for (Node aNode : this.aForest.getNode().values())
        {
            aNode.initLocation(0,y);
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
        if(anActionEvent.getActionCommand().equals("Restart") ){
            this.flag = false;
        }
    }

	/**
	 * メニューをポップアップする。
	 */
	public void showPopupMenu(MouseEvent aMouseEvent, ForestController aController)
	{
       /* if(this.flag == true)
            this.flag = false;
        else
            this.flag = true;*/
        this.flag = true;
        
        if (aMouseEvent.isPopupTrigger())
        {
            JPopupMenu popup = new JPopupMenu();
            
            JMenuItem i1 = new JMenuItem("Restart");
            i1.addActionListener(aController);
            popup.add(i1);
            
            JMenuItem i2 = new JMenuItem("SawtoothWave");
            i2.addActionListener(aController);
            popup.add(i2);
            
            popup.show(aMouseEvent.getComponent(), aMouseEvent.getX(), aMouseEvent.getY());
        }
        


        }

    /**
     * ファイルを選んでくるメソッド
     */
    public File Filechooser(String aFileChooserDirectory)
    {
        JFileChooser ch = new JFileChooser(aFileChooserDirectory);
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
        bar2 = new JScrollBar(JScrollBar.HORIZONTAL);
        bar.addAdjustmentListener(this);
        bar2.addAdjustmentListener(this);

        aView.add(bar);
        aView.add(bar2);


        aWindow = new JFrame("test");
        aWindow.getContentPane().add(aView);
        aWindow.getContentPane().add(bar , BorderLayout.EAST);
        aWindow.getContentPane().add(bar2 , BorderLayout.NORTH);
        aWindow.setMinimumSize(d);
        aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //aWindow.setSize(10,10);
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
        System.out.println("バーの情報縦["+bar.getValue()+"]");
        System.out.println("バーの情報横["+barw.getValue()+"]");

        barScore = bar.getValue() * 2;
        barScore2 = bar2.getValue() * 10;
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
    public int getBar2()
    {
        return barScore2;
    }


    /**
     * フラグのゲッター
     */
    public boolean getFlag()
    {
        //System.out.println("getFlag起動");
        return this.flag;
    }



}