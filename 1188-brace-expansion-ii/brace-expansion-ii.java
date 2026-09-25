import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Stack<Set<String>> stk = new Stack<>();
        
        Set<String> startSet = new HashSet<>();
        startSet.add("");
        stk.push(startSet);
        
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            if (ch == ',') {
                Set<String> top1 = stk.pop();
                Set<String> top2 = stk.pop();
                top2.addAll(top1);
                stk.push(top2);
                
                Set<String> emptySet = new HashSet<>();
                emptySet.add("");
                stk.push(emptySet);
                
            } else if (ch == '}') {
                Set<String> top1 = stk.pop();
                Set<String> top2 = stk.pop();
                Set<String> top3 = stk.pop();
                
                Set<String> right = new HashSet<>(top1);
                right.addAll(top2);
                
                Set<String> product = new HashSet<>();
                for (String l : top3) {
                    for (String r : right) {
                        product.add(l + r);
                    }
                }
                stk.push(product);
                
            } else if (ch == '{') {
                stk.push(new HashSet<>());
                
                Set<String> emptySet = new HashSet<>();
                emptySet.add("");
                stk.push(emptySet);
                
            } else {
                Set<String> top = stk.pop();
                Set<String> updated = new HashSet<>();
                for (String pre : top) {
                    updated.add(pre + ch);
                }
                stk.push(updated);
            }
        }
        
        List<String> result = new ArrayList<>(stk.pop());
        Collections.sort(result);
        return result;
    }
}