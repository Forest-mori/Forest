package forest;

import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ForestControllerクラス
 * テスト良好（2014年8月8日）
 */
public class ForestController extends mvc.Controller implements ActionListener 
{
    /**
	 * ポップアップメニューが表示中（処理中）であるかを表すフィールド。
     * テスト良好（2014年8月8日）
	 */
	private boolean isMenuPopuping;
    
    private ForestModel model;
    
	/**
	 * フォレストコントローラーのコンストラクタ
     * テスト良好（2014年8月8日）
	 */
	public ForestController(ForestModel aModel){
		super();
        this.model = aModel;
	}

	/**
	 * ポップアップメニューの項目が選択された時の処理をするメソッド
     * テスト良好（2014年8月8日）
	 */
	public void actionPerformed(ActionEvent anActionEvent)
	{
        this.model.actionPerformed(anActionEvent);
		return;
	}

	/**
	 * メニューをポップアップする。
     * テスト良好（2014年8月8日）
	 */
	public void showPopupMenu(MouseEvent aMouseEvent)
	{
        isMenuPopuping = true;
		this.model.showPopupMenu(aMouseEvent, this);
		return;
	}
    
    
    /**
	 * マウスボタンが押されたときの処理をする。
     * テスト良好（2014年8月8日）
	 */
	public void mousePressed(MouseEvent aMouseEvent) {
		
        if(aMouseEvent.getButton() == 3)
        {
            showPopupMenu(aMouseEvent);
        }
        
        
		return;
	}



}