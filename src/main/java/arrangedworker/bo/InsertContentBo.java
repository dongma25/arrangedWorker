package arrangedworker.bo;


import arrangedworker.po.MultipleInsertPo;
import arrangedworker.strategy.InsertStrategy;
import lombok.Data;

/**
 * @author dongma
 */
@Data
public class InsertContentBo {

    public MultipleInsertPo multipleInsertPo;

    public InsertStrategy insertStrategy;

}
