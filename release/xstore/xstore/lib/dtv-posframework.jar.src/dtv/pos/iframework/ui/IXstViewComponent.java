/*    */ package dtv.pos.iframework.ui;
/*    */ 
/*    */ import dtv.i18n.FormattableFactory;
/*    */ import dtv.ui.IUIResourceManager;
/*    */ import dtv.ui.UIResourceManager;
/*    */ import javax.swing.JComponent;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IXstViewComponent
/*    */ {
/*    */   public static final String COMPONENT_WRAPPER = "COMPONENT_WRAPPER";
/*    */   public static final String CELL_RENDERER_DEF = "CellRendererDef";
/*    */   public static final String ALTERNATE_CELL_RENDERER_DEF = "AlternateCellRendererDef";
/*    */   public static final String COLUMN_HEADER_RENDERER_DEF = "ColumnHeaderRendererDef";
/*    */   public static final String ROW_HEADER_RENDERER_DEF = "RowHeaderRendererDef";
/*    */   public static final String UPPER_LEFT_RENDERER_DEF = "UpperLeftRendererDef";
/* 56 */   public static final FormattableFactory FF = FormattableFactory.getInstance();
/*    */   
/* 58 */   public static final IUIResourceManager UIRM = UIResourceManager.getInstance();
/*    */   
/*    */   JComponent getDisplayComponent();
/*    */   
/*    */   JComponent getFocusComponent();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\IXstViewComponent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */