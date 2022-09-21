import 'package:agoraapiproject/const/colors.dart';
import 'package:agoraapiproject/layout/main_layout.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class ReorderableListViewScreen extends StatefulWidget {
  const ReorderableListViewScreen({Key? key}) : super(key: key);

  @override
  State<ReorderableListViewScreen> createState() =>
      _ReorderableListViewScreenState();
}

class _ReorderableListViewScreenState extends State<ReorderableListViewScreen> {
  List<int> numbers = List.generate(100, (index) => index);
  @override
  Widget build(BuildContext context) {
    return MainLayout(
        title: 'RorderableListViewScreen',
        //ReorderableListView의 children은 key값을 넣어줘야한다, 컴퓨터가 보기에 아이템은 다 똑같아 보이기 때문!
        //그리고 한번에 childern 전부 렌더링한다!! 성능면에서 고려해봐야함!
        body: ReorderableListView.builder(
          itemBuilder: (context, index) {
            return renderContainer(
              color: rainbowColors[numbers[index] % rainbowColors.length],
              index: numbers[index],
            );
          },
          itemCount: 100,
          onReorder: (int oldIndex, int newIndex) {
            setState(() {
              //oldIndex와 newIndex모두
              //이동이 되기 전에 산정한다.
              //
              //
              //[red,orange,yellow]
              //[0,1,2]
              //
              //red를 yellow 다음으로 옮긴다.
              //red : 0 oldIndex -> 3 newIndex
              //[orange,yellow,red]
              //
              //[red, orange, yellow]
              //yellow를 맨 앞으로 옮기고싶다.
              //yellow : 2 oldIndex -> 0 newIndex
              //[yellow, red, orange]

              if (oldIndex < newIndex) {
                newIndex -= 1;
              }

              final item = numbers.removeAt(oldIndex);
              numbers.insert(newIndex, item);
            });
          },
        )
    );
  }

  Widget renderDefault() {
    return ReorderableListView(
      children: numbers
          .map((e) => renderContainer(
              color: rainbowColors[e % rainbowColors.length], index: e))
          .toList(),
      onReorder: (int oldIndex, int newIndex) {
        setState(() {
          //oldIndex와 newIndex모두
          //이동이 되기 전에 산정한다.
          //
          //
          //[red,orange,yellow]
          //[0,1,2]
          //
          //red를 yellow 다음으로 옮긴다.
          //red : 0 oldIndex -> 3 newIndex
          //[orange,yellow,red]
          //
          //[red, orange, yellow]
          //yellow를 맨 앞으로 옮기고싶다.
          //yellow : 2 oldIndex -> 0 newIndex
          //[yellow, red, orange]

          if (oldIndex < newIndex) {
            newIndex -= 1;
          }

          final item = numbers.removeAt(oldIndex);
          numbers.insert(newIndex, item);
        });
      },
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
      key: Key(index.toString()),
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
