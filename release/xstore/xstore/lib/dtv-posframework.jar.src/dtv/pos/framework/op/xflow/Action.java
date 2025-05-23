package dtv.pos.framework.op.xflow;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
  String key() default "ACCEPT";
  
  String label();
  
  StubOpStatus opStatus() default StubOpStatus.COMPLETE;
  
  ResponseType responseType();
  
  String scopedValue() default "";
  
  boolean scopedValueIsNull() default false;
  
  String valueKey() default "";
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\xflow\Action.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */