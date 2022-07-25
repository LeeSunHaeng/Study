void main() {
  //List
  //리스트

  List<String> blackPink = ['제니', '지수', '로제', '리사'];
  List<int> numbers = [1,2,3,4];

  print(blackPink);
  print(numbers);

  // index
  // 순서
  // 0부터 시작
  print(blackPink[0]);
  print(blackPink[1]);
  print(blackPink[2]);
  print(blackPink[3]);

  //길이
  print(blackPink.length);

  //추가
  blackPink.add('선행');
  print(blackPink);
  blackPink.remove('선행');
  print(blackPink);
  blackPink.indexOf('지수');

  //Map 맵
  //Key / Value

  Map<String,String> dic = {
    'Harry Potter' : '해리포터',
    'Ron Weasley' : '론 위즐리',
    'Hermione Granger' : '헤르미온느 그레인저',
  };

  print(dic);

  Map<String,bool> isHarry = {
    'Harry Potter' : true,
    'Ron Weasley' : true,
    'Iron Man' : false
  };
  print(isHarry);

  isHarry.addAll({
    'Spiderman': false
  });
  print(isHarry);

  print(isHarry['Iron Man']);

  isHarry['Hulk'] = false;
  print(isHarry);

  isHarry['Spiderman'] = true;
  print(isHarry);

  String a = 'Harry Potter';
  isHarry.remove('${a}');
  print(isHarry);

  print(isHarry.keys);
  print(isHarry.values);

  // Set
  // List는 중복값을 저장할 수 있고 Set은 중복값을 저장할 수 없음
  final Set<String> names = {
    'Code',
    'Flutter',
    'Black',
    'Flutter'
  };

   print(names);

   names.add('Jenny');
   print(names);

   names.remove('Jenny');
   print(names);

   print(names.contains('Flutter'));

}