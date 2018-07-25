import sbt.IvyConsole.Dependencies._
import ReleaseTransformations._
import sbt.StdoutOutput

releaseCrossBuild := false
releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  releaseStepCommand("publishSigned"),
  setNextVersion,
  commitNextVersion,
  releaseStepCommand("sonatypeReleaseAll"),
  pushChanges
)

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.github.shafiquejamal",
      scalaVersion := "2.11.11",
			crossScalaVersions := Seq("2.11.11", "2.12.6"),
      version      := "0.0.6"
    )),
    name := "utils-test",
    libraryDependencies ++= Seq(
      "com.github.shafiquejamal" %% "utils" % "0.0.6"
    )
  )

javaOptions in run ++= Seq(
  "-Dlog4j.debug=true",
  "-Dlog4j.configuration=log4j.properties")
outputStrategy := Some(StdoutOutput)


useGpg := true
pomIncludeRepository := { _ => false }

licenses := Seq("BSD-style" -> url("http://www.opensource.org/licenses/bsd-license.php"))

homepage := Some(url("https://github.com/shafiquejamal/eigenroute-utils"))

scmInfo := Some(
  ScmInfo(
    url("https://github.com/shafiquejamal/eigenroute-util-test"),
    "scm:git@github.com:shafiquejamal/eigenroute-util-test.git"
  )
)

developers := List(
  Developer(
    id    = "shafiquejamal",
    name  = "Shafique Jamal",
    email = "admin@eigenroute.com",
    url   = url("http://eigenroute.com")
  )
)

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false
