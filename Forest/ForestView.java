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
	 * 指定されたモデルとコントローラでMVCを構築するコンストラクタ。 テスト良好（2014年8月8日）
	 * @param aModel
	 * @param aController
	 */
	public ForestView(ForestModel aModel, ForestController aController)
	{
		super(aModel, aController);
		new JPanel();
	}

	/**
	 * 描画を行う。 テスト良好（2014年8月8日）
	 * @param aGraphics
	 */
	public void paintComponent(Graphics aGraphics)
	{
		super.paintComponent(aGraphics);
		ForestModel aModel = (ForestModel) model;
		if (aModel == null)
		{
			System.out.println("モデルが内包されていません");
		}
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

				int barScore_height = -aModel.getBar();
				int barScore_wight = -aModel.getBar2();

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
}
