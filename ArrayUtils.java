public class ArrayUtils{
	
    
//1.计算数组中最大值
    public static int arrayMaxElement(int[] data){
    	
	java.util.Arrays.sort(data);//排序
    
	int max = data[data.length-1];
    //把排好序的数组最大下标的那个数给 max
    
	return max;
    
	 }
//2.计算数组中最小值
    public static int arrayMinElement(int[] data){
    
	java.util.Arrays.sort(data);//排序
    
	int min = data[0];
    //把排好序的数组的第一个数给 min
    
	return min;
    
	}
//3.计算数组值之和
    public static int arrayElementSum(int[] data){
    
	int sum = 0;
    
	for(int i = 0;i < data.length;i++){
    
	sum = data[i] + sum;
    
	}
    
	return sum;
  
  }
//4.数组拼接
    public static void arrayJoin(int[] a, int[] b){
		
    a=new int[]{1,2,3,0,0,0};
    
	b=new int[]{4,5,6};
	
	System.arraycopy(b,0,a,3,3);
    
	printArray(a);
  
  }
//5.数组截取
//[start,end)
    public static int[] arraySub(int[] data,int start,int end){
		
		if(data==null){
			
			throw new IllegalArgumentException("data must be not null.");
	
		}
		
		if(start<0||end<0){
			
	
		    throw new IllegalArgumentException("start or end must be >0.");
		
		}

	    if(start>= data.length){

	        throw new IllegalArgumentException("start must be <data.length.");
        
		}

	    if(start>end){

	    throw new IllegalArgumentException("start must be <end.");

	    }

	    int count = end-start;

	    if(count>data.length){

	    throw new IllegalArgumentException("count must be <= data.length.");

	    }

	    int [] b = new int[count];

	    for(int i = start;i<end;i++){

	    b[i-start]= data[i];

	    }
		return b;
		
		

}
//6.数组打印 4,3,2
    public static void printArray(int[] data){
		
		if(data==null){
				
				return;
				
			}else{
				for(int i=0; i < data.length; i++){
					
					System.out.println( data[i] );
					
					}
					System.out.println();
			}
	}

//7.数组反转
//比如：[1,2,3,4]=>[4,3,2,1]
    public static void printReversal(int[] data){
		
    for(int i=0; i < data.length/2;i++){
    
	int temp=data[i];
    
	data[i]=data[data.length - 1 - i];
	
	data[data.length - 1 - i] = temp;
    
	}
    
	for(int i=0;i< data.length-1;i++){
		
		System.out.println( data[i] );
		
	}
  System.out.println();
  }
  
    public static void main(String[] args){
		int[] array={3,9,5,2,10,7,8};
		
		int[] array2={99,88};
		
		arrayMaxElement(array);
	
        arrayMinElement(array);

	    arrayElementSum(array);

	    printArray(array);

	    arrayJoin(array,array2);
		
	    printReversal(array);

  }
  
}