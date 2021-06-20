package dev.neuroteam.ecs.Engine;

import dev.neuroteam.ecs.Family.Family;
import dev.neuroteam.ecs.System.System;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

//Simple engine implementation
public class PlainEngine implements Engine {

    List<System> systems = new CopyOnWriteArrayList<>();
    boolean resortRequired = true;

    @Override
    synchronized public void add(System system) {
        resortRequired = true;
        system.addedToEngine(this);
    }


    @Override
    synchronized public void remove(System system) {
        system.removedFromEngine(this);
        systems.remove(system);
    }

    @Override
    public void removeAll(Family family) {

    }

    @Override
    public boolean has(System system) {
        return systems.contains(system);
    }

    @Override
    public List<System> list() {
        return systems;
    }

    @Override
    public Collection<System> list(Family family) {
        return null;
    }

    synchronized public void resort() {
        systems.sort(Comparator.comparing(System::getPriority));
    }

    @Override
    synchronized public void update(double delta) {
        if (resortRequired) resort();

        ListIterator<System> iter = systems.listIterator();
        while (iter.hasNext()) {
            iter.next().update(delta);
        }
    }

    @Override
    public void clear() {
        systems.clear();
    }
}
