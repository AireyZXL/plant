package com.resico.plant.zero5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Airey
 * @date 2021/12/7 14:07
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class TreeDomainDev {


    public static void main(String[] args) {

        TreeDomain treeDomain = new TreeDomain(1, "dfd", "#AA-AA");
        TreeDomain treeDomain2 = new TreeDomain(2, "dfd", "#AA-AD");
        TreeDomain treeDomain3 = new TreeDomain(3, "dfd", "#AA-AB");



        List<TreeDomain> peerList = new ArrayList<>();
        peerList.add(treeDomain);
        peerList.add(treeDomain2);
        peerList.add(treeDomain3);

        System.out.println("peerList="+peerList);


        peerList = peerList.stream().sorted(Comparator.comparing(TreeDomain::getLayerNumber)).collect(Collectors.toList());
        System.out.println("peerList="+peerList);
        List<String> layerNumberList = peerList.stream().map(TreeDomain::getLayerNumber).collect(Collectors.toList());
        int lastPosition = getLastPosition(layerNumberList);

        System.out.println(peerList.get(lastPosition));

    }


    public static int getLastPosition(List<String> layerNumberList) {
        List<Character> secondCharList = layerNumberList.stream().map(item -> item.charAt(item.length() - 1)).collect(Collectors.toList());
        List<Character> firstCharList = layerNumberList.stream().map(item -> item.charAt(item.length() - 2)).collect(Collectors.toList());
        int index = 0;
        for (int i = 0; i < secondCharList.size(); i++) {
            int j = i + 1;
            if (j == secondCharList.size()) {
                index = i;
                break;
            }
            int f1 = firstCharList.get(i);
            int f2 = firstCharList.get(j);
            int s1 = secondCharList.get(i);
            int s2 = secondCharList.get(j);
            if (f1 == f2) {
                if (s2 != s1 + 1) {
                    index = i;
                    break;
                }
            } else {
                if (!(s1 == 90 && f2 == f1 + 1 && s2 == 65)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

}
