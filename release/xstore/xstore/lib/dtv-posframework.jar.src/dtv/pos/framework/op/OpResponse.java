/*     */ package dtv.pos.framework.op;
/*     */ 
/*     */ import dtv.pos.iframework.op.IOpResponse;
/*     */ import dtv.pos.iframework.op.OpStatus;
/*     */ import dtv.pos.iframework.op.req.IOpRequest;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OpResponse
/*     */   implements IOpResponse
/*     */ {
/*  21 */   protected static final List<IOpRequest> NO_REQUESTS = new ArrayList<>();
/*     */ 
/*     */ 
/*     */   
/*     */   protected final List<IOpRequest> requests_;
/*     */ 
/*     */   
/*     */   protected final OpStatus status_;
/*     */ 
/*     */ 
/*     */   
/*     */   OpResponse(OpStatus argStatus, IOpRequest... argReq) {
/*  33 */     if (argStatus == null) {
/*  34 */       throw new IllegalArgumentException("You cannot instantiate an OpResponse with a null OpStatus.");
/*     */     }
/*     */     
/*  37 */     this.status_ = argStatus;
/*     */     
/*  39 */     if (argReq == null) {
/*  40 */       this.requests_ = NO_REQUESTS;
/*     */     } else {
/*     */       
/*  43 */       this.requests_ = new ArrayList<>(Arrays.asList(argReq));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendOpRequest(IOpRequest argReq) {
/*  49 */     this.requests_.add(argReq);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse derive(OpStatus argStatus) {
/*  55 */     if (this.status_.getPauseChain() && 
/*  56 */       !argStatus.getPauseChain()) {
/*  57 */       throw new IllegalArgumentException("cannot change from a paused status to a non-paused status");
/*     */     }
/*     */ 
/*     */     
/*  61 */     return new OpResponse(argStatus, this.requests_.<IOpRequest>toArray(new IOpRequest[0]));
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
/*     */   public List<IOpRequest> getOpRequests() {
/*  73 */     return this.requests_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public OpStatus getOpStatus() {
/*  79 */     return this.status_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasRequests() {
/*  85 */     return !this.requests_.isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void insertOpRequest(IOpRequest argReq) {
/*  90 */     this.requests_.add(0, argReq);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder s = new StringBuilder(80);
/*  97 */     s.append(this.status_.toString());
/*     */     
/*  99 */     for (IOpRequest req : this.requests_) {
/* 100 */       s.append(":");
/* 101 */       s.append(req.toString());
/*     */     } 
/*     */     
/* 104 */     return s.toString();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\OpResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */