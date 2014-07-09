package forest;


import java.io.IOException;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Forest extends Object
{
    /*
     * ノードを束縛する
     */
    private HashMap<Integer,Node> nodes;
    
    /*
     * ブランチを束縛する
     */
    private ArrayList<Branch> branches;
    
    /*
     * ルートノードを束縛する
     */
    private ArrayList<Node> roots;
    
    /*
     * フォレストのコンストラクタ
     */
    public Forest()
    {
        this.nodes = new HashMap<Integer,Node>();
        this.branches = new ArrayList<Branch>();
        this.roots = new ArrayList<Node>();
        
    }
    
    /*
     * ForestModelで取ってきたテキストファイルを読み込む
     */
    public void read(File aFile)
    {
        try{
            BufferedReader br = new BufferedReader(new FileReader(aFile));
            String str = br.readLine();
            int a = 0;
            String aaa;
            int count = 0;
            while(str != null){
                //System.out.println(str);
                if(str.equals("trees:"))
                {
                    a = 1;
                }
                if(a == 1)
                {
                    for(int j = 0; j < str.length();j++)
                    {
                       aaa = str.substring(j,j+1);
                        if(aaa.equals("-"))
                            count++;
                    }
                    System.out.println(count);
                }
            
                str = br.readLine();
                count = 0;
            }
            
            br.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    /*
     * readで読み込んだデータを元に木を作る
     */
    public void create(String data){
        
    }
    
    /*
     * 探索処理をして、モデルに通知して画面を更新する
     */
    public void visit()
    {
        
    }
    
    /*
     * ノードのゲッター
     */
    public HashMap<Integer,Node> getNode()
    {
        return this.nodes;
    }
    
    /*
     * ルートノードのゲッター
     */
    public ArrayList<Node> getRoot()
    {
        return this.roots;
    }
    
    /*
     * ブランチのゲッター
     */
    public ArrayList<Branch> getBranch(){
        return this.branches;
    }
    
    
    
    
}