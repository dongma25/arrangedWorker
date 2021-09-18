package arrangedworker.holder;

import arrangedworker.bo.InsertContentBo;
import org.springframework.stereotype.Component;

/**
 * @author dongma
 */
@Component
public class BusinessCheckOneHolder extends AbstractInsertHolder{
    @Override
    public void handle(InsertContentBo insertContentBo) {

    }

    @Override
    public int weight() {
        return 30;
    }
}
