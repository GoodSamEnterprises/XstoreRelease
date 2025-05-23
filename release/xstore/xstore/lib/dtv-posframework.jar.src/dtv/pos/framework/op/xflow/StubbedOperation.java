package dtv.pos.framework.op.xflow;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface StubbedOperation {
  Action[] actions() default {};
  
  boolean addApplicability() default false;
  
  String description();
  
  boolean noCancel() default false;
  
  boolean noComplete() default false;
  
  OpType opType() default OpType.SYSTEM;
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\xflow\StubbedOperation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */