/*    */ package dtv.data2.dataloader.pluggable;
/*    */ 
/*    */ import dtv.data2.dataloader.fileprocessing.IHasSourceData;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
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
/*    */ public class DataFileException
/*    */   extends RuntimeException
/*    */   implements IHasSourceData
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 22 */   private List<String> _sourceData = new ArrayList<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DataFileException(String argMessage) {
/* 30 */     super(argMessage);
/*    */   }
/*    */   
/*    */   public DataFileException(String argMessage, String argFailedLine) {
/* 34 */     super(argMessage);
/*    */     
/* 36 */     this._sourceData = Arrays.asList(new String[] { argFailedLine });
/*    */   }
/*    */   
/*    */   public DataFileException(String argMessage, Throwable argCause) {
/* 40 */     super(argMessage, argCause);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DataFileException(String argMessage, Throwable argCause, String argFailedLine) {
/* 50 */     super(argMessage, argCause);
/*    */     
/* 52 */     this._sourceData = Arrays.asList(new String[] { argFailedLine });
/*    */   }
/*    */ 
/*    */   
/*    */   public List<String> getSourceData() {
/* 57 */     return this._sourceData;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\pluggable\DataFileException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */