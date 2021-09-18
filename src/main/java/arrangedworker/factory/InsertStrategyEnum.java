package arrangedworker.factory;


import arrangedworker.strategy.InsertStrategy;

import java.util.Arrays;
import java.util.List;

/**
 * @author dongma
 */

public enum InsertStrategyEnum implements InsertStrategy {
    /**
     *
     */
    DEFAULT {
        @Override
        public List<Integer> getWeight() {
            return Arrays.asList(10, 20, 30);
        }
    },

    APPLET {
        @Override
        public List<Integer> getWeight() {
            return Arrays.asList(10, 30);
        }
    };

    @Override
    public abstract List<Integer> getWeight();
}
