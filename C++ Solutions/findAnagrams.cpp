class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> freq(26, 0);
        vector<int> result;

        int left = 0, right = 0, count = p.size();

        if(s.size() < p.size()){
            return result;
        }    

        // init the frequency for p
        for(char c: p){
            freq[c - 'a']++;
        }

        while(right < s.size()){
            // current frequency
            if(freq[s[right] - 'a'] >= 1){
                count--;
            }
            freq[s[right] - 'a']--;
            right++;

            // check if anagram found
            if(count == 0){
                result.push_back(left);
            }

            // slide window size
            if(right - left == p.size()){
                if(freq[s[left] - 'a'] >= 0){
                    count++;
                }
                freq[s[left] - 'a']++;
                left++;
            }
        }
        return result;   
    }
};
