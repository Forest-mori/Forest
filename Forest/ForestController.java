package forest;

import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForestController extends mvc.Controller implements ActionListener 
{
    /**
	 * ポップアップメニューが表示中（処理中）であるかを表すフィールド。
	 */
	private boolean isMenuPopuping;
    
    private ForestModel model;
    
	/**
	 * フォレストコントローラーのコンストラクタ
	 */
	public ForestController(ForestModel aModel){
		super();
        this.model = aModel;
	}

	/**
	 * ポップアップメニューの項目が選択された時の処理をするメソッド
	 */
	public void actionPerformed(ActionEvent anActionEvent)
	{
        this.model.actionPerformed(anActionEvent);
		return;
	}

	/**
	 * メニューをポップアップする。
	 */
	public void showPopupMenu(MouseEvent aMouseEvent)
	{
        isMenuPopuping = true;
		this.model.showPopupMenu(aMouseEvent, this);
		return;
	}
    
    
    /**
	 * マウスボタンが押されたときの処理をする。
	 */
	public void mousePressed(MouseEvent aMouseEvent) {
		
        if(aMouseEvent.getButton() == 3){
            showPopupMenu(aMouseEvent);
            System.out.println("aaaa");
        }
        
        
		return;
	}



}