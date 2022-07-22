void main() {
  //Type

  //정수
  //integer
  int num1 = 23;
  print(num1);

  int num2 = 20;
  print(num2);

  print(num1 + num2);

  print(num1 - num2);

  // 나누기 연산 / 는 1.2588 이렇게 나온다
  print(num1 / num2);

  // 몫만 구하려면 ~/ 연산자를 사용해야 몫만 1 이렇게 나옴
  print(num1 ~/num2);

  print(num1 * num2);

  print(num1 % num2);

  //실수
  //double
  double dnum1 = 2.5;
  double dnum2 = 0.7;

  print(dnum1 + dnum2);

  print(dnum1 - dnum2);

  print(dnum1 * dnum2);

  print(dnum1 / dnum2);

  print(dnum1 ~/ dnum2);

  print(dnum1 % dnum2);

  // 맞다 / 틀리다
  // Boolean
  bool isTrue = true;
  bool isFalse = false;

  print(isTrue);
  print(isFalse);

  //글자타입
  //String
  String name1 = '레드벨벳';
  String name2 = '슬기';
  print(name1);
  print(name2);

  print(name1 +' '+ name2);

  print('${name1} 아이린 ${name2}');
  print('$name1 아닙니다');
  print('${name1.runtimeType} $name2');

  //글자타입 (번외
  // var String
  // var은 오른쪽의 값으로 타입을 유추하는것
  // 다 var타입으로 선언하면 나중에 코드가 길어질때 가독성이 매우 떨어짐
  var name3 = '블랙핑크';
  var number = 20;

  print(number.runtimeType);

  //다이나믹
  //var타입은 한번 선언하면 타입이 고정됨 한번 String으로 선언하면 소멸까지 String임
  //dynamic타입은 타입을 바꿔도 오류가 나지 않음 String -> int 가능
  dynamic dyname = '이선행';
  print(dyname);

  dynamic dynum  = 1;
  print(dynum);

  var name22 = '블랙핑크';

  print(dyname.runtimeType);
  print(name22.runtimeType);

  dyname = 23;
  //error
  //name22 = 22;


  //nullable - null이 될 수 있다.
  //non-nullable - null이 될 수 없다.
  //null - 아무런 값도 있지 않다.

  String name = '코드팩토리';
  print(name);

  String? nname2 = '블랙핑크';

  name2 = '';
  print(name2);

  // !는 null이 아니라는 강조의 표시
  name2 = '코드팩토리';
  print(name2!);

  //final const
  //둘 다 한번 선언하면 값을 바꿀수 없다.
  //final은 빌드타임을 알지 않아도 되지만
  //const는 빌드타임을 알고 있어야함
  //#빋드타임 : 코드를 작성하는 순간의 시간
  final String fname = '코드팩토리';

  print(fname);
  //final은 값 변경이 불가능
  //fname = '블랙핑크';

  const String fname2 = '블랙핑크';
  print(fname2);

  // Run을 한 시간이 아니라 코드가 실행 되는 시간을 보여줌
  // now와 now2의 값이 다름 하지만 실행 속도가 빨라서 같이 나오는 것
  final DateTime now = DateTime.now();
  print(now);

  //DateTime은 코드를 작성한 시간이 아니라 코드가 실행되는 시간을 가져오기 때문에
  //코드를 작성한 시간을 알아야 하는 const로 선언할 수 없음.
  
  //const DateTime now2 = DateTime.now();

}