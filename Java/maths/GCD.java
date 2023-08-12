class GCD{

 static int hcf(int a, int b){
int result = Math.min(a,b);
while(result> 0){
if(a % result == 0 && b % result ==0){
 break;
} 
 result--;
}
return result;
}

public static void main(String ...args){
int a = 20, b=10;
System.out.println(hcf(a,b));
}
}
