void main(){
  Lecture<String, int> lecture1 = Lecture('123', 23);
  lecture1.printId();

  Test test = Test();
}

//Generic - 타입을 외부에서 받을때 사용
class Lecture<T, X> {
  final T id;
  final X name;

  Lecture(this.id, this.name);

  void printId(){
    print(id.runtimeType);
  }
}

//Object Oriented Programming (OOP)
//객체지향 프로그래밍
//모든 클래스들은 Object를 상속받고 있다. 생략되어 있는 것임
class Test extends Object{}