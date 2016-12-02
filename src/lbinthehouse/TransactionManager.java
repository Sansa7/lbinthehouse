package lbinthehouse;
import java.util.Scanner;
import java.util.Arrays;
public class TransactionManager {
	
		int [] Sites_Status;
		int time=0;
	  TransactionManager(){
		  Sites_Status=new int[20];
		  for (int i=0;i<20;i++){
			  Sites_Status[i]=1;//initially, all sites are up; when the value becomes 0, that site is down
		  }  
	  };
	  
	  
	  public static boolean isNumber(String string) {
		    try {
		        Long.parseLong(string);
		    } catch (Exception e) {
		        return false;
		    }
		    return true;
		}
	    void Schedule(){
	        Scanner scanner = new Scanner(System.in);
	        while (scanner.hasNext()){
	        	
	        	
	            String myString = scanner.nextLine().trim();
	            String[] operations=myString.split(";");
	            
	            
	            System.out.println("time is: "+time);
	 	       
	            for (int i=0;i<operations.length;i++){
	            	operations[i]=operations[i].trim();
	            
	     	       
	            
	            
	            if ((operations[i].length()>=9) && (operations[i].substring(0,7).equals("begin(T"))&& (operations[i].indexOf(')')!=-1)){
	            	
	            	
	            	String number=operations[i].substring(operations[i].indexOf('T')+1, operations[i].indexOf(')'));
	            	if (isNumber(number)==true){
	            		int trueNumber=Integer.valueOf(number);
	            	System.out.println("call start in Data Manager for "+number);
	       
	            	}
	            
	            }
	            
	            if ((operations[i].length()>=7) && (operations[i].substring(0,5).equals("end(T"))&& (operations[i].indexOf(')')!=-1)){
	            	
	            	String number=operations[i].substring(operations[i].indexOf('T')+1, operations[i].indexOf(')'));
	            	if (isNumber(number)==true){
	            		int trueNumber=Integer.valueOf(number);
	            	System.out.println("call commit or abort in Data Manager for "+number);
	            
	            	}
	       
	            }
	            if ((operations[i].length()>=11) && (operations[i].substring(0,3).equals("W(T")) && (operations[i].indexOf(')')!=-1)){
	            	
	            	String[] tuple=operations[i].split(",");
	            	if (tuple.length==3){
	                	tuple[0]=tuple[0].trim();
	                	tuple[1]=tuple[1].trim();
	                	tuple[2]=tuple[2].trim();
	                	int transactionNumber=-1;
	                	int siteNumber=-1;
	          
	      
	                	if (isNumber(tuple[0].substring(3))==true){
	                	
	                		transactionNumber=Integer.valueOf(tuple[0].substring(3));
	       
	                	}
	                	
	         
	                	if ((tuple[1].substring(0,1).equals("x")) && (isNumber(tuple[1].substring(1))==true)){
	                
	                		siteNumber=Integer.valueOf(tuple[1].substring(1));
	                	}
	                	
	                	if (transactionNumber!=-1 && siteNumber!=-1){

	                		if (isNumber(tuple[2].substring(0,tuple[2].indexOf(")")))==true){
	                			int value=Integer.valueOf(tuple[2].substring(0,tuple[2].indexOf(")")));
	                			
	                			
	                			System.out.println("Write operation: transaction is "+tuple[0].substring(3)+", value is "+tuple[2].substring(0,tuple[2].indexOf(")"))+" acquire site lock for "+tuple[1].substring(1)+", then call write() in Data Manager");
	                		}
	                	}
	                	
	            
	             
	            	}
	            	
	            	
	            }
	        
	            }
	        	
            	time+=1;
	
	        };
	    }
}
