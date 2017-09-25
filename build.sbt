name := "coding-club"
 
version := "1.0" 
      
lazy val `coding-club` = (project in file(".")).enablePlugins(PlayJava)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  javaJdbc ,
  cache ,
  javaWs,
  guice,
  "net.sf.ucanaccess" % "ucanaccess" % "4.0.2",
  evolutions
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

      