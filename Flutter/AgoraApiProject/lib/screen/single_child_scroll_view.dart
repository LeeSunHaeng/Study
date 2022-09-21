import 'package:agoraapiproject/layout/main_layout.dart';
import 'package:flutter/material.dart';

import '../const/colors.dart';

class SingleChildScrollViewScreen extends StatelessWidget {
  const SingleChildScrollViewScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MainLayout(
        title: 'SingleChildScrollView',
        body: SingleChildScrollView(
          clipBehavior: Clip.none,
          physics: BouncingScrollPhysics(),
          child:
          Column(
            // children : [
            // renderContainer(color: Colors.black),
            // ]
              children : rainbowColors.map((e) =>
              renderContainer(color: e)
              ).toList(),
          ),
        )
    );
  }
  Widget renderContainer({required Color color,}){
    return Container(
      height: 300,
      color: color,
    );
  }
}

