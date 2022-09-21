import 'package:agoraapiproject/layout/main_layout.dart';
import 'package:agoraapiproject/screen/custom_scroll_view_screen.dart';
import 'package:agoraapiproject/screen/grid_view_screen.dart';
import 'package:agoraapiproject/screen/list_view_screen.dart';
import 'package:agoraapiproject/screen/refreshindicator_screen.dart';
import 'package:agoraapiproject/screen/reorderable_list_view_screen.dart';
import 'package:agoraapiproject/screen/scrollbar_screen.dart';
import 'package:agoraapiproject/screen/single_child_scroll_view.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class ScreenModel {
  final WidgetBuilder builder;
  final String name;

  ScreenModel({required this.builder, required this.name});
}

class HomeScreen extends StatelessWidget {
  final screens =[
    ScreenModel(builder: (_) => SingleChildScrollViewScreen(), name: 'SingleChildScrollViewScreen'),
    ScreenModel(builder: (_) => ListViewScreen(), name: 'ListViewScreen'),
    ScreenModel(builder: (_) => GridViewScreen(), name: 'GridViewScreen'),
    ScreenModel(builder: (_) => ReorderableListViewScreen(), name: 'ReorderableListViewScreen'),
    ScreenModel(builder: (_) => CustomScrollViewScreen(), name: 'CustomScrollViewScreen'),
    ScreenModel(builder: (_) => ScrollBarScreen(), name: 'ScrollBarScreen'),
    ScreenModel(builder: (_) => RefreshIndicatorScreen(), name: 'RefreshIndicator'),
  ];
   HomeScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MainLayout(
        title: 'Home',
        body: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 8.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: screens
                .map(
                    (screen) => ElevatedButton(onPressed: (){
                      Navigator.of(context).push(MaterialPageRoute(builder: screen.builder));
                  }, child: Text(screen.name)
                          )
                  ).toList()

              // ElevatedButton(
              //     onPressed: () {
              //       Navigator.of(context).push(MaterialPageRoute(
              //           builder: (_) => SingleChildScrollViewScreen()));
              //     },
              //     child: Text('SingleChildScrollView')),
              // ElevatedButton(
              //     onPressed: () {
              //       Navigator.of(context).push(
              //           MaterialPageRoute(builder: (_) => ListViewScreen()));
              //     },
              //     child: Text('ListView')),

          ),
        ));
  }
}
