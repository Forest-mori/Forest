package forest;

import java.awt.Point;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.TreeMap;

/**
 * Forestクラス テスト良好（2014年8月8日）
 */
public class Forest extends Object
{

	/**
	 * ノードを番号と一緒に束縛する テスト良好（2014年8月8日）
	 */
	private TreeMap<Integer, Node> nodes;

	/**
	 * 一時的にノードの深さを保存する テスト良好（2014年8月8日）
	 */
	private HashMap<String, Integer> depths;

	/**
	 * ブランチを束縛する テスト良好（2014年8月8日）
	 */
	private ArrayList<Branch> branches;

	/**
	 * ルートノードを束縛する テスト良好（2014年8月8日）
	 */
	private ArrayList<Node> roots;

	/**
	 * テキストのタイプを表す。tree = 0,node = 1, branch = 2 テスト良好（2014年8月8日）
	 */
	private int textType;

	/**
	 * 画面更新用にForestModelを束縛する テスト良好（2014年8月8日）
	 */
	private ForestModel aModel;

	/**
	 * 一番のy座標を持つ変数 テスト良好（2014年8月8日）
	 */
	public static int underY;

	/**
	 * フォレストのコンストラクタ テスト良好（2014年8月8日）
	 * @param aModel
	 */
	public Forest(ForestModel aModel)
	{
		this.nodes = new TreeMap<Integer, Node>();
		this.branches = new ArrayList<Branch>();
		this.roots = new ArrayList<Node>();
		this.depths = new HashMap<String, Integer>();
		this.textType = 5;
		this.aModel = aModel;

	}

	/**
	 * ForestModelで取ってきたテキストファイルを読み込む 
	 * テスト良好（2014年8月8日）
	 * @param aFile
	 */
	public void read(File aFile)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(aFile));
			String str = br.readLine();

			while (str != null)
			{

				if (str.equals("trees:"))
				{
					this.textType = 0;
				}
				else if (str.equals("nodes:"))
				{
					this.textType = 1;
				}
				else if (str.equals("branches:"))
				{
					this.textType = 2;
				}
				else if (this.textType == 0)
				{
					int depthcount = 0;
					String nodeName = null;

					String depth[] = str.split("-- ");
					for (int k = 0; k < depth.length; k++)
					{
						if (depth[k].equals("|"))
						{

							depthcount = depthcount + 1;
						}
						else
						{
							nodeName = depth[k];

						}
					}

					this.depths.put(nodeName, depthcount);

				}

				else if (this.textType == 1 || this.textType == 2)
				{
					this.create(str);
				}

				str = br.readLine();

			}

			br.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}

	/**
	 * readで読み込んだデータを元に木を作る テスト良好（2014年8月8日）
	 * @param data
	 */
	public void create(String data)
	{
		if (this.textType == 1)
		{

			String[] node = data.split(", ");
			Node aNode = new Node(Integer.parseInt(node[0]), node[1],
			        this.depths.get(node[1]));
			this.nodes.put(Integer.parseInt(node[0]), aNode);
			if (this.depths.get(node[1]) == 0)
			{
				this.roots.add(aNode);
			}
		}
		else if (this.textType == 2)
		{
			String[] branch = data.split(", ");
			Node parentNode = this.nodes.get(Integer.parseInt(branch[0]));
			Node childNode = this.nodes.get(Integer.parseInt(branch[1]));
			parentNode.setChild(childNode);
			childNode.setParent(parentNode);
			this.nodes.put(Integer.parseInt(branch[0]), parentNode);
			this.nodes.put(Integer.parseInt(branch[1]), childNode);
			Branch aBranch = new Branch(parentNode, childNode);
			this.branches.add(aBranch);
		}
		return;
	}

	/**
	 * 探索処理をして、モデルに通知して画面を更新する テスト良好（2014年8月8日）
	 * @param aNode
	 * @param aPoint
	 */
	public void visit(Node aNode, Point aPoint)
	{
		boolean flag = aModel.getFlag();
		while (flag)
		{
			flag = aModel.getFlag();
			if (aModel.getFlag() == true)
			{
				flag = true;
			}

			System.out.println("false");

		}

		if (aNode.getVisit() == false)
		{
			aNode.setNodeLocation(aPoint.x, aPoint.y);
		}

		try
		{
			Thread.sleep(100);
		}
		catch (InterruptedException anException)
		{
			throw new RuntimeException(anException.toString());
		}

		this.aModel.changed();

		int nodey = aPoint.y;
		for (Node child : aNode.getChildren())
		{
			while (nodey <= underY)
			{
				// 16はラベルの縦の長さ
				nodey += 16;
			}
			this.visit(child, new Point(aNode.getName().length() * 10
			        + aPoint.x, nodey));
			child.setVisit();

		}
		if (nodey > underY)
			underY = nodey;
		if (aNode.getVisit() == false)
			aNode.setNodeLocation(aPoint.x, (nodey + aPoint.y + 16) / 2);
		if (aNode.getParents().size() == 0 && aNode.getChildren().size() == 1)
		{
			Node child = aNode.getChildren().get(0);
			aNode.setNodeLocation(aPoint.x, child.getNodeLocation().y);
		}

	}

	/**
	 * ノードのゲッター テスト良好（2014年8月8日）
	 * @return nodes
	 */
	public TreeMap<Integer, Node> getNode()
	{
		return this.nodes;
	}

	/**
	 * ルートノードのゲッター テスト良好（2014年8月8日）
	 * @return roots
	 */
	public ArrayList<Node> getRoot()
	{
		return this.roots;
	}

	/**
	 * ブランチのゲッター テスト良好（2014年8月8日）
	 * @return branches
	 */
	public ArrayList<Branch> getBranch()
	{
		return this.branches;
	}

	/**
	 * underYのゲッター
	 * @return y
	 */
	public int getUnderY()
	{
		int y = underY;
		return y;
	}

}
