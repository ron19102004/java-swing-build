package com.movie.app.interfaces;

public interface UpdateService<Entity, Dto> {

    public Entity update(Dto dto);
}
