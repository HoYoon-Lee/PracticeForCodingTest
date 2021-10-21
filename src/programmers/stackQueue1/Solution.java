package programmers.stackQueue1;

public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0;  i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                if(prices[i] > prices[j]){
                    answer[i] = j - i;
                    break;
                }
            }
            if(answer[i] == 0) answer[i] = prices.length - 1 - i;
        }

        /*Queue<Integer> priceQueue = new LinkedList<>();

        for(int i = 0; i < prices.length; i++){
            priceQueue.clear();
            priceQueue.addAll(Arrays.stream(Arrays.copyOfRange(prices, i + 1, prices.length)).boxed().collect(Collectors.toList()));

            for(int j = 1; !priceQueue.isEmpty(); j++){
                int price = priceQueue.poll();
                if(prices[i] > price){
                    answer[i] = j;
                    break;
                }
            }
            if(answer[i] == 0){
                answer[i] = prices.length - (i + 1);
            }
        }*/

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {5, 4, 3, 2, 1};
        int[] result = solution.solution(prices);
        for(int a : result){
            System.out.print(a);
        }
    }
}
