package com.movie.app.configs.db;

public class EntityBuider implements IEntityBuider {

    private StringBuilder entitySQL;
    
    private EntityBuider() {
        this.entitySQL = new StringBuilder();
    }

    @Override
    public IEntityBuider name(String name) {
        this.entitySQL
                .append("CREATE TABLE IF NOT EXISTS `")
                .append(name)
                .append("`(");
        return this;
    }
    
    @Override
    public IEntityBuider add(IAttributeEntityBuider attributeEntityBuider, boolean isEndAttribute) {
        this.entitySQL
                .append(attributeEntityBuider.build())
                .append(isEndAttribute ? ");" : ",");
        return this;
    }

    @Override
    public String toString() {
        String sql = this.entitySQL.toString();
        this.entitySQL.setLength(0);
        return sql;
    }
    
    public static IEntityBuider builder() {
        return new EntityBuider();
    }
    
}
