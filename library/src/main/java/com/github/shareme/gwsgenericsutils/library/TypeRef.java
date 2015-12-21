package com.github.shareme.gwsgenericsutils.library;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Borrowed from EffectiveJava, Reloaded..idea is from Neal Gafter
 *
 * Used for Strings and Integer Generics as they have the same object signature
 * due to type erasure.
 *
 *
 * Created by fgrott on 12/21/2015.
 */
@SuppressWarnings("unused")
public abstract class TypeRef<T> {

    private final Type type;

    protected TypeRef(){
        ParameterizedType superclass = (ParameterizedType)getClass().getGenericSuperclass();
        type = superclass.getActualTypeArguments()[0];
    }

    @Override
    public boolean equals (Object o){
        return o instanceof  TypeRef && ((TypeRef)o).type.equals(type);
    }

    @Override
    public int hashCode(){
        return type.hashCode();
    }
}
