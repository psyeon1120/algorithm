import java.util.*;
import java.io.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        List<Integer> a = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            a.add(Integer.parseInt(br.readLine()));
        }
        
        // 산술평균
        int avg = (int) Math.round(a.stream()
            .mapToDouble(d -> d)
            .average().orElse(0));
        
        Collections.sort(a);
        int min = a.get(0);
        int max = a.get(a.size() - 1);
        
        // 최빈값 구하기
        int[] cnt = new int[8001];
        for (int i = 0; i < N; i++) {
            cnt[a.get(i) + 4000]++;
        }
        
        List<Integer> modeList = new ArrayList<>();
        int modeCnt = 0;
        for (int i = 0; i < 8001; i++) {
            if (modeCnt < cnt[i]) {
                modeList.clear();
                modeList.add(i - 4000);
                modeCnt = cnt[i];
            } else if (modeCnt == cnt[i] && !modeList.contains(i - 4000)) {
                modeList.add(i - 4000);
            }
        }
        
        // 중앙값
        int median = a.get(a.size() / 2);
        
        // 최빈값
        int mode = modeList.size() > 1 ? modeList.get(1) : modeList.get(0);
        
        // 범위
        int range = max - min;
        
        System.out.println(avg);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}