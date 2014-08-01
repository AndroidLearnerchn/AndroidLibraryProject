package com.contextawareframework.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import android.content.Context;
import android.util.Log;

public class CsvFileWriter {

	private static final String CSVFILE = "CsvFileWriter";  
	private Context localContext;
	/*
	 * Default Constructor
	 */
	public void CsvFileWriter(Context context)
	{
			localContext= context;
	}
	/*
	 * Description : Method to create file to store data from database 
	 * to an external file on SD card. Need to mention Read / Write Permission 
	 * in the Android Manifest file.
	 **/
	public FileWriter createFile(File path,String folderName, String fileName) throws IOException
	{	
		FileWriter writer = null;
		try{
			if(path==null)
				path = android.os.Environment.getExternalStorageDirectory();
			if(folderName == null)
				folderName = "CSVFolder";
			File root = new File(path, folderName);

			//To check if folder is not already present
			if (!root.exists()) {
				root.mkdirs();
			}
			if(fileName == null)
				fileName = "CSVFile.csv";
			File file = new File(root,fileName);
			//If file is not present then it will create the file
			if(!file.exists())
			{
				writer = new FileWriter(file,true); // If true it will append in the existing file

			}
			else
			{	//If file is already present for an iteration then it will delete the file and create a new file
				file.delete(); // If you dont want to delete then comment the else part 
				writer = new FileWriter(file,true);

			}
		}
		catch(IOException e)
		{
			Log.e(CSVFILE,"Error while writing");
			e.printStackTrace();
		}
		return writer;
	}
	
	public void writeData(String data, FileWriter writer) throws FileNotFoundException,IOException
	{
		//FileWriter writer = new FileWriter(fileName,true);
		writer.append(data + "\n");
		writer.flush();
		writer.close();
	}
	/*
	 * Method to prepare a string data to be written in the file
	 */
	public String dataToWrite(Object... value)
	{
		int success = 0;// To check if the function exit properly
		// If function return is ok then it will return 1 else 0

		String data = null;
		StringBuilder strbuilder = null;
		 
		for (Object object:value)
		{	
			System.out.println("Argument passed :  "+object);
			strbuilder = (StringBuilder) strbuilder.append(object.toString()+",") ;
			System.out.println("Argument passed :  "+strbuilder);
		}
		
				return strbuilder.toString();
	}
	
}
