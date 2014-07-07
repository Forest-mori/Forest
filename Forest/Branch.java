package forest;

public class Branch extends Object
{
    
    /*
     * 枝の左側（親ノード）のインスタンスを束縛する
     */
    private Node parentNode;
    
    /*
     * 枝の右側（子ノード）のインスタンスを束縛する
     */
    private Node childNode;
    
    /*
     * ブランチのコンストラクタ
     */
    public Branch(Node parentNode, Node childNode)
    {
        this.setParent(parentNode);
        this.setChild(childNode);
    }
    
    /*
     * 親ノードのセッター
     */
    public void setParent(Node aNode)
    {
        this.parentNode = aNode;
    }
    
    /*
     * 子ノードのセッター
     */
    public void setChild(Node aNode)
    {
        this.childNode = aNode;
    }
    
    /*
     * 親ノードのゲッター
     */
    public Node getParent()
    {
        return parentNode;
    }
    
    /*
     * 子ノードのゲッター
     */
    public Node getChild()
    {
        return childNode;
    }
}