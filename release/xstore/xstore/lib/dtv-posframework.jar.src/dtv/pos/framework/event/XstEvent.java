/*     */ package dtv.pos.framework.event;
/*     */ 
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.event.IXstEventType;
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
/*     */ 
/*     */ public class XstEvent
/*     */   implements IXstEvent
/*     */ {
/*     */   private String name_;
/*     */   private IXstEventType type_;
/*     */   private Object[] data_;
/*     */   private Object source_;
/*     */   
/*     */   public XstEvent(IXstEventType argEventType) {
/*  29 */     this(argEventType, null, null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XstEvent(IXstEventType argEventType, Object argEventData) {
/*  39 */     this(argEventType, argEventData, null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XstEvent(IXstEventType argEventType, Object argEventData, Object argSource) {
/*  51 */     this(argEventType, argEventData, null, argSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XstEvent(IXstEventType argEventType, Object argEventData, String argEventName) {
/*  63 */     this(argEventType, argEventData, argEventName, null);
/*     */   }
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
/*     */   public XstEvent(IXstEventType argEventType, Object argEventData, String argEventName, Object argSource) {
/*  77 */     this.data_ = new Object[1];
/*  78 */     setSource(argSource);
/*  79 */     setType(argEventType);
/*  80 */     setName(argEventName);
/*  81 */     setData(argEventData);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getData() {
/*  91 */     return this.data_[0];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] getDataSet() {
/* 100 */     return this.data_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 110 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getSource() {
/* 119 */     return this.source_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringData() {
/* 128 */     if (getData() == null) {
/* 129 */       return "";
/*     */     }
/*     */     
/* 132 */     return getData().toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstEventType getType() {
/* 142 */     return this.type_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setData(Object argData) {
/* 151 */     if (argData instanceof Object[]) {
/* 152 */       this.data_ = (Object[])argData;
/*     */     } else {
/*     */       
/* 155 */       this.data_ = new Object[1];
/* 156 */       this.data_[0] = argData;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setSource(Object argSource) {
/* 165 */     this.source_ = argSource;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setName(String argName) {
/* 173 */     this.name_ = argName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setType(IXstEventType argType) {
/* 181 */     this.type_ = argType;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\event\XstEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */