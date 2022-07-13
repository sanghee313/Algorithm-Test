import java.util.Scanner;

public class Main {
    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();//출력에 사용될것

        int n = sc.nextInt();
        stack = new int[n];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            switch (str){
                case "push":
                    push(sc.nextInt());//push일 경우 한번 더 입력받는다
                    break;
                case "pop":
                    sb.append(pop()).append('\n');//pop한후 출력
                    break;
                case "size":
                    sb.append(size()).append('\n');//size 출력
                    break;
                case "empty":
                    sb.append(empty()).append('\n');//empty 출력
                    break;
                case "top":
                    sb.append(top()).append('\n');//top 출력
                    break;
            }
        }
        System.out.println(sb);
        sc.close();
    }

    public static void push(int item){
        stack[size] = item; //stack 맨 위에 값 추가
        size++;
    }

    public static int pop(){
        if(size==0) return -1; //꺼낼게 없을때
        //꺼낼게 있을 때 값 하나 꺼낸 후 stack에서 삭제
        int res = stack[size-1];
        stack[size-1] = 0;
        size--;
        return res;
    }

    public static int size(){
        return size;
    }

    public static int empty(){
        if (size==0) return 1;
        return 0;
    }

    public static int top(){
        if(size==0) return -1; //꺼낼게 없을때
        return stack[size-1]; //맨 위에꺼 꺼냄
    }
}