package forest;

import java.awt.Point;

/**
 * Exampleクラス テスト良好（2014年8月8日）
 */
public class Example extends Object
{
	/**
	 * モデルを生成し、すべて準備ができた状態で、ノードの初期位置を設定し探索開始する テスト良好（2014年8月8日）
	 * 
	 * @param args
	 *            コマンドライン変数
	 */
	public static void main(String args[])
	{
		ForestModel aModel = new ForestModel();
		int y = 1;
		for (Node aNode : aModel.getForest().getNode().values())
		{
			aNode.initLocation(0, y);
			y += 16;
		}

		for (Node aNode : aModel.getForest().getRoot())
		{
			aModel.getForest().visit(aNode,
			        new Point(0, aModel.getForest().getUnderY()));
		}

		return;
	}
}