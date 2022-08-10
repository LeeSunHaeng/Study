import 'dart:convert';

void main(){
  var json = [
    {
      "so2Grade": "1",
      "coFlag": null,
      "khaiValue": "58",
      "so2Value": "0.003",
      "coValue": "0.2",
      "pm10Flag": null,
      "o3Grade": "2",
      "pm10Value": "19",
      "khaiGrade": "2",
      "sidoName": "서울",
      "no2Flag": null,
      "no2Grade": "1",
      "o3Flag": null,
      "so2Flag": null,
      "dataTime": "2022-08-05 13:00",
      "coGrade": "1",
      "no2Value": "0.015",
      "stationName": "중구",
      "pm10Grade": "1",
      "o3Value": "0.040"
    },
    {
      "so2Grade": "1",
      "coFlag": null,
      "khaiValue": "53",
      "so2Value": "0.004",
      "coValue": "0.5",
      "pm10Flag": null,
      "o3Grade": "1",
      "pm10Value": "25",
      "khaiGrade": "2",
      "sidoName": "서울",
      "no2Flag": null,
      "no2Grade": "1",
      "o3Flag": null,
      "so2Flag": null,
      "dataTime": "2022-08-05 13:00",
      "coGrade": "1",
      "no2Value": "0.024",
      "stationName": "한강대로",
      "pm10Grade": "2",
      "o3Value": "0.013"
    },
    {
      "so2Grade": "1",
      "coFlag": null,
      "khaiValue": "64",
      "so2Value": "0.003",
      "coValue": "0.2",
      "pm10Flag": null,
      "o3Grade": "2",
      "pm10Value": "21",
      "khaiGrade": "2",
      "sidoName": "서울",
      "no2Flag": null,
      "no2Grade": "1",
      "o3Flag": null,
      "so2Flag": null,
      "dataTime": "2022-08-05 13:00",
      "coGrade": "1",
      "no2Value": "0.011",
      "stationName": "종로구",
      "pm10Grade": "1",
      "o3Value": "0.047"
    }
  ];

  Map<String,dynamic> map = json[0];

  print(map.keys);
}