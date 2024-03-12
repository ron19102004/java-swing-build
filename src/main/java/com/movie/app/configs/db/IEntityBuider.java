

package com.movie.app.configs.db;

public interface IEntityBuider {
    public IEntityBuider name(String name);
    public IEntityBuider add(IAttributeEntityBuider attributeEntityBuider, boolean isEndAttribute);
}
