package ec.com.uce.web.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

/**
 * Agrega pie de pagina y marcas de agua a los PDF
 * 
 * @author Sheyla Rivera
 * @author Kruger - Santiago Cabrera M.
 * @version 1.0 21/07/2009
 * @since J2SDK5.0
 */
public class ConcatenadorPdf {

	@SuppressWarnings({ "rawtypes", "unused" })
	private ArrayList master;

	@SuppressWarnings("unused")
	private int pageOffset;

	@SuppressWarnings("unused")
	private ByteArrayOutputStream pdfDestino;

	@SuppressWarnings("rawtypes")
	public ConcatenadorPdf() {
		master = new ArrayList();
		pdfDestino = new ByteArrayOutputStream();
		pageOffset = 0;
	}

	public static byte[] numerarMarcar(byte pdf[], boolean numerarPaginas, boolean marcaDeAgua, String imagenMarcaAgua) throws IOException, DocumentException {
		PdfReader reader = new PdfReader(pdf);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfStamper stamp = new PdfStamper(reader, byteArrayOutputStream);
		PdfContentByte over;
		PdfContentByte under;
		BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA_OBLIQUE, BaseFont.WINANSI, BaseFont.EMBEDDED);

		int numPaginas = reader.getNumberOfPages();
		int i = 0;

		Rectangle rec = reader.getPageSizeWithRotation(1);

		Image img = null;
		if (marcaDeAgua) {
			img = Image.getInstance(new URL("http://127.0.0.1:8080/dione_web/" + imagenMarcaAgua));
			img.setAbsolutePosition(rec.getWidth() / 2 - img.getWidth() / 2, rec.getHeight() / 2 - img.getHeight() / 2);
		}
		
		while (i++ < numPaginas) {
			if (marcaDeAgua) {
				under = stamp.getUnderContent(i);
				under.addImage(img);
			}
			
			if (numerarPaginas) {
				over = stamp.getOverContent(i);
				over.beginText();
				over.setFontAndSize(bf, 7);
				over.setTextMatrix(680, 30);
				over.showText("Página " + i + " de " + numPaginas);
				over.endText();
				over.beginText();
				over.setFontAndSize(bf, 7);
				over.setTextMatrix(50, 50);
				over.showText("Banco Guayaquil");
				over.endText();
				over.beginText();
				over.setFontAndSize(bf, 7);
				over.setTextMatrix(50, 40);
				over.showText("Pichincha 105 - 107 y Francisco de Paula Ycaza");
				over.endText();
				over.beginText();
				over.setFontAndSize(bf, 7);
				over.setTextMatrix(50, 30);
				over.showText("Teléfono 3730100");
				over.endText();
			}
		}
		
		stamp.close();
		
		return byteArrayOutputStream.toByteArray();
	}
}
