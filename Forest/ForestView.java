package forest;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.util.TreeMap;
import java.awt.Point;
import java.awt.FontMetrics;
import java.util.ArrayList;

/**
 * ForestViewクラス テスト良好（2014年8月8日）
 */
public class ForestView extends mvc.View
{

	/**
	 * 指定されたforestグラフィックス　テスト良好(2014年8月9日)
	 */
	private Graphics graphic;

	/**
	 * スクロール量としてPointのインスタンスを束縛する。 テスト良好（2010年7月25日）
	 */
	private Point offset;

	/**
	 * 保存用Point テスト良好(2014年8月9日)
	 */
	private Point savePoint;

	/**
	 * 指定されたモデルとコントローラでMVCを構築するコンストラクタ。 テスト良好（2014年8月8日）
	 * 
	 * @param aModel
	 *            ForestModelを内包する変数
	 * @param aController
	 *            ForestControllerを内包する変数
	 */
	public ForestView(ForestModel aModel, ForestController aController)
	{
		super(aModel, aController);
		offset = new Point(0, 0);
		savePoint = new Point(0, 0);
		new JPanel();
	}

	/**
	 * 描画を行う。 テスト良好（2014年8月8日）
	 * 
	 * @param aGraphics
	 *            指定されたグラフィックス
	 */
	@Override
	public void paintComponent(Graphics aGraphics)
	{
		super.paintComponent(aGraphics);
		ForestModel aModel = (ForestModel) model;
		if (aModel == null)
		{
			System.out.println("モデルが内包されていません");
		}
		this.graphic = aGraphics;
		Forest aForest = aModel.getForest();
		if (aForest == null)
		{
			System.out.println("フォレストデータがありません");
		}
		else
		{

			// int width = this.getWidth();
			// int height = this.getHeight();
			aGraphics.setColor(Color.black);
			TreeMap<Integer, Node> aNode = aForest.getNode();
			ArrayList<Branch> aBranch = aForest.getBranch();

			if ((aNode == null) && (aBranch == null))
			{
				System.out.println("フォレストにノードがありません");
			}
			else
			{
				int widthes = 0;
				Point aPoint = null;
				FontMetrics fm = aGraphics.getFontMetrics();

				int barScore_height = -aModel.getBar() + offset.y;
				int barScore_wight = -aModel.getBar2() + offset.x;

				setOffset(new Point(barScore_wight, barScore_height));

				for (Node aTest : aNode.values())
				{

					widthes = fm.stringWidth(aTest.getName());

					aPoint = aTest.getNodeLocation();
					aGraphics.setColor(Color.white);
					aGraphics.drawRect(aPoint.x + barScore_wight, aPoint.y
					        + barScore_height, widthes + 2, 16);
					aGraphics.drawString(aTest.getName(), aPoint.x + 2
					        + barScore_wight, aPoint.y + 13 + barScore_height);

				}
				for (Branch aTest : aBranch)
				{
					widthes = fm.stringWidth(aTest.getParent().getName());
					Point parent = aTest.getParent().getNodeLocation();
					Point child = aTest.getChild().getNodeLocation();
					aGraphics.drawLine(parent.x + widthes + 2 + barScore_wight,
					        parent.y + 8 + barScore_height, child.x
					                + barScore_wight, child.y + barScore_height
					                + 8);
				}
			}
		}

		return;
	}

	/**
	 * 指定されたforestグラフィックスのゲッター　テスト良好(2014年8月9日)
	 * 
	 * @return graphic 指定されたforestグラフィックス
	 */
	public Graphics getGraphic()
	{
		return graphic;
	}

	/**
	 * スクロール量を指定された座標に設定（絶対スクロール）する。 テスト良好（2010年7月25日）
	 * 
	 * @param aPoint
	 *            ピクチャ座標
	 */
	@Override
	public void scrollTo(Point aPoint)
	{
		System.out.println("変化量.x" + aPoint.x);
		System.out.println("変化量.y" + aPoint.y);
		// System.out.println("scrollTo");
		offset.x = offset.x + aPoint.x;
		offset.y = offset.y + aPoint.y;
		System.out.println("x=" + offset.x);
		System.out.println("y=" + offset.y);
		this.repaint();
		return;
	}

	/**
	 * 保存用スクロール座標のセッター　テスト良好（2014年8月9日）
	 * 
	 * @param aPoint
	 *            　スクロール座標
	 */
	public void setOffset(Point aPoint)
	{
		savePoint = aPoint;
	}

	/**
	 * 保存用スクロール座標のゲッター　テスト良好（2014年8月9日）
	 * 
	 * @return savePoint 保存用スクロール座標
	 */
	public Point getOffset()
	{
		return savePoint;
	}

}
