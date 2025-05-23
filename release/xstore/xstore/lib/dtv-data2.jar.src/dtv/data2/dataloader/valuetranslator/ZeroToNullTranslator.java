/*    */ package dtv.data2.dataloader.valuetranslator;
/*    */ 
/*    */ import dtv.data2.dataloader.fileprocessing.FileLine;
/*    */ import java.math.BigDecimal;
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
/*    */ public class ZeroToNullTranslator
/*    */   extends AbstractValueTranslator
/*    */ {
/* 21 */   private static final Logger logger_ = Logger.getLogger(ZeroToNullTranslator.class);
/*    */ 
/*    */ 
/*    */   
/*    */   public String translate(String argCurrentValue, FileLine argCurrentLine) {
/* 26 */     if (argCurrentValue != null) {
/* 27 */       String result = argCurrentValue.trim();
/*    */       
/*    */       try {
/* 30 */         BigDecimal number = new BigDecimal(result);
/*    */         
/* 32 */         if (number.compareTo(BigDecimal.ZERO) == 0) {
/* 33 */           return null;
/*    */         }
/*    */       }
/* 36 */       catch (Exception ee) {
/* 37 */         if (logger_.isInfoEnabled()) {
/* 38 */           logger_.info("Value was not numeric and will not be translated by ZeroToNullTranslator: [" + argCurrentValue + "] cause: " + ee);
/*    */         }
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 44 */     return argCurrentValue;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\valuetranslator\ZeroToNullTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */