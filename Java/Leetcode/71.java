class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] str = path.split("/");
        for(String s : str){
            if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(!s.equals(".") && !s.equals("")){
                stack.push(s);
            }
        }
        
        if(stack.isEmpty()){
            return "/";
        }
        
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < stack.size(); i++){
            res.append("/" + stack.get(i));
        }
        
        return res.toString();
    }
}

class Solution {
    public String simplifyPath(String path) {
        // 双端队列
        Deque<String> queue = new LinkedList<>();
        // 分割字符
        String[] res = path.split("/");
        for(int i = 0; i < res.length; i++){
            String s = res[i];
            if(s.equals(".") || s.equals("")) continue;
            else if (s.equals("..")){
                if(!queue.isEmpty()){
                    queue.pollLast();
                }
            }else{
                queue.offer(s);
            }
        }
        // 拼接
        if(queue.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder("/");
        while(!queue.isEmpty()){
            sb.append("/" + queue.poll());
        }
        // 判空
        return sb.toString();
    }
}