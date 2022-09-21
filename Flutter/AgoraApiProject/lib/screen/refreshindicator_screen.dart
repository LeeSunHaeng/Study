import 'package:agoraapiproject/const/colors.dart';
import 'package:agoraapiproject/layout/main_layout.dart';
import 'package:flutter/material.dart';

class RefreshIndicatorScreen extends StatelessWidget {
  List<int> numbers = List.generate(100, (index) => index);
  RefreshIndicatorScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MainLayout(
      title: 'RefreshIndicatorScreen',
      body: RefreshIndicator(
        onRefresh: () async{
          await Future.delayed(Duration(seconds: 3));
        },
        child: SingleChildScrollView(
          child: Column(
            children: numbers.map((e) => renderContainer(color: rainbowColors[e%rainbowColors.length], index: e)).toList(),
          )
        )
      ),
    );
  }

  Widget renderListView(){
    return ListView(
      children: numbers
          .map(
            (e) => renderContainer(
            color: rainbowColors[e % rainbowColors.length], index: e),
      )
          .toList(),
    );
  }

  Widget renderContainer({
    required Color color,
    required int index,
    double? height,
  }) {
    print(index);

    return Container(
      //height: height == null ? 300 : height,
      //key: Key(index.toString()),
      height: height ?? 300,
      color: color,
      child: Center(
        child: Text(
          index.toString(),
          style: TextStyle(
            color: Colors.white,
            fontWeight: FontWeight.w700,
            fontSize: 30.0,
          ),
        ),
      ),
    );
  }
}