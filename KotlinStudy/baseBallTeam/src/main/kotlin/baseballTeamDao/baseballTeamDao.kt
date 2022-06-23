package baseballTeamDao

import Batter
import Human
import Pitcher
import java.io.FileWriter
import java.util.*

class baseballTeamDao {

    val sc = Scanner(System.`in`)
    var baseballTeam = mutableListOf<Human>()

    fun insert() {
        print("어떤 선수를 추가 하시겠습니까(1.투수 2.타자) : ")
        val put:Int =sc.nextInt()
        print("번호 : ")
        val number:Int = sc.nextInt()
        print("이름 : ")
        val name:String = sc.next()
        print("나이 : ")
        val age:Int = sc.nextInt()
        print("신장 : ")
        val height:String = sc.next()

        if(put == 1){
            print("승 : ")
            val win:Int = sc.nextInt()
            print("패 : ")
            val lose:Int = sc.nextInt()
            print("방어율 : ")
            val defence:Double = sc.nextDouble()

            val PitMem:Human = Pitcher(number,name,age,height,win,lose,defence)
            baseballTeam.add(PitMem)

        }
        else if(put ==2){
            print("타수 : ")
            val batCount:Int = sc.nextInt()
            print("안타 : ")
            val hit:Int = sc.nextInt()
            print("타율 : ")
            val batAvg:Double = sc.nextDouble()

            val BatMem:Human = Batter(number,name,age,height,batCount,hit,batAvg)
            baseballTeam.add(BatMem)
        }
        println("선수가 추가되었습니다.")


/*
        val pitTeam:Human= baseballTeam[0]
        if(pitTeam is Pitcher){
            pitTeam.win
        }


           println( baseballTeam[0] is Pitcher )

        val obj:Human = baseballTeam[0]
        if(obj is Pitcher){x
            obj.win = ""
        }else (obj is Batter){

        }
        */


    }

    fun delete(){
        select()
        println("삭제할 선수의 index Number를 입력해 주세요")
        val delNum:Int = sc.nextInt()
        baseballTeam.removeAt(delNum)
        println("삭제되었습니다.")
    }

    fun  select(){
    println("검색할 선수의 이름을 입력해주세요 : ")
        val search:String = sc.next()
        for(index in baseballTeam.indices){
            if(baseballTeam[index].name == search){
                println(baseballTeam[index])
                println("이 선수의 index Number = $index 입니다.")
            }
        }
    }

    fun update(){
        select()
        println("수정할 선수의 index Number를 입력해 주세요")
        val upNum:Int = sc.nextInt()
        val man:Human = baseballTeam[upNum]
        if(man is Pitcher){
            println(man)
            println("수정할 항목을 입력해 주세요")
            println("(1)번호 (2)나이 (3)승 (4)패 (5)방어율 : ")
            val chNum:Int = sc.nextInt()
            when(chNum){
                1 -> {
                    println("현재 번호는${man.number} 입니다. 수정 : ")
                    val newNum:Int = sc.nextInt()
                    man.number = newNum
                    println("번호가 ${man.number}(으)로 수정되었습니다.")
                }
                2 -> {
                    println("현재 나이는${man.age} 입니다. 수정 : ")
                    val newAge:Int = sc.nextInt()
                    man.age = newAge
                    println("나이가 ${man.age}(으)로 수정되었습니다.")
                }

                3 -> {
                    println("현재 승리는 ${man.win}회 입니다. 수정 : ")
                    val newWin:Int = sc.nextInt()
                    man.win = newWin
                    println("승리가 ${man.win}회로 수정되었습니다.")
                }

                4 -> {
                    println("현재 패배는 ${man.lose}회 입니다. 수정 : ")
                    val newLose:Int = sc.nextInt()
                    man.lose = newLose
                    println("패배가 ${man.lose}회로 수정되었습니다.")
                }

                5->{
                    println("현재 방어율은${man.defense} 입니다. 수정 : ")
                    val newDefense:Double = sc.nextDouble()
                    man.defense = newDefense
                    println("방어율이 ${man.defense}(으)로 수정되었습니다.")
                }
            }
        }
        else if(man is Batter){
            println(man)
            println("수정할 항목을 입력해 주세요")
            println("(1)번호 (2)나이 (3)타수 (4)안타 수 (5)타율 : ")
            val chNum:Int = sc.nextInt()
            when(chNum){
                1 -> {
                    println("현재 번호는${man.number} 입니다. 수정 : ")
                    val newNum:Int = sc.nextInt()
                    man.number = newNum
                    println("번호가 ${man.number}(으)로 수정되었습니다.")
                }
                2 -> {
                    println("현재 나이는${man.age} 입니다. 수정 : ")
                    val newAge:Int = sc.nextInt()
                    man.age = newAge
                    println("나이가 ${man.age}(으)로 수정되었습니다.")
                }

                3 -> {
                    println("현재 타수는 ${man.batCount} 입니다. 수정 : ")
                    val newBatCount:Int = sc.nextInt()
                    man.batCount = newBatCount
                    println("타수가 ${man.batCount}(으)로 수정되었습니다.")
                }

                4 -> {
                    println("현재 안타 수 는 ${man.hit}회 입니다. 수정 : ")
                    val newHit:Int = sc.nextInt()
                    man.hit = newHit
                    println("안타 수 가 ${man.hit}회로 수정되었습니다.")
                }

                5->{
                    println("현재 타율은${man.batAvg} 입니다. 수정 : ")
                    val newBatAvg = sc.nextDouble()
                    man.batAvg = newBatAvg
                    println("타율이 ${man.batAvg}(으)로 수정되었습니다.")
                }
            }
        }


    }

    fun batPrint(){
        val sortList = mutableListOf<Batter>()
        val pitList = mutableListOf<Pitcher>()

        for(i in baseballTeam){
            if(i is Batter){
                sortList.add(i)
            }
            else if (i is Pitcher){
                pitList.add(i)
            }
        }
        sortList.sortedByDescending { it.batAvg }
        println(sortList)

    }

    fun pitPrint(){
        val sortList = mutableListOf<Pitcher>()
        var batList = mutableListOf<Batter>()
        for(i in baseballTeam){
            if(i is Pitcher){
                sortList.add(i)
            }
            else if (i is Batter){
                batList.add(i)
            }
        }
        sortList.sortByDescending { it.defense }
        println(sortList)

    }

    fun save() {
        val path:String = "C:\\myfile\\baseball.txt"
        val writer = FileWriter(path)

        try{
            writer.write(baseballTeam.toString())
        }
        catch (e:Exception){
        }
        finally {
            writer.close()
        }
        println("저장되었습니다.")
    }



    }














