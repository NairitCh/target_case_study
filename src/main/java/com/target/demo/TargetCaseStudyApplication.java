package com.target.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.target.demo.model.Keywords;


@SpringBootApplication
public class TargetCaseStudyApplication {
	
	private static final String FILE_NAME = "abusive_keywords.xlsx";
	
	public static void main(String[] args) {
		SpringApplication.run(TargetCaseStudyApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void parseKeywords() {
		try {
			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			int rowCounter = 0;
			while(iterator.hasNext()) {
				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				if (rowCounter > 0) {
					while (cellIterator.hasNext()) {
						Cell currentCell = cellIterator.next();
						if(currentCell.getColumnIndex() == 0) {
							Keywords.getInstance().add(currentCell.getStringCellValue());
						}
					}
				} else {
					rowCounter++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
