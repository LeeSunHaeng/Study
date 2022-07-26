void main() {
  final List<Map<String, String>> people = [
    {'name': '로제', 'group': '블랙핑크'},
    {'name': '지수', 'group': '블랙핑크'},
    {'name': 'rm', 'group': 'BTS'},
    {'name': '뷔', 'group': 'BTS'}
  ];
  final newPeople = people
      .map((e) => Person(e['name']!, e['group']!))
      .where((element) => element.group == 'BTS')
      .fold<int>(
          0, (previousValue, element) => previousValue + element.name.length);

  print(people);
  print(newPeople);
}

class Person {
  final String name;
  final String group;

  Person(this.name, this.group);
}
