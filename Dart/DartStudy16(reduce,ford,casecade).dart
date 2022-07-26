void main() {
  //reduce
  //value : 현재 값, element : 다음 값
  //이 두가지를 가지고 계산을 진행행  //리스트의 타입과 출력의 타입이 같아야 한다
  List<int> numbers = [
    1,
    2,
    3,
    4,
    5
  ];
  final newNumbers = numbers.reduce((value, element){
    print('----------------------------------');
    print('value : $value');
    print('element : $element');
    return value + element;
  });
  print(newNumbers);

  final newNumbers2 = numbers.reduce((value, element) => value + element);
  print(newNumbers2);

  //ford
  //ford는 첫번쨰 값을 정해 줄 수 있음, 출력 값도 아무 형태나 가능
  final newNum = numbers.fold<int>(0, (previousValue, element) => previousValue + element);
  print(newNum);

  //casecade
  //List 앞에 ...을 붙이면 합치기 가능
  List<int> even = [2,4,6,8];
  List<int> odd = [1,3,5,7];
  print([even,odd]);
  print([...even,...odd]);

}