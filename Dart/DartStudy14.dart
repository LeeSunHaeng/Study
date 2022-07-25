void main(){
  List<String> BlackPink = ['로제','리사', '지수', '제니'];
  //
  // print(BlackPink);
  // print(BlackPink.asMap());
  // print(BlackPink.toSet());
  //
  // Map blackMap = BlackPink.asMap();
  //
  // print(blackMap.keys.toList());
  // print(blackMap.values.toList());
  //
  // Set BlackSet = Set.from(BlackPink);
  // print(BlackSet.toList());

 final newBlackPink = BlackPink.map((x){
    return '블랙핑크 $x';
  });

  print(BlackPink);
  print(newBlackPink.toList());

  final newBlackPink2 = BlackPink.map((x) => '블랙핑크 $x');
  print(newBlackPink2.toList());

  print(BlackPink == BlackPink);
  print(newBlackPink == newBlackPink2);
  print(newBlackPink2 == newBlackPink);

  String number = '13579';

  final parsed = number.split('').map((e) => '$e.jpg').toList();
  print(parsed);

  //map 맵핑

  Map<String,String> fruit = {
    'apple' : '사과',
    'banana' : '바나나'
  };

   final newFruit = fruit.map((key, value) => MapEntry('Fruit $key', '과일 $value'));
   print(newFruit);


   final keys = fruit.keys.map((e) => 'fruit $e').toList();
   final values = fruit.values.map((e) => '과일 $e').toList();
   print(keys);
   print(values);

   //Set 맵핑
  Set<int> numbers = {1,2,2,3,4,5};

  final newnumbers = numbers.map((e) => 1+e);
  print(newnumbers);

}