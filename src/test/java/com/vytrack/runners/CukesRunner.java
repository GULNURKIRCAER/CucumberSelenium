package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",// json is a file extension,storing information.RAPOR ICIN
                 "html:target/default-html-reports",
                "rerun:target/rerun.txt"}, //This will create a rerun,txt file inside the target folder,
                                            // which keeps failed scenarios.
        features = "src/test/resources/features", //to make connection if there is no features cukesRunner
                                                 // will look at same package(runners)Path of file
        glue = "com/vytrack/step_definitions",
       // dryRun = true  calisip calismadigi gosterir print yapmaz,senaryo yazdiktan sonra true yap ki
        //sana konsolda metodu cikarsin.sonra false yap
        dryRun = false, //to get only undefined step definitions.print yapar.sayfaya gider acar kapatir
        tags="@drivers" //tags="@navigate and @wip"
        //tags = "@wip" //work in process
        //tags= "@login" //en yukarida login old icin hepsini cikartacak
        //tags= "@store_manager"  hangisini istiyorsak ozel onu yazabiliriz
        //tags="@driver and @VYT-123"  sadece 1.yi alir.adini daha ozel yaptik
        //tags="@driver or @store_manager"  1. ve 3.yu aliyor
        //tags="@login and not "@wip and not "@store_manager" login olanlari al wip olanlari alma

        //mvn verify -Dcucumber.options="--tags @smoke" -Dbrowser=firefox
)
public class CukesRunner {// connection between feature files and step definition files
}
