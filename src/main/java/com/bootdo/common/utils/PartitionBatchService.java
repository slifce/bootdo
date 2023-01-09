import com.google.common.collect.Lists;

import java.util.List;

/**
 * 分批操作数据库
 */
public class PartitionBatchService {

    public static void main(String[] args) {
        List<OrgInfo> OrgBaseTreeVOTotals = getOrgBaseTreeVOs();
        List<List<OrgInfo>> OrgBaseTreeVOsPartition = Lists.partition(OrgBaseTreeVOTotals, 1000);
        for (List<OrgInfo> OrgBaseTreeVOs : OrgBaseTreeVOsPartition) {
            // 处理一批1000 的OrgBaseTreeVO数据
            doSomething(OrgBaseTreeVOs);
            // 更新一批1000 的OrgBaseTreeVO数据
            updates(OrgBaseTreeVOs);
        }
    }

    /**
     * 获取待处理的数据
     *
     * @return
     */
    private static List<OrgInfo> getOrgBaseTreeVOs() {
        return Lists.newArrayList(new OrgInfo());
    }

    /**
     * 更新一批数据
     *
     * @param orgBaseTreeVOs
     */
    private static void updates(List<OrgInfo> orgBaseTreeVOs) {
    }

    /**
     * 逻辑处理一批数据
     *
     * @param orgBaseTreeVOs
     */
    private static void doSomething(List<OrgInfo> orgBaseTreeVOs) {
    }

}


