/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class PDF {
    public void btnPDFActionPerformed(String contenido) {//GEN-FIRST:event_btnPDFActionPerformed
//         PostulanteModelo p = llenarModelo();
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("formularioPaises"+".pdf"));
            document.open();
            // Establecer márgenes
            document.setMargins(50, 50, 50, 50);

            // Establecer tamaño de página
            document.setPageSize(PageSize.A4);
            // Crear una fuente con estilo y tamaño específicos
            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLUE);

            // Crear un párrafo con la fuente especificada
            Paragraph paragraph = new Paragraph("REPORTE LISTA DE PAISES", font);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            Font font1 = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.DARK_GRAY);
            // Añadir espaciado antes del párrafo
            Paragraph paragraph1 = new Paragraph(contenido, font1);
            paragraph1.setSpacingBefore(10);
            paragraph1.setAlignment(Element.ALIGN_LEFT);
            document.add(paragraph1);

            document.close();
            JOptionPane.showMessageDialog(null, "PDF generado correctamente.");
        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + e.getMessage());
        }
        

}}
