import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import '../const/colors.dart';

class CardTitle extends StatelessWidget {
  final String title;
  const CardTitle({required this.title, Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Padding(
        child: Text(
          title,
          style: TextStyle(
              color: Colors.white,
              fontWeight: FontWeight.w700
          ),
          textAlign: TextAlign.center,
        ),
        padding: EdgeInsets.all(4),
      ),
      decoration: BoxDecoration(
          color: darkColor,
          borderRadius: BorderRadius.only(
            topLeft: Radius.circular(16.0),
            topRight: Radius.circular(16.0),
          )
      ),
    );
  }
}
