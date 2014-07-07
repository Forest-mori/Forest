package forest;

import java.awt.Graphics;

public class ForestView extends mvc.View
{
    
    /*
     * 指定されたモデルとコントローラでMVCを構築するコンストラクタ。
     */
    public ForestView(ForestModel aModel,ForestController aController)
    {
        super(aModel,aController);
    }
    
    
	/**
	 * 描画を行う。
	 */
	public void paintComponent(Graphics aGraphics) {
        
    }
    
    
}