package arrangedworker.holder;


import arrangedworker.bo.InsertContentBo;

/**
 * @author dongma
 */
public interface InsertHolder {

    void handle(InsertContentBo insertContentBo);

    int weight();

}
