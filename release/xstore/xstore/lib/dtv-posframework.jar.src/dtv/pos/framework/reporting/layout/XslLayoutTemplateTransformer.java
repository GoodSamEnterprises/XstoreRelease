/*     */ package dtv.pos.framework.reporting.layout;
/*     */ 
/*     */ import dtv.pos.framework.reporting.ReportException;
/*     */ import dtv.pos.framework.reporting.type.ReportOutputFormat;
/*     */ import dtv.pos.iframework.reporting.IReportDefinition;
/*     */ import dtv.util.FileUtils;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.attribute.FileAttribute;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import oracle.xdo.template.FOProcessor;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.springframework.core.io.Resource;
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
/*     */ public class XslLayoutTemplateTransformer
/*     */ {
/*  30 */   private static final Logger _logger = Logger.getLogger(XslLayoutTemplateTransformer.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  36 */   private static final Properties _defaultProperties = new Properties(); static {
/*  37 */     _defaultProperties.put("xslt-xpath-optimization", "false");
/*  38 */     _defaultProperties.put("pdf-compression", "true");
/*     */   }
/*  40 */   private static final Properties _defaultHtmlProperties = new Properties(); static {
/*  41 */     _defaultHtmlProperties.put("html-image-base-uri", "/xadmin/dynamicResource/");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Resource _configuration;
/*     */ 
/*     */ 
/*     */   
/*     */   public Resource getConfiguration() {
/*  51 */     return this._configuration;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfiguration(Resource argConfiguration) {
/*  59 */     this._configuration = argConfiguration;
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
/*     */   public byte[] transform(IReportDefinition argReportDef, ReportOutputFormat argOutputFormat, byte[] argLayoutTemplate, byte[] argDataset, Map<String, byte[]> argImageMap) throws ReportException {
/*  72 */     _logger
/*  73 */       .debug("Rendering report output for " + argReportDef.getName() + " Output type=" + argOutputFormat);
/*     */     
/*  75 */     ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
/*     */     
/*     */     try {
/*  78 */       FOProcessor foProc = new FOProcessor();
/*     */ 
/*     */ 
/*     */       
/*  82 */       if (this._configuration != null) {
/*  83 */         foProc.setConfig(this._configuration.getInputStream());
/*     */       } else {
/*     */         
/*  86 */         foProc.setConfig(_defaultProperties);
/*     */       } 
/*     */       
/*  89 */       File tempDir = null;
/*  90 */       if (ReportOutputFormat.HTML.equals(argOutputFormat)) {
/*  91 */         tempDir = Files.createTempDirectory("temp-reports", (FileAttribute<?>[])new FileAttribute[0]).toFile();
/*  92 */         _defaultHtmlProperties.put("html-image-dir", tempDir.getCanonicalPath());
/*  93 */         foProc.setConfig(_defaultHtmlProperties);
/*     */       } 
/*     */       
/*  96 */       foProc.setData(new ByteArrayInputStream(argDataset));
/*  97 */       foProc.setTemplate(new ByteArrayInputStream(argLayoutTemplate));
/*  98 */       foProc.setOutput(outputStream);
/*  99 */       foProc.setOutputFormat(argOutputFormat.getFormatId());
/*     */       
/* 101 */       foProc.generate();
/*     */       
/* 103 */       if (ReportOutputFormat.HTML.equals(argOutputFormat)) {
/* 104 */         for (File image : tempDir.listFiles()) {
/* 105 */           argImageMap.put(image.getName(), FileUtils.loadFileBytes(image));
/*     */         }
/* 107 */         FileUtils.deleteTree(tempDir);
/*     */       } 
/*     */       
/* 110 */       byte[] output = outputStream.toByteArray();
/*     */       
/* 112 */       _logger.debug("Rendered " + output.length + " bytes");
/*     */       
/* 114 */       return output;
/*     */     }
/* 116 */     catch (Exception e) {
/* 117 */       throw new ReportException("Failed to render report output", e);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\layout\XslLayoutTemplateTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */