void main() {

  //const로 인스턴스를 생성했을때 값이 같은 인스턴스끼리는 같은 인스턴스로 본다.
  Idol BTS1 = Idol('방탄소년단', ['이','김','박']);

  Idol BTS2 = Idol('방탄소년단', ['이','김','박']);

  print(BTS1 == BTS2);
  BTS1.setFirstMember = '인호';
  print(BTS1);


  Idol BTS = Idol.fromList([['진','뷔','정국'], 'BTS']);
  BTS.introduce();
}

//Idol class
//name
//members
//sayHello
//introduce
//immutable 프로그래밍

//getter , setter
//데이터를 가져옴, 데이터를 설정함
//private로 만드려면 Idol 앞에 _를붙여주고 멤버변수나 함수에도 _ 붙여줘야함
//private : 같은 파일 내에서만 사용가능
class Idol {
  final String name;
  final List<String> members;

  Idol(this.name, this.members);

  Idol.fromList(List values) :
      this.members = values[0],
      this.name = values[1];

  void sayHello() {
    print('안녕하세요 $name 입니다.');
  }
  void introduce(){
    print('저희 멤버는 $members 가 있습니다.');
  }
  get getFirstMember{
    return this.members[0];
  }

  set setFirstMember (String name){
    this.members[0] = name;
  }
}