/*    */ package dtv.pos.framework.ui.vk;
/*    */ 
/*    */ import dtv.hardware.audio.AudioMgr;
/*    */ import dtv.pos.common.ConfigurationMgr;
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ import org.apache.log4j.Logger;
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
/*    */ public class KeyClickListener
/*    */   implements MouseListener
/*    */ {
/* 23 */   private static final Logger _logger = Logger.getLogger(KeyClickListener.class);
/* 24 */   private static final KeyClickListener INSTANCE = new KeyClickListener();
/*    */ 
/*    */   
/*    */   private final String _keyClickTone;
/*    */ 
/*    */ 
/*    */   
/*    */   public static KeyClickListener getInstance() {
/* 32 */     return INSTANCE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private KeyClickListener() {
/* 39 */     int frequency = ConfigurationMgr.getOnScreenKeyboardKeyClickFreqency();
/* 40 */     int volume = ConfigurationMgr.getOnScreenKeyboardKeyClickVolume();
/* 41 */     int duration = ConfigurationMgr.getOnScreenKeyboardKeyClickDuration();
/* 42 */     if (frequency < 0 || frequency > 20000) {
/* 43 */       _logger.warn("Invalid key click frequency of " + frequency + " was provided.  Defaulting to 1300Hz.");
/* 44 */       frequency = 1300;
/*    */     } 
/* 46 */     if (volume < 0 || volume > 100) {
/* 47 */       _logger.warn("Invalid key click volume of " + volume + " was provided.  Defaulting to 20%.");
/* 48 */       volume = 20;
/*    */     } 
/* 50 */     if (duration < 0 || duration > 100) {
/* 51 */       _logger.warn("Invalid key click duration of " + duration + " was provided.  Defaulting to 15ms.");
/* 52 */       duration = 15;
/*    */     } 
/* 54 */     float amplitude = volume / 100.0F;
/*    */     
/* 56 */     this._keyClickTone = String.format("*,SINE,41000.0,%d,%.2f,%d,*,SINE,41000.0,750,0.0,15", new Object[] { Integer.valueOf(frequency), Float.valueOf(amplitude), Integer.valueOf(duration) });
/*    */   }
/*    */ 
/*    */   
/*    */   public void mouseClicked(MouseEvent argE) {}
/*    */ 
/*    */   
/*    */   public void mousePressed(MouseEvent argE) {
/* 64 */     AudioMgr.playAsync(this._keyClickTone);
/*    */   }
/*    */   
/*    */   public void mouseReleased(MouseEvent argE) {}
/*    */   
/*    */   public void mouseEntered(MouseEvent argE) {}
/*    */   
/*    */   public void mouseExited(MouseEvent argE) {}
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\vk\KeyClickListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */