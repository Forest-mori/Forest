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
        super.paintComponent(aGraphics);
		ForestModel aModel = (ForestModel)model;
		Forest aForest = aModel.getForest();
		if(aForest == null)
		{
			System.out.println("フォレストデータがありません");
		}
		else
		{
            
			if(aModel == null)
			{
				System.out.println("モデルが内包されていません");
			}
			int width = this.getWidth();
			int height = this.getHeight();
			aGraphics.setColor(Color.black);
			TreeMap<Integer,Node> aNode = aForest.getNode();
			ArrayList<Branch> aBranch = aForest.getBranch();
            
			if((aNode == null) && (aBranch == null))
			{
                System.out.println("フォレストにノードがありません");
			}
			else
			{
				
				int i = 0;
				int widthes = 0;
				Point aPoint = null;
				FontMetrics fm = aGraphics.getFontMetrics();
                
                int barScore_height = -aModel.getBar();
                int barScore_wight = -aModel.getBar2();
                
				for(Node aTest : aNode.values())
				{
					
					widthes = fm.stringWidth(aTest.getName());
                    
                    
					aPoint = aTest.getNodeLocation();
					aGraphics.setColor(Color.white);
					aGraphics.drawRect(aPoint.x+barScore_wight,aPoint.y+barScore_height,widthes+2,16);
					aGraphics.drawString(aTest.getName(),aPoint.x+2+barScore_wight,aPoint.y+13+barScore_height);
                    
					i++;
				}
				for (Branch aTest : aBranch)
				{
					widthes = fm.stringWidth(aTest.getParent().getName());
					Point parent = aTest.getParent().getNodeLocation();
					Point child = aTest.getChild().getNodeLocation();
					aGraphics.drawLine(parent.x+widthes+2+barScore_wight,parent.y+8+barScore_height,child.x+barScore_wight,child.y+barScore_height+8);
				}
			}
            
		}
		
		return;
        
	}
    
    
}