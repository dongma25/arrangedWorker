package arrangedworker.strategy;

import java.util.List;

/**
 * @author dongma
 */
public interface InsertStrategy {

    /**
     * 获取权重
     *
     * @return
     */
    List<Integer> getWeight();

}
