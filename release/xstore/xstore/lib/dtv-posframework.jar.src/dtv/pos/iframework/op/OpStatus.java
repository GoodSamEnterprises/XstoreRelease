/*     */ package dtv.pos.iframework.op;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.apache.commons.lang3.builder.EqualsBuilder;
/*     */ import org.apache.commons.lang3.builder.HashCodeBuilder;
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
/*     */ public final class OpStatus
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 8858790597608520209L;
/*     */   private static final int ERROR_INT = 1;
/*     */   private static final int COMPLETE_INT = 2;
/*     */   private static final int INCOMPLETE_INT = 3;
/*     */   private static final int BREAKPOINT_FOUND_INT = 4;
/*     */   private static final int CHAIN_COMPLETE_INT = 5;
/*  31 */   public static final OpStatus ERROR = new OpStatus(1, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  37 */   public static final OpStatus ERROR_HALT = new OpStatus(1, true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  44 */   public static final OpStatus COMPLETE = new OpStatus(2, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  51 */   public static final OpStatus CHAIN_COMPLETE = new OpStatus(5, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   public static final OpStatus COMPLETE_HALT = new OpStatus(2, true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  67 */   public static final OpStatus INCOMPLETE = new OpStatus(3, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  76 */   public static final OpStatus INCOMPLETE_HALT = new OpStatus(3, true);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  81 */   public static final OpStatus BREAKPOINT_FOUND = new OpStatus(4, false);
/*     */   
/*     */   private final String status_;
/*     */   
/*     */   private final int intStatus_;
/*     */   
/*     */   private final boolean pauseChain_;
/*     */   
/*     */   public static OpStatus createHaltVariant(OpStatus status) {
/*  90 */     switch (status.intStatus_) {
/*     */       case 4:
/*  92 */         return status;
/*     */       case 5:
/*  94 */         return status;
/*     */       case 1:
/*  96 */         return ERROR_HALT;
/*     */       case 2:
/*  98 */         return COMPLETE_HALT;
/*     */     } 
/*     */     
/* 101 */     return INCOMPLETE_HALT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 110 */   private String toString_ = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private OpStatus(int argStatus, boolean pauseChain) {
/* 119 */     this.intStatus_ = argStatus;
/* 120 */     switch (argStatus) {
/*     */       case 4:
/* 122 */         this.status_ = "BREAKPOINT_FOUND";
/*     */         break;
/*     */       case 5:
/* 125 */         this.status_ = "CHAIN_COMPLETE";
/*     */         break;
/*     */       case 1:
/* 128 */         this.status_ = "ERROR";
/*     */         break;
/*     */       case 2:
/* 131 */         this.status_ = "COMPLETE";
/*     */         break;
/*     */       
/*     */       default:
/* 135 */         this.status_ = "INCOMPLETE";
/*     */         break;
/*     */     } 
/* 138 */     this.pauseChain_ = pauseChain;
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
/*     */   public boolean equals(Object argObject) {
/* 151 */     if (this == argObject) {
/* 152 */       return true;
/*     */     }
/*     */     
/* 155 */     if (!(argObject instanceof OpStatus)) {
/* 156 */       return false;
/*     */     }
/*     */     
/* 159 */     OpStatus other = (OpStatus)argObject;
/*     */     
/* 161 */     return (new EqualsBuilder()).append(this.intStatus_, other.intStatus_)
/* 162 */       .append(getPauseChain(), other.getPauseChain()).isEquals();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getPauseChain() {
/* 170 */     return this.pauseChain_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 176 */     return (new HashCodeBuilder()).append(this.intStatus_).toHashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreakpointFound() {
/* 184 */     return (this.intStatus_ == BREAKPOINT_FOUND.intStatus_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isComplete() {
/* 192 */     return (this.intStatus_ == COMPLETE.intStatus_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isError() {
/* 200 */     return (this.intStatus_ == ERROR.intStatus_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isIncomplete() {
/* 208 */     return (this.intStatus_ == INCOMPLETE.intStatus_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 217 */     if (this.toString_ == null) {
/* 218 */       this.toString_ = this.pauseChain_ ? (this.status_ + " (halt)") : this.status_;
/*     */     }
/* 220 */     return this.toString_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\op\OpStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */