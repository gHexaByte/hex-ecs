package dev.neuroteam.ecs.System;

import dev.neuroteam.ecs.Engine.Engine;
import dev.neuroteam.ecs.Entity.Entity;
import dev.neuroteam.ecs.Family.Family;

import java.util.HashSet;
import java.util.Set;

// Family based system
public class FamilySystem implements System{

    final Family family;
    int priority;

    Set<Entity> entitySet = new HashSet<>();


    FamilySystem(Family family){
        this.family = family;
    }
    FamilySystem(Family family, int priority){
        this.family = family;
        this.priority = priority;
    }



    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public Family getFamily() {
        return null;
    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void entityAdded(Entity entity, Engine engine) {

    }

    @Override
    public void entityRemoved(Entity entity, Engine engine) {

    }

    @Override
    public void addedToEngine(Engine engine) {

    }

    @Override
    public void removedFromEngine(Engine engine) {

    }
}
