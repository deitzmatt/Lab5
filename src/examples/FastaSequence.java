package examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FastaSequence 
{
	private String sequence;
	private String header;
	
	public FastaSequence(String header, String sequence)
	{
		sequence = this.sequence;
		header = this.header;
	}

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		List<FastaSequence> fastaList = FastaSequence.readFastaFile("/Users/mdeitz/Desktop/testFasta.txt");
		for (FastaSequence fs : fastaList)
		{
			System.out.println(fs.getHeader());
			System.out.println(fs.getSequence());
			System.out.println(fs.getGCRatio());
		}

	}
	public static List<FastaSequence> readFastaFile(String filename) throws Exception
	{
		List<FastaSequence> fastaList = new ArrayList<>();
		char headIndicator = '>';
		BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
		for(String line = reader.readLine();line != null; line = reader.readLine())
		{
			if(line.charAt(0) == headIndicator)
			{
				String header = line.substring(1);
				String sequence = reader.readLine();
				FastaSequence temp = new FastaSequence(header,sequence);
				fastaList.add(temp);
			}
		}
		reader.close();
		
		return fastaList;
	}
	public String getHeader()
	{
		return header;
	}
	public String getSequence()
	{
		return sequence;
	}
	public float getGCRatio()
	{
		return 0f;
	}

}
