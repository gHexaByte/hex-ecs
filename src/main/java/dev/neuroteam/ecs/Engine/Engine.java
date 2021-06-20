package dev.neuroteam.ecs.Engine;

import dev.neuroteam.ecs.Family.Family;
import dev.neuroteam.ecs.System.System;

import java.util.Collection;

public interface Engine {

    void add(System system);

    void remove(System system);

    void removeAll(Family family);

    boolean has(System system);

    Collection<System> list();

    Collection<System> list(Family family);

    void update(double delta);

    void clear();
}
