package forest;

import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import javax.swing.JScrollBar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.BorderLayout;
import java.awt.Point;

import java.awt.FontMetrics;

/**
 * ForestModelクラス テスト良好（2014年8月9日）
 */
public class ForestModel extends mvc.Model implements AdjustmentListener
{
	/**
	 * Forestクラスのインスタンスを束縛する変数 テスト良好（2014年8月9日）
	 */
	private Forest aForest;

	/**
	 * JFrameを束縛する テスト良好（2014年8月9日）
	 */
	public JFrame aWindow;

	/**
	 * ForestView を内包する テスト良好（2014年8月9日）
	 */
	protected ForestView aView;

	/**
	 * スクロールバーを保存するフィールド（縦） テスト良好（2014年8月9日）
	 */
	public JScrollBar bar_height;

	/**
	 * スクロールバーを保存するフィールド（横） テスト良好（2014年8月9日）
	 */
	public JScrollBar bar_wight;

	/**
	 * 縦のスクロール量を保存するフィールド テスト良好（2014年8月9日）
	 */
	private int barScore_height;

	/**
	 * 横のスクロール量を保存するフィールド テスト良好（2014年8月9日）
	 */
	private int barScore_wight;

	/**
	 * 整列を止めるか止めないかを決める変数 テスト良好（2014年8月9日）
	 */
	public boolean flag;

	/**
	 * File chooserの初期パス指定 テスト良好（2014年8月9日）
	 */
	public String aFileChooserDirectory = "./texts";

	/**
	 * コンストラクタ テスト良好（2014年8月9日）
	 */
	public ForestModel()
	{
		super();

		this.aWindow = null;
		this.flag = false;
		this.aForest = new Forest(this);
		this.aView = new ForestView(this, new ForestController(this));

		File aFile = this.Filechooser(aFileChooserDirectory);
		if (aFile == null)
			return;
		this.aForest.read(aFile);
		this.open();
	}

	/**
	 * ポップアップメニューの項目が選択された時の処理をするメソッド テスト良好（2014年8月9日）
	 *
	 * @param anActionEvent
	 *            とあるアクションのイベント
	 */
	public void actionPerformed(ActionEvent anActionEvent)
	{
		if (anActionEvent.getActionCommand().equals("Stop → Restart"))
		{
			this.flag = false;
		}
	}

	/**
	 * メニューをポップアップする。 テスト良好（2014年8月9日）
	 *
	 * @param aMouseEvent
	 *            マウスのイベント
	 * @param aController
	 *            マウスイベントを受け取ったコントローラ
	 */
	public void showPopupMenu(MouseEvent aMouseEvent,
	        ForestController aController)
	{

		this.flag = true;

		if (aMouseEvent.isPopupTrigger())
		{
			JPopupMenu popup = new JPopupMenu();

			JMenuItem i1 = new JMenuItem("Stop → Restart");
			i1.addActionListener(aController);
			popup.add(i1);

			popup.show(aMouseEvent.getComponent(), aMouseEvent.getX(),
			        aMouseEvent.getY());
		}

	}

	/**
	 * マウスクリックした位置を座標として受け取り、その位置にNodeがあれば出力 テスト良好（2014年8月9日)
	 *
	 * @param aPoint
	 *            ピクチャ座標
	 * @param aMouseEvent
	 *            マウスのイベント
	 */
	public void mouseClicked(Point aPoint, MouseEvent aMouseEvent)
	{
		FontMetrics fm = this.aView.getGraphic().getFontMetrics();

		Point savePoint = aView.getOffset();

		for (Node node : this.getForest().getNode().values())
		{
			if (node.getNodeLocation().x + savePoint.x <= aPoint.x
			        && node.getNodeLocation().x + savePoint.x
			                + fm.stringWidth(node.getName()) >= aPoint.x)
			{
				if (node.getNodeLocation().y + savePoint.y <= aPoint.y
				        && node.getNodeLocation().y + 16 + savePoint.y >= aPoint.y)
				{
					System.out.println(node.getName());
				}
			}
		}
		return;
	}

	/**
	 * マウスがドラックされたときの動作 テスト良好(2014年8月9日)
	 *
	 * @param aPoint
	 *            　ピクチャ座標
	 */
	public void mouseDragged(Point aPoint)
	{
		aView.scrollTo(aPoint);

		return;
	}

	/**
	 * ファイルを選んでくるメソッド テスト良好（2014年8月9日）
	 *
	 * @param aFileChooserDirectory
	 *            File chooserの初期ディレクトリパス
	 * @return ch.getSelectedFile() 選択ファイル
	 */
	public File Filechooser(String aFileChooserDirectory)
	{
		JFileChooser ch = new JFileChooser(aFileChooserDirectory);
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "Text File", "txt");
		ch.setFileFilter(filter);
		ch.showOpenDialog(null);
		return ch.getSelectedFile();
	}

	/**
	 * ウィンドウを表示させる テスト良好（2014年8月9日）
	 */
	public void open()
	{

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

		bar_height = new JScrollBar(JScrollBar.VERTICAL);
		bar_wight = new JScrollBar(JScrollBar.HORIZONTAL);

		bar_height.addAdjustmentListener(this);
		bar_wight.addAdjustmentListener(this);

		aView.add(bar_height);
		aView.add(bar_wight);

		aWindow = new JFrame("test");
		aWindow.getContentPane().add(aView);
		aWindow.getContentPane().add(bar_height, BorderLayout.EAST);
		aWindow.getContentPane().add(bar_wight, BorderLayout.NORTH);
		aWindow.setMinimumSize(d);
		aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aWindow.setSize(800, 400);
		aWindow.setLocation(0, 0);
		aWindow.setVisible(true);
		return;
	}

	/**
	 * Forestのインスタンスのゲッター テスト良好（2014年8月9日）
	 *
	 * @return aForest　Forestクラスのインスタンスを束縛する変数
	 */
	public Forest getForest()
	{
		return this.aForest;
	}

	/**
	 * スクロールの取得 テスト良好（2014年8月9日）
	 *
	 * @param e
	 *            　変更時のイベント
	 */
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e)
	{

		barScore_height = bar_height.getValue() * 10;
		barScore_wight = bar_wight.getValue() * 20;
		changed();
		return;

	}

	/**
	 * 縦スクロールのゲッター テスト良好（2014年8月9日）
	 *
	 * @return barScore_height スクロールバーを保存するフィールド（縦）
	 */
	public int getBar()
	{
		return barScore_height;
	}

	/**
	 * 横スクロールのゲッター テスト良好（2014年8月9日）
	 *
	 * @return barScore_wight スクロールバーを保存するフィールド（横）
	 */
	public int getBar2()
	{
		return barScore_wight;
	}

	/**
	 * フラグのゲッター テスト良好（2014年8月9日）
	 *
	 * @return flag フラグ
	 */
	public boolean getFlag()
	{
		return this.flag;
	}

}