package com.bootdo.brave.controller;

import com.alibaba.fastjson.JSON;
import com.bootdo.brave.domain.OrgInfo;
import com.bootdo.brave.domain.TreeVo;
import com.bootdo.brave.service.OrgInfoService;
import com.bootdo.brave.service.TreeService;
import com.bootdo.common.utils.BaseTreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2019/8/12.
 */
@RestController
public class HelloController {

    @Autowired
    private OrgInfoService orgInfoService;

    @Autowired
    private TreeService treeService;

    @RequestMapping("/hello")
    public String index() {
        return "hello world";
    }

    @RequestMapping("/getOrgInfo")
    public String getOrgInfo() {
        List<OrgInfo> list = orgInfoService.list(null);
        List<OrgInfo> baseTree = BaseTreeUtil.buildTree(list);
        return JSON.toJSONString(baseTree);
    }

    @RequestMapping("/findOrgInfo")
    public String findOrgInfo() {
        String keywords = "JAVA组4";
        List<TreeVo> treeVos = treeService.treeKeywords(keywords);
        List<String> list = new ArrayList<>();
        for (TreeVo treeVo : treeVos) {
            String nodeName = treeVo.getName();
            list.add(nodeName);
        }
        List<TreeVo> oneTrees = treeService.findOneTree();
        List<TreeVo> lists = new ArrayList<>();
        for (TreeVo oneTree : oneTrees) {
            traverse(oneTree);
            lists.add(oneTree);
        }
        if (keywords.isEmpty()) {
            return JSON.toJSONString(lists);
        }
        List<TreeVo> treeVos1 = screenTree(lists, list);
        return JSON.toJSONString(treeVos1);
    }

    /**
     * 树结构遍历
     *
     * @param oneTree
     */
    public void traverse(TreeVo oneTree) {
        List<TreeVo> treeVos = treeService.findTwoTreeByNumber(oneTree.getNumber());
        if (treeVos != null) {
            for (int i = 0; i < treeVos.size(); i++) {
                TreeVo treeVo = treeVos.get(i);
                traverse(treeVo);
            }
        }
        oneTree.setChildren(treeVos);
    }

    /**
     * 树形筛选查找
     *
     * @param treeDtoList 树形集合
     * @param idList      筛选条件(可以是其他条件)
     * @return 包含的节点数据
     */
    public static List<TreeVo> screenTree(List<TreeVo> treeDtoList, List<String> idList) {
        //最后返回的筛选完成的集合
        List<TreeVo> screeningOfCompleteList = new ArrayList<>();
        if (listIsNotEmpty(treeDtoList) && listIsNotEmpty(idList)) {
            for (TreeVo treeDto : treeDtoList) {
                List<TreeVo> subsetList = treeDto.getChildren();
                //递归筛选完成后的返回的需要添加的数据
                TreeVo addTreeDto = getSubsetPmsPlanPo(treeDto, subsetList, idList);
                if (isNotEmpty(addTreeDto)) {
                    screeningOfCompleteList.add(addTreeDto);
                }
            }
            return screeningOfCompleteList;
        }
        return null;
    }


    /**
     * 筛选符合的集合并返回
     *
     * @param treeDto           树形类
     * @param subsetTreeDtoList 子集集合
     * @param idList            筛选条件
     * @return 筛选成功的类
     */
    public static TreeVo getSubsetPmsPlanPo(TreeVo treeDto, List<TreeVo> subsetTreeDtoList, List<String> idList) {
        //作为筛选条件的判断值
        String nodeName = treeDto.getName();
        //有子集时继续向下寻找
        if (listIsNotEmpty(subsetTreeDtoList)) {
            List<TreeVo> addTreeDtoList = new ArrayList<>();
            for (TreeVo subsetTreeDto : subsetTreeDtoList) {
                List<TreeVo> subsetList = subsetTreeDto.getChildren();
                TreeVo newTreeDto = getSubsetPmsPlanPo(subsetTreeDto, subsetList, idList);
                //当子集筛选完不为空时添加
                if (isNotEmpty(newTreeDto)) {
                    addTreeDtoList.add(newTreeDto);
                }
            }
            //子集满足条件筛选时集合不为空时，替换对象集合内容并返回当前对象
            if (listIsNotEmpty(addTreeDtoList)) {
                treeDto.setChildren(addTreeDtoList);
                return treeDto;
                //当前对象子集对象不满足条件时，判断当前对象自己是否满足筛选条件，满足设置子集集合为空，并返回当前对象
            } else if (listIsEmpty(addTreeDtoList) && idList.contains(nodeName)) {
                if (listIsEmpty(addTreeDtoList) && treeDto.getLevel() == "6") {
                    treeDto.setChildren(null);
                }
//                treeDto.setTreeVoList(null);
                return treeDto;
            } else {
                //未满足筛选条件直接返回null
                return null;
            }
        } else {
            //无子集时判断当前对象是否满足筛选条件
            if (idList.contains(nodeName)) {
                return treeDto;
            } else {
                return null;
            }
        }
    }

    /**
     * 判断集合为空
     *
     * @param list 需要判断的集合
     * @return 集合为空时返回 true
     */
    public static boolean listIsEmpty(Collection list) {
        return (null == list || list.size() == 0);
    }

    /**
     * 判断集合非空
     *
     * @param list 需要判断的集合
     * @return 集合非空时返回 true
     */
    public static boolean listIsNotEmpty(Collection list) {
        return !listIsEmpty(list);
    }

    /**
     * 判断对象为null或空时
     *
     * @param object 对象
     * @return 对象为空或null时返回 true
     */
    public static boolean isEmpty(Object object) {
        if (object == null) {
            return (true);
        }
        if ("".equals(object)) {
            return (true);
        }
        if ("null".equals(object)) {
            return (true);
        }
        return (false);
    }

    /**
     * 判断对象非空
     *
     * @param object 对象
     * @return 对象为非空时返回 true
     */
    public static boolean isNotEmpty(Object object) {
        if (object != null && !object.equals("") && !object.equals("null")) {
            return (true);
        }
        return (false);
    }


    public void selectById(Integer id, List<Integer> idList, List<Integer> list) {
        //查询数据库等于id的数据
        List<TreeVo> childList = treeService.findTwoTree(id);
        //递归查询下一级id,同时将上一次查询结果添加到list集合
        childList.forEach(menu -> {
            idList.add(menu.getId());
            if (menu.getLevel() == "6") {
                list.add(menu.getId());
            }
            this.selectById(menu.getId(), idList, list);
        });
    }

    public void selectByNumber(String number, List<String> numberList, List<String> list) {
        //查询数据库等于id的数据
        List<TreeVo> childList = treeService.findTwoTreeByNumber(number);
        //递归查询下一级id,同时将上一次查询结果添加到list集合
        childList.forEach(menu -> {
            numberList.add(menu.getNumber());
            if (menu.getLevel() == "6") {
                list.add(menu.getNumber());
            }
            this.selectByNumber(menu.getNumber(), numberList, list);
        });
    }

    public void selectByIdFive(Integer id, List<Integer> idList, List<Integer> list) {
        //查询数据库等于id的数据
        List<TreeVo> childList = treeService.findTwoTree(id);
        //递归查询下一级id,同时将上一次查询结果添加到list集合
        childList.forEach(menu -> {
            idList.add(menu.getId());
            if (Integer.parseInt(menu.getLevel()) < 6) {
                list.add(menu.getId());
            }
            this.selectById(menu.getId(), idList, list);
        });
    }

}
