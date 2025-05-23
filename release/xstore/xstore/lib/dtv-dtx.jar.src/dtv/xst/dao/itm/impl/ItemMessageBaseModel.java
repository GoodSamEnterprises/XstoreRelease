/*    */ package dtv.xst.dao.itm.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.xst.dao.itm.IItemMessage;
/*    */ import dtv.xst.dao.itm.IItemMessageModel;
/*    */ import dtv.xst.dao.itm.IItemMessageProperty;
/*    */ import dtv.xst.dao.itm.IItemMessageTypes;
/*    */ import java.util.ArrayList;
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
/*    */ 
/*    */ public abstract class ItemMessageBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IItemMessageProperty>
/*    */   implements IItemMessage, IItemMessageModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 26 */   private transient List<String> lineItemTypeStrings_ = null;
/*    */ 
/*    */ 
/*    */   
/*    */   public List<String> getLineItemTypesStrings() {
/* 31 */     if (this.lineItemTypeStrings_ == null) {
/* 32 */       this.lineItemTypeStrings_ = new ArrayList<>();
/*    */       
/* 34 */       for (int i = 0; i < getLineItemTypes().size(); i++) {
/* 35 */         IItemMessageTypes msgType = getLineItemTypes().get(i);
/* 36 */         this.lineItemTypeStrings_.add(msgType.getLineItemType());
/*    */       } 
/*    */     } 
/*    */     
/* 40 */     return this.lineItemTypeStrings_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemMessageBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */