/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=right=null;
	}
}
*/
class GfG
{
    boolean bool=true;
	boolean isCompleteBT(Node root)
    {
          //add code here.
          ArrayList<Integer> list=new ArrayList<>();
          req(root,0,1,list);
          int n=1;
          for(int i=0; i<list.size()-1; i++){
              if(list.get(i)!=n ){ return false; }
              n*=2;
          }
          return bool;
	} 
	void req(Node root,int k,int i,ArrayList<Integer> list){     
	   if(root==null || !bool){ return; }
	   if(k==list.size()){ list.add(0); }
	   if((i-1)!=list.get(k)){ bool=false; return; }
	   list.set(k,list.get(k)+1);
	   req(root.left,k+1,(i*2)-1,list);
	   req(root.right,k+1,(i*2),list);
	   
	}
}
