package arrangedworker;

import arrangedworker.bo.InsertContentBo;
import arrangedworker.po.MultipleInsertPo;
import arrangedworker.po.SingleInsertPo;
import arrangedworker.template.AppletInsertManager;

/**
 * @author dongma
 */
public class InsertMain {

    public static void main(String[] arg) {

        new AppletInsertManager().insert(new SingleInsertPo(),
                insertPo -> {
                    if (insertPo instanceof SingleInsertPo) {
                        SingleInsertPo po = (SingleInsertPo) insertPo;
                        MultipleInsertPo multipleInsertPo = new MultipleInsertPo();
                        multipleInsertPo.setArrangedTimeId(po.getArrangedTimeId());
                        InsertContentBo insertContentBo = new InsertContentBo();
                        insertContentBo.setMultipleInsertPo(multipleInsertPo);
                        return insertContentBo;
                    }
                    return null;
                });

    }

}
