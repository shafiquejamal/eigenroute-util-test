name := """eigenroute-util-test"""

version := "0.0.3"
organization := "com.eigenroute"

scalaVersion := "2.11.7"
// resolvers += "Eigenroute maven repo" at "http://mavenrepo.eigenroute.com/"

libraryDependencies ++= Seq(
  "com.eigenroute" %% "eigenroute-util" % "0.0.3"
)

publishMavenStyle := true
val resolver = Resolver.ssh("Eigenroute maven repo", "mavenrepo.eigenroute.com", 7835, "/home/mavenrepo/repo") withPermissions "0644"
publishTo := Some(resolver as ("mavenrepo", Path.userHome / ".ssh" / "id_rsa"))

publishArtifact in packageSrc := false

publishArtifact in packageDoc := false
