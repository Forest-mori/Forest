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
     * 一時的にノードの深さを保存する
     */
    private HashMap<Integer,Integer> depths;
    
    /*
     * ブランチを束縛する
     */
    private ArrayList<Branch> branches;
    
    /*
     * ルートノードを束縛する
     */
    private ArrayList<Node> roots;
    
    /*
     * テキストのタイプを表す。tree = 0,node = 1, branch = 2
     */
    private int textType;
    
    /*
     * フォレストのコンストラクタ
     */
    public Forest()
    {
        this.nodes = new HashMap<Integer,Node>();
        this.branches = new ArrayList<Branch>();
        this.roots = new ArrayList<Node>();
        this.depths = new HashMap<Integer,Integer>();
        this.textType = 5;
        
    }
    
    /*
     * ForestModelで取ってきたテキストファイルを読み込む
     */
    public void read(File aFile)
    {
        try{
            BufferedReader br = new BufferedReader(new FileReader(aFile));
            String str = br.readLine();
            int nodenum = 1;
            while(str != null){
                System.out.println(str);
                
                if(str.equals("trees:"))
                {
                    this.textType = 0;
                }
                else if(str.equals("nodes:"))
                {
                    this.textType = 1;
                }
                else if(str.equals("branches:"))
                {
                    this.textType = 2;
                }
                else if(this.textType == 0)
                {
                    int count = 0;
                    for(int j = 0; j < str.length();j++)
                    {
                        String depth = str.substring(j,j+1);
                        if(depth.equals("-"))
                            count++;
                    }
                    this.depths.put(nodenum,count/2);
                    count++;
                }
                
                
                else if(this.textType == 1 || this.textType = 2)
                {
                    this.create(str);
                }
                
                
                str = br.readLine();
                
                
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
    public void create(String data)
    {
        
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