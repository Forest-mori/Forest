package forest;

import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFrame;
import java.awt.Dimension;

import javax.swing.JLabel;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFrame;



public class ForestModel extends mvc.Model
{
    /**
     *Forestクラスのインスタンスを束縛する変数
     */
    private Forest aForest;
<<<<<<< HEAD
    /*
     *
     */
    public JFrame aWindow;
    /*
     * ForestView を内包する
     */
    protected ForestView aView;

    
    /*
=======
  
    /**
     * ForestViewを束縛する
     */
    private ForestView aView;
    
    /**
>>>>>>> FETCH_HEAD
     * コンストラクタ
     */
    public ForestModel(){
        super();
<<<<<<< HEAD
        aWindow = null;
        aForest = null;
        aView  = null;
        this.aForest = new Forest();
=======
        
        aForest = new Forest(this);
        aView = new ForestView(this,new ForestController());
>>>>>>> FETCH_HEAD
        this.aForest.read(this.Filechooser());
        aView = new ForestView(this,new ForestController());
        open();
        test();
    }
    public void test()
    {
        JLabel label = new JLabel("SwingLabel");
        aView.setLabel(label);
        aWindow.setVisible(true);
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
        aWindow = new JFrame("test");
    }
<<<<<<< HEAD
    /*
=======
    
    
    /**
>>>>>>> FETCH_HEAD
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
<<<<<<< HEAD
    public void open()
    {
        aWindow = new JFrame("test");
        aWindow.getContentPane().add(aView);
        aWindow.setMinimumSize(new Dimension(400, 300));
        aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aWindow.setSize(800, 600);
        aWindow.setLocation(200,100);
        aWindow.setVisible(true);
        return;
    }
=======
   
>>>>>>> FETCH_HEAD
    
    
}