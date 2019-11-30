package com.thunisoft.develop.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

class DemoApplicationTests {

	@Test
	void contextLoads() {
		try {
			StringBuffer sqlBuf = new StringBuffer();
			Scanner inputFile = new Scanner(new File("C:\\Users\\lenovo\\Documents\\CoCall\\23083@cocall.thunisoft.com_8888\\FileRecv\\柳灏\\gov.sql"));



			//put entire SQL into string buffer
			while(inputFile.hasNextLine()) {
				String next = inputFile.nextLine();

				if(!next.contains("-") && !next.isEmpty()) {
					sqlBuf.append(next);
					sqlBuf.append("\n");
				}


			}



			TreeMap<String,String> replacements = new TreeMap<String,String>();

			replacements.put("`","\"");
			replacements.put("VARCHAR","VARCHAR2");
			replacements.put("NOT NULL","NOT NULL ENABLE");
			replacements.put(" INT "," NUMBER ");
			replacements.put("ENGINE = \\w*.",";");//remove the engine type
			replacements.put("IF NOT EXISTS .\\w*.\\.","");//remove the engine type
			replacements.put("DATETIME","TIMESTAMP");//remove the engine type

			replacements.put("ON DELETE NO ACTION","");
			replacements.put("ON UPDATE NO ACTION","");
			replacements.put(".mydb..","");
			replacements.put("CREATE SCHEMA IF NOT EXISTS DEFAULT CHARACTER","");
			replacements.put("\\s*?\\)",")");//mysql work bench seems to put some anoying white space before closing some brackets
			replacements.put("IF NOT EXISTS","");//mysql work bench seems to put some anoying white space before closing some brackets
			replacements.put("AUTO_INCREMENT","");

			replacements.put("\"\\w*\"\\.","");//remove the engine type

			//remove the crap at the top for new database setup
			//replacements.put("CREATE SCHEMA.*?;","");//remove the engine type
			replacements.put("USE.*?;","");//remove the engine type
			replacements.put("SET.*?;","");//remove the engine type
			replacements.put("\\;","/");



			//convert to String
			String sql = sqlBuf.toString();

			for(Map.Entry<String, String> vkPairs : replacements.entrySet() ) {
				sql = sql.replaceAll("(?s)"+vkPairs.getKey(),vkPairs.getValue());
			}





			BufferedWriter writer = new BufferedWriter(new FileWriter("oracle.sql"));

			writer.append(sql);
			writer.flush();



		} catch (FileNotFoundException e) {
			System.err.println("file not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("there was an IO exeption");
			e.printStackTrace();
		}
	}

}
