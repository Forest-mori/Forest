package forest;

import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFrame;
import java.awt.Dimension;

import javax.swing.JLabel;






public class ForestModel extends mvc.Model
{
    /*
     *Forestクラスのインスタンスを束縛する変数
     */
    private Forest aForest;
    /*
     *
     */
    public JFrame aWindow;
    /*
     * ForestView を内包する
     */
    protected ForestView aView;

    
    /*
     * コンストラクタ
     */
    public ForestModel(){
        super();
        aWindow = null;
        aForest = null;
        aView  = null;
        this.aForest = new Forest();
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
    
    /*
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
    /*
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
    
    
}