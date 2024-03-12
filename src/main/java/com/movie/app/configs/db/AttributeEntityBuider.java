package com.movie.app.configs.db;

public class AttributeEntityBuider implements IAttributeEntityBuider {

    private StringBuilder attributeEntity;

    private AttributeEntityBuider() {
        this.attributeEntity = new StringBuilder();
    }

    @Override
    public IAttributeEntityBuider type(String type) {
        this.attributeEntity
                .append(" ")
                .append(type);
        return this;
    }

    @Override
    public IAttributeEntityBuider name(String name) {
        this.attributeEntity
                .append(" `")
                .append(name)
                .append("`");
        return this;
    }

    @Override
    public IAttributeEntityBuider nullable(boolean isNullable) {
        this.attributeEntity
                .append(isNullable ? " NULL " : " NOT NULL");
        return this;
    }

    @Override
    public IAttributeEntityBuider primary(boolean isPrimary) {
        this.attributeEntity
                .append(isPrimary ? " PRIMARY KEY" : "");
        return this;
    }

    @Override
    public IAttributeEntityBuider autoIncrement(boolean isAutoIncrement) {
        this.attributeEntity
                .append(isAutoIncrement ? " AUTO_INCREMENT" : "");
        return this;
    }

    @Override
    public IAttributeEntityBuider other(String other) {
        this.attributeEntity
                .append(" ")
                .append(other);
        return this;
    }

    public static IAttributeEntityBuider builder() {
        return new AttributeEntityBuider();
    }

    @Override
    public IAttributeEntityBuider unique(boolean isUnique) {
        this.attributeEntity
                .append(isUnique ? " UNIQUE" : "");
        return this;
    }

    @Override
    public IAttributeEntityBuider foreign(String tableNameForeignKey, String idNameTableForeign, String attributeForeign) {
        this.attributeEntity
                .append("FOREIGN KEY ")
                .append("(")
                .append(attributeForeign)
                .append(") REFERENCES ")
                .append(tableNameForeignKey)
                .append("(")
                .append(idNameTableForeign)
                .append(")");
        return this;
    }

    @Override
    public String build() {
        String attr = this.attributeEntity.toString();
        this.attributeEntity.setLength(0);
        return attr;
    }

}
