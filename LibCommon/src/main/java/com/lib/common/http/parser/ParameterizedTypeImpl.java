package com.lib.common.http.parser;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/**
*作者： 钟雄辉
*时间： 2019/6/24
*描述：
**/
public class ParameterizedTypeImpl implements ParameterizedType {
    private final Class raw;
    private final Type[] args;

    public ParameterizedTypeImpl(Class raw, Type[] args) {
        this.raw = raw;
        this.args = args != null ? args : new Type[0];
    }

    @Override
    public Type[] getActualTypeArguments() {
        return args;
    }

    @Override
    public Type getRawType() {
        return raw;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }
}
