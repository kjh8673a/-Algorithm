import java.util.*;

class Solution {
    static class Music {
        int idx;
        int plays;
        
        public Music(int idx, int plays) {
            this.idx = idx;
            this.plays = plays;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        ArrayList<String> genreList = new ArrayList<>();
        map.forEach((k, v) -> genreList.add(k));
        Collections.sort(genreList, new Comparator<String>() {
           @Override
            public int compare(String o1, String o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(String genre : genreList) {
            ArrayList<Music> musicList = new ArrayList<>();
            for(int i = 0; i < genres.length; i++) {
                if(genres[i].equals(genre)) {
                    musicList.add(new Music(i, plays[i]));
                }
            }
            Collections.sort(musicList, new Comparator<Music>() {
               @Override
                public int compare(Music o1, Music o2) {
                    if(o1.plays == o2.plays) {
                        return o1.idx - o2.idx;
                    }
                    return o2.plays - o1.plays;
                }
            });
            
            result.add(musicList.get(0).idx);
            if(musicList.size() >= 2) {
                result.add(musicList.get(1).idx);
            }
        }
        
        int[] answer = new int[result.size()];
        int idx = 0;
        for(int i : result) {
            answer[idx++] = i;
        }
        
        return answer;
    }
}