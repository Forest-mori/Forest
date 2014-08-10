package forest;

/**
 * ブランチクラス テスト良好（2014年8月9日）
 */
public class Branch extends Object
{

	/**
	 * 枝の左側（親ノード）のインスタンスを束縛する テスト良好（2014年8月9日）
	 */
	private Node parentNode;

	/**
	 * 枝の右側（子ノード）のインスタンスを束縛する テスト良好（2014年8月9日）
	 */
	private Node childNode;

	/**
	 * ブランチのコンストラクタ テスト良好（2014年8月9日）
	 * 
	 * @param parentNode
	 *            ノードの親ノード
	 * @param childNode
	 *            ノードの子ノード
	 */
	public Branch(Node parentNode, Node childNode)
	{
		this.setParent(parentNode);
		this.setChild(childNode);
	}

	/**
	 * 親ノードのセッター テスト良好（2014年8月9日）
	 * 
	 * @param aNode
	 *            　Nodeクラスのインスタンスを束縛する変数
	 */
	public void setParent(Node aNode)
	{
		this.parentNode = aNode;
	}

	/**
	 * 子ノードのセッター テスト良好（2014年8月9日）
	 * 
	 * @param aNode
	 *            Nodeクラスのインスタンスを束縛する変数
	 */
	public void setChild(Node aNode)
	{
		this.childNode = aNode;
	}

	/**
	 * 親ノードのゲッター テスト良好（2014年8月9日）
	 * 
	 * @return parentNode ノードの親ノード
	 */
	public Node getParent()
	{
		return parentNode;
	}

	/**
	 * 子ノードのゲッター テスト良好（2014年8月9日）
	 * 
	 * @return childNode　ノードの子ノード
	 */
	public Node getChild()
	{
		return childNode;
	}
}