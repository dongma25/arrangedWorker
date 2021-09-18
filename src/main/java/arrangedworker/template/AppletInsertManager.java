package arrangedworker.template;

import arrangedworker.bo.InsertContentBo;
import arrangedworker.factory.InsertStrategyEnum;
import arrangedworker.strategy.InsertStrategy;
import arrangedworker.vo.InsertVo;

/**
 * @author dongma
 */
public class AppletInsertManager extends AbstractInsertManager {

    @Override
    public InsertStrategy getStrategy() {
        return InsertStrategyEnum.APPLET;
    }

    @Override
    public void beforeInsert(InsertContentBo insertContentBo) {

    }

    @Override
    public void afterInsert(InsertContentBo insertContentBo) {

    }

    @Override
    public InsertVo getDateVo(InsertContentBo insertContentBo) {
        return null;
    }

}
