
package com.movie.app.interfaces;

public interface CreateService<Entity,Dto> {
    public Entity save(Dto Dto);
}
