/*    */ package dtv.pos.framework.reporting.fill;
/*    */ 
/*    */ import dtv.i18n.FormattableFactory;
/*    */ import dtv.i18n.FormatterType;
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.i18n.OutputContextType;
/*    */ import dtv.pos.iframework.type.IDtvDate;
/*    */ import dtv.util.DateUtils;
/*    */ import java.io.IOException;
/*    */ import java.io.ObjectInputStream;
/*    */ import java.io.ObjectOutputStream;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AbsoluteDtvDate
/*    */   implements IDtvDate
/*    */ {
/* 22 */   private static final FormattableFactory FF = FormattableFactory.getInstance();
/*    */   
/*    */   private Date date_;
/*    */   
/*    */   private IFormattable description_;
/*    */   
/*    */   private static final long serialVersionUID = -1740418553200564576L;
/*    */   
/*    */   public static IDtvDate valueOf(String s) {
/* 31 */     return new AbsoluteDtvDate(DateUtils.parseDate(s));
/*    */   }
/*    */   
/*    */   public AbsoluteDtvDate() {
/* 35 */     this(DateUtils.getNewDate());
/*    */   }
/*    */   
/*    */   public AbsoluteDtvDate(Date argDate) {
/* 39 */     this.date_ = argDate;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Date getDate() {
/* 45 */     return (Date)this.date_.clone();
/*    */   }
/*    */ 
/*    */   
/*    */   public Date getDate(Date argReferencePoint) {
/* 50 */     return getDate();
/*    */   }
/*    */ 
/*    */   
/*    */   public IFormattable getDescription() {
/* 55 */     if (this.description_ == null) {
/* 56 */       this.description_ = FF.getSimpleFormattable(this.date_, FormatterType.DATE_MEDIUM);
/*    */     }
/* 58 */     return this.description_;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isRelative() {
/* 63 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toExternalForm() {
/* 68 */     return DateUtils.format(this.date_);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 73 */     return getDescription().toString(OutputContextType.VIEW);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void readObject(ObjectInputStream in) throws IOException {
/* 79 */     this.date_ = DateUtils.getNewDate(in.readLong());
/*    */   }
/*    */ 
/*    */   
/*    */   private void writeObject(ObjectOutputStream out) throws IOException {
/* 84 */     out.writeLong(this.date_.getTime());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\fill\AbsoluteDtvDate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */