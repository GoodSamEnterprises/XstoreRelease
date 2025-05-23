/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import dtv.event.Event;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.pos.iframework.form.component.IFormComponent;
/*     */ import dtv.xst.dao.crm.IParty;
/*     */ import dtv.xst.dao.trl.IRetailTransaction;
/*     */ import dtv.xst.dao.trn.IPosTransaction;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
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
/*     */ public class FormCustomerDisplayTransactionInformationHeader
/*     */   extends FormInformationPanel
/*     */   implements IFormComponent
/*     */ {
/*  29 */   private static final Image imageHeaderBackground_ = UIRM
/*  30 */     .getImage("_imageCustomerDisplayTransactionHeaderBackground");
/*  31 */   private static final Color imageHeaderBackgroundColor_ = UIRM.getRGBColor("_imageCustomerDisplayTransactionHeaderBackgroundColor", new Color(77, 118, 149));
/*     */   
/*     */   private boolean isCustomerAttached;
/*     */ 
/*     */   
/*  36 */   private EventHandler _customerHandler = new EventHandler()
/*     */     {
/*     */       protected void handle(Event argEvent)
/*     */       {
/*  40 */         IParty customer = (IParty)argEvent.getPayload();
/*  41 */         if (customer == null) {
/*  42 */           FormCustomerDisplayTransactionInformationHeader.this.isCustomerAttached = false;
/*     */         } else {
/*     */           
/*  45 */           FormCustomerDisplayTransactionInformationHeader.this.isCustomerAttached = true;
/*     */         } 
/*  47 */         FormCustomerDisplayTransactionInformationHeader.this.getInformationPanel().repaint();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormCustomerDisplayTransactionInformationHeader() {
/*  57 */     getInformationPanel().setLayout(null);
/*  58 */     this._eventManager.registerEventHandler((IEventAware)this._customerHandler, (IEventSource)new EventDescriptor("PrivilegedEventDescriptor"), IRetailTransaction.SET_CUSTOMERPARTY
/*  59 */         .toConstraint());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected InformationPanel createInformationPanel() {
/*  65 */     return new InformationPanel();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void newTransaction(IPosTransaction argTransaction) {
/*  70 */     if (argTransaction == null) {
/*  71 */       this.isCustomerAttached = false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class InformationPanel
/*     */     extends FormInformationPanel.InformationPanel
/*     */   {
/*     */     private static final long serialVersionUID = 5627341292924615431L;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int offset_;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void paintBackground(Graphics g) {
/*  95 */       super.paintBackground(g);
/*     */       
/*  97 */       if (FormCustomerDisplayTransactionInformationHeader.imageHeaderBackground_ == null) {
/*  98 */         g.setColor(FormCustomerDisplayTransactionInformationHeader.imageHeaderBackgroundColor_);
/*  99 */         g.fillRect(0, 0, getWidth() - 1, getHeight());
/*     */       }
/* 101 */       else if (FormCustomerDisplayTransactionInformationHeader.this.isCustomerAttached) {
/* 102 */         g.setColor(getBackground());
/* 103 */         g.fillRect(0, 0, getWidth() - 1, getHeight());
/*     */       } else {
/*     */         
/* 106 */         g.drawImage(FormCustomerDisplayTransactionInformationHeader.imageHeaderBackground_, this.offset_, this.offset_, getWidth() - 1, getHeight(), null);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormCustomerDisplayTransactionInformationHeader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */