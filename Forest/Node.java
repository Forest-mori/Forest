package forest;


public class Node extends JLabel
{
    /*
     * ノードの番号を束縛する
     */
    private int nodeNumber;
    
    /*
     * ノードの名前を束縛する
     */
    private String nodeName;
    
    /*
     * このノードの親を束縛する
     */
    private ArrayList<Node> Parents;
    
    /*
     * このノードの子を束縛する
     */
    private ArrayList<Node> Children;
    
    /*
     * このノードの深さを束縛する
     */
    private int depth;
    
    /*
     * ノードのコンストラクタ
     */
    public Node(int num,String name)
    {
        
    }
    
    /*
     * ノード番号のゲッター
     */
    public int getNumber()
    {
        
    }
    
    /*
     * ノード名のゲッター
     */
    public String getName()
    {
        
    }
    
    /*
     * ノードの深さのゲッター
     */
    public int getDepth()
    {
        
    }
    
    /*
     * ノードの親ノードのゲッター
     */
    public ArrayList<Node> getParents()
    {
        
    }
    
    /*
     * ノードの子ノードのゲッター
     */
    public ArrayList<Node> getChildren()
    {
        
    }
    
    /*
     * ノードの親ノードを設定する
     */
    public void setParent(Node aNode)
    {
        
    }
    
    /*
     * ノードの子ノードを設定する
     */
    public void setChild(Node aNode)
    {
        
    }
}