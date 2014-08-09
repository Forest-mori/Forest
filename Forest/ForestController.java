package forest;

import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Point;

/**
 * ForestControllerクラス テスト良好（2014年8月8日）
 */
public class ForestController extends mvc.Controller implements ActionListener
{

	/**
	 * ForestModelを内包する テスト良好（2014年8月8日）
	 */
	private ForestModel model;

	/**
	 * フォレストコントローラーのコンストラクタ テスト良好（2014年8月8日）
	 * @param aModel
	 */
	public ForestController(ForestModel aModel)
	{
		super();
		this.model = aModel;
	}

	/**
	 * ポップアップメニューの項目が選択された時の処理をするメソッド テスト良好（2014年8月8日）
	 * @param anActionEvent
	 */
	public void actionPerformed(ActionEvent anActionEvent)
	{
		this.model.actionPerformed(anActionEvent);
		return;
	}

	/**
	 * メニューをポップアップする。 テスト良好（2014年8月8日）
	 * @param aMouseEvent
	 */
	public void showPopupMenu(MouseEvent aMouseEvent)
	{
		this.model.showPopupMenu(aMouseEvent, this);
		return;
	}

	/**
	 * マウスボタンが押されたときの処理をする。 テスト良好（2014年8月8日）
	 * @param aMouseEvent
	 */
	public void mousePressed(MouseEvent aMouseEvent)
	{

		if (aMouseEvent.getButton() == 3)
		{
			showPopupMenu(aMouseEvent);
		}

        if (aMouseEvent.getButton() == 1)
		{
			Point aPoint = aMouseEvent.getPoint();
            aPoint.translate(view.scrollAmount().x, view.scrollAmount().y);
            this.model.mouseClicked(aPoint, aMouseEvent);
            return;
		}
		return;
	}

}