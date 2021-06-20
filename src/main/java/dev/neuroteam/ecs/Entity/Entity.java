package dev.neuroteam.ecs.Entity;

import dev.neuroteam.ecs.Component;

public interface Entity {
    void add(Component component);

    void remove(Class<? extends Component> componentClass);

    boolean has(Class<? extends Component> componentClass);

    <T extends Component> T get(Class<T> componentClass);

    void clear();
}
