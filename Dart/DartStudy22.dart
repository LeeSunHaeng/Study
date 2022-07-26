import 'dart:async';
import 'dart:io';

void main(){

  playAllStream().listen((event) {
    print(event);
  });
  print('---------------------------------------------------------------------------------------------------------------------');
  calculate(1).where((event) => event % 2 == 0).listen((event) {
    print(event);
  });




}

Stream<int> playAllStream() async*{
  yield* calculate(1);
  yield* calculate(1000);
}

Stream<int> calculate(int number)async*{
  //int n = int.parse(stdin.readLineSync()!);
  for(int i = 0; i < 10; i++){
    yield i * number;
  //await Future.delayed(Duration(seconds: 1));
  }
}