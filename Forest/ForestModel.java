package forest;

import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;




public class ForestModel extends mvc.Model
{
    /*
     *Forestクラスのインスタンスを束縛する変数
     */
    private Forest aForest;
    
    
    /*
     * コンストラクタ
     */
    public ForestModel(){
        super();
        this.aForest = new Forest();
        this.aForest.read(this.Filechooser());
        
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
    
    
}