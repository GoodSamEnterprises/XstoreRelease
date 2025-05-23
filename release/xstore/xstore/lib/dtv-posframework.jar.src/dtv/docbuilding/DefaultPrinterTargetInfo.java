/*     */ package dtv.docbuilding;
/*     */ 
/*     */ import dtv.util.xmlexport.XmlExportAttribute;
/*     */ import dtv.util.xmlexport.XmlExportWriter;
/*     */ import java.io.IOException;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import org.w3c.dom.Element;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultPrinterTargetInfo
/*     */   implements IPrinterTargetInfo
/*     */ {
/*     */   private static final long serialVersionUID = -1161702314854533363L;
/*     */   private static final String RECEIPT = "RECEIPT";
/*     */   private static final String RECEIPT_BACKUP = "RECEIPT_BACKUP";
/*     */   private final String printerType_;
/*     */   private final String backupPrinterType_;
/*     */   
/*     */   public static IPrinterTargetInfo fromXml(Element argXmlElement) {
/*  36 */     return new DefaultPrinterTargetInfo(argXmlElement.getAttribute("primary"), argXmlElement
/*  37 */         .getAttribute("backup"));
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
/*     */   public DefaultPrinterTargetInfo(String argPrinterType, String argBackupPrinterType) {
/*  51 */     this.printerType_ = argPrinterType;
/*  52 */     this.backupPrinterType_ = argBackupPrinterType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBackupPrinterType() {
/*  62 */     return this.backupPrinterType_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPrinterType() {
/*  72 */     return this.printerType_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeXml(XmlExportWriter w) throws IOException {
/*  83 */     List<XmlExportAttribute> attribs = new LinkedList<>();
/*  84 */     attribs.add(new XmlExportAttribute("primary", clean(this.printerType_)));
/*  85 */     attribs.add(new XmlExportAttribute("backup", clean(this.backupPrinterType_)));
/*  86 */     w.writeElement("targetinfo", attribs.<XmlExportAttribute>toArray(new XmlExportAttribute[attribs.size()]));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String clean(String argType) {
/*  96 */     if (!"RECEIPT".equals(argType) && !"RECEIPT_BACKUP".equals(argType))
/*     */     {
/*     */       
/*  99 */       if (argType.startsWith("RECEIPT")) {
/* 100 */         return "RECEIPT";
/*     */       }
/*     */     }
/* 103 */     return argType;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\DefaultPrinterTargetInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */