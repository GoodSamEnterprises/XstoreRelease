/*    */ package dtv.docbuilding.xml;
/*    */ 
/*    */ import dtv.i18n.formatter.output.IOutputFormatter;
/*    */ import dtv.util.StringUtils;
/*    */ import java.util.Locale;
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
/*    */ 
/*    */ public class DocXmlCdataFormatter
/*    */   implements IOutputFormatter
/*    */ {
/*    */   private final IOutputFormatter _delegate;
/*    */   
/*    */   DocXmlCdataFormatter() {
/* 29 */     this(null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   DocXmlCdataFormatter(IOutputFormatter argDelegate) {
/* 38 */     this._delegate = argDelegate;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String format(Object argObj, Locale argLocale) {
/* 44 */     String formattedText = (this._delegate == null) ? StringUtils.nonEmpty(argObj) : this._delegate.format(argObj, argLocale);
/* 45 */     return (formattedText == null) ? null : ("<![CDATA[" + formattedText + "]]>");
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\DocXmlCdataFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */