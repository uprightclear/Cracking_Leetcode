class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        List<String> rec = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }
        Collections.sort(rec, new Comparator<String>() {
            public int compare(String word1, String word2) {
                return cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1);
            }
        });
        return rec.subList(0, k);
    }
}

//pq
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (map.get(s1) == map.get(s2)) {
                    return s1.compareTo(s2);
                }
                return map.get(s2) - map.get(s1);
            }
        });
        pq.addAll(map.keySet());
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()) {
                res.add(pq.poll());
            }
        }
        return res;
    }
}


//bucket sort
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for(String word : words) count.put(word, count.getOrDefault(word, 0) + 1);
        
        List<String>[] buckets = new ArrayList[words.length + 1];
        for(int i = 0; i <= words.length; i++) buckets[i] = new ArrayList<>();
        
        for(String word : count.keySet()) buckets[count.get(word)].add(word);
        
        List<String> ans = new ArrayList<>();
        for(int i = words.length; i >= 0; i--) {
            if(buckets[i].size() == 0) continue;
            Collections.sort(buckets[i]);
            for(int j = 0; j < buckets[i].size(); j++) {
                ans.add(buckets[i].get(j));
                if(ans.size() == k) break;
            }
            if(ans.size() == k) break;
        }
        return ans;
    }
}