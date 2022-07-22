void main() {
  int number = 2;

  print(number % 2);
  print(number % 3);
  print(number);

  print('-------------------------------');

  number ++;
  print(number);

  number--;
  print(number);

  double dnum = 4.0;
  print(dnum);

  dnum += 1;
  print(number);

  dnum -= 2;
  print(dnum);

  dnum *= 2;
  print(dnum);

  dnum /= 2;
  print(dnum);


  //null
  double? ndnum = 4.0;
  print(ndnum);

  ndnum = 2.0;

  ndnum = null;
  print(ndnum);
  // ??= 은 값이 null 이라면 오른쪽 값을 넣어라 라는 뜻
  ndnum ??= 3.0;
  print(ndnum);

  //값 비교

  int inum1 = 1;
  int inum2 = 2;

  print(inum1 > inum2);
  print(inum1 < inum2);
  print(inum1 >= inum2);
  print(inum1 <= inum2);
  print(inum1 == inum2);
  print(inum1 != inum2);

  //타입 비교
  print(inum1 is int);
  print(inum1 is String);

  print(inum1 is! int);
  print(inum1 is! String);

  //논리 오퍼레이터
  bool result = 12>10 && 1>0;
  print(result);

  bool result2 = 12>10 && 1<0;
  print(result2);

  bool result3 = 12>10 || 1>0;
  print(result3);

  bool result4 = 12>10 || 1<0;
  print(result4);

  bool result5 = 12<10 || 1<0;
  print(result5);

}