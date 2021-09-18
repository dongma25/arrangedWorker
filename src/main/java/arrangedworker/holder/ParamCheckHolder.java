package arrangedworker.holder;

import arrangedworker.bo.InsertContentBo;
import org.springframework.stereotype.Component;

/**
 * @author dongma
 */
@Component
public class ParamCheckHolder extends AbstractInsertHolder{
    @Override
    public void handle(InsertContentBo insertContentBo) {

    }

    @Override
    public int weight() {
        return 10;
    }
}
