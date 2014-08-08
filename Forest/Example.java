package forest;

import java.io.File;
import java.awt.Point;

public class Example extends Object
{
	public static void main(String args[])
	{
		ForestModel aModel = new ForestModel();
        int y = 1;
        for (Node aNode : aModel.getForest().getNode().values())
        {
            aNode.initLocation(0,y);
            y += 16;
        }
        
        for(Node aNode : aModel.getForest().getRoot()){
            aModel.getForest().visit(aNode,new Point(0,aModel.getForest().underY));
        }

		return;
	}
}