package arrangedworker.holder;

import arrangedworker.bo.InsertContentBo;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author dongma
 */
@Component
public class InsertHolderChain implements ApplicationContextAware {

    private final List<InsertHolder> chain = new ArrayList<>(10);

    public void handle(InsertContentBo insertContentBo) {
        if (insertContentBo.getInsertStrategy() == null || ObjectUtils.isEmpty(insertContentBo.getInsertStrategy().getWeight())) {
            return;
        }
        for (InsertHolder insertHolder : chain) {
            if (insertContentBo.getInsertStrategy().getWeight().contains(insertHolder.weight())) {
                insertHolder.handle(insertContentBo);
            }
        }
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        Map<String, InsertHolder> beans = applicationContext.getBeansOfType(InsertHolder.class);
        chain.addAll(beans.values());
        chain.sort(Comparator.comparingInt(InsertHolder::weight));
    }

}
