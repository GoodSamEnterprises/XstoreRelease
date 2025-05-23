/*    */ package dtv.xst.dao.com.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.util.ICodeInterface;
/*    */ import dtv.xst.dao.com.ICodeValue;
/*    */ import dtv.xst.dao.com.ICodeValueModel;
/*    */ import dtv.xst.dao.com.ICodeValueProperty;
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
/*    */ public abstract class CodeValueBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<ICodeValueProperty>
/*    */   implements ICodeValue, ICodeValueModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public int compareTo(ICodeInterface argOther) {
/* 26 */     return getSortOrder() - argOther.getSortOrder();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\CodeValueBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */