/*    */ package dtv.xst.dao.inv;
/*    */ 
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
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
/*    */ public interface ICartonModel
/*    */   extends IDataModel, IHasDocumentId
/*    */ {
/* 19 */   public static final EventEnum LINES_FIELD = new EventEnum("LineItems");
/*    */ 
/*    */   
/* 22 */   public static final EventEnum LINE_ADDED = new EventEnum("LINE_ADDED");
/*    */ 
/*    */   
/* 25 */   public static final EventEnum SET_TEMPCARTONSTATUSCODE = new EventEnum("set tempCartonStatusCode");
/*    */   
/*    */   void addInventoryDocumentLineItem(IInventoryDocumentLineItem paramIInventoryDocumentLineItem);
/*    */   
/*    */   void commitTemp();
/*    */   
/*    */   List<IInventoryDocumentLineItem> getLineItems();
/*    */   
/*    */   String getTempCartonStatusCode();
/*    */   
/*    */   int getUnvoidedLineCount();
/*    */   
/*    */   double getUnvoidedQuantityCount();
/*    */   
/*    */   void setTempCartonStatusCode(String paramString);
/*    */   
/*    */   void startTemp();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\ICartonModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */