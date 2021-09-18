package arrangedworker.holder;

import arrangedworker.bo.InsertContentBo;
import org.springframework.stereotype.Component;

/**
 * @author dongma
 */
@Component
public class BusinessCheckTwoHolder extends AbstractInsertHolder{

    @Override
    public int weight() {
        return 20;
    }

    @Override
    public void handle(InsertContentBo insertContentBo) {

    }

}
