import 'dart:async';

void main() {
  final controller = StreamController();
  //여러개의 stream을 동시에 열고 싶을땐 .asBroadcastStream();
  final stream = controller.stream.asBroadcastStream();

  final streamListener1 = stream.listen((val) {
    print('Listen1 : $val');
  });
  //stream도 함수를 사용할 수 있다
  final streamListener2 = stream.where((event) => event % 2 == 1).listen((val) {
    print('Listen2 : $val');
  });

  controller.sink.add(1);
  controller.sink.add(2);
  controller.sink.add(3);
  controller.sink.add(4);
  controller.sink.add(5);
}