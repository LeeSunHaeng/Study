import 'package:flutter/cupertino.dart';

import 'card_title.dart';
import 'main_card.dart';

class HourlyCard extends StatelessWidget {
  const HourlyCard({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MainCard(
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: [
          CardTitle(
            title: '시간별 미세먼지',
          ),
          Column(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: List.generate(
                  24 - DateTime.now().hour,
                      (index) => Padding(
                    padding: EdgeInsets.symmetric(horizontal: 8.0,vertical: 4.0),
                    child: Row(
                      mainAxisAlignment:
                      MainAxisAlignment.spaceBetween,
                      children: [
                        Expanded(
                            child: Text(
                                '${index + DateTime.now().hour}시')),
                        Expanded(
                          child: Image.asset(
                            'asset/img/good.png',
                            height: 20.0,
                          ),
                        ),
                        Expanded(
                          child: Text('좋음',textAlign: TextAlign.right,),
                        ),
                      ],
                    ),
                  )))
        ],
      ),
    );
  }
}
