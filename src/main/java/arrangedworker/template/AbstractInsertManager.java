package arrangedworker.template;

import arrangedworker.InsertPoTranFunction;
import arrangedworker.bo.InsertContentBo;
import arrangedworker.holder.InsertHolderChain;
import arrangedworker.po.InsertPo;
import arrangedworker.strategy.InsertStrategy;
import arrangedworker.vo.InsertVo;
import arrangedworker.wrapper.MdcThreadPoolExecutor;

import javax.annotation.Resource;
import java.util.concurrent.*;

/**
 * @author dongma
 */
public abstract class AbstractInsertManager implements InsertManager {

    private static final Executor LOG_RECORD_EXECUTOR = new MdcThreadPoolExecutor(new ThreadPoolExecutor(
            20,
            50,
            3000,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1000),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()));

    @Resource
    public InsertHolderChain insertHolderChain;

    public abstract InsertStrategy getStrategy();

    public abstract void beforeInsert(InsertContentBo insertContentBo);

    public abstract void afterInsert(InsertContentBo insertContentBo);

    public abstract InsertVo getDateVo(InsertContentBo insertContentBo);

    private void doInsertHolderChain(InsertContentBo insertContentBo) {
        insertContentBo.setInsertStrategy(getStrategy());
        insertHolderChain.handle(insertContentBo);
    }

    private void doInsert(InsertContentBo insertContentBo) {

    }

    @Override
    public final InsertVo insert(InsertContentBo insertContentBo) {
        doInsertHolderChain(insertContentBo);

        beforeInsert(insertContentBo);

        doInsert(insertContentBo);

        afterInsert(insertContentBo);

        return getDateVo(insertContentBo);
    }

    @Override
    public final InsertVo insert(InsertPo insertPo, InsertPoTranFunction insertPoTranFunction) {
        InsertContentBo insertContentBo = insertPoTranFunction.tran(insertPo);
        return insert(insertContentBo);
    }

}
