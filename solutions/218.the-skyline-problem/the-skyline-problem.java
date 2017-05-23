class Height {
    int index;
    int height;
    Height(int index, int height) {
        this.index = index;
        this.height = height;
    }
}

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        if(buildings.length == 0 || buildings[0].length == 0) return result; 

        List<Height> heights = new ArrayList<Height>();
        for(int[] building : buildings) {
            heights.add(new Height(building[0], -building[2]));
            heights.add(new Height(building[1], building[2]));
        }

        Collections.sort(heights, new Comparator<Height>(){
                @Override
                public int compare(Height h1, Height h2) {
                    return h1.index != h2.index ? h1.index - h2.index : h1.height - h2.height;
                }
            });
        
        // use reverseOrder so that the lager one get the higher priority, 1000 is the init capacity
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(1000, Collections.reverseOrder());
        pq.offer(0);
        int prev = 0;
        for (Height h : heights) {
            if(h.height < 0) {
                pq.offer(-h.height);
            } else {
                pq.remove(h.height);
            }
            int cur = pq.peek();
            if (cur !=  prev) {
                result.add(new int[]{h.index, cur});
                prev = cur;
            }
        }

        return result;
    }
    
}