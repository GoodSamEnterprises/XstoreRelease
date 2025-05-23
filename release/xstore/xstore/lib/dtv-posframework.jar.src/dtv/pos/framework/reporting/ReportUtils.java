/*     */ package dtv.pos.framework.reporting;
/*     */ 
/*     */ import com.micros.xstore.config.report.DataTemplate;
/*     */ import com.micros.xstore.config.report.ObjectFactory;
/*     */ import dtv.pos.iframework.reporting.IReportDefinition;
/*     */ import java.awt.Color;
/*     */ import java.awt.print.Pageable;
/*     */ import java.awt.print.PrinterJob;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.lang.reflect.Field;
/*     */ import javax.print.PrintService;
/*     */ import javax.print.PrintServiceLookup;
/*     */ import javax.print.attribute.AttributeSet;
/*     */ import javax.print.attribute.PrintRequestAttributeSet;
/*     */ import javax.xml.bind.JAXBContext;
/*     */ import javax.xml.bind.Unmarshaller;
/*     */ import javax.xml.stream.XMLInputFactory;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import javax.xml.stream.util.StreamReaderDelegate;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.apache.pdfbox.pdmodel.PDDocument;
/*     */ import org.apache.pdfbox.pdmodel.PDPage;
/*     */ import org.apache.pdfbox.pdmodel.PDPageContentStream;
/*     */ import org.apache.pdfbox.pdmodel.PDPageTree;
/*     */ import org.apache.pdfbox.pdmodel.font.PDFont;
/*     */ import org.apache.pdfbox.pdmodel.font.PDType1Font;
/*     */ import org.apache.pdfbox.printing.PDFPageable;
/*     */ import org.apache.pdfbox.util.Matrix;
/*     */ import org.springframework.core.io.Resource;
/*     */ import org.springframework.web.context.support.ServletContextResource;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReportUtils
/*     */ {
/*  45 */   private static final Logger logger_ = Logger.getLogger(ReportUtils.class);
/*     */   
/*     */   public static InputStream getTemplateStream(Resource argTemplate) {
/*  48 */     InputStream is = null;
/*     */     try {
/*  50 */       is = argTemplate.getInputStream();
/*     */     }
/*  52 */     catch (IOException ex) {
/*  53 */       ServletContextResource resource = (ServletContextResource)argTemplate;
/*  54 */       is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource.getPath());
/*     */     } 
/*     */     
/*  57 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean printPages(PDDocument argPrint, boolean argWithPrintDialog, AttributeSet argPrinterAttributes, PrintRequestAttributeSet argPrintRequestAttributeSet, int argCopies) throws ReportException {
/*  73 */     PrinterJob printJob = PrinterJob.getPrinterJob();
/*     */ 
/*     */     
/*     */     try {
/*  77 */       if (argPrinterAttributes != null) {
/*  78 */         PrintService[] services = PrintServiceLookup.lookupPrintServices(null, argPrinterAttributes);
/*  79 */         if (services != null && services.length > 0) {
/*  80 */           printJob.setPrintService(services[0]);
/*     */         }
/*     */         else {
/*     */           
/*  84 */           return false;
/*     */         }
/*     */       
/*     */       } 
/*  88 */     } catch (Exception ex) {
/*  89 */       logger_.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/*     */     
/*  92 */     printJob.setCopies(argCopies);
/*  93 */     printJob.setJobName("Reports - " + argPrint.getDocumentInformation().getTitle());
/*     */     
/*  95 */     printJob.setPageable((Pageable)new PDFPageable(argPrint));
/*     */     
/*     */     try {
/*  98 */       if (argWithPrintDialog && 
/*  99 */         !printJob.printDialog(argPrintRequestAttributeSet)) {
/* 100 */         return false;
/*     */       }
/*     */       
/* 103 */       printJob.print(argPrintRequestAttributeSet);
/*     */     }
/* 105 */     catch (Exception ex) {
/* 106 */       throw new ReportException("Error printing report.", ex);
/*     */     } 
/*     */     
/* 109 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setWatermarkText(PDDocument argDoc, String argWatermarkText) {
/* 120 */     PDType1Font pDType1Font = PDType1Font.HELVETICA;
/* 121 */     float fontSize = 36.0F;
/* 122 */     String fontColor = "LIGHT_GRAY";
/* 123 */     Integer textRot = Integer.valueOf(45);
/*     */     
/*     */     try {
/* 126 */       PDPageTree allPages = argDoc.getDocumentCatalog().getPages();
/*     */       
/* 128 */       for (int i = 0; i < allPages.getCount(); i++) {
/* 129 */         Color color; PDPage page = allPages.get(i);
/*     */ 
/*     */         
/* 132 */         boolean pageRotated = (page.getRotation() == 90 || page.getRotation() == 270);
/*     */         
/* 134 */         boolean textRotated = (textRot.intValue() != 0 || textRot.intValue() != 360);
/*     */         
/* 136 */         int totalRot = page.getRotation() - textRot.intValue();
/*     */ 
/*     */         
/* 139 */         PDPageContentStream contentStream = new PDPageContentStream(argDoc, page, PDPageContentStream.AppendMode.PREPEND, true, true);
/*     */         
/* 141 */         contentStream.beginText();
/*     */ 
/*     */         
/* 144 */         contentStream.setFont((PDFont)pDType1Font, fontSize);
/*     */ 
/*     */ 
/*     */         
/*     */         try {
/* 149 */           Field field = Color.class.getField(fontColor);
/* 150 */           color = (Color)field.get(null);
/*     */         }
/* 152 */         catch (Exception e) {
/*     */           
/* 154 */           color = Color.BLACK;
/*     */         } 
/* 156 */         contentStream.setNonStrokingColor(color);
/*     */ 
/*     */         
/* 159 */         float stringWidth = pDType1Font.getStringWidth(argWatermarkText) * fontSize / 1000.0F;
/*     */ 
/*     */         
/* 162 */         float pageWidth = pageRotated ? page.getMediaBox().getHeight() : page.getMediaBox().getWidth();
/* 163 */         float pageHeight = pageRotated ? page.getMediaBox().getWidth() : page.getMediaBox().getHeight();
/*     */ 
/*     */         
/* 166 */         float xVal = pageRotated ? (pageHeight / 2.0F) : ((pageWidth - stringWidth) / 2.0F);
/*     */         
/* 168 */         float yVal = pageRotated ? ((pageWidth - stringWidth) / 3.0F) : (pageHeight / 3.0F);
/*     */ 
/*     */ 
/*     */         
/* 172 */         Matrix matrix = new Matrix();
/*     */         
/* 174 */         matrix.translate(xVal, yVal);
/*     */         
/* 176 */         double angle = pageRotated ? Math.toRadians(totalRot) : (textRotated ? Math.toRadians(textRot.intValue()) : 0.0D);
/*     */         
/* 178 */         if (angle != 0.0D) {
/* 179 */           matrix.rotate(angle);
/*     */         }
/*     */         
/* 182 */         contentStream.setTextMatrix(matrix);
/*     */         
/* 184 */         contentStream.showText(argWatermarkText);
/*     */ 
/*     */         
/* 187 */         contentStream.endText();
/* 188 */         contentStream.close();
/*     */       }
/*     */     
/* 191 */     } catch (Exception ex) {
/* 192 */       logger_.error("");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DataTemplate unmarshalDataTemplate(IReportDefinition argReportDef) throws ReportException {
/*     */     try {
/* 205 */       JAXBContext context = JAXBContext.newInstance(ObjectFactory.class.getPackage().getName());
/* 206 */       Unmarshaller unmarshaller = context.createUnmarshaller();
/* 207 */       XMLInputFactory xmlFactory = XMLInputFactory.newFactory();
/*     */       
/* 209 */       InputStream is = getTemplateStream(argReportDef.getDataTemplate());
/* 210 */       XMLStreamReader xmlReader = new StreamReaderDelegate(xmlFactory.createXMLStreamReader(is));
/*     */       
/* 212 */       DataTemplate dataTemplate = (DataTemplate)unmarshaller.unmarshal(xmlReader);
/* 213 */       logger_.debug("Report Template: " + dataTemplate.getName());
/*     */       
/* 215 */       if (is != null) {
/* 216 */         is.close();
/*     */       }
/* 218 */       return dataTemplate;
/*     */     }
/* 220 */     catch (Exception e) {
/* 221 */       throw new ReportException("Failed to unmarshal dataTemplate", e);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\ReportUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */