void main() {
  // if문

  int number = 2;

  if(number % 3 == 0){
    print('나머지가 0입니다');
  }
  else if(number % 3 == 1){
    print('나머지가 1입니다.');
  }
  else{
    print('나머지가 2입니다.');
  }

  //switch

  switch(number % 3){
    case 0 :
      print('나머지가 0입니다.');
      break;

    case 1 :
      print('나머지가 1입니다.');
      break;

    default :
      print('나머지가 2입니다.');
      break;
  }

  //Loop
  //for
  for(int i = 0; i<10; i++){
    print('$i ㅎㅎ');
  }

  int total = 0;

  List<int> numbers = [1,2,3,4,5,6];
  for(int i = 0; i<numbers.length; i++){
    total += numbers[i];
  }
  print(total);

  total = 0;

  for(int i in numbers){
    total += i;
  }
  print(total);

  for(int i = 0; i<10; i++){
    if(i == 5){
      continue;
    }
    print(i);
  }

  // while
  total = 0;

  while(total < 10){
    total +=1;
    if(total == 5){
      break;
    }
  }
  print(total);

  do {
    total += 1;
  }while(total < 10);

  print(total);

}