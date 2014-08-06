package forest;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.util.TreeMap;
import java.awt.Point;
import java.awt.FontMetrics;
import java.util.ArrayList;


public class ForestView extends mvc.View
{

	/**
	 * 指定されたモデルとコントローラでMVCを構築するコンストラクタ。
	 */
	private JPanel p;

	public ForestView(ForestModel aModel,ForestController aController)
	{
		super(aModel,aController);
		p = new JPanel();
	}


	/**
	 * 描画を行う。
	 */
	public void paintComponent(Graphics aGraphics)

	{
		//System.out.println("------------------viewによる動作----------------");
		super.paintComponent(aGraphics);
		ForestModel aModel = (ForestModel)model;
		Forest aForest = aModel.getForest();
		if(aForest == null)
		{
			System.out.println("フォレストデータがありません");
		}
		else
		{
			//System.out.println("フォレストデータを確認");

			if(aModel == null)
			{
				//System.out.println("モデルが内包されていません");
			}
			int width = this.getWidth();
			int height = this.getHeight();
			aGraphics.setColor(Color.black);
			//System.out.println("nodeを作成してみます");
			TreeMap<Integer,Node> aNode = aForest.getNode();
			ArrayList<Branch> aBranch = aForest.getBranch();

			if((aNode == null) && (aBranch == null))
			{
			//	System.out.println("フォレストにノードがありません");
			}
			else
			{
				//System.out.println("フォレストにノードを確認");
				int i = 0;
				int widthes = 0;
				Point aPoint = null;
				FontMetrics fm = aGraphics.getFontMetrics();

				for(Node aTest : aNode.values())
				{
					//System.out.println("----名前：" + aTest.getName() + "["+i+"]番目----");
				   // System.out.println("名前["+aTest.getName()+"]の位置座標:"+aTest.getNodeLocation());
					widthes = fm.stringWidth(aTest.getName());

					//System.out.println("今回の文字のサイズ["+widthes+"]");
					//ノードのサークルを作成する。(文字入り)
					aPoint = aTest.getNodeLocation();
					aGraphics.setColor(Color.white);
					aGraphics.drawRect(aPoint.x,aPoint.y,widthes+2,16);
					aGraphics.drawString(aTest.getName(),aPoint.x+2,aPoint.y+13);

					i++;
				}
				for (Branch aTest : aBranch)
				{
					widthes = fm.stringWidth(aTest.getParent().getName());
					Point parent = aTest.getParent().getNodeLocation();
					Point child = aTest.getChild().getNodeLocation();
					aGraphics.drawLine(parent.x+widthes+2,parent.y+8,child.x,child.y);
				}
			}

		}
		//System.out.println("------------------viewによる動作終了----------------");

		return;

	}


}