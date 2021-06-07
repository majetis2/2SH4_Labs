
public class SLLSet {
    private int size;
    private SLLNode head;

    public SLLSet() {
        size = 0;
        head = null;   //setting head to null
    }

    public SLLSet(int[] sortedArray) {
    	size = sortedArray.length;
    	head = new SLLNode(sortedArray[size-1],null);  //setting head to the last item
    	for(int i=size-2; i>=0;i--)
    	{
    		head = new SLLNode(sortedArray[i],head); //iterating head through each element from the last to the first
    	}
        
    }

    public int getSize() {
		
        return size; //returns size
    }

    public SLLSet copy() {
    	SLLSet copy = new SLLSet();
    	if(head!=null) {
		  int arr_num[] = new int [size];  //adding to array all values
		  int pos = 0;
		  for(SLLNode here=head; here!=null; here=here.next) 
		  {
			  arr_num[pos] = here.value; 
			  pos++;
		  }
		  copy = new SLLSet(arr_num);  //creating the copied SLLSet with the array
    	}
        
        return copy;
    }

    public boolean isIn(int v) {
        for (SLLNode here=head; here!=null; here=here.next) {
        	if(here.value==v) {    //if condition check whether the value is in the SLLSet
        		return true; //returns true if the value is in the set
        	}
        }

        return false; //else returns false
    }

    public void add(int v) {
    	if(this.isIn(v)==false) {
    		size++; //increments the size
    		if(head == null || v < head.value) {
    			head =  new SLLNode (v,head);  //Creates new node if the list is empty
    		}
    		else{
    			SLLNode check = head;
        		while(check.next!=null) {
        			check = check.next;
        		}
        		if(v>check.value) {  //adding item to the last node of SLLSet
        			SLLNode tail = new SLLNode(v,null);
        			SLLNode temp = head;
        			while(temp.next!=null){
        				temp = temp.next;
        			}
        			temp.next = tail;
        		 }
        		
        		else{  //adds the item in middle
        			SLLNode here = head;
        			SLLNode insert_head = here;
        			while(here!= null) {
        				if(v<here.next.value){
        					insert_head = here;
        					break;
        				  }
        				here = here.next;
        			 }
        			SLLNode insert_node = new SLLNode(v,insert_head.next);
        			insert_head.next = insert_node;
        				
        		}
    		}
    		
    	}
    }

    public void remove(int v) {
    if(this.isIn(v)== true && head!=null){
    	size --; //decrements the size
    	SLLNode check = head;
		while(check.next.next!=null) {
			check = check.next;
		}
    	if(v==head.value) {  //removes the first element
    		head = head.next;
    	}
    	
    	else if(v==check.next.value) { //removes the last element
    		check.next = null;
    	}
    	
    	else {     //removes the element in the middle or in between first and last nodes
    		for(SLLNode here=head; here!=null;here=here.next) {
    			if(v==here.next.value) {
    				here.next = here.next.next;
    				break;
    			}
    		}
    	}
      }
        
    }

