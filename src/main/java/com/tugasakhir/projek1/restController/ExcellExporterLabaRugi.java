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

import com.tugasakhir.projek1.Dto.ExportToExcelAkunRequestDto;
import com.tugasakhir.projek1.Dto.ExportToExcelPrdKeluarRequestDto;

public class ExcellExporterLabaRugi {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	List<ExportToExcelPrdKeluarRequestDto> dtos;
	List<ExportToExcelAkunRequestDto> dtosAkuns;
	Integer grandTotal;
	Integer monthLabaRugi;
	Integer yearLabaRugi;
	Integer rows = 0;
	Integer coloumn = 0;
	Integer rowBeban =0;
	Integer row_global=0;
	Integer totalAkun=0;
	Integer totalAkhir=0;
	String bulan ;

	public ExcellExporterLabaRugi(List<ExportToExcelPrdKeluarRequestDto> dtos,List<ExportToExcelAkunRequestDto> dtosAkuns, Integer grandTotal,Integer monthLabaRugi,Integer yearLabaRugi) {
		this.dtos = dtos;
		this.dtosAkuns=dtosAkuns;
		this.grandTotal = grandTotal;
		this.monthLabaRugi=monthLabaRugi;
		this.yearLabaRugi=yearLabaRugi;
		
		workbook = new XSSFWorkbook();
	}
	
	

	private void writeHeaderLine() {
		if(monthLabaRugi==1) {
			bulan="Januari";
		}else if(monthLabaRugi==2) {
			bulan="Februari";
		}else if(monthLabaRugi==3) {
			bulan="Mei";
		}else if(monthLabaRugi==4) {
			bulan="April";
		}else if(monthLabaRugi==5) {
			bulan="Mei";
		}else if(monthLabaRugi==6) {
			bulan="Juni";
		}else if(monthLabaRugi==7) {
			bulan="Juli";
		}else if(monthLabaRugi==8) {
			bulan="Agustus";
		}else if(monthLabaRugi==9) {
			bulan="September";
		}else if(monthLabaRugi==10) {
			bulan="Oktober";
		}else if(monthLabaRugi==11) {
			bulan="November";
		}else {
			bulan="Desember";
		}
			
		sheet = workbook.createSheet("Laporan Laba Rugi");

		Row row = sheet.createRow(5);
		Row row1 = sheet.createRow(1);
		Row row2 = sheet.createRow(2);
		Row row3 = sheet.createRow(3);
		
		
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(15);
		style.setFont(font);

		createCell(row1, 1, "PT.Musim Masim Bandung", style);
		createCell(row2, 1, "Laporan Laba Rugi", style);
		createCell(row3, 1, "Periode "+bulan+ " "+ yearLabaRugi, style);
		createCell(row, 1, "Pendapatan atas Penjualan : ", style);
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

		for (ExportToExcelPrdKeluarRequestDto dto : dtos) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 1;

			createCell(row, columnCount++, dto.getNamaProduk(), style);
			createCell(row, columnCount++,"Rp. "+ dto.getTotal(), style);

			coloumn = columnCount;
		}

		rows = rowCount;
		System.out.println("rowCount : "+rows);
		System.out.println("columnCount :"+coloumn);

	}
	
	private void writeGrandTotal() {
		
		coloumn=coloumn-1;
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(15);
		style.setFont(font);

	
		
			Row row = sheet.createRow(rows++);
			 row_global=rows;
			Row row3=sheet.createRow(row_global);
			
			createCell(row, 1, "Total Penjualan :", style);
			createCell(row, 2, "Rp. "+ grandTotal, style);
			createCell(row3, 1, "Pengeluaran Beban-beban :", style);


	}
	
	private void writeAkunLabaRugi() {

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		for (ExportToExcelAkunRequestDto dtosAkun : dtosAkuns) {
			Row row = sheet.createRow(++row_global);
			int columnCount = 1;
			createCell(row, columnCount++, dtosAkun.getNama_akun(), style);
			createCell(row, columnCount++,"Rp. "+ dtosAkun.getNominal(), style);

			totalAkun+=dtosAkun.getNominal();
			coloumn = columnCount;
		}	
		System.out.println("Row Globalll :"+row_global);
	}
	
private void writeGrandTotalAkun() {
		String labaOrrugi;
	
		totalAkhir=grandTotal-totalAkun;
		if(totalAkhir<0) {
			System.out.println("Rugi");
			labaOrrugi="Rugi";
		}else {
			System.out.println("Laba");
			labaOrrugi="Laba";
		}
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(15);
		style.setFont(font);

	
		
			Row row = sheet.createRow(++row_global);
			Row row2 = sheet.createRow(++row_global);
			
			createCell(row, 1, "Total Beban :", style);
			createCell(row, 2, "Rp. "+ totalAkun, style);
			createCell(row2, 1, "Keterangan", style);
			createCell(row2, 2, labaOrrugi, style);
			createCell(row2, 3, "Rp. "+totalAkhir, style);
			
			System.out.println("Total Akhir :"+totalAkhir);


	}

	public void export(HttpServletResponse response) throws IOException {

		writeHeaderLine();
		writeDataLines();
		writeGrandTotal();
		writeAkunLabaRugi();
		writeGrandTotalAkun();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}
}
