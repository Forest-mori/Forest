package forest;

import javax.swing.JLabel;
import java.util.ArrayList;

public class Node extends Object
{
    /**
     * ノードの番号を束縛する
     */
    private int nodeNumber;
    
    /**
     * ノードの名前を束縛する
     */
    private String nodeName;
    
    /**
     * このノードの親を束縛する
     */
    private ArrayList<Node> Parents;
    
    /**
     * このノードの子を束縛する
     */
    private ArrayList<Node> Children;
    
    /**
     * このノードの深さを束縛する
     */
    private int depth;
    
    /**
     * 探索したかどうかを確認するための属性.未探索→false,探索済→true
     */
    private boolean visit;
    
    /**
     * ノードのコンストラクタ
     */
    public Node(int num,String name)
    {
        this.nodeNumber = num;
        this.nodeName = name;
        this.Parents = new ArrayList<Node>();
        this.Children = new ArrayList<Node>();
        this.visit = false;
        
    }
    
    /**
     * ノード番号のゲッター
     */
    public int getNumber()
    {
        return this.nodeNumber;
    }
    
    /**
     * ノード名のゲッター
     */
    public String getName()
    {
        return this.nodeName;
    }
    
    /**
     * ノードの深さのゲッター
     */
    public int getDepth()
    {
        return this.depth;
    }
    
    /**
     * ノードの親ノードのゲッター
     */
    public ArrayList<Node> getParents()
    {
        return this.Parents;
    }
    
    /**
     * ノードの子ノードのゲッター
     */
    public ArrayList<Node> getChildren()
    {
        return this.Children;
    }
    
    /**
     * ノードの親ノードを設定する
     */
    public void setParent(Node aNode)
    {
        this.Parents.add(aNode);
    }
    
    /**
     * ノードの子ノードを設定する
     */
    public void setChild(Node aNode)
    {
        this.Children.add(aNode);
    }
    
    /**
     * 探索済みと設定する
     */
    public void setVisit()
    {
        this.visit = true;
    }
    
    /**
     *  探索したかどうか確認する
     */
    public boolean getVisit()
    {
        return this.visit;
    }
    
}