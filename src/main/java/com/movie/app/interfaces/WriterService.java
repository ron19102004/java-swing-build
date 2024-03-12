package com.movie.app.interfaces;

public interface WriterService<Entity, CreateDto, UpdateDto>
        extends CreateService<Entity, CreateDto>, UpdateService<Entity, UpdateDto>, RemoveService {
}
