import 'package:flutter/material.dart';


class HomeScreen extends StatelessWidget {
  const HomeScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        bottom: false,
        child: Container(
          color: Colors.black,
          // height: MediaQuery.of(context).size.height,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.start,
            // mainAxosAllignment - 주축 정렬
            // start - 시작
            // end - 끝
            // center - 가운데
            // spaceBetween - 위젯과 위젯의 사이가 동일하게 배치됨
            // spaceEvenly - 위젯과 위젯의 사이가 동일하지만 끝과 끝에도
            //                위젯이 아닌 빈 간격으로 시작한다
            //spaceAround - spaceEvenly + 끝과 끝의 간격은 1/2

            crossAxisAlignment: CrossAxisAlignment.end,
            //CrossAxisAlignment - 반대축 정렬
            // start - 시작
            // end - 끝
            // center - 가운데
            // stretch - 최대로 늘린다.

            mainAxisSize: MainAxisSize.max,
            //mainAxisSize - 주축 크기
            //max - 최대
            //min - 최소
            children: [

              //Expended / Flexible
              //Row나 Column의 Children에만 사용할 수 있다.
              
              Flexible(
                flex: 3,
                child: Container(
                  color: Colors.red,
                  width: 50.0,
                  height : 50.0,
                ),
              ),
              Expanded(
                child: Container(
                  color: Colors.orange,
                  width: 50.0,
                  height : 50.0,
                ),
              ),
              Expanded(
                child: Container(
                  color: Colors.blue,
                  width: 50.0,
                  height : 50.0,
                ),
              )
            ],
          ),
        ),
      )
    );
  }
}