import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:tablecalendar/const/samplejson.dart';

class MyCalendar extends StatefulWidget {

  const MyCalendar({Key? key}) : super(key: key);

  @override
  State<MyCalendar> createState() => _MyCalendarState();

}


class _MyCalendarState extends State<MyCalendar> {
  late int index;
  late List<Map<String,List<Map<String,dynamic>>>> dataList;
  late List<String> monthList;

  @override
  void initState() {
    super.initState();
    index = 1;
    dataList = [CalendarJsonJuly,CalendarJsonAugust,CalendarJsonSeptember];
    monthList = ['7월', '8월', '9월'];

  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Column(
          children: [
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                ElevatedButton(onPressed: (){

                  setState(() {
                    index = (index-1)%3.abs();
                  });
                }, child: Icon(Icons.arrow_back_ios)),

                Text('${monthList[index]}',style: TextStyle(fontSize: 25),),

                ElevatedButton(onPressed: (){

                  setState(() {
                    index = (index+1)%3.abs();
                  });
                }, child: Icon(Icons.arrow_forward_ios)),
              ],
            ),
            Table(
              border: TableBorder.all(),
              children: <TableRow>[

                //Head
                TableRow(children: CalendarHead()),

                //월
                TableRow(
                  children: CalendarBody('월'!, dataList[index]!['월']!)!,
                ),

                //화
                TableRow(
                  children: CalendarBody('화'!, dataList[index]!['화']!)!,
                ),

                //수
                TableRow(
                  children: CalendarBody('수'!, dataList[index]!['수']!)!,
                ),

                //목
                TableRow(
                  children: CalendarBody('목'!, dataList[index]!['목']!)!,
                ),

                //금
                TableRow(
                  children: CalendarBody('금'!, dataList[index]!['금']!)!,
                ),

                //토
                TableRow(
                  children: CalendarBody('토'!, dataList[index]!['토']!)!,
                ),

                //일
                TableRow(
                  children: CalendarBody('일'!, dataList[index]!['일']!)!,
                ),
              ],
            ),
          ],
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
