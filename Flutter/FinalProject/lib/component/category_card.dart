import 'dart:convert';

import 'package:finalproject/component/card_title.dart';
import 'package:finalproject/component/main_card.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import 'main_stat.dart';

class CategoryCard extends StatefulWidget {

  const CategoryCard({Key? key}) : super(key: key);

  @override
  State<CategoryCard> createState() => _CategoryCardState();
}

class _CategoryCardState extends State<CategoryCard> {



  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: 160,
      child: MainCard
        (child: LayoutBuilder(
        builder: (context, constraint){

          return Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              CardTitle(title: '종류별 통계',),
              Expanded(
                child: ListView(
                    scrollDirection: Axis.horizontal,
                    physics: PageScrollPhysics(),
                    children: List.generate(20, (index) => MainStat(
                      category: '미세먼지$index',
                      imgPath: 'asset/img/best.png',
                      level: '최고',
                      stat: '0㎍/㎥',
                      width: constraint.maxWidth/3,
                    ),
                    )
                ),
              )
            ],
          );
        },

      ),
      ),

      );
  }
}
