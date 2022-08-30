//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            List<List<String>> adj = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                List<String> l = new ArrayList<>();

                String name = sc.next();
                l.add(name);

                int tmp = sc.nextInt();

                sc.nextLine();
                for (int j = 0; j < tmp; j++) {
                    String h = sc.next();

                    l.add(h);
                }

                adj.add(l);
            }

            Solution obj = new Solution();
            List<List<String>> ans = obj.mergeDetails(adj);
            Collections.sort(ans,
                             (x, y)->{ return x.get(0).compareTo(y.get(0)); });

            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {


   public List<List<String>> mergeDetails(List<List<String>> details) {

     
       
 HashMap<ArrayList<String>,String> hmap =new HashMap<ArrayList<String>,String>();
 for(List<String> studentData : details)
 {
  String studentName =studentData.get(0);
  studentData.remove(0);
  
  ArrayList<String> listTobeUpdated =null;
  ArrayList<String> uniqueEmails = null;
  for(String emailData : studentData) {
      //If map contains email id get the key and replace the key appending new email ids
   if(checkIfMapContainsEmailId(hmap, emailData)) {
    listTobeUpdated=getMapKeyContainingEmailId(hmap, emailData);
    
   }
   else {
    uniqueEmails=new ArrayList<String>(studentData);
   }
  
  }
  if(listTobeUpdated!=null) {
  String existingStudentName=hmap.get(listTobeUpdated);
  hmap.remove(listTobeUpdated);
  listTobeUpdated.addAll(studentData);

  ArrayList<String> listWithoutDuplicates = new ArrayList<String>(listTobeUpdated.stream().distinct().collect(java.util.stream.Collectors.toList()));
  Collections.sort(listWithoutDuplicates);
  hmap.put(listWithoutDuplicates, existingStudentName);
  }
  else {
   Collections.sort(uniqueEmails);
   hmap.put(uniqueEmails,studentName);
  }
 }

  
 List<List<String>> list = new ArrayList<List<String>>();
 for(ArrayList<String> emails : hmap.keySet()) {
  String studentName=hmap.get(emails);
  emails.add(0,studentName);
  list.add(emails);
 }
 
  Collections.sort(list, new Comparator<List<String>>() {  
            @Override  
            public int compare(List<String> o1, List<String> o2) {  
                int comp = o1.get(0).compareTo(o2.get(0)); 
                if (comp !=0)  
                 return comp;
                else
                 return o1.get(1).compareTo(o2.get(1)); 
            }  
        }); 
        
 return list;

   }
   
   public  boolean checkIfMapContainsEmailId(HashMap<ArrayList<String>,String> map, String mailId)
{
for(ArrayList<String> emailList: map.keySet())
{
 if(emailList.contains(mailId))
  return true;
}
 
return false;
}

public  ArrayList<String> getMapKeyContainingEmailId(HashMap<ArrayList<String>,String> map, String mailId)
{
for(ArrayList<String> emailList: map.keySet())
{
 if(emailList.contains(mailId))
  return emailList;
}
 
return null;
}
}
