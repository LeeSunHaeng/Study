void main() {
  Employee sulgi = Employee('슬기');
  Employee chorong = Employee('초롱');

  Employee.building = '성호빌딩';
  sulgi.printNameAndBuilding();
  chorong.printNameAndBuilding();
}

class Employee {
  //static은 instance에 귀속되지 않고 class에 귀속된다.
  // 알바생이 일하는 건물
  static String? building;
  // 알바생 이름
  final String name;

  Employee(
      this.name
      );

  void printNameAndBuilding() {
    print('제 이름은 $name 입니다. $building 건물에서 근무하고 있습니다.');
  }
  static void printBuilding(){
    print('저는 $building 건물에서 근무중입니다.');
  }
}