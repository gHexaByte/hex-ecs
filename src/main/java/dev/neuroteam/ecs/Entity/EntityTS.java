package dev.neuroteam.ecs.Entity;

import dev.neuroteam.ecs.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EntityTS implements Entity {

    final Map<Class<? extends Component>, Component> components = new ConcurrentHashMap<>();


    @Override
    public void add(Component component) {
        components.put(component.getClass(), component);

    }

    @Override
    public void remove(Class<? extends Component> componentClass) {
        components.remove(componentClass);
    }

    @Override
    public boolean has(Class<? extends Component> componentClass) {
        return components.containsKey(componentClass);
    }

    @Override
    public <T extends Component> T get(Class<T> componentClass) {
        return (T) components.get(componentClass);
    }

    @Override
    public void clear() {
        components.clear();
    }


}
