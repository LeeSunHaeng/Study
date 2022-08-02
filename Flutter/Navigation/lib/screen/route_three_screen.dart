import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:navigation/layout/main_layout.dart';

class RouteThreeScreen extends StatelessWidget {
  const RouteThreeScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MainLayout(title: 'Route Three', children: [
      ElevatedButton(
        onPressed: () {
          Navigator.of(context).pop();
        },
        child: Text('POP'),
      ),
      ElevatedButton(
        onPressed: (){
          Navigator.of(context).pushNamed('/',arguments: 999);
        }
        , child: Text('PUSH_Named'),)
    ]);
  }
}
