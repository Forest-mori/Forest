package forest;

import java.util.ArrayList;
import java.awt.Point;
import java.util.Collections;

/**
 * Nodeクラス テスト良好（2014年8月8日）
 */
public class Node extends Object
{
	/**
	 * ノードの番号を束縛する テスト良好（2014年8月8日）
	 */
	private int nodeNumber;

	/**
	 * ノードの名前を束縛する テスト良好（2014年8月8日）
	 */
	private String nodeName;

	/**
	 * このノードの親を束縛する テスト良好（2014年8月8日）
	 */
	private ArrayList<Node> Parents;

	/**
	 * このノードの子を束縛する テスト良好（2014年8月8日）
	 */
	private ArrayList<Node> Children;

	/**
	 * このノードの深さを束縛する テスト良好（2014年8月8日）
	 */
	private int depth;

	/**
	 * 探索したかどうかを確認するための属性.未探索→false,探索済→true テスト良好（2014年8月8日）
	 */
	private boolean visit;

	/**
	 * ノードの一座標を束縛する テスト良好（2014年8月8日）
	 */
	private Point aPoint;

	/**
	 * ノードのコンストラクタ テスト良好（2014年8月8日）
	 * @param num
	 * @param name
	 * @param depth
	 */
	public Node(int num, String name, int depth)
	{
		this.nodeNumber = num;
		this.nodeName = name;
		this.depth = depth;
		this.Parents = new ArrayList<Node>();
		this.Children = new ArrayList<Node>();
		this.visit = false;
		this.aPoint = null;
	}

	/**
	 * ノード番号のゲッター テスト良好（2014年8月8日）
	 * @return nodeNumber
	 */
	public int getNumber()
	{
		return this.nodeNumber;
	}

	/**
	 * ノード名のゲッター テスト良好（2014年8月8日）
	 * @return nodeName
	 */
	public String getName()
	{
		return this.nodeName;
	}

	/**
	 * ノードの深さのゲッター テスト良好（2014年8月8日）
	 * @return depth
	 */
	public int getDepth()
	{
		return this.depth;
	}

	/**
	 * ノードの親ノードのゲッター テスト良好（2014年8月8日）
	 * @return parents
	 */
	public ArrayList<Node> getParents()
	{
		return this.Parents;
	}

	/**
	 * ノードの子ノードのゲッター テスト良好（2014年8月8日）
	 * @return Children
	 */
	public ArrayList<Node> getChildren()
	{
		return this.Children;
	}

	/**
	 * ノードの親ノードを設定する テスト良好（2014年8月8日）
	 * @param aNode
	 */
	public void setParent(Node aNode)
	{
		this.Parents.add(aNode);
	}

	/**
	 * ノードの子ノードを設定する テスト良好（2014年8月8日）
	 * @param aNode
	 */
	public void setChild(Node aNode)
	{
		this.Children.add(aNode);
		Collections.sort(this.Children, new Comparator());
	}

	/**
	 * 探索済みと設定する テスト良好（2014年8月8日）
	 */
	public void setVisit()
	{
		this.visit = true;
	}

	/**
	 * 探索したかどうか確認する テスト良好（2014年8月8日）
	 * @return visit
	 */
	public boolean getVisit()
	{
		return this.visit;
	}

	/**
	 * このノードの座標を返す テスト良好（2014年8月8日）
	 * @return aPoint
	 */
	public Point getNodeLocation()
	{
		return this.aPoint;
	}

	/**
	 * ノードの座標の初期設定をする テスト良好（2014年8月8日）
	 * @param x
	 * @param y
	 */
	public void initLocation(int x, int y)
	{
		this.aPoint = new Point(x, y);
	}

	/**
	 * このノードの座標を変更する テスト良好（2014年8月8日）
	 * @param x
	 * @param y
	 */
	public void setNodeLocation(int x, int y)
	{
		this.aPoint.setLocation(x, y);
	}

}

/**
 * ノードを辞書順にするコンパレータクラス テスト良好（2014年8月8日）
 */
class Comparator implements java.util.Comparator<Object>
{
	/**
	 * ソートするコンパレーター テスト良好（2014年8月8日）
	 * @param node1
	 * @param node2
	 * @return ((Node) node1).getName().compareTo(((Node) node2).getName())
	 */
	public int compare(Object node1, Object node2)
	{
		return ((Node) node1).getName().compareTo(((Node) node2).getName());
	}
}
