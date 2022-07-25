void main(){
  BoyGroup bts = BoyGroup('bts');
  GirlGroup blackpink = GirlGroup('blackpink');

  bts.sayName();
  blackpink.sayName();


}

//interface
abstract class IdolInterface {
  String name;
  IdolInterface(this.name);

  void sayName();
}

class BoyGroup implements IdolInterface{
  String name;

  BoyGroup(this.name);

  void sayName(){
    print(name);
  }
}

class GirlGroup implements IdolInterface{
  String name;
  GirlGroup(this.name);
  void sayName(){
    print(name);
  }
}