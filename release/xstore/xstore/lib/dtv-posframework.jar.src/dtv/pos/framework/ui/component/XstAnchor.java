/*    */ package dtv.pos.framework.ui.component;
/*    */ 
/*    */ import dtv.i18n.OutputContextType;
/*    */ import dtv.pos.framework.action.IXstActionFactory;
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.action.IXstAction;
/*    */ import dtv.pos.iframework.event.IXstEvent;
/*    */ import dtv.pos.iframework.ui.IXstViewComponent;
/*    */ import dtv.pos.ui.component.PosLabel;
/*    */ import dtv.util.MutableString;
/*    */ import dtv.util.config.BooleanConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.ParameterConfig;
/*    */ import dtv.util.config.StringConfig;
/*    */ import dtv.util.temp.InjectionHammer;
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ import javax.inject.Inject;
/*    */ import javax.inject.Provider;
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
/*    */ public class XstAnchor
/*    */   implements IXstViewComponent
/*    */ {
/*    */   @Inject
/*    */   private IXstActionFactory _actionFactory;
/*    */   @Inject
/*    */   private Provider<IModeController> _modeProvider;
/*    */   private PosLabel _anchor;
/*    */   private String _anchorValue;
/*    */   
/*    */   public XstAnchor() {
/* 42 */     InjectionHammer.forceAtInjectProcessing(this);
/* 43 */     final IXstAction action = this._actionFactory.getAction("BROWSER::FROM_FORM");
/*    */     
/* 45 */     this._anchor = new PosLabel(new MutableString(action.getActionName().toString(OutputContextType.VIEW)));
/* 46 */     this._anchor.addMouseListener(new MouseListener()
/*    */         {
/*    */           
/*    */           public void mouseClicked(MouseEvent argE)
/*    */           {
/* 51 */             StringConfig embedKey = new StringConfig("isEmbedded");
/* 52 */             BooleanConfig embedValue = new BooleanConfig(true);
/* 53 */             ParameterConfig embedParam = new ParameterConfig(embedKey, (IConfigObject)embedValue);
/* 54 */             action.getParameters().add(embedParam);
/*    */             
/* 56 */             StringConfig urlKey = new StringConfig("url");
/* 57 */             StringConfig urlValue = new StringConfig(XstAnchor.this._anchorValue);
/* 58 */             ParameterConfig urlParam = new ParameterConfig(urlKey, (IConfigObject)urlValue);
/* 59 */             action.getParameters().add(urlParam);
/*    */             
/* 61 */             ((IModeController)XstAnchor.this._modeProvider.get()).getEventRouter().fireEvent((IXstEvent)action);
/*    */           }
/*    */ 
/*    */           
/*    */           public void mouseEntered(MouseEvent argE) {}
/*    */ 
/*    */           
/*    */           public void mouseExited(MouseEvent argE) {}
/*    */ 
/*    */           
/*    */           public void mousePressed(MouseEvent argE) {}
/*    */ 
/*    */           
/*    */           public void mouseReleased(MouseEvent argE) {}
/*    */         });
/*    */   }
/*    */   
/*    */   public PosLabel getAnchor() {
/* 79 */     return this._anchor;
/*    */   }
/*    */ 
/*    */   
/*    */   public JComponent getDisplayComponent() {
/* 84 */     return (JComponent)getAnchor();
/*    */   }
/*    */ 
/*    */   
/*    */   public JComponent getFocusComponent() {
/* 89 */     return (JComponent)getAnchor();
/*    */   }
/*    */   
/*    */   public void setAnchorValue(String argAnchorValue) {
/* 93 */     this._anchorValue = argAnchorValue;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\XstAnchor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */