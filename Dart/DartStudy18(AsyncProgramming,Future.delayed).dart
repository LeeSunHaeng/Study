void main() {
  //동기
  addNumbers(2, 2);
  addNumbers(4, 4);

  //Future - 미래
  //미래에 받아올 값

  Future<String> name = Future.value('코드팩토리');
  Future<int> number = Future.value(1);
  Future<bool> isTrue = Future.value(true);

  //2개의 파라미터
  // delayed - 지연되다
  // 1번 파라미터 - 지연할 시간(얼마나 지연할건지) Duration
  // 2번 파라미터 - 지연 시간이 지난 후 실행할 함수.

  print('딜레이 시작');

  Future.delayed(Duration(seconds: 3), () {
    print('Delay 끝');
  });
}
//1 + 1 = 2
//2 + 2 = 4

void addNumbers(int num1, int num2) {
  print('계산 시작 : $num1 + $num2');

  Future.delayed(Duration(seconds: 2), () {
    print('계산완료 : ${num1 + num2}');
  });
  print('계산완료');
}
