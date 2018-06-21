package tw.com.softleader.itextpdfkhmer;


import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.licensekey.LicenseKey;

public class ITextPdfApp {

	public static final String DEST = "temp/combodia-khmer-text.pdf";

	public static final String KHMER_OS_FONT = "./fonts/KhmerOS.ttf";
	public static final String KHMER_Battambang_FONT = "./fonts/Google-Battambang-Regular.ttf";
	public static final String KonKhmer_Arom_FONT = "./fonts/KonKhmer_Arom.ttf";

	public static void main(String args[]) throws IOException, FileNotFoundException {

		LicenseKey.loadLicenseFile("./itext-license.xml");

		File file = new File(DEST);
		file.getParentFile().mkdirs();
		new ITextPdfApp().createPdf(DEST);

		System.out.println("PDF exported in " + file.getAbsolutePath());

	}

	public void createPdf(String dest) throws IOException {
		PdfDocument pdf = new PdfDocument(new PdfWriter(dest));

		PdfPage page = pdf.addNewPage(PageSize.A4);
		PdfCanvas pdfCanvas = new PdfCanvas(page);
		Rectangle rectangle = new Rectangle(0, 0, 400, 800);
		
		
		
//		pdfCanvas.rectangle(rectangle);
//		pdfCanvas.stroke();
		Canvas canvas = new Canvas(pdfCanvas, pdf, rectangle);
		canvas.setStrokeColor(new DeviceRgb(Color.BLUE));
		
		// PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
		PdfFont bold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
		PdfFont khmer_os_font = PdfFontFactory.createFont(KHMER_OS_FONT, PdfEncodings.IDENTITY_H);
		PdfFont khmer_os_p_font = PdfFontFactory.createFont(KHMER_Battambang_FONT, PdfEncodings.IDENTITY_H);
		PdfFont konkhmer_arom_font = PdfFontFactory.createFont(KonKhmer_Arom_FONT, PdfEncodings.IDENTITY_H);

		Text title = new Text("Combodia Khmer Text Test").setFont(bold);
		Text data1 = new Text("សារអេទេ្បចត្រូនិច កាលបរិចេ្ឆទ ថៃ្លរដ្ឋបាល").setFont(khmer_os_font);
		Text data2 = new Text("សារអេទេ្បចត្រូនិច កាលបរិចេ្ឆទ ថៃ្លរដ្ឋបាល").setFont(khmer_os_p_font);
		Text data3 = new Text("សារអេទេ្បចត្រូនិច កាលបរិចេ្ឆទ ថៃ្លរដ្ឋបាល").setFont(konkhmer_arom_font);

		Paragraph pTitle = new Paragraph().add(title);
		Paragraph p1 = new Paragraph(data1);
		p1.setBackgroundColor(new DeviceRgb(Color.GRAY));
		
		Paragraph p2 = new Paragraph(data2);
		Paragraph p3 = new Paragraph(data3);
		
		
		
		canvas.add(pTitle);
		canvas.add(p1);
		canvas.add(p2);
		canvas.add(p3);
		canvas.close();
		pdf.close();

	}

}
