import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:navigation/layout/main_layout.dart';
import 'package:navigation/screen/route_two_screen.dart';

class RouteOneScreen extends StatelessWidget {
  const RouteOneScreen({ Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MainLayout(
        title: 'RouteOneScreen',
        children: [
          ElevatedButton(
            onPressed: () {
              Navigator.of(context).pop(456);
            },
            child: Text('Pop'),
          ),

          ElevatedButton(
            onPressed: () {
              //
              Navigator.of(context).push(
                  MaterialPageRoute(builder: (_) => RouteTwoScreen(),
                    settings: RouteSettings(
                      arguments: 789,
                    )
                  )
              );
            },
            child: Text('PUSH'),
          ),
        ]);
  }
}
