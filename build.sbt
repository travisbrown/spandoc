organization := "com.davegurnell"
name         := "spandoc"

scalaVersion in ThisBuild := "2.11.8"

resolvers += "Awesome Utilities"  at "https://dl.bintray.com/davegurnell/maven"
resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies += "com.davegurnell" %% "unindent"      % "1.0.0"
libraryDependencies += "org.typelevel"   %% "cats"          % "0.4.1"
libraryDependencies += "io.circe"        %% "circe-core"    % "0.4.0"
libraryDependencies += "io.circe"        %% "circe-generic" % "0.4.0"
libraryDependencies += "io.circe"        %% "circe-parser"  % "0.4.0"
libraryDependencies += "org.scalatest"   %% "scalatest"     % "2.2.4" % "test"

licenses += ("Apache-2.0", url("http://apache.org/licenses/LICENSE-2.0"))
bintrayPackageLabels in bintray := Seq("scala", "pandoc", "utility")
bintrayRepository    in bintray := "maven"
