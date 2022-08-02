import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:navigation/layout/main_layout.dart';
import 'package:navigation/screen/route_three_screen.dart';

class RouteTwoScreen extends StatelessWidget {
  const RouteTwoScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final argument = ModalRoute.of(context)!.settings.arguments;

    return MainLayout(title: 'RouteTwoScreen', children: [
      Text(
        'argument : $argument',
        textAlign: TextAlign.center,
      ),
      ElevatedButton(
        onPressed: () {
          Navigator.of(context).pop(43335);
        },
        child: Text('Pop'),
      ),
      ElevatedButton(
          onPressed: () {
            Navigator.of(context).pushNamed('/three');
          },
          child: Text('PUSH')),
      ElevatedButton(
          onPressed: () {
            Navigator.of(context).pushReplacementNamed(
                '/three',);
          },
          child: Text('PUSHReplace')),

      ElevatedButton(
          onPressed: (){
            Navigator.of(context).pushNamedAndRemoveUntil(
                    '/three',
                    (route) => route.settings.name == '/');
      },
          child:Text('PushAndRemoveUntil') )
    ]);
  }
}
