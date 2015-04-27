//object gradefiles extends App {
//    def main(args: Array[String]) {



import scala.util._
import scala.io._
import scala.math._
import java.io

object gradefiles extends App {

  def parseCSVHeader(line : String) : Array[String] = {
    val tokens = line.split(",")
    for (i <- 0 until tokens.length)
       tokens(i) = tokens(i).trim
    tokens
  }

  def parseCSVRowOfDoubles(line : String, failValue : Double) : Array[Double] = {

    val tokens = line.split(",")
    val doubles = Array.fill(tokens.length)(failValue)
    for (i <- 0 until tokens.length) {
      doubles(i) = Try(tokens(i).trim.toDouble) getOrElse(failValue)
    } 
    doubles
  }

  def parseCSVRowOfInts(line : String, failValue : Int) : Array[Int] = {

    val tokens = line.split(",")
    val integers = Array.fill(tokens.length)(failValue)
    for (i <- 0 until tokens.length) {
      integers(i) = Try(tokens(i).trim.toInt) getOrElse(failValue)
    } 
    integers
  }

  def readCategoryFile(courseName : String) : (Int, Array[String], Array[Int], Array[Int]) = {
    val courseFileName = s"categories_$courseName.txt"
    val file = Source.fromFile(courseFileName)
    val lines = file.getLines
    val header = lines.next
    val headerNames = parseCSVHeader(header)
    val quantities = lines.next
    val quantitiesArray = parseCSVRowOfInts(quantities, -1)
    val weights = lines.next
    val weightsArray = parseCSVRowOfInts(weights, -1)

    val columns = min(min(headerNames.length, quantitiesArray.length), weightsArray.length)

    (columns, headerNames, quantitiesArray, weightsArray)
  }
    
    def readStudentFile(courseName : String) :  (Array[String], Array[String], Array[String]) = { 
        val studentFileName = s"students_$courseName.txt"
        val file = Source.fromFile(studentFileName)
        val lines = file.getLines
        val n = lines.length
        var ids = Array[String]()
        var last = Array[String]()
        var first = Array[String]()
        
        for (line <- lines) {
           val lineContent = line.split(",")
            ids = ids :+ lineContent(0)
            last = last :+ lineContent(1)
            first = first :+ lineContent(2)
        }
        (ids, last, first)
    }
            
    def readStudentID(courseName : String, IDs: Array[Int] ) : (Int) = {
        for (ID <- IDs) {
            val IDFileName = s"$ID$courseName.data"
            val file = Source.fromFile(IDFileName)
            val lines = file.getLines
            var categories = Array[String]()
            var grades = Array[String]()
                
            for (line <- lines) {
                    val lineContent = line.split(",")
                        categories = categories :+ lineContent(0)
                        grades = grades :+ lineContent(2)
                }
        }
    }
    def averageGradegrades: Array[Int], Array[Double] : (Int) = {
        val sumofcategoriestotal= quantitiesArray.sum 
        var totalexamweight = weightsArray.sum 
        var grade = ((sumofcategories * weightsArray)/totalexamweight) 
   }
            
            //calculate grade here using the two arrays 
            // make an other function or calculate it here
            // 
            
            (categories, grades)
             
                     }        
  



       
  {  

  val courseAbbrev = readLine("Enter course abbrev ")
    // switched quantitiesArray and weightsArray in order to match with the corresponding rows in the file
  val columnns, headerNames, weightsArray,  quantitiesArray = readCategoryFile(courseAbbrev)
   readStudentFile(courseAbbrev)
}

   
  
    
//   val exampleHeading = "Exams, Homework, Project"
//   val exampleData = "10, a, 25, 35.6"
//   val exampleData2 = "10, a, 25, 35"

//   println(">> Heading")
//   parseCSVHeader(exampleHeading) foreach println
//   println(">> CSV Row of Doubles")
//   parseCSVRowOfDoubles(exampleData, -1.0) foreach println
//   println(">> CSV Row of Ints")
//   parseCSVRowOfInts(exampleData2, -1) foreach println

//   println(">> Reading the Category File")
//   val courseName = Try(args(0)) getOrElse("comp150")
//   println(s">> Reading $courseName categories file")
//   val results = readCategoryFile(courseName)
//   results match {
//     case (n, h, q, w) => {
//       println(s"There are $n columns of data")
//       println("Headings")
//       h foreach println
//       println("Quantities")
//       q foreach println
//       println("Weights")
//       w foreach println
//    }
//  }





