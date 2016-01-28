package com.letv.ugc.annotation;



import java.lang.annotation.*;

/**
 * Created by qiyongpeng on 2016/1/4.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Inherited
public @interface NullParamValidation {
    int[] ignoreFieldIndices() default {};
    String[] allFieldNames() default{};
}

