void main(){
  DateTime now = DateTime.now();

  print(now);
  print(now.year);
  print(now.day);
  print(now.hour);
  print(now.minute);
  print(now.second);
  print(now.millisecond);
  print('----------------------------------------------------------');
  Duration duration = Duration(seconds : 999);
  print(duration);
  print(duration.inDays);
  print(duration.inHours);
  print(duration.inMinutes);
  print(duration.inSeconds);
  print(duration.inMilliseconds);

  DateTime specificDays = DateTime(
    2017,11,23,5,56,22
  );
  print(specificDays);

  final difference = now.difference(specificDays);
  print(difference);
  print(difference.inDays);
  print(difference.inHours);
  print(difference.inMinutes);
  print(difference.inSeconds);
  print(difference.inMilliseconds);

  print(now.isAfter(specificDays));
  print(now.isBefore(specificDays));
  print(now.add(Duration(hours: 10)));
  print(now.subtract(Duration(days:2)));



}