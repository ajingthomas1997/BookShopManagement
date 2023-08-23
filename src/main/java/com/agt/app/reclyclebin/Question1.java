package com.agt.app.reclyclebin;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Student{
	
	String name;
	
}

public class Question1 {

	public static String[] uniqueNames(String[] names1, String[] names2) {
        
	      String names[] = new String[names1.length+names2.length];
	      
	      for(int i=0; i<names1.length; i++){
	        
	        names[i] = names1[i];
	        
	      }
	      
	      for(int i=0; i<names2.length; i++){
	        
	        names[i+names1.length] = names2[i];
	        
	      }
	      
	      for(int i=0; i<names.length; i++){
	        
	        for(int j=i+1;j<names.length; j++){
	          
	          if(names[i].equals(names[j]) && !names[i].equals("0")){
	            
	            names[j]="0";

	          }
	          
	        }
	        
	      }
	      
	      int count = 0;
	      
	      for(String str : names){
	        
	        if(!str.equals("0")){
	          
	          count++;
	          
	        }
	        
	      }
	      
	      String uniqueNames[] = new String[count];
	      
	      for(int i=0, j=0; i<names.length; i++){
	        
	        if(!names[i].equals("0")){
	          
	        	uniqueNames[j++] = names[i];
	          
	        }
	        
	      }
	      
	       return uniqueNames;
	      
	    }
	    
	    public static void main(String[] args) {
	        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
	        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
	        System.out.println(String.join(", ", Question1.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
	    }
	}