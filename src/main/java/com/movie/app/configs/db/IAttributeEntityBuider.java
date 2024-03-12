package com.movie.app.configs.db;

public interface IAttributeEntityBuider {

    public IAttributeEntityBuider name(String name);

    public IAttributeEntityBuider type(String type);

    public IAttributeEntityBuider nullable(boolean isNullable);

    public IAttributeEntityBuider primary(boolean isPrimary);

    public IAttributeEntityBuider autoIncrement(boolean isAutoIncrement);

    public IAttributeEntityBuider unique(boolean isUnique);

    public IAttributeEntityBuider other(String other);

    public IAttributeEntityBuider foreign(String tableNameForeignKey, String idNameTableForeign,String attributeForeign);

    public String build();
}
