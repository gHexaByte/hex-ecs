package dev.neuroteam.ecs.Family;

import dev.neuroteam.ecs.Component;
import dev.neuroteam.ecs.Entity.Entity;

import java.util.Collections;
import java.util.Set;

public class FamilyPlain implements Family {

    final Set<Class<? extends Component>> allOf;
    final Set<Class<? extends Component>> oneOf;
    final Set<Class<? extends Component>> exclude;


    FamilyPlain(Set<Class<? extends Component>> allOf, Set<Class<? extends Component>> oneOf, Set<Class<? extends Component>> exclude) {
        if (allOf != null) {
            this.allOf = Collections.unmodifiableSet(allOf);
        } else {
            this.allOf = Collections.emptySet();
        }
        if (oneOf != null) {
            this.oneOf = Collections.unmodifiableSet(oneOf);
        } else {
            this.oneOf = Collections.emptySet();
        }
        if (exclude != null) {
            this.exclude = Collections.unmodifiableSet(exclude);
        } else {
            this.exclude = Collections.emptySet();
        }
    }

    @Override
    public boolean matches(Entity entity) {
        if (allOf != null) {
            boolean matches = true;
            for (Class<? extends Component> clazz : allOf) {
                if (!entity.has(clazz)) {
                    matches = false;
                }
            }
            if (!matches) return false;
        }
        if (oneOf != null && !oneOf.isEmpty()) {
            boolean found = false;
            for (Class<? extends Component> clazz : oneOf) {
                if (entity.has(clazz)) {
                    found = true;
                }
            }
            if (!found) return false;
        }
        if (exclude != null) {
            for (Class<? extends Component> clazz : exclude) {
                if (entity.has(clazz)) {
                    return false;
                }
            }
        }
        return true;
    }
}