    public SLLSet union(SLLSet s) {
    	if(s.head == null)   //checks if any set is null and returns the other set
            return this;
       
        if(this.head == null)
            return s;

        SLLSet union_set = new SLLSet();  //creating new set
        SLLNode set1_head = head;
        SLLNode set2_head = s.head;       
        
        //Creating the head value

        if(set1_head.value < set2_head.value)
        {
            union_set.head = new SLLNode(set1_head.value, null);
            union_set.size = 1;
            set1_head = set1_head.next;
        }
        else if(set1_head.value > set2_head.value)
        {
            union_set.head = new SLLNode(set2_head.value, null);
            union_set.size = 1;
            set2_head = set2_head.next;          
        }
        else if(set1_head.value == set2_head.value)
        {
            union_set.head = new SLLNode(set1_head.value, null);
            union_set.size = 1;
            set1_head = set1_head.next;
            set2_head = set2_head.next;          
        }

        //Adding elements after head
        SLLNode union_head = union_set.head;
        while(set1_head != null && set2_head != null)
        {
            if(set1_head.value < set2_head.value)
            {
            	union_head.next = new SLLNode(set1_head.value, null);
                union_set.size++;
                union_head = union_head.next;
                set1_head = set1_head.next;              
            }
            else if(set1_head.value > set2_head.value)
            {
                union_head.next = new SLLNode(set2_head.value, null);
                union_set.size++;
                union_head = union_head.next;              
                set2_head = set2_head.next;
            }
            else if(set1_head.value == set2_head.value)
            {
                union_head.next = new SLLNode(set1_head.value, null);
                union_set.size++;
                union_head = union_head.next;
                set1_head = set1_head.next;
                set2_head = set2_head.next;
            }
        }

        //Adding all the other elements
        if(set2_head == null)
        {
            while(set1_head != null)
            {
                union_head.next = new SLLNode(set1_head.value, null);
                union_set.size++;
                union_head = union_head.next;
                set1_head = set1_head.next;
            }
        }
        
        else
        {
            while(set2_head != null)
            {
                union_head.next = new SLLNode(set2_head.value, null);
                union_set.size++;
                union_head = union_head.next;
                set2_head = set2_head.next;
            }
        }
        return union_set;
    }

    public SLLSet intersection(SLLSet s) {
    	SLLSet intersect_set = new SLLSet();  //Creating new set
        
        //Returning empty set if any set is empty
    	if(s.head == null || head == null)
            return intersect_set;              
       
        SLLNode set1_head = head;
        SLLNode set2_head = s.head;      
       
        //Creating the first node or head for intersection set 
        while(set1_head != null && set2_head != null)
        {
            if(set1_head.value < set2_head.value)
            {
                set1_head = set1_head.next;
            }
            else if(set1_head.value > set2_head.value)
            {
                set2_head = set2_head.next;
            }
            //Makes a set with first element that is common in both sets
            else if(set1_head.value == set2_head.value) 
            {
                intersect_set.head = new SLLNode(set1_head.value, null);
                set1_head = set1_head.next;
                set2_head = set2_head.next;
                intersect_set.size = 1;
                break;
            }
        }
        
        
        //Adds other elements to the set that are common
        SLLNode intersect_head = intersect_set.head;
        while(set1_head != null & set2_head != null)
        {
            if(set1_head.value < set2_head.value)
            {
                set1_head = set1_head.next;
            }
            else if(set2_head.value < set1_head.value)
            {
                set2_head = set2_head.next;
            }
            else if(set1_head.value == set2_head.value)
            {
                intersect_head.next = new SLLNode(set2_head.value, null);
                intersect_set.size++;
                intersect_head = intersect_head.next;
                set1_head = set1_head.next;
                set2_head = set2_head.next;              
            }
        }
       
        return intersect_set;
    }

    public SLLSet difference(SLLSet s) {
    	SLLSet same_set = this.intersection(s);
        SLLSet differ_set = new SLLSet();
        
        for(SLLNode here=head; here!=null; here=here.next) 
        {
        	if(same_set.isIn(here.value) != true) 
        	{
        		differ_set.add(here.value);  //Adds the elements that are not in the set to differ_set
            }
        }
        	
        return differ_set;
    }

    public static SLLSet union(SLLSet[] sArray) {
        SLLSet ss = new SLLSet();  //creates new SLLSet with empty constructor
        for(int pos=0;pos<sArray.length;pos++) 
        {
        	ss = ss.union(sArray[pos]);  //Union of all the SLLSets in SLLSet array
        }
        return ss;
    }

    @Override
    public String toString() {
        String str = "";  //string method
        int count =0;
    	for(SLLNode here=head; here!=null; here = here.next){
    		str += String.valueOf(here.value);
    		if(count<(size-1)) 
    		{
    			str += ", ";
    		}
    		count++;
    	}
  
        return str;
    }
}
