/*    */ package dtv.pos.framework.reporting.fill;
/*    */ 
/*    */ import dtv.pos.framework.reporting.ReportFillException;
/*    */ import dtv.pos.protocol.DtvURLConnection;
/*    */ import java.net.URL;
/*    */ import java.net.URLConnection;
/*    */ import org.apache.pdfbox.pdmodel.PDDocument;
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
/*    */ public class UrlReportFill
/*    */   extends ReportFill
/*    */ {
/*    */   private final URL url_;
/*    */   private URLConnection connection_;
/*    */   
/*    */   protected UrlReportFill(URL argUrl) {
/* 27 */     super(null, null);
/* 28 */     this.url_ = argUrl;
/*    */   }
/*    */ 
/*    */   
/*    */   public void cancel() {
/* 33 */     URLConnection c = this.connection_;
/* 34 */     if (c instanceof DtvURLConnection) {
/* 35 */       ((DtvURLConnection)c).cancelGetContents();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void run() throws ReportFillException {
/*    */     try {
/* 44 */       this.connection_ = this.url_.openConnection();
/* 45 */       Object o = this.connection_.getContent();
/* 46 */       this.connection_ = null;
/* 47 */       PDDocument p = (PDDocument)o;
/* 48 */       setResults(p);
/*    */     }
/* 50 */     catch (Exception ex) {
/* 51 */       throw new ReportFillException(ex);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\fill\UrlReportFill.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */