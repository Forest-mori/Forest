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



public class ForestView extends mvc.View
{
    
    /*
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
        if(aModel == null)
        {
            System.out.println("モデルが内包されていません");
        }
        int width = this.getWidth();
		int height = this.getHeight();
        aGraphics.setColor(Color.gray);
        
        return;
    }
    
    
}