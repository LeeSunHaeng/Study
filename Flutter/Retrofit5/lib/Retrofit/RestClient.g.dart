// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'RestClient.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

PracticeRequest _$PracticeRequestFromJson(Map<String, dynamic> json) =>
    PracticeRequest(
      serviceKey: json['serviceKey'] as String?,
      sidoName: json['sidoName'] as String?,
    );

Map<String, dynamic> _$PracticeRequestToJson(PracticeRequest instance) =>
    <String, dynamic>{
      'serviceKey': instance.serviceKey,
      'sidoName': instance.sidoName,
    };

pmData _$pmDataFromJson(Map<String, dynamic> json) => pmData(
      stationName: json['stationName'] as String?,
      sidoName: json['sidoName'] as String?,
      dataTime: json['dataTime'] as String?,
      o3Value: json['o3Value'] as String?,
      pm10Value: json['pm10Value'] as String?,
    );

Map<String, dynamic> _$pmDataToJson(pmData instance) => <String, dynamic>{
      'stationName': instance.stationName,
      'sidoName': instance.sidoName,
      'dataTime': instance.dataTime,
      'o3Value': instance.o3Value,
      'pm10Value': instance.pm10Value,
    };

// **************************************************************************
// RetrofitGenerator
// **************************************************************************

class _RestClient implements RestClient {
  _RestClient(this._dio, {this.baseUrl}) {
    baseUrl ??= 'http://apis.data.go.kr';
  }

  final Dio _dio;

  String? baseUrl;

  @override
  Future<List<pmData>> getData(serviceKey, sidoName, returnType) async {
    const _extra = <String, dynamic>{};
    final queryParameters = <String, dynamic>{
      r'serviceKey': serviceKey,
      r'sidoName': sidoName,
      r'returnType': returnType
    };
    final _headers = <String, dynamic>{
      r'Accept': 'application/json',
      r'content-type': 'application/json'
    };
    _headers.removeWhere((k, v) => v == null);
    final _data = <String, dynamic>{};
    final _result = await _dio.fetch<List<dynamic>>(
        _setStreamType<List<pmData>>(Options(
                method: 'GET',
                headers: _headers,
                extra: _extra,
                contentType: 'application/json')
            .compose(_dio.options,
                '/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty',
                queryParameters: queryParameters, data: _data)
            .copyWith(baseUrl: baseUrl ?? _dio.options.baseUrl)));
    var value = _result.data!
        .map((dynamic i) => pmData.fromJson(i as Map<String, dynamic>))
        .toList();
    return value;
  }

  RequestOptions _setStreamType<T>(RequestOptions requestOptions) {
    if (T != dynamic &&
        !(requestOptions.responseType == ResponseType.bytes ||
            requestOptions.responseType == ResponseType.stream)) {
      if (T == String) {
        requestOptions.responseType = ResponseType.plain;
      } else {
        requestOptions.responseType = ResponseType.json;
      }
    }
    return requestOptions;
  }
}
