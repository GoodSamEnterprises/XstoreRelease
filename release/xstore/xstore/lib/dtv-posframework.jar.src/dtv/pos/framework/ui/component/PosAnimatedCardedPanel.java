/*     */ package dtv.pos.framework.ui.component;
/*     */ 
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.ui.swing.DtvCardedPanel;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.image.BufferedImage;
/*     */ import javax.swing.SwingUtilities;
/*     */ import org.pushingpixels.trident.Timeline;
/*     */ import org.pushingpixels.trident.callback.TimelineCallback;
/*     */ import org.pushingpixels.trident.callback.TimelineCallbackAdapter;
/*     */ import org.pushingpixels.trident.swing.SwingRepaintTimeline;
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
/*     */ 
/*     */ public class PosAnimatedCardedPanel
/*     */   extends DtvCardedPanel
/*     */ {
/*     */   public static final String PAINT_TRANSACTION_IMAGE = "PAINT_TRANSACTION_IMAGE";
/*     */   public static final String TRANSACTION_IMAGE = "TRANSACTION_IMAGE";
/*     */   public static final String CUSTOMER_MAINTENANCE_IMAGE = "CUSTOMER_MAINTENANCE_IMAGE";
/*     */   public static final String ANIMATION_TYPE = "ANIMATION_TYPE";
/*  36 */   private static final int ANIMATION_DURATION = UIResourceManager.getInstance().getInt("_transactionCustomerMaintenanceAnimationDuration");
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   private int animWidth_;
/*     */   
/*     */   private int animHeight_;
/*     */   
/*     */   private Timeline animationTimeline_;
/*     */   
/*     */   public void paint(Graphics g) {
/*  47 */     Boolean paintTransactionImage = (Boolean)getClientProperty("PAINT_TRANSACTION_IMAGE");
/*     */     
/*  49 */     if (paintTransactionImage != null && paintTransactionImage.booleanValue()) {
/*  50 */       Object o = getClientProperty("TRANSACTION_IMAGE");
/*  51 */       if (o != null && o instanceof Image) {
/*  52 */         Image img = (Image)o;
/*  53 */         g.drawImage(img, 0, 0, null);
/*     */       } 
/*     */     } 
/*     */     
/*  57 */     AnimationType type = (AnimationType)getClientProperty("ANIMATION_TYPE");
/*  58 */     BufferedImage image = (BufferedImage)getClientProperty("CUSTOMER_MAINTENANCE_IMAGE");
/*     */     
/*  60 */     if (type != null && image != null) {
/*  61 */       int height = (image.getHeight() > -1) ? image.getHeight() : 0;
/*  62 */       int width = (image.getWidth() > -1) ? image.getWidth() : 0;
/*     */       
/*  64 */       switch (type) {
/*     */         case ZOOM_IN:
/*  66 */           setAnimWidth(0);
/*  67 */           setAnimHeight(0);
/*  68 */           startAnimation(0, width, 0, height);
/*     */           break;
/*     */         
/*     */         case ZOOM_OUT:
/*  72 */           setAnimWidth(width);
/*  73 */           setAnimHeight(height);
/*  74 */           startAnimation(width, 0, height, 0);
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  82 */       g.drawImage(image, width - this.animWidth_, 0, this.animWidth_, this.animHeight_, null);
/*     */     
/*     */     }
/*  85 */     else if (!isAnimating() && ((paintTransactionImage != null && 
/*  86 */       !paintTransactionImage.booleanValue()) || paintTransactionImage == null)) {
/*  87 */       super.paint(g);
/*     */     
/*     */     }
/*  90 */     else if (!isAnimating()) {
/*  91 */       paintChildren(g);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAnimHeight(int height) {
/*  98 */     this.animHeight_ = height;
/*     */   }
/*     */   
/*     */   public void setAnimWidth(int width) {
/* 102 */     this.animWidth_ = width;
/*     */   }
/*     */   
/*     */   protected void animationDone() {
/* 106 */     putClientProperty("PAINT_TRANSACTION_IMAGE", Boolean.valueOf(false));
/* 107 */     putClientProperty("ANIMATION_TYPE", null);
/* 108 */     putClientProperty("CUSTOMER_MAINTENANCE_IMAGE", null);
/*     */   }
/*     */   
/*     */   protected void animationStarted() {
/* 112 */     putClientProperty("ANIMATION_TYPE", AnimationType.ANIMATING);
/*     */   }
/*     */   
/*     */   protected boolean isAnimating() {
/* 116 */     return (getClientProperty("ANIMATION_TYPE") != null && 
/* 117 */       getClientProperty("ANIMATION_TYPE") instanceof AnimationType && AnimationType.ANIMATING
/* 118 */       .equals(getClientProperty("ANIMATION_TYPE")));
/*     */   }
/*     */   
/*     */   protected void startAnimation(int width1, int width2, int height1, int height2) {
/* 122 */     if (isAnimating()) {
/*     */       return;
/*     */     }
/*     */     
/* 126 */     animationStarted();
/* 127 */     SwingUtilities.invokeLater(new Animation(width1, width2, height1, height2));
/*     */   }
/*     */   
/*     */   public class Animation
/*     */     implements Runnable {
/*     */     int width1_;
/*     */     int width2_;
/*     */     
/*     */     public Animation(int width1, int width2, int height1, int height2) {
/* 136 */       this.width1_ = width1;
/* 137 */       this.width2_ = width2;
/* 138 */       this.height1_ = height1;
/* 139 */       this.height2_ = height2;
/*     */     }
/*     */     int height1_;
/*     */     int height2_;
/*     */     
/*     */     public void run() {
/* 145 */       PosAnimatedCardedPanel.this.animationTimeline_ = new Timeline(this);
/* 146 */       PosAnimatedCardedPanel.this.animationTimeline_.addPropertyToInterpolate("animWidth", Integer.valueOf(this.width1_), Integer.valueOf(this.width2_));
/* 147 */       PosAnimatedCardedPanel.this.animationTimeline_.addPropertyToInterpolate("animHeight", Integer.valueOf(this.height1_), Integer.valueOf(this.height2_));
/* 148 */       PosAnimatedCardedPanel.this.animationTimeline_.setDuration(PosAnimatedCardedPanel.ANIMATION_DURATION);
/* 149 */       PosAnimatedCardedPanel.this.animationTimeline_.addCallback((TimelineCallback)new TimelineCallbackAdapter()
/*     */           {
/*     */             
/*     */             public void onTimelineStateChanged(Timeline.TimelineState argOldState, Timeline.TimelineState argNewState, float argDurationFraction, float argTimelinePosition)
/*     */             {
/* 154 */               if (argNewState.equals(Timeline.TimelineState.DONE) && 
/* 155 */                 PosAnimatedCardedPanel.this.animationTimeline_.isDone()) {
/* 156 */                 PosAnimatedCardedPanel.this.animationDone();
/*     */               }
/*     */             }
/*     */           });
/*     */       
/* 161 */       PosAnimatedCardedPanel.this.animationTimeline_.playLoopSkipping(1, Timeline.RepeatBehavior.LOOP, 0L);
/* 162 */       SwingRepaintTimeline repaintTimeline = new SwingRepaintTimeline(PosAnimatedCardedPanel.this.getParent());
/* 163 */       repaintTimeline.setDuration(PosAnimatedCardedPanel.ANIMATION_DURATION);
/* 164 */       repaintTimeline.playLoopSkipping(1, Timeline.RepeatBehavior.LOOP, 0L);
/*     */     }
/*     */     
/*     */     public void setAnimHeight(int height) {
/* 168 */       PosAnimatedCardedPanel.this.setAnimHeight(height);
/*     */     }
/*     */     
/*     */     public void setAnimWidth(int width) {
/* 172 */       PosAnimatedCardedPanel.this.setAnimWidth(width);
/*     */     }
/*     */   }
/*     */   
/*     */   public enum AnimationType
/*     */   {
/* 178 */     ZOOM_IN, ZOOM_OUT, ANIMATING;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\PosAnimatedCardedPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */