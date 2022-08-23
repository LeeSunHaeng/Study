import 'package:flutter/material.dart';
import 'package:tablecalendar/const/samplejson.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    var data = CalendarJsonAugust;
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        body: Column(
          children: [
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                ElevatedButton(onPressed: (){
                }, child: Icon(Icons.arrow_back_ios)),
                ElevatedButton(onPressed: (){}, child: Icon(Icons.arrow_forward_ios)),
              ],
            ),
            Table(
              border: TableBorder.all(),
              children: <TableRow>[

                //Head
                TableRow(children: CalendarHead()),

                //월
                TableRow(
                  children: CalendarBody('월'!, data!['월']!)!,
                ),

                //화
                TableRow(
                  children: CalendarBody('화'!, data!['화']!)!,
                ),

                //수
                TableRow(
                  children: CalendarBody('수'!, data!['수']!)!,
                ),

                //목
                TableRow(
                  children: CalendarBody('목'!, data!['목']!)!,
                ),

                //금
                TableRow(
                  children: CalendarBody('금'!, data!['금']!)!,
                ),

                //토
                TableRow(
                  children: CalendarBody('토'!, data!['토']!)!,
                ),

                //일
                TableRow(
                  children: CalendarBody('일'!, data!['일']!)!,
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}

List<Widget> CalendarHead() {
  List<Widget> list = [];

  list.add(Container(
    height: 60,
    color: Colors.grey,
    child: Text('', style: TextStyle(fontSize: 20)),
    padding: EdgeInsets.only(top: 10),
  ));

  for (int i = 1; i < 6; i++) {
    list.add(Container(
      height: 60,
      child: Text('${i}주차', style: TextStyle(fontSize: 20)),
      padding: EdgeInsets.only(top: 10),
    ));
  }

  return list;
}

List<Widget> CalendarBody(String day, List<Map<String, dynamic>> dayOfTheWeek) {
  List<Widget> list = [];
  list.add(
    Container(
      height: 60,
      color: Colors.green,
      child: Text('$day', style: TextStyle(fontSize: 20)),
      padding: EdgeInsets.only(top: 10),
    ),
  );
  for (int i = 0; i < 5; i++) {
    if (i <= dayOfTheWeek.length - 1) {
      if (dayOfTheWeek[i]['건수'] > 1) {
        list.add(Container(
          child: Column(
            children: [
              Text('${dayOfTheWeek[i]['일자']}일'),
              Text(dayOfTheWeek[i]['상태']),
              Text('+'),
            ],
          ),
        ));
      } else {
        list.add(Container(
          child: Column(
            children: [
              Text('${dayOfTheWeek[i]['일자']}일'),
              Text(dayOfTheWeek[i]['상태']),
            ],
          ),
        ));
      }
    } else {
      list.add(Container());
    }
  }
  return list;
}
