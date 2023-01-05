package com.bootdo.common.utils;

import com.bootdo.brave.domain.OrgInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BaseTreeUtil {

    public static List<OrgInfo> buildTree(List<OrgInfo> zoneList) {
        Map<String, List<OrgInfo>> zoneByParentIdMap = new HashMap<>();
        zoneList.forEach(zone -> {
            List<OrgInfo> children = zoneByParentIdMap.getOrDefault(zone.getParentNumber(), new ArrayList<>());
            children.add(zone);
            zoneByParentIdMap.put(zone.getParentNumber(), children);
        });
        zoneList.forEach(zone -> zone.setChildren(zoneByParentIdMap.get(zone.getNumber())));
        return zoneList.stream()
                .filter(v -> v.getLevel().equals("0"))
                .collect(Collectors.toList());
    }


}
