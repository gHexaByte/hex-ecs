package dev.neuroteam.ecs.Family;

import dev.neuroteam.ecs.Entity.Entity;

public interface Family {
    boolean matches(Entity entity);
}
