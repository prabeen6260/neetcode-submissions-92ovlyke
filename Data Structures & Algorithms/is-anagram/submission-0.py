class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        a1={}
        a2={}
        for c in s:
            a1[c]=a1.get(c,0)+1
        for c in t:
            a2[c]=a2.get(c,0)+1
        if a1.items()==a2.items():
            return True
        return False

