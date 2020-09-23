package other;

import java.util.*;

/**
 * Mike, Ellie, Rohan, Fatma私人参加自行车比赛，分别获得1-4名，
 * 他们每个人骑不同颜色的自行车(红，紫，蓝，绿)。基于以下线索，谁获得了第二名
 *
 * Ellie骑紫色的车，Rohan没有骑绿色的车
 * Mike和Ellie不是第一，也不是最后
 * 骑蓝色车的人领先Fatma
 * 骑绿色车的人领先骑紫色车的人
 */
public class SecondBikeNoObject {

    private static boolean[] used;

    public static void main(String[] args) {
        String[] names = {"Fatma", "Rohan","Mike", "Ellie", };
        String[] colors = {"Purple", "Blue","Red", "Green", };

        for (List<String> nameRank:permuteUnique(names)) {
            Map<String, Integer> nameRankMap = new HashMap<>();
            for (int i = 0; i < nameRank.size();i++) {
                nameRankMap.put(nameRank.get(i), i);
            }
            // Mike 和 Ellie 不是第一，也不是最后
            if (nameRankMap.get("Mike") == 0 || nameRankMap.get("Mike") == 3 || nameRankMap.get("Ellie") == 0 || nameRankMap.get("Ellie") == 3) {
                continue;
            }
            for (List<String> colorRank:permuteUnique(colors)) {
                Map<String, Integer> colorRankMap = new HashMap<>();
                for (int i = 0; i < nameRank.size();i++) {
                    colorRankMap.put(colorRank.get(i), i);
                }
                // Ellie骑紫色的车，Rohan没有骑绿色的车
                if (nameRankMap.get("Rohan").equals(colorRankMap.get("Green")) || !nameRankMap.get("Ellie").equals(colorRankMap.get("Purple"))) {
                    continue;
                }
                // 骑蓝色车的人领先Fatma
                if (colorRankMap.get("Blue") >= nameRankMap.get("Fatma")) {
                    continue;
                }
                // 骑绿色车的人领先骑紫色车的人
                if (colorRankMap.get("Green") > colorRankMap.get("Purple")) {
                    continue;
                }
                System.out.println("第二名是：" + nameRank.get(1) + " 自行车的颜色是：" + colorRank.get(1));
            }
        }

    }

    // 全排序
    public static List<List<String>> permuteUnique(String[] nums) {
        List<List<String>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        Arrays.sort(nums);
        used = new boolean[len];
        findCombination(0, nums, new ArrayList<>(), res);
        return res;
    }

    private static void findCombination(int index, String[] nums, List<String> combaination, List<List<String>> res) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(combaination));
            return;
        }

        for (int i = 0; i < nums.length;i++) {
            if (used[i] || (i > 0 && nums[i].equals(nums[i - 1]) && !used[i - 1]))
                continue;

            used[i] = true;
            combaination.add(nums[i]);
            findCombination(index + 1, nums, combaination, res);
            combaination.remove(index);
            used[i] = false;
        }
    }
}
