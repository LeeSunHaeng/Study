void main() {
  //Where
  //리스트의 엘리먼트 값을 True 인지 False 인지 구별해서 유지 또는 삭제
  List<Map<String,String>> people =[
    {
      'name' : '로제',
      'group' : '블랙핑크'
    },
    {
      'name' : '지수',
      'group' : '블랙핑크'
    },
    {
      'name' : 'rm',
      'group' : 'BTS'
    },
    {
      'name' : '뷔',
      'group' : 'BTS'
    }
  ];

  print(people);

  final BlackPink = people.where((e) => e['group'] == '블랙핑크');
  print(BlackPink);
}