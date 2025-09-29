package textprocessing;

public class RepeatedStringMatch {

    public static void main(String[] args) {
        String a = "a", b = "aa";
       int result = repeatedStringMatch(a, b);
        System.out.println("result ? " + result);
    }
        public static int repeatedStringMatch(String a, String b) {
            int count = 1;
            String a1= a;
            while(a1.length() < b.length()){
                count += 1;
                a1 += a;
            }
            System.out.println("string a ? " + a);
            int[] pattern = getPrefixArray(b);
            int[] a1b1Index = new int[2];
            int a1Index =0, bIndex = 0;
            a1b1Index = isPatternMatch(a1, b, a1Index, bIndex, pattern, a1b1Index);

            while(a1b1Index[1] != pattern.length){
                a1 += a;
                count += 1;
                a1b1Index = isPatternMatch(a1, b, a1b1Index[0], a1b1Index[1], pattern,a1b1Index);
                if(count > 5) return -1;
            }
            return count;
        }

        private static int[] isPatternMatch(String a1, String b, int a1Index, int bIndex, int[] pattern, int[] a1b1Index){
            while(a1Index < a1.length()){
                if(a1.charAt(a1Index) == b.charAt(bIndex)){
                    a1Index += 1;
                    bIndex += 1;
                    a1b1Index[0] = a1Index;
                    a1b1Index[1] = bIndex;
                    if(bIndex == pattern.length) {
                        return a1b1Index;
                    }

                }else{
                    if(bIndex == 0){
                        a1Index += 1;
                    }else{
                        bIndex = pattern[bIndex-1];
                    }
                    a1b1Index[0] = a1Index;
                    a1b1Index[1] = bIndex;
                }
            }
            return a1b1Index;
        }

        private static int[] getPrefixArray(String b){
            int[] prefixArr = new int[b.length()];
            int prefixIndex = 0, arrayIndex = 1;
            while(arrayIndex < b.length()){
                if(b.charAt(arrayIndex) == b.charAt(prefixIndex)){
                    prefixIndex +=1;
                    prefixArr[arrayIndex] = prefixIndex;
                    arrayIndex += 1;
                }else{
                    if(prefixIndex == 0){
                        arrayIndex += 1;
                    }else{
                        prefixIndex = prefixArr[prefixIndex-1];
                    }
                }
            }
            return prefixArr;
        }
    }
