name := "hackerrank"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= {
    val scalaTestV = "3.0.1"
    
    Seq(
        "org.scalatest" %% "scalatest" % scalaTestV % "test"
    )
}
        