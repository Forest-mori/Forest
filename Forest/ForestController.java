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
	 * 前のポインタを保存するようのフィールド
	 */
	private Point savePoint;

	/**
	 * フォレストコントローラーのコンストラクタ テスト良好（2014年8月8日）
	 * 
	 * @param aModel
	 *            ForestModelを内包する変数
	 */
	public ForestController(ForestModel aModel)
	{
		super();
		this.model = aModel;
		savePoint = new Point(0, 0);

	}

	/**
	 * ポップアップメニューの項目が選択された時の処理をするメソッド テスト良好（2014年8月8日）
	 * 
	 * @param anActionEvent
	 *            とあるアクションのイベント
	 */
	public void actionPerformed(ActionEvent anActionEvent)
	{
		this.model.actionPerformed(anActionEvent);
		return;
	}

	/**
	 * メニューをポップアップする。 テスト良好（2014年8月8日）
	 * 
	 * @param aMouseEvent
	 *            マウスのイベント
	 */
	public void showPopupMenu(MouseEvent aMouseEvent)
	{
		this.model.showPopupMenu(aMouseEvent, this);
		return;
	}

	/**
	 * マウスボタンが押されたときの処理をする。 テスト良好（2014年8月8日）
	 * 
	 * @param aMouseEvent
	 *            マウスのイベント
	 */
	@Override
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

	/**
	 * マウスがドラックされたときの動作 テスト良好(2014年8月9日）
	 * 
	 * @param aMouseEvent
	 *            マウスのイベント
	 */
	@Override
	public void mouseDragged(MouseEvent aMouseEvent)
	{
		// System.out.println("テスト");
		Point aPoint = aMouseEvent.getPoint();
		if (savePoint.x != 0 && savePoint.y != 0)
		{
			int x = aPoint.x - savePoint.x;
			int y = aPoint.y - savePoint.y;
			// System.out.println("x==="+x);
			// System.out.println("y==="+y);

			this.model.mouseDragged(new Point(x, y));
		}
		savePoint = aPoint;
		return;
	}

	/**
	 * マウスが離れたときの処理 テスト良好(2014年8月9日)
	 * 
	 * @param aMouseEvent
	 *            マウスのイベント
	 */
	@Override
	public void mouseReleased(MouseEvent aMouseEvent)
	{
		savePoint = new Point(0, 0);
		return;
	}

}