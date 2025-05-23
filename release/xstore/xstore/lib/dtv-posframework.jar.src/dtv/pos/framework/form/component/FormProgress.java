/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import java.awt.Dimension;
/*     */ import javax.swing.JProgressBar;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FormProgress<T extends IFormModel>
/*     */   extends AbstractFormComponent<T>
/*     */ {
/*  25 */   private static final Logger logger_ = Logger.getLogger(FormProgress.class);
/*     */   
/*     */   protected final JProgressBar progressBar_;
/*     */   
/*     */   public static final int PROGRESS_INVISIBLE = 2147483647;
/*     */   
/*     */   private boolean invisible_ = false;
/*     */   
/*     */   public FormProgress() {
/*  34 */     this.progressBar_ = new DtvProgressBar();
/*  35 */     this.progressBar_.setFocusable(false);
/*  36 */     this.progressBar_.setMinimum(0);
/*  37 */     this.progressBar_.setMaximum(100);
/*     */ 
/*     */     
/*  40 */     setProgress(-1);
/*  41 */     setComponent(this.progressBar_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfig(IFormComponentConfig<?> newValue) {
/*  47 */     super.setConfig(newValue);
/*  48 */     setProgress(30);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getComponentValue() {
/*  54 */     return Integer.valueOf(this.progressBar_.getValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComponentEnabled(boolean newValue) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComponentValue(Object newValue) {
/*  66 */     if (newValue instanceof Integer) {
/*  67 */       setProgress(((Integer)newValue).intValue());
/*     */     }
/*  69 */     else if (newValue != null) {
/*  70 */       logger_.warn("unexpected data type " + newValue.getClass().getName());
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setProgress(int newValue) {
/*  75 */     if (newValue == Integer.MAX_VALUE) {
/*  76 */       this.invisible_ = true;
/*  77 */       this.progressBar_.setVisible(false);
/*     */     } else {
/*     */       
/*  80 */       if (newValue < 0) {
/*  81 */         this.progressBar_.setIndeterminate(true);
/*  82 */         this.progressBar_.setValue(-newValue);
/*     */       } else {
/*     */         
/*  85 */         this.progressBar_.setIndeterminate(false);
/*  86 */         this.progressBar_.setValue(newValue);
/*     */       } 
/*  88 */       if (this.invisible_) {
/*  89 */         this.progressBar_.setVisible(true);
/*  90 */         this.invisible_ = false;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static class DtvProgressBar
/*     */     extends JProgressBar
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/*     */     public Dimension getMinimumSize() {
/* 103 */       return getPreferredSize();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormProgress.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */