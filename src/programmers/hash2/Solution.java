package programmers.hash2;

public class Solution {
    public boolean solution(String[] phone_book) {
        for(int i = 0; i < phone_book.length - 1; i++){
            for(int j = i + 1; j < phone_book.length; j++){
                if(phone_book[i].startsWith(phone_book[j])) return false;
                if(phone_book[j].startsWith(phone_book[i])) return false;
            }
        }

        return true;

        /*boolean answer = true;
        HashMap<Integer, ArrayList<String>> lengths = new HashMap<Integer, ArrayList<String>>();

        for(String phoneNum : phone_book) {
        	if(!lengths.containsKey(phoneNum.length())) {
        		lengths.put(phoneNum.length(), new ArrayList<String>());
        	}
        	lengths.get(phoneNum.length()).add(phoneNum);
        }

        ArrayList<Integer> keys = new ArrayList<Integer>();
        keys.addAll(lengths.keySet());

        for(int i = 0; i < keys.size() - 1; i++) {
        	for(String num : lengths.get(keys.get(i))) {
        		for(int j = i + 1; j < keys.size(); j++) {
        			final int tmp = i;
        			answer = lengths.get(keys.get(j)).stream().allMatch(it -> !it.substring(0, keys.get(tmp)).equals(num));
        			if(!answer) return answer;
        		}
        	}
        }
        return answer;*/
    }
}
