import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class Internet 
{
	public static void main(String[] args) 
	{
		BufferedReader br = null;
		br = new BufferedReader(new InputStreamReader(System.in));
		String Index=null;
		String Symbol=null;
		double s = 0,r=0,d=0,t=0;
		try 
		{
			System.out.println("%%%%%%%%%%%%%%%%%");
			System.out.println("%%%%%%%SYP%%%%%%%");
			System.out.println("%%%%%%%%%%%%%%%%%");
			System.out.println("Enter Index (INDEXSP): ");			
			Index = br.readLine();
			System.out.println("Enter Symbol (.IXP): ");			
			Symbol = br.readLine();
			System.out.println("Enter S 2060.74: ");
			s=Double.parseDouble(br.readLine());
			System.out.println("Enter r 0.035: ");
			r=Double.parseDouble(br.readLine());
			System.out.println("Enter d 0.0205: ");
			d=Double.parseDouble(br.readLine());
			System.out.println("Enter t 76: ");
			t=Double.parseDouble(br.readLine());
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getOTP(Index,Symbol,s,r,d,t);
	}
	public static String getOTP(String Index,String Symbol,double s,double r, double d,double t)
	{
		
			String Answer="I dont know";
		    String line = null;
		    for(int i=0;i<5;i++)
		    {
				try 
				{
					long tstart=System.currentTimeMillis();
					/*
					//String D1="https://www.google.com/finance/info?q=INDEXSP%3a.INX";
					String D1="http://finance.yahoo.com/quote/%5EGSPC?p=^GSPC";
					URL url = new URL(D1);			
				    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				    long tend=System.currentTimeMillis();
				    System.out.print(tend-tstart+" ");
				    for(int t=0;t<4;t++)
				    {
				    	line = reader.readLine();
				    }
				    for(int t=0;t<3;t++)
				    {
				    	line = reader.readLine();
				    	System.out.print(line);
				    }
				    */
					double f;
				    
				    f=s*(1+((r-d)*(t/365)));

					
				    
				//    reader.close();		
				    System.out.println(f);
				    Thread.sleep(500);
				}catch ( Exception ex ) {
				    ex.printStackTrace();
				}
				
					
				
		    }
	
			return Answer;
		
	}


}

