import java.util.*;
 public class Gift {
	 public int getValue(int[] gifts, int n) {
		 if(gifts.length<n) 
			 return 0;
		 if(gifts.length==0)
			 return 0;
		 int count=0,temp=0;
		 for(int i=0;i<n;i++) {
			 if(count==0) {
				 temp=gifts[i];
				 count=1;
			}else{
				if(temp==gifts[i])
					count++;
				elsecount--;
			} 
		}
		int size=0;
		for(int i=0;i<n;i++){
			if(temp==gifts[i])
				size++;
			}
			return (size>n/2)?temp:0;
	} 
}