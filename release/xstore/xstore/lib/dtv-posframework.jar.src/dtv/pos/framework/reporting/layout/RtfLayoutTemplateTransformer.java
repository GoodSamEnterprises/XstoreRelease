/*    */ package dtv.pos.framework.reporting.layout;
/*    */ 
/*    */ import dtv.pos.framework.reporting.ReportException;
/*    */ import dtv.pos.framework.reporting.ReportUtils;
/*    */ import dtv.pos.iframework.reporting.IReportDefinition;
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.InputStream;
/*    */ import oracle.xdo.template.RTFProcessor;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RtfLayoutTemplateTransformer
/*    */ {
/* 26 */   private static final Logger _logger = Logger.getLogger(RtfLayoutTemplateTransformer.class);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public byte[] transform(IReportDefinition argReportDef) throws ReportException {
/* 44 */     if (argReportDef == null) {
/* 45 */       throw new ReportException("No report definition defined");
/*    */     }
/*    */     
/* 48 */     _logger.debug("Rendering Report Layout " + argReportDef.getLayoutTemplate());
/*    */     
/*    */     try {
/* 51 */       InputStream is = ReportUtils.getTemplateStream(argReportDef.getLayoutTemplate());
/* 52 */       RTFProcessor processor = new RTFProcessor(is);
/*    */ 
/*    */       
/* 55 */       ByteArrayOutputStream xslLayoutTemplate = new ByteArrayOutputStream();
/* 56 */       processor.setOutput(xslLayoutTemplate);
/* 57 */       processor.process();
/*    */       
/* 59 */       byte[] output = xslLayoutTemplate.toByteArray();
/*    */       
/* 61 */       _logger.debug("Rendered " + output.length + " bytes");
/*    */       
/* 63 */       if (is != null) {
/* 64 */         is.close();
/*    */       }
/*    */       
/* 67 */       return output;
/*    */     }
/* 69 */     catch (Exception e) {
/* 70 */       throw new ReportException("Unable to transform RTF (" + argReportDef
/* 71 */           .getLayoutTemplate() + ") to XSL-FO", e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\layout\RtfLayoutTemplateTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */