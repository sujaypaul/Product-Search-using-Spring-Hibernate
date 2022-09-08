package com.nagarro.training.advanceJavaAssignment4.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.nagarro.training.advanceJavaAssignment4.dao.TshirtDao;
import com.nagarro.training.advanceJavaAssignment4.model.Tshirt;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class TshirtCsvFileReader {

	public static void getAllTshirts() {

		try {
			// getting list of files in directory
			
			File[] getalldata = new File("C:\\Users\\sujaypaul\\Desktop\\Assignments\\sujay-paul\\Advanced-Java-Assignment-4\\CSV")
							.listFiles(obj -> obj.isFile() 
									&& obj.getName().endsWith(".csv"));


			// parsing and reading data from each CSV file
			if (getalldata != null) {
				CSVParser parser = new CSVParserBuilder().withSeparator('|').withIgnoreQuotations(true).build();

				for (File file : getalldata) {
					
					CSVReader csvReader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(parser)
							.withSkipLines(1).build();

					String[] S;
					
					try {
						while ((S = csvReader.readNext()) != null) {
							Tshirt tshirt = new Tshirt();
														
							tshirt.setId(S[0]);
							tshirt.setName(S[1]);
							tshirt.setColor(S[2].toUpperCase());
							tshirt.setGender(S[3].toUpperCase());
							tshirt.setSize(S[4].toUpperCase());
							tshirt.setPrice(Double.parseDouble(S[5]));
							tshirt.setRating(Double.parseDouble(S[6]));
							tshirt.setAvalibilty(S[7]);
							

							TshirtDao.saveTshirt(tshirt);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR : CSV file not found");
		}
	}
	
}
