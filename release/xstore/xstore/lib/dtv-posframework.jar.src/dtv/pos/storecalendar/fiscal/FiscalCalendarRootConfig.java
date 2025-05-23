/*    */ package dtv.pos.storecalendar.fiscal;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
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
/*    */ 
/*    */ public class FiscalCalendarRootConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   public static final String MAIN_TAG = "root";
/*    */   public static final String DTYPE = "root";
/*    */   private static final long serialVersionUID = 1L;
/* 25 */   private final List<FiscalCalendarWeekConfig> _weekList = new ArrayList<>();
/*    */   
/*    */   public String getChildTag() {
/* 28 */     return "week";
/*    */   }
/*    */   
/*    */   public FiscalCalendarWeekConfig[] getWeeks() {
/* 32 */     FiscalCalendarWeekConfig[] weeks = this._weekList.<FiscalCalendarWeekConfig>toArray(new FiscalCalendarWeekConfig[this._weekList.size()]);
/* 33 */     Arrays.sort((Object[])weeks);
/* 34 */     return weeks;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 39 */     if (argValue instanceof FiscalCalendarWeekConfig) {
/* 40 */       this._weekList.add((FiscalCalendarWeekConfig)argValue);
/*    */     } else {
/*    */       
/* 43 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\storecalendar\fiscal\FiscalCalendarRootConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */