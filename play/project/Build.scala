import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "orbisgis-server-play"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "org.orbisgis" % "orbisgis-core-monomap" % "4.0-SNAPSHOT" changing(),
      "com.sun.xml.bind" % "jaxb-impl" % "2.2.5",
      "com.kitfox.svg" % "svg-salamander" % "1.0" from "http://repo.orbisgis.org/com/kitfox/svg/svg-salamander/1.0/svg-salamander-1.0.jar",
      "javax.media" % "jai_core" % "1.1.3" from "http://repo.orbisgis.org/javax/media/jai_core/1.1.3/jai_core-1.1.3.jar",
      "junit" % "junit" % "4.10" % "test",
      "org.orbisgis.server" % "orbiswms-lib" % "1.0-SNAPSHOT" changing(),
      "org.orbisgis.server" % "mapcatalog" % "1.1-SNAPSHOT" changing()
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
       resolvers ++= Seq( "IRSTV" at "http://repo.orbisgis.org",
        "Local repo" at "file://"+Path.userHome.absolutePath+"/.m2/repository"),
	javacOptions ++= Seq("-source", "1.7"),
	excludeFilter in unmanagedSources := "test",
	unmanagedSourceDirectories in Test += file("app/wms/src/test/java")
    )
}
