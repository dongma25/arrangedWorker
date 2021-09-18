package arrangedworker;


import arrangedworker.bo.InsertContentBo;
import arrangedworker.po.InsertPo;

/**
 * @author edy
 */
@FunctionalInterface
public interface InsertPoTranFunction {

    InsertContentBo tran(InsertPo insertPo);

}
