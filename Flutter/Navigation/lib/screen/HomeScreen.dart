import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:navigation/layout/main_layout.dart';
import 'package:navigation/screen/route_one_screen.dart';

class HomeScreen extends StatelessWidget {

  const HomeScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final argument = ModalRoute.of(context)!.settings.arguments;
    return WillPopScope(
      onWillPop: () async{
        // true - pop 가능
        // false - pop 불가능
        // 작업실행
        return false;
      },
      child: MainLayout(
          title: 'HomeScreen',
          children: [
            ElevatedButton(
                onPressed: (){
                  print(Navigator.of(context).canPop());
                },
                child: Text('CanPop')),
            ElevatedButton(onPressed: (){
              Navigator.of(context).maybePop();
            }, child: Text('MayBePop')),
            ElevatedButton(
                onPressed: (){
                  Navigator.of(context).pop();
                },
                child: Text('Pop')),
            Text('argument : $argument'),
            ElevatedButton(
              onPressed: () async {
                final result = await Navigator.of(context).push(
                  MaterialPageRoute(builder: (BuildContext context) => RouteOneScreen())
                );
                print(result);
              },
              child: Text('Push'),
            )
          ]),
    );
  }
}
