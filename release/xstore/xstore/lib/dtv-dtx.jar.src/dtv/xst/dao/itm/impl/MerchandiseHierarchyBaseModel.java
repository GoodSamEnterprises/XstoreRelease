/*    */ package dtv.xst.dao.itm.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.util.ICodeInterface;
/*    */ import dtv.xst.dao.itm.IMerchandiseHierarchy;
/*    */ import dtv.xst.dao.itm.IMerchandiseHierarchyModel;
/*    */ import dtv.xst.dao.itm.IMerchandiseHierarchyProperty;
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
/*    */ public abstract class MerchandiseHierarchyBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IMerchandiseHierarchyProperty>
/*    */   implements IMerchandiseHierarchy, IMerchandiseHierarchyModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public int compareTo(ICodeInterface argOther) {
/* 27 */     return getSortOrder() - argOther.getSortOrder();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getCode() {
/* 33 */     return getHierarchyId();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\MerchandiseHierarchyBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */