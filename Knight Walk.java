class Solution
{

   class Node
   {
       int r;int c;int d;
       public Node( int r,int c,int d)
       {
           this.r=r;this.c=c;this.d=d;
       }
   }

   public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
   {
       KnightPos[0]--;
       KnightPos[1]--;
       TargetPos[0]--;
       TargetPos[1]--;
       int board[][]=new int[N][N];
       for(int i=0;i<N;i++)
       {
           for(int j=0;j<N;j++)
           {
               board[i][j]=Integer.MAX_VALUE;
           }
       }
       board[KnightPos[0]][KnightPos[1]]=0;
       PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->a.d-b.d);
       pq.add(new Node(KnightPos[0],KnightPos[1],0));
       while(!pq.isEmpty())
       {
           Node curr=pq.remove();
           visitAllCell(new int[]{curr.r,curr.c},curr.d+1,N,pq,board);
       }
     
      
       return board[TargetPos[0]][TargetPos[1]]==Integer.MAX_VALUE?-1:board[TargetPos[0]][TargetPos[1]];
   }
   private void visitAllCell(int KnightPos[],int steps,int N
   ,PriorityQueue pq,int board[][])
   {
     
       if(KnightPos[0]+2 <N )
       {
           if(KnightPos[1]+1 <N )
           {
               if(board[KnightPos[0]+2][KnightPos[1]+1] >steps )
               {
                   board[KnightPos[0]+2][KnightPos[1]+1] =steps;
                   pq.add(new Node(KnightPos[0]+2,KnightPos[1]+1,steps));
               }
             
           }
           if(KnightPos[1]-1 >=0 )
           {
               if(board[KnightPos[0]+2][KnightPos[1]-1] >steps )
               {
                   board[KnightPos[0]+2][KnightPos[1]-1] =steps;
                   pq.add(new Node(KnightPos[0]+2,KnightPos[1]-1,steps));
               }
             
           }
       }
       if(KnightPos[0]-2 >=0 )
       {
           if(KnightPos[1]+1 <N )
           {
               if(board[KnightPos[0]-2][KnightPos[1]+1] >steps )
               {
                   board[KnightPos[0]-2][KnightPos[1]+1] =steps;
                   pq.add(new Node(KnightPos[0]-2,KnightPos[1]+1,steps));
               }
             
           }
           if(KnightPos[1]-1 >=0 )
           {
               if(board[KnightPos[0]-2][KnightPos[1]-1] >steps )
               {
                   board[KnightPos[0]-2][KnightPos[1]-1] =steps;
                   pq.add(new Node(KnightPos[0]-2,KnightPos[1]-1,steps));
               }
             
           }
       }
       
       if(KnightPos[1]+2 <N )
       {
           if(KnightPos[0]+1 <N )
           {
               if(board[KnightPos[0]+1][KnightPos[1]+2] >steps )
               {
                   board[KnightPos[0]+1][KnightPos[1]+2] =steps;
                   pq.add(new Node(KnightPos[0]+1,KnightPos[1]+2,steps));
               }
             
           }
           if(KnightPos[0]-1 >=0 )
           {
               if(board[KnightPos[0]-1][KnightPos[1]+2] >steps )
               {
                   board[KnightPos[0]-1][KnightPos[1]+2] =steps;
                   pq.add(new Node(KnightPos[0]-1,KnightPos[1]+2,steps));
               }
             
           }
       }
       if(KnightPos[1]-2 >=0 )
       {
           if(KnightPos[0]+1 <N )
           {
               if(board[KnightPos[0]+1][KnightPos[1]-2] >steps )
               {
                   board[KnightPos[0]+1][KnightPos[1]-2] =steps;
                   pq.add(new Node(KnightPos[0]+1,KnightPos[1]-2,steps));
               }
             
           }
           if(KnightPos[0]-1 >=0 )
           {
               if(board[KnightPos[0]-1][KnightPos[1]-2] >steps )
               {
                   board[KnightPos[0]-1][KnightPos[1]-2] =steps;
                   pq.add(new Node(KnightPos[0]-1,KnightPos[1]-2,steps));
               }
             
           }
       }
   }
}
