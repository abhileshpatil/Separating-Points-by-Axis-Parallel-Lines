import java.io.*;
import java.util.*;

public class ParallelLine {
	static int n;
	static float a[];
	static float b[];
	static float c[];
	
	public static void main(String []args)
	{	
		List<String> lines = new ArrayList<String>();
     File f = new File("input/");                            
     
     for(File file : f.listFiles())
     {
    	 BufferedReader br;
    	 try{
			br =new BufferedReader(new FileReader(file));
            String outputfile=file.getName();
            String outputfile1=outputfile.replaceAll("\\D+","");
			
			String s;
			while((s = br.readLine()) != null)
    	 {
				lines.add(s);
    	 
    	 }
			
			int n = Integer.parseInt(lines.get(0));              // Total number of points

			a = new float[n];                                    // Array a[] stores x co-ordinates of the points in the file
			b = new float[n];                                    // Array b[] stores y co-ordinates of the points in the file

			
			int w = 0;
			int y = 0;

			for(int j = 1; j < lines.size(); j++){
				
				String[] coordinates = lines.get(j).split(" ");

				a[w] = Float.parseFloat(coordinates[0]);
				w++;
				b[y] = Float.parseFloat(coordinates[1]);
				y++;
				
			}

			
     
     
     
     float p,q,sum,total;
     int k=0;
     int count=0;                                            /* Count variable stores the sum of horizontal and vertical lines 
                                                                required to separate the points*/ 
	 c=new float[n/2];                                      // Array c[] stores co-ordinates where vertical line cross x axis 
	 int d[]=new int[n];                                   /* Array d[] stores value 0 or 1 which keeps track whether the 
	                                                          two points between two vertical lines are separated or not*/
	 float z[]=new float[n];                               // Array z[] stores co-ordinates where horizontal line cross y axis
	 
	 for(int i=0;i<n;i++)
	 {
		 d[i]=0;
		 z[i]=-1;
	 }
	 
	 for(int i=0;i<=((n/2)-1);i++)
	 {
		 c[i]=-1;
	 }
	 {
	 int j=0;
	 for(int i=2;i<n;i=i+2)
	 {   count++;
		 c[j]=(a[i-1]+a[i])/2;
		 j++;
	 }
	 
	 }
	 
//-----------------------For Horizontal Lines--------------------------------
	 
	 
	 
	 
	 
	 float g=0;
	 sum=0;
	 int m=0;
	 p=0;
	 q=0;
	 for(int i=0;i<n;i++)
	 {   
		 if(d[i]==0)
	     {  
			p= b[i];                  
			if(i+1<n)
			{
			q= b[i+1];
			}
			
			if(p!=0 && q!=0)
			{
			if(p<q)
			{
			    sum=q;
				for(int j=i;j<n;j++)
				{   if(d[j]==0)
				{
					if(b[j]>p && b[j]<q)
					{
						g=0;
				        m=j;
				       if(j%2!=0)    
					{
				    	   if(b[j-1]>p && b[j-1]<q)
				    	   {
				    		   g=(b[j]+b[j-1])/2;
				    		   
				    		   if(g%2.0==0.0 || g%2.0==1.0)
				    		   {
				    		        	 g=(float) (g+0.5);
				    		        	 
				    		   }
				    		
				    		   m=j;
				    		   j=n+1;
				    	   }
					}
				
				       if(g==0)
					    {
						if(b[m]<sum)
							sum=b[m];
					    }
				       }
					
				}   
				    
				       }
					
				
			if(g==0)
			{   total=(sum+p)/2;
			    if(total%2.0==0.0 || total%2==1.0)
			    {
			    	total=(float) (total+0.5);
			    }
			   
			    {
			    	for(int l=0;l<n;l=l+2)
			        {   if(l+1<n)
			        {
			        	if(b[l]<b[l+1])
			        {
			                   if(b[l]<total && total <b[l+1])
			                   {
			                	   d[l]=1;
			                	   d[l+1]=1;
			                   }
			                   
			        }
			        	else
			        	{
			        		 if(b[l]>total && total >b[l+1])
			                   {
			                	   d[l]=1;
			                	   d[l+1]=1;
			                   }
			        	}
			        }
			        }
				z[k]=total;
				k++;
			    }
			//	k++;
				}
			
			
//<----if g!=0------------To draw horizontal line in between>
			
			
			
			else
			{   
				for(int l=0;l<n;l=l+2)
		        {   if(l+1<n)
		            {
		        	if(b[l]<b[l+1])
		        {
		                   if(b[l]<g && g <b[l+1])
		                   {
		                	   d[l]=1;
		                	   d[l+1]=1;
		                   }
		                   
		        }
		        	
		        	else
		        	{
		        		 if(b[l]>g && g >b[l+1])
		                   {
		                	   d[l]=1;
		                	   d[l+1]=1;
		                   }
		        	}
		            }
		        }
				z[k]=g;
				g=0;
				k++;
			}
			p=0;
			q=0;
			sum=0;
			}
			
		 
			
			else                                       // p>q
			{   
				sum=p;
				for(int j=i;j<n;j++)
				{   
					if(d[j]==0)
					{
					if(b[j]<p && b[j]>q)
					{   g=0;
					    m=j;
						if(j%2!=0)    
						{
					    	   if(b[j-1]<p && b[j-1]>q)
					    	   {
					    		   g=(b[j]+b[j-1])/2;
					    		   if(g%2.0==0.0 || g%2.0==1.0)
					    		   {
					    		        	 g=(float) (g+0.5);
					    		        	
					    		   }   
					    		 
					    		   m=j;
					    		   j=n+1;
					    	   }
						}
				
						if(g==0)
						{
						if(b[m]<sum)
							sum=b[m];
						}		
					
				}
					
					}
					
				}
				
				if(g==0)
				{
				total=(sum+q)/2;
				if(total%2.0==0.0 || total%2==1.0)
				{   
					total=(float) (total+0.5);
				}
				
				{
					for(int l=0;l<n;l=l+2)
			        {   if(l+1<n)
			        {
			        	if(b[l]<b[l+1])
			        {
			                   if(b[l]<total && total <b[l+1])
			                   {
			                	   d[l]=1;
			                	   d[l+1]=1;
			                   }
			                   
			        }
			        	else
			        	{
			        		 if(b[l]>total && total >b[l+1])
			                   {
			                	   d[l]=1;
			                	   d[l+1]=1;
			                   }
			        	}
			        }
			        }
				z[k]=total;
				k++;
				
				}
				}
				
				else
				{   for(int l=0;l<n;l=l+2)
		        {  
					if(l+1<n)
		        {
		        	if(b[l]<b[l+1])
		        {
		                   if(b[l]<g && g <b[l+1])
		                   {
		                	   d[l]=1;
		                	   d[l+1]=1;
		                   }
		                   
		        }
		        	else
		        	{
		        		 if(b[l]>g && g>b[l+1])
		                   {
		                	   d[l]=1;
		                	   d[l+1]=1;
		                   }
		        	}
		        }
		        }
					z[k]=g;
					k++;
					g=0;
				}
				p=0;
				q=0;
				sum=0;
			}
			
						 	 
		 }
		 }
	 } 	 
	 for(k=0;k<n;k++){
		 if(z[k]!=-1)
	 count++;
	 }
	 File Outputvalues=new File("output_greedy/greedy_solution"+outputfile1+".txt");
	 PrintStream output =new PrintStream(new FileOutputStream(Outputvalues));
	 System.setOut(output);
	 System.out.println(count);
		 if(n%2==0)
		 {
		  
		 for(int i=0;(i<((n/2)-1));i++)
		 {
		 System.out.println(""+"v"+" "+" "+c[i]);
		 
		 }
		 }
		 else
		 {
			 for(int i=0;(i<=((n/2)-1));i++)
			 {
			 System.out.println(""+"v"+" "+" "+c[i]);
			 } 
		 }
		 for(k=0;k<n;k++){
			 if(z[k]!=-1)
		 System.out.println("h"+"  "+z[k]);
		 }
		 
	 lines.clear();
  	 }catch(Exception e)
    	 {
    		
    	 }
     }
     }
}
