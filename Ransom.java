//给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
//判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
//如果可以构成，返回 true ；否则返回 false。
class Ransom {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars1 = ransomNote.toCharArray();
        char[] chars2 = magazine.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        int i = 0;
        int j = 0;
        while (i < chars1.length && j < chars2.length) {
            if (chars1[i] == chars2[j]) {
                i++;
                j++;
            } else {
                if (chars2[j] > chars1[i]) {
                    return false;
                }
                j++;
            }
        }
        if (i == chars1.length) {
            return true;
        } else {
            return false;
        }
    }
}