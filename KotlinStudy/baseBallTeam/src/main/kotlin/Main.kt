import baseballTeamDao.baseballTeamDao
import java.util.*

fun main(args: Array<String>) {

    val scan = Scanner(System.`in`)
    var baseballTeam = mutableListOf<Human>()
    var Team = baseballTeamDao()


    println("환영합니다.")
    while(true){
    println("메뉴를 골라주세요")
    println("(1)선수 추가 \n(2)선수 삭제 \n(3)선수 검색 \n(4)선수 수정 \n(5)타율 오름차순 출력 \n(6)방어율 오름차순 출력 \n(7)파일로 저장 \n(8)종료")
    print("입력 : ")
    val menu:Int = scan.nextInt()

    when(menu) {

        //선수추가
        1 -> Team.insert()

        //선수삭제
        2 -> Team.delete()

        //선수검색
        3 -> Team.select()

        //선수수정
        4 -> Team.update()

        //타율 순서 출력
        5 -> Team.batPrint()

        //방어율 순서 출력
        6 -> Team.pitPrint()

        //파일로 저장
        7 -> Team.save()

        //종료
        8 ->break
    }
}
}