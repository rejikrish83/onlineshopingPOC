package com.atb.web.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XlsReader {
	
	private static final Log LOG = LogFactory.getLog(XlsReader.class);
	static XSSFRow row;

	public void readXLFileAndStoreInDB(InputStream is/*,ApiDao apiDao*/) {
		
		LOG.info("Reading XL File...");
		//ApiFileUploadedDetails apiFileUploadedDetails = null;
		XSSFWorkbook workbook;
		try {
			workbook = new XSSFWorkbook(is);
			XSSFSheet spreadsheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = spreadsheet.iterator();
			LOG.info("Sheet Name... "+spreadsheet.getSheetName());
			while (rowIterator.hasNext()) {
				//apiFileUploadedDetails = new ApiFileUploadedDetails();
				row = (XSSFRow) rowIterator.next();

				if (row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
					Double costCenter = row.getCell(0).getNumericCellValue();
					
					LOG.info("costCenter ["+costCenter+"]");
					//apiFileUploadedDetails.setAssetClass(assetClass.longValue());
				}

				if (row.getCell(1).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
					Double assetClass = row.getCell(1).getNumericCellValue();
					LOG.info("assetClass ["+assetClass+"]");
				}
				
				if (row.getCell(2).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
					Double assetClass = row.getCell(1).getNumericCellValue();
					LOG.info("assetClass ["+assetClass+"]");
				}
				
			//	apiDao.createAPIRecord(apiFileUploadedDetails);				
			}
		} catch (Exception e) {
			LOG.error("Exception occured in XlsReader ", e.getCause());
			LOG.error(e.getMessage());
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}