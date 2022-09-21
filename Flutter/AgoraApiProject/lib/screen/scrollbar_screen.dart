import 'package:agoraapiproject/const/colors.dart';
import 'package:agoraapiproject/layout/main_layout.dart';
import 'package:flutter/material.dart';

class ScrollBarScreen extends StatelessWidget {
  List<int> numbers = List.generate(100, (index) => index);
  ScrollBarScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MainLayout(
      title: 'ScrollBarScreen',
      body: Scrollbar(
        child: SingleChildScrollView(
          child: Column(
            children: numbers
                .map(
                  (e) => renderContainer(
                      color: rainbowColors[e % rainbowColors.length], index: e),
                )
                .toList(),
          ),
        ),
      ),
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
