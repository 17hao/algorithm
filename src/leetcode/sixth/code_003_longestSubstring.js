var lengthOfLongestSubstring = function (s) {
    var slidingWin = new Set();
    if (s.length <= 1) {
        return s.length;
    }
    slidingWin.add(s.charAt(0));
    var left = 0, right = 1, res = 1;
    while (right < s.length) {
        if (!slidingWin.has(s.charAt(right))) {
            slidingWin.add(s.charAt(right++));
        } else {
            while (slidingWin.has(s.charAt(right))){
                slidingWin.delete(s.charAt(left++))
            }
            slidingWin.add(s.charAt(right++));
        }
        res = Math.max(res, slidingWin.size);
    }
    return res;
}

var _lengthOfLongestSubstring = function (s) {
    var win = new Set();
    var l = 0, r = 0, res = 0;
    while (l < s.length && r < s.length) {
        if (!win.has(s.charAt(r))) {
            win.add(s.charAt(r++));
            res = Math.max(res, win.size);
        } else {
            win.delete(s.charAt(l++));
        }
    }
    return res;
}

console.log(lengthOfLongestSubstring(""))
console.log(lengthOfLongestSubstring("dvdf"))
console.log(lengthOfLongestSubstring("dvdfabcdefg"))
console.log(lengthOfLongestSubstring("abcabcbb"))

console.log(_lengthOfLongestSubstring(""))
console.log(_lengthOfLongestSubstring("dvdf"))
console.log(_lengthOfLongestSubstring("dvdfabcdefg"))
console.log(_lengthOfLongestSubstring("abcabcbb"))