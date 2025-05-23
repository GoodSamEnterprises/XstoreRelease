/*    */ package dtv.data2.access.impl.daogen;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.util.concurrent.Callable;
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
/*    */ public class GenerateModels
/*    */   implements Callable<Void>
/*    */ {
/* 22 */   private static final Logger logger_ = Logger.getLogger(GenerateModels.class);
/*    */   
/*    */   private final DaoGenHelper helper_;
/*    */   
/*    */   GenerateModels(DaoGenHelper argHelper) {
/* 27 */     this.helper_ = argHelper;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Void call() throws IOException {
/* 35 */     logger_.info("Generating model classes");
/*    */     
/* 37 */     for (DtxDefinition dtx : this.helper_.getDtxDefinitions()) {
/* 38 */       if (dtx.needsGeneration(null)) {
/* 39 */         IModelGenerator generator = null;
/*    */ 
/*    */         
/*    */         try {
/* 43 */           Class<? extends IModelGenerator> generatorClass = this.helper_.getPrecompileClassloader().loadClass(dtx.getModelGenerator()).asSubclass(IModelGenerator.class);
/*    */           
/*    */           try {
/* 46 */             Constructor<? extends IModelGenerator> generatorConstructor = generatorClass.getConstructor(new Class[] { DaoGenHelper.class });
/* 47 */             generator = generatorConstructor.newInstance(new Object[] { this.helper_ });
/*    */           }
/* 49 */           catch (NoSuchMethodException ex) {
/* 50 */             generator = generatorClass.newInstance();
/*    */           }
/*    */         
/* 53 */         } catch (ReflectiveOperationException ex) {
/* 54 */           logger_.error("An error occurred instantiating model-generator class [" + dtx.getModelGenerator() + "]. Falling back to use the default.", ex);
/*    */           
/* 56 */           generator = new DefaultModelGenerator(this.helper_);
/*    */         } 
/*    */         
/* 59 */         String result = generator.generateModel(dtx);
/* 60 */         File f = new File(this.helper_.getOutPath() + this.helper_.getFilePath(dtx) + dtx.getName() + "Model.java");
/* 61 */         this.helper_.getWriter().write(f, result);
/*    */       } 
/*    */     } 
/*    */     
/* 65 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\GenerateModels.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */