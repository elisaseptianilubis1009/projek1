/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugasakhir.projek1.restController;

/**
 *
 * @author admin
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tugasakhir.projek1.Dto.ExportToExcelRequestDto;

public class ExcellExporter {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	List<ExportToExcelRequestDto> dtos;
	Integer grandTotal;
	Integer rows = 0;
	Integer coloumn = 0;

	public ExcellExporter(List<ExportToExcelRequestDto> dtos, Integer grandTotal) {
		this.dtos = dtos;
		this.grandTotal = grandTotal;
		workbook = new XSSFWorkbook();
	}
	
	

	private void writeHeaderLine() {
		sheet = workbook.createSheet("Laporan Penjualan");

		Row row = sheet.createRow(5);
		Row row1 = sheet.createRow(1);
		Row row2 = sheet.createRow(2);
		Row row3 = sheet.createRow(3);
		

		
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(15);
		style.setFont(font);

		createCell(row1, 0, "PT.Musim Masim Bandung", style);
		createCell(row2, 0, "Laporan Penjualan Bulanan", style);
		createCell(row3, 0, "Periode 31 September 2021", style);
		createCell(row, 0, "Nama produk", style);
		createCell(row, 1, "Quantity", style);
		createCell(row, 2, "Total", style);

	}

	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}

	private void writeDataLines() {
		int rowCount = 6;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ExportToExcelRequestDto dto : dtos) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, dto.getNamaProduk(), style);
			createCell(row, columnCount++, dto.getQuantity(), style);
			createCell(row, columnCount++, dto.getTotal(), style);

			coloumn = columnCount;
		}

		rows = rowCount;
		System.out.println("rowCount : "+rows);
		System.out.println("columnCount :"+coloumn);

	}
	
	private void writeGrandTotal() {
	
		coloumn=coloumn-1;
		Integer coloumn2=coloumn-2;
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(15);
		style.setFont(font);

	
			Row row = sheet.createRow(rows++);
			
			createCell(row, coloumn2, "Total Penjualan", style);
			createCell(row, coloumn, grandTotal, style);
		


	}
	
	private void writeJudul() {
		


		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(15);
		style.setFont(font);

	
//			Row row = sheet.createRow(0);
//			Row row2 = sheet.createRow(2);
//			Row row3 = sheet.createRow(3);
			
//			createCell(row, 1, "PT.Musim Masim Bandung", style);
//			createCell(row2, 1, "Laporan Penjualan Bulanan", style);
//			createCell(row3, 1, "Periode 31 September 2021", style);
		


	}


	public void export(HttpServletResponse response) throws IOException {
//		writeJudul();
		writeHeaderLine();
		writeDataLines();
		writeGrandTotal();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}
}
