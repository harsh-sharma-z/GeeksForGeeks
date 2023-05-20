if (n % size != 0) return false;
        // push elewith freq in TM
         TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int x: hand) {
            m.put(x, m.getOrDefault(x, 0) + 1);
        }
        
        //itr in TM and forms grp
         while (!m.isEmpty()) 
         {
            int a = m.firstKey();
            
            m.put(a , m.get(a) - 1);
            if (m.get(a) == 0) m.remove(a);
            
            for (int j = 1; j < size; j++) 
            {
                int b = a + j; // since i want consecutive
                if (m.containsKey(b)) 
                {
                    m.put(b, m.get(b) - 1);
                    if (m.get(b) == 0) m.remove(b);
                } 
                else 
                    return false;
            }
           
        }
        return true;
