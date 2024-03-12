
package com.movie.app.interfaces;

import java.util.List;
import java.util.Optional;

public interface ReaderService<Entity> {
    public Optional<Entity> findById(Long id);
    public List<Entity> find();
}
