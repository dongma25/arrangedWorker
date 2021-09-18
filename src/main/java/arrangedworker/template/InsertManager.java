package arrangedworker.template;

import arrangedworker.InsertPoTranFunction;
import arrangedworker.bo.InsertContentBo;
import arrangedworker.po.InsertPo;
import arrangedworker.vo.InsertVo;

/**
 * @author dongma
 */
public interface InsertManager {

    InsertVo insert(InsertContentBo insertContentBo);

    InsertVo insert(InsertPo insertPo, InsertPoTranFunction insertPoTranFunction);

}
