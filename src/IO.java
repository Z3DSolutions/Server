import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.LinkedList;
	
public class IO 
{
	File[] files;
	
	IO()
	{
		files=loadFiles();
		for(int i=0;i<files.length;i++)
		{
			if(files[i]==null)
				continue;
			if(files[i].getName()==null)
				continue;
			System.out.println(files[i].getName());
		}
	}
	File[] getFiles()
	{
		return files;
	}
	File[] loadFiles()
	{
		String Path="./files/";
		File[] files=null;
		LinkedList<File> Directories=new LinkedList<File>();	
		LinkedList<File> Files=new LinkedList<File>();
		try
		{			
			files = new File(Path).listFiles();
			for(int j=0;j<files.length;j++)
			{
				if(files[j].isDirectory())
				{
					Directories.add(files[j]);
				}
				else if(files[j].getName().contains(".txt"))
				{
					Files.add(files[j]);
				}
				else
				{
				//	System.out.println("%File "+files[j].getName());
				}
			}
	
			files=new File[Files.size()];
			int index=0;
			while(!Files.isEmpty())
			{
				files[index]=Files.pop();
				index++;
			}
			
		}catch(Exception e){}		
		return files;
	}
}
