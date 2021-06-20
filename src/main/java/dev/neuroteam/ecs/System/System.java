package dev.neuroteam.ecs.System;

import dev.neuroteam.ecs.Engine.Engine;
import dev.neuroteam.ecs.Entity.Entity;
import dev.neuroteam.ecs.Family.Family;

import java.util.Set;

public interface System {

    int getPriority();
    Family getFamily();

    void update(double delta);

    void entityAdded(Entity entity, Engine engine);
    void entityRemoved(Entity entity, Engine engine);

    void addedToEngine(Engine engine);
    void removedFromEngine(Engine engine);
}
