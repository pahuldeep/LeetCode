class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        vector<int> freq(256);
        if (s2.size() == 0 && s1.size() > s2.size()) {
            return false;
        }

        for (int i = 0; i < s1.size(); i++) {
            freq[s1[i] - 'a']++;
        }

        int count = s1.size();
        int left = 0, right = 0;

        while (right < s2.size()) {
            if (freq[s2[right] - 'a'] >= 1) {
                count--;
            }
            freq[s2[right] - 'a']--;
            right++;

            if (count == 0) {
                return true;
            }

            if (right - left == s1.size()) {
                if (freq[s2[left] - 'a'] >= 0) {
                    count++;
                }
                freq[s2[left] - 'a']++;
                left++;
            }
        }
        return false;
    }
};
