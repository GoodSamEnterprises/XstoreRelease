/*    */ package dtv.logbuilder.oxm;
/*    */ 
/*    */ import dtv.docbuilding.IDocBuilder;
/*    */ import dtv.logbuilder.config.LogConfigHelper;
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
/*    */ public class XmlBuilder
/*    */   implements IXmlBuilder
/*    */ {
/* 23 */   private static final Logger logger_ = Logger.getLogger(XmlBuilder.class);
/*    */   
/*    */   private static IXmlBuilder INSTANCE;
/*    */   
/*    */   private final LogConfigHelper configHelper_;
/*    */ 
/*    */   
/*    */   public static IXmlBuilder getInstance() {
/* 31 */     if (INSTANCE == null) {
/*    */       
/* 33 */       String className = System.getProperty(XmlBuilder.class.getName());
/*    */       try {
/* 35 */         INSTANCE = (IXmlBuilder)Class.forName(className).newInstance();
/*    */       }
/* 37 */       catch (Exception ex) {
/* 38 */         INSTANCE = new XmlBuilder();
/*    */       } 
/*    */     } 
/* 41 */     return INSTANCE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected XmlBuilder() {
/* 50 */     this.configHelper_ = new LogConfigHelper();
/* 51 */     this.configHelper_.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IXmlPosDocument buildXml(String argDocumentId, Object argSource) {
/* 57 */     IXmlPosDocument doc = new XmlPosDocument();
/*    */ 
/*    */     
/*    */     try {
/* 61 */       IDocBuilder<?> layout = this.configHelper_.getLayout(argDocumentId);
/*    */ 
/*    */       
/* 64 */       doc = (IXmlPosDocument)layout.build(doc, argSource, XmlDocElementFactory.getInstance());
/*    */     }
/* 66 */     catch (Exception ex) {
/* 67 */       logger_.error("Caught exception building XML document [" + argDocumentId + "] with source object " + argSource
/* 68 */           .getClass().getName(), ex);
/*    */     } 
/* 70 */     return doc;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\oxm\XmlBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */