/*    */ package dtv.pos.framework.form.design.model;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.swing.SpinnerModel;
/*    */ import javax.swing.event.ChangeEvent;
/*    */ import javax.swing.event.ChangeListener;
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
/*    */ public class IntegerSpinnerModel
/*    */   implements SpinnerModel
/*    */ {
/* 22 */   private final List<ChangeListener> changeListeners_ = new ArrayList<>();
/*    */   private final Integer max_;
/*    */   private final Integer min_;
/*    */   private Integer value_;
/*    */   
/*    */   public IntegerSpinnerModel(Integer min, Integer max, Integer initialValue) {
/* 28 */     this.max_ = max;
/* 29 */     this.min_ = min;
/* 30 */     this.value_ = initialValue;
/*    */   }
/*    */ 
/*    */   
/*    */   public void addChangeListener(ChangeListener l) {
/* 35 */     this.changeListeners_.add(l);
/*    */   }
/*    */   
/*    */   public Integer getInteger() {
/* 39 */     return this.value_;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getNextValue() {
/* 44 */     if (this.value_.equals(this.max_)) {
/* 45 */       return this.min_;
/*    */     }
/*    */     
/* 48 */     return Integer.valueOf(this.value_.intValue() + 1);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Object getPreviousValue() {
/* 54 */     if (this.value_.equals(this.min_)) {
/* 55 */       return this.max_;
/*    */     }
/*    */     
/* 58 */     return Integer.valueOf(this.value_.intValue() - 1);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Object getValue() {
/* 64 */     return this.value_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void removeChangeListener(ChangeListener l) {
/* 69 */     this.changeListeners_.remove(l);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setValue(Object value) {
/*    */     Integer v;
/* 75 */     if (value instanceof Integer) {
/* 76 */       v = (Integer)value;
/*    */     } else {
/*    */       
/* 79 */       v = Integer.valueOf(String.valueOf(value));
/*    */     } 
/* 81 */     this.value_ = v;
/* 82 */     notifyListeners();
/*    */   }
/*    */   
/*    */   private void notifyListeners() {
/* 86 */     ChangeEvent e = new ChangeEvent(this);
/* 87 */     for (int i = 0; i < this.changeListeners_.size(); i++)
/* 88 */       ((ChangeListener)this.changeListeners_.get(i)).stateChanged(e); 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\model\IntegerSpinnerModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */