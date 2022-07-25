// void - 공허
void main() {
 int a = addNumbers(10, y: 20, z: 30);
 int b = addNumbers(2, y: 3, z : 20);
 print(a+b);


 Operation operation = add;
 int result = operation(12,22,33);

 print(result);

 int result2 = calculate(11,22,33,add);
 print(result2);

 int result3 = calculate(33,44, 55, subtract);
 print(result3);
}

//function (함수)
// 세개의 숫자 (x, y, z)를 더하고 짝수인지 홀수인지 알려주는 함수
//parameter / argument - 매개변수
//positional parameter - 순서가 중요한 파라미터
//optional parameter[] - 있어도 되고 없어도 되는 파라미터
//named parameter(required) - 이름이 있는 파라미터 (순서가 중요하지 않다.)
//arrow function - 화살표 함수

int addNumbers(int x,{
  required int y,
  int z = 40
}) => x+y+z;
  // int sum = x+y+z;
  //
  // print('x = $x');
  // print('y = $y');
  // print('z = $z');
  //
  // if(sum % 2 == 0){
  //   print('짝수입니다.');
  // }else{
  //   print('홀수입니다');
  // }
  // return sum;

// typedef Operation
//signature
 typedef Operation = int Function(int x, int y , int z);

 //더하기
int add(int x, int y, int z) => x + y + z;

//빼기
int subtract(int x, int y, int z) => x - y - z;

int calculate(int x, int y, int z , Operation operation){
  return operation(x,y,z);
}