class baseballTeamDto {
}
open class Human(var number:Int, var name:String, var age:Int, var height:String){

}

class Pitcher(number: Int, name: String, age: Int, height: String, var win:Int, var lose:Int, var defense:Double) : Human(number, name, age, height){
    override fun toString(): String {
        return "Pitcher(number=$number name=$name age=$age height=$height win=$win, lose=$lose, defense=$defense)"
    }




}

class Batter(number: Int, name: String, age: Int, height: String, var batCount:Int, var hit:Int, var batAvg:Double) : Human(number, name, age, height){
    override fun toString(): String {
        return "Batter(number=$number name=$name age=$age height=$height batCount=$batCount, hit=$hit, batAvg=$batAvg)"
    }
}
