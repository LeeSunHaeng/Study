import 'package:flutter/material.dart';
import 'package:tablecalendar/calendar/mycalendar.dart';
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
      home: SafeArea(
        top: true,
        child: MyCalendar(),
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
