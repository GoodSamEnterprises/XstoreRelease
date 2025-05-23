/*     */ package dtv.pos.framework.biometric.fingerprint;
/*     */ 
/*     */ import dtv.util.ImageUtils;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Image;
/*     */ import java.awt.image.BufferedImage;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FingerprintHandDisplay
/*     */   extends JLabel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final int FINGER_COUNT = 10;
/*     */   private final Image handsImage;
/*     */   private final Image[] fingerImages;
/*     */   private final Image[] selectImages;
/*     */   private final Image[] enrollImages;
/*     */   private final int width;
/*     */   private final int height;
/*  30 */   private final boolean[] showFinger = new boolean[10];
/*  31 */   private int selectedFinger = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FingerprintHandDisplay() {
/*  38 */     this.handsImage = ImageUtils.getImage("classpath:graphics/bio/palms.png");
/*     */     
/*  40 */     this.fingerImages = new Image[10];
/*  41 */     this.selectImages = new Image[10];
/*  42 */     this.enrollImages = new Image[10];
/*  43 */     for (int i = 0; i < 10; i++) {
/*  44 */       this.fingerImages[i] = ImageUtils.getImage("classpath:graphics/bio/finger_" + i + ".png");
/*  45 */       this.selectImages[i] = ImageUtils.getImage("classpath:graphics/bio/finger_selected_" + i + ".png");
/*  46 */       this.enrollImages[i] = ImageUtils.getImage("classpath:graphics/bio/finger_enrolled_" + i + ".png");
/*     */     } 
/*     */ 
/*     */     
/*  50 */     this.width = this.handsImage.getWidth(null);
/*  51 */     this.height = this.handsImage.getHeight(null);
/*  52 */     Dimension size = new Dimension(this.width, this.height);
/*     */ 
/*     */     
/*  55 */     setMinimumSize(size);
/*  56 */     setMaximumSize(size);
/*  57 */     setPreferredSize(size);
/*     */     
/*  59 */     updateIcon();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSelectedFinger() {
/*  68 */     return this.selectedFinger;
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
/*     */   public boolean getShowFinger(int argIndex) {
/*  80 */     return this.showFinger[argIndex];
/*     */   }
/*     */   
/*     */   public void setSelectedFinger(FingerEnum newValue) {
/*  84 */     setSelectedFinger((newValue == null) ? -1 : newValue.getSortOrder());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSelectedFinger(int argValue) {
/*  93 */     int value = (argValue < 0 || argValue >= 10) ? -1 : argValue;
/*  94 */     if (value != this.selectedFinger) {
/*  95 */       this.selectedFinger = value;
/*  96 */       updateIcon();
/*     */     } 
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
/*     */   public void setShowFinger(int argIndex, boolean newValue) {
/* 109 */     if (this.showFinger[argIndex] != newValue) {
/* 110 */       this.showFinger[argIndex] = newValue;
/* 111 */       updateIcon();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void updateIcon() {
/* 117 */     BufferedImage buffImg = new BufferedImage(this.width, this.height, 2);
/* 118 */     Graphics2D g = buffImg.createGraphics();
/*     */ 
/*     */     
/* 121 */     g.drawImage(this.handsImage, 0, 0, this.width, this.height, null);
/*     */ 
/*     */     
/* 124 */     for (int i = 0; i < 10; i++) {
/* 125 */       if (i == this.selectedFinger) {
/* 126 */         g.drawImage(this.selectImages[i], 0, 0, this.width, this.height, null);
/*     */       }
/* 128 */       else if (this.showFinger[i]) {
/* 129 */         g.drawImage(this.enrollImages[i], 0, 0, this.width, this.height, null);
/*     */       } else {
/*     */         
/* 132 */         g.drawImage(this.fingerImages[i], 0, 0, this.width, this.height, null);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 137 */     setIcon(new ImageIcon(buffImg));
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\biometric\fingerprint\FingerprintHandDisplay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */