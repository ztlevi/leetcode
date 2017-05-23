public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> li = new LinkedList();
        for(int i = 1; i<n+1; i++){
            if(i%15==0){
                li.add("FizzBuzz");
                continue;
            }else if(i%3==0){
                li.add("Fizz");
                continue;
            }else if(i%5==0){
                li.add("Buzz");
                continue;
            }else{
                li.add(String.valueOf(i));
            }
        }
        return li;
    }
}